package justdoit.api.dto.response;

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
 * 코드 히스토리 (필요시 변경사항 기록)
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
public class UserInfoResponse {

    private String userId;              //사용자 아아디

    private String userPw;              //사용자 비밀번호

    private String userNm;              //사용자 이름

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
