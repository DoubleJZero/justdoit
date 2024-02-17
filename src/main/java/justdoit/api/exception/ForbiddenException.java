package justdoit.api.exception;

/**
 * ForbiddenException
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class ForbiddenException extends JandbException {

    public ForbiddenException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo);
    }
}
