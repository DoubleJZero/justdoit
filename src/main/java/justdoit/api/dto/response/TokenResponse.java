package justdoit.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

/**
 * TokenResponse
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Schema(description = "토큰 response")
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class TokenResponse {

    @Schema(description = "로그인 토큰", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5kYiIsImF1dGgiOiJST0xFX01BTkFHRVIsUk9MRV9VU0VSIiwiZXhwIjoxNzA4NTY4NTkxfQ.XL8juQh0OS0DODjB8AGtiqrNHOccnt3-rH1LBG1Y1Nkwa994jUywg3vyh_gdQkS7Y4Ubj_LvFKKo7ywFU8lI0Q")
    private String token;

    /**
     * token return
     * @param token token
     * @return token
     */
    public static TokenResponse of(String token) {
        return TokenResponse.builder().token(token).build();
    }
}
