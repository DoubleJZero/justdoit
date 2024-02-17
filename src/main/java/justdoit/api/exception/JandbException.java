package justdoit.api.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * JandbException
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = false)
@Getter
public abstract class JandbException extends Exception {

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    public JandbException(ExceptionInfo exceptionInfo) {
        this.code = exceptionInfo.getCode();
        this.message = exceptionInfo.getMessage();
        this.httpStatus = exceptionInfo.getHttpStatus();
    }
}
