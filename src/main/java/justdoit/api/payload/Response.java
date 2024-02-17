package justdoit.api.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Response<D> {

    private int status;

    private String code;

    private String message;

    private D data;
}
