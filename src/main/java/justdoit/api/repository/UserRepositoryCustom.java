package justdoit.api.repository;

import justdoit.api.dto.response.UserInfoResponse;

import java.util.List;

/**
 * UserRepositoryCustom
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public interface UserRepositoryCustom {

    List<UserInfoResponse> getUserInfoList();

    UserInfoResponse getUserInfoDetail(String userId);
}
