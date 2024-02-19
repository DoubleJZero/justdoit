package justdoit.api.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class TokenResponse {

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
