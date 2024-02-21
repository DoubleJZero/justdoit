package justdoit.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

/**
 * SampleResponse
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
@Schema(description = "sample response")
public class SampleResponse {

    @Schema(description = "string", example = "hello world!")
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
