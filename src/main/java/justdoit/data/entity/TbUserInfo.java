package justdoit.data.entity;

import jakarta.persistence.*;
import justdoit.data.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;


/**
 * 사용자 Entity
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Entity
@Getter
@Setter
@DynamicInsert
@Table(name = "TB_USER_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbUserInfo extends BaseTimeEntity {

    @Id
    @Column(name = "USER_ID", nullable = false, length = 20)
    private String userId;                                      //사용자 아이디

    @Column(name = "USER_PW")
    private String userPw;                                      //사용자 비밀번호

    @Column(name = "USER_NM", length = 30)
    private String userNm;                                      //사용자 이름

    @Column(name = "USER_BIRTH", length = 8)
    private String userBirth;                                   //사용자 생년월일

    @Builder
    public TbUserInfo(String userId, String userPw, String userNm, String userBirth){
        this.userId = userId;
        this.userPw = userPw;
        this.userNm = userNm;
        this.userBirth = userBirth;
    }
}