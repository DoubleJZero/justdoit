package justdoit.api.security.service;

import justdoit.api.repository.UserRepository;
import justdoit.api.security.constance.UserRole;
import justdoit.data.entity.TbUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JandbUserDetailsService
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Component("userDetailsService")
@RequiredArgsConstructor
public class JandbUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    // 로그인시에 DB에서 유저정보와 권한정보를 가져와서 해당 정보를 기반으로 userdetails.User 객체를 생성해 리턴
    public UserDetails loadUserByUsername(final String username) {
        TbUserInfo userInfo = userRepository.findByUserId(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다.");
        }

        return createUser(username, userInfo);
    }

    private User createUser(String username, TbUserInfo user) {
        /*if (!user.isActivated()) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }*/

        /*List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());*/

        // TODO 현시점 권한을 따로 관리하지 않기때문에 임의 하드코딩 데이터 사용
        List<String> dumpAuthList = List.of(UserRole.USER.getName(),UserRole.MANAGER.getName());

        List<GrantedAuthority> grantedAuthorities = dumpAuthList.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(user.getUserId(),
                user.getUserPw(),
                grantedAuthorities);
    }
}
