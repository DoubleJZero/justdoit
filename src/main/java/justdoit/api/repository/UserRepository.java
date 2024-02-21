package justdoit.api.repository;

import justdoit.data.entity.TbUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<TbUserInfo, Long>, UserRepositoryCustom {
    TbUserInfo findByUserId(String userId);

    TbUserInfo findByUserIdAndUserPw(String userId, String userPw);

    void deleteByUserId(String userId);
}