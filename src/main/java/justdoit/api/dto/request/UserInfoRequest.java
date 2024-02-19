package justdoit.api.dto.request;

import justdoit.data.entity.TbUserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRequest {

    private String userId;              //사용자 아아디

    private String userPw;              //사용자 비밀번호

    private String userNm;              //사용자 이름

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
