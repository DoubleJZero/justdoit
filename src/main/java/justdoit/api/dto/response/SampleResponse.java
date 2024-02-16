package justdoit.api.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class SampleResponse {

    private String str;

    /**
     * instance return
     * @param str hello world!
     * @return instance
     */
    public static SampleResponse of(String str) {
        return SampleResponse.builder()
                .str(str)
                .build();
    }
}
