package justdoit.api.controller;

import justdoit.api.dto.request.UserInfoRequest;
import justdoit.api.dto.response.UserInfoResponse;
import justdoit.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    /**
     * 사용자 목록 조회
     * @return 사용자목록
     */
    @GetMapping("/list")
    public List<UserInfoResponse> getUserList(){
        return userService.getUserList();
    }

    /**
     * 사용자정보 저장
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserInfoRequest userInfoRequest){
        userService.saveUser(userInfoRequest);
    }

    /**
     * 사용자 검증
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/checkUser")
    public String checkUser(@RequestBody UserInfoRequest userInfoRequest){
        return userService.checkUser(userInfoRequest);
    }

    /**
     * 사용자 목록 조회 querydsl
     * @return 사용자목록
     */
    @GetMapping("/getUserInfoList")
    public List<UserInfoResponse> getUserInfoList(){
        return userService.getUserInfoList();
    }

    /**
     * 사용자정보 삭제
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody UserInfoRequest userInfoRequest){
        userService.deleteUser(userInfoRequest.getUserId());
    }

    /**
     * 사용자 상세 조회
     * @return 사용자목록
     */
    @GetMapping("/getUserInfoDetail")
    public UserInfoResponse getUserInfoDetail(@RequestBody UserInfoRequest userInfoRequest){
        return userService.getUserInfoDetail(userInfoRequest.getUserId());
    }

}