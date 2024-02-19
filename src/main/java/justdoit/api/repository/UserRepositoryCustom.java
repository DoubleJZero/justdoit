package justdoit.api.repository;

import justdoit.api.dto.response.UserInfoResponse;

import java.util.List;

/**
 * 사용자 querydsl interface
 *
 * <pre>
 * 코드 히스토리 (필요시 변경사항 기록)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public interface UserRepositoryCustom {

    List<UserInfoResponse> getUserInfoList();

    UserInfoResponse getUserInfoDetail(String userId);
}
