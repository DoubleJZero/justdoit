package justdoit.api.security.constance;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UserRole
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public enum UserRole {
    USER("ROLE_USER"),
    MANAGER("ROLE_MANAGER"),
    ADMIN("ROLE_ADMIN");

    private final String name;
}
