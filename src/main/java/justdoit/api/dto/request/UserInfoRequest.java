package justdoit.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import justdoit.data.entity.TbUserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * UserInfoRequest
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 정보 request")
public class UserInfoRequest {

    @Schema(description = "사용자 아아디", example = "jandb")
    private String userId;              //사용자 아아디

    @Schema(description = "사용자 비밀번호", example = "jandb")
    private String userPw;              //사용자 비밀번호

    @Schema(description = "사용자 이름", example = "제임스")
    private String userNm;              //사용자 이름

    @Schema(description = "사용자 생년월일", example = "19900101")
    private String userBirth;           //사용자 생년월일

    /**
     * dto -> entity convert
     * @return entity
     */
    public TbUserInfo toEntity(){
        return TbUserInfo.builder()
                .userId(userId)
                .userPw(userPw)
                .userNm(userNm)
                .userBirth(userBirth)
                .build();
    }
}
