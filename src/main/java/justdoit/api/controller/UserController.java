package justdoit.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import justdoit.api.dto.request.UserInfoRequest;
import justdoit.api.dto.response.UserInfoResponse;
import justdoit.api.exception.JandbException;
import justdoit.api.payload.Response;
import justdoit.api.payload.ResponseFactory;
import justdoit.api.security.constance.UserRole;
import justdoit.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Tag(name = "02 사용자", description = "사용자 API")
public class UserController {

    private final UserService userService;

    /**
     * 사용자 목록 조회
     * @return 사용자목록
     */
    @GetMapping("/list")
    @Operation(summary = "사용자 목록 조회", description = "사용자 목록을 조회한다.")
    public Response<List<UserInfoResponse>> getUserList() throws JandbException {
        return ResponseFactory.createSuccess(userService.getUserList());
    }

    /**
     * 사용자정보 저장
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/saveUser")
    @Operation(summary = "사용자 정보 저장", description = "사용자 정보를 저장한다.")
    public void saveUser(@RequestBody UserInfoRequest userInfoRequest){
        userService.saveUser(userInfoRequest);
    }

    /**
     * 사용자 검증
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/checkUser")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "사용자 검증", description = "사용자를 검증 한다.")
    public Response<String> checkUser(@RequestBody UserInfoRequest userInfoRequest) throws JandbException {
        return ResponseFactory.createSuccess(userService.checkUser(userInfoRequest));
    }

    /**
     * 사용자 목록 조회 querydsl
     * @return 사용자목록
     */
    @GetMapping("/getUserInfoList")
    @Operation(summary = "사용자 목록 조회 querydsl", description = "사용자 목록을 조회 한다. querydsl")
    public List<UserInfoResponse> getUserInfoList(){
        return userService.getUserInfoList();
    }

    /**
     * 사용자정보 삭제
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/deleteUser")
    @Operation(summary = "사용자 정보 삭제", description = "사용자 정보를 삭제 한다.")
    public void deleteUser(@RequestBody UserInfoRequest userInfoRequest){
        userService.deleteUser(userInfoRequest.getUserId());
    }

    /**
     * 사용자 상세 조회
     * @return 사용자목록
     */
    @GetMapping("/getUserInfoDetail")
    @Operation(summary = "사용자 상세 조회", description = "사용자 정보 상세 조회 한다.")
    public UserInfoResponse getUserInfoDetail(@RequestBody UserInfoRequest userInfoRequest){
        return userService.getUserInfoDetail(userInfoRequest.getUserId());
    }

}