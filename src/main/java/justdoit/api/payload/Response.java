package justdoit.api.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Response
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Schema(description = "Response")
public class Response<D> {

    @Schema(description = "응답 상태 값", example = "200")
    private int status;

    @Schema(description = "응답 상태 코드", example = "CM0000")
    private String code;

    @Schema(description = "응답 상태 메세지", example = "Success")
    private String message;

    @Schema(description = "응답 데이터", example = "{}")
    private D data;
}
