package justdoit.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;

/**
 * LoginRequest
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Getter
@Schema(description = "로그인 request")
public class LoginRequest {

    @NotNull
    @Size(min = 5, max = 20)
    @Schema(description = "사용자 아아디", example = "jandb")
    private String userId;              //사용자 아아디

    @NotNull
    @Size(min = 5, max = 100)
    @Schema(description = "사용자 비밀번호", example = "jandb")
    private String userPw;              //사용자 비밀번호
}
