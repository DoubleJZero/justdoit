package justdoit.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import justdoit.data.entity.TbUserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * UserInfoResponse
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Schema(description = "사용자 정보 response")
public class UserInfoResponse {

    @Schema(description = "사용자 아아디", example = "jandb")
    private String userId;              //사용자 아아디

    @Schema(description = "사용자 비밀번호", example = "jandb")
    private String userPw;              //사용자 비밀번호

    @Schema(description = "사용자 이름", example = "제임스")
    private String userNm;              //사용자 이름

    @Schema(description = "사용자 생년월일", example = "19900101")
    private String userBirth;           //사용자 생년월일

    /**
     * entity -> dto convert
     * @param tbUserInfo 사용자정보 entity
     * @return UserInfoDto
     */
    public static UserInfoResponse of(TbUserInfo tbUserInfo){
        return UserInfoResponse.builder()
                .userId(tbUserInfo.getUserId())
                .userPw(tbUserInfo.getUserPw())
                .userNm(tbUserInfo.getUserNm())
                .userBirth(tbUserInfo.getUserBirth())
                .build();
    }
}
