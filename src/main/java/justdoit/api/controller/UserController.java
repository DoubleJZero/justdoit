package justdoit.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import justdoit.api.dto.request.UserInfoRequest;
import justdoit.api.dto.response.UserInfoResponse;
import justdoit.api.exception.JandbException;
import justdoit.api.payload.Response;
import justdoit.api.payload.ResponseFactory;
import justdoit.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 *
 * <pre>
 * code history (Record changes as needed)
 * trouble shooting : getUserInfoDetail method
 * issue : GetMapping() Required request body is missing
 * solve : GetMapping() -> PostMapping() change
 * description : @RequestBody have to use PostMapping()
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
    @PutMapping("/saveUser")
    @Operation(summary = "사용자 정보 저장", description = "사용자 정보를 저장한다.")
    public Response<Void> saveUser(@RequestBody UserInfoRequest userInfoRequest) throws JandbException {
        userService.saveUser(userInfoRequest);
        return ResponseFactory.createSuccess();
    }

    /**
     * 사용자 검증
     * @param userInfoRequest 사용자정보DTO
     */
    @PostMapping("/checkUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    public Response<List<UserInfoResponse>> getUserInfoList() throws JandbException {
        return ResponseFactory.createSuccess(userService.getUserInfoList());
    }

    /**
     * 사용자정보 삭제
     * @param userInfoRequest 사용자정보DTO
     */
    @DeleteMapping("/deleteUser")
    @Operation(summary = "사용자 정보 삭제", description = "사용자 정보를 삭제 한다.")
    public Response<Void> deleteUser(@RequestBody UserInfoRequest userInfoRequest) throws JandbException {
        userService.deleteUser(userInfoRequest.getUserId());
        return ResponseFactory.createSuccess();
    }

    /**
     * 사용자 상세 조회
     * @return 사용자목록
     */
    @PostMapping("/getUserInfoDetail")
    @Operation(summary = "사용자 상세 조회", description = "사용자 정보 상세 조회 한다.")
    public Response<UserInfoResponse> getUserInfoDetail(@RequestBody UserInfoRequest userInfoRequest) throws JandbException {
        return ResponseFactory.createSuccess(userService.getUserInfoDetail(userInfoRequest.getUserId()));
    }

}