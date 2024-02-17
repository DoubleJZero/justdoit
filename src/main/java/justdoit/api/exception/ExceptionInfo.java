package justdoit.api.exception;

import org.springframework.http.HttpStatus;

/**
 * ExceptionInfo
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public interface ExceptionInfo {

    String getCode();
    String getMessage();
    HttpStatus getHttpStatus();
}
