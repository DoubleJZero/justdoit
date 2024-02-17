package justdoit.api.exception;

/**
 * UnauthorizedException
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class UnauthorizedException extends JandbException {

    public UnauthorizedException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo);
    }
}
