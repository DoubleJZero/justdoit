package justdoit.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ExceptoinType
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Getter
public enum ExceptionType implements ExceptionInfo {
    SUCCESS("CM0000", "Success", HttpStatus.OK),
    BAD_REQUEST("CM0001", "You made an incorrect request.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("CM0002", "There is no credentials.", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("CM0003", "You do not have access.", HttpStatus.FORBIDDEN),
    NOT_FOUND("CM0004", "The requested page could not be found.", HttpStatus.NOT_FOUND),
    BUSINESS("CM0005", "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    UNKNOWN("CM9999","An unknown error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ExceptionType(String code, String message, HttpStatus httpStatus){
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
