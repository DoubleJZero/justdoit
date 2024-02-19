package justdoit.api.service;

import justdoit.api.dto.request.UserInfoRequest;
import justdoit.api.dto.response.UserInfoResponse;
import justdoit.api.repository.UserRepository;
import justdoit.data.entity.TbUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 사용자 service
 *
 * <pre>
 * 코드 히스토리 (필요시 변경사항 기록)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder bCryptPasswordEncoder;


    /**
     * 사용자 목록 조회
     * @return 사용자목록
     */
    public List<UserInfoResponse> getUserList(){
        return userRepository.findAll().stream().map(UserInfoResponse::of).collect(Collectors.toList());
    }

    /**
     * 사용자정보 저장
     * @param userInfoRequest 사용자정보DTO
     */
    @Transactional
    public void saveUser(UserInfoRequest userInfoRequest){
        Optional.ofNullable(userRepository.findByUserId(userInfoRequest.getUserId()))
                .ifPresentOrElse(e -> {
                    e.setUserPw(bCryptPasswordEncoder.encode(userInfoRequest.getUserPw()));
                    e.setUserNm(userInfoRequest.getUserNm());
                    e.setUserBirth(userInfoRequest.getUserBirth());
                    e.setUpdtId(userInfoRequest.getUserId());
                    userRepository.saveAndFlush(e);
                }, ()->{
                    TbUserInfo entity =  userInfoRequest.toEntity();
                    entity.setUserPw(bCryptPasswordEncoder.encode(entity.getUserPw()));
                    entity.setRgstId("system");
                    entity.setUpdtId("system");
                    userRepository.saveAndFlush(entity);
                });
    }

    /**
     * 사용자 검증
     * @param userInfoRequest 사용자정보DTO
     */
    public String checkUser(UserInfoRequest userInfoRequest){
        return Optional.ofNullable(
                userRepository.findByUserIdAndUserPw(
                        userInfoRequest.getUserId()
                        , bCryptPasswordEncoder.encode(userInfoRequest.getUserPw())
                )
        ).isPresent() ? "Y" : "N";
    }

    /**
     * 사용자 목록 조회 querydsl
     * @return 사용자목록
     */
    public List<UserInfoResponse> getUserInfoList(){
        return userRepository.getUserInfoList();
    }

    /**
     * 사용자정보 삭제
     * @param userId 사용자 아이디
     */
    @Transactional
    public void deleteUser(String userId){
        userRepository.deleteByUserId(userId);
    }

    /**
     * 사용자 상세 조회
     * @return 사용자목록
     */
    public UserInfoResponse getUserInfoDetail(String userId){
        return userRepository.getUserInfoDetail(userId);
    }

}