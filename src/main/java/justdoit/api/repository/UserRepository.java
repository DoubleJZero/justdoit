package justdoit.api.repository;

import justdoit.data.entity.TbUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 사용자 repository
 *
 * <pre>
 * 코드 히스토리 (필요시 변경사항 기록)
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