package justdoit.api.exception;

/**
 * NotFoundException
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class NotFoundException extends JandbException {

    public NotFoundException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo);
    }
}
