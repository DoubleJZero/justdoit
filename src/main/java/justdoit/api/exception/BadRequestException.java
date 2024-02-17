package justdoit.api.exception;

/**
 * BadRequestException
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class BadRequestException extends JandbException {

    public BadRequestException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo);
    }
}
