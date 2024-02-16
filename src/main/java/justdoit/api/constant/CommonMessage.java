package justdoit.api.constant;

import lombok.Getter;

@Getter
public enum CommonMessage {
    SUCCESS("CM0000", "성공"),
    BAD_REQUEST("CM0001", "잘못된 요청을 했습니다."),
    UNKNOWN("CM9999","알수없는 에러");

    private String code;
    private String message;

    CommonMessage(String code, String message){
        this.code = code;
        this.message = message;
    }
}
