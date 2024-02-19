package justdoit.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotNull
    @Size(min = 5, max = 20)
    private String userId;              //사용자 아아디

    @NotNull
    @Size(min = 5, max = 100)
    private String userPw;              //사용자 비밀번호
}
