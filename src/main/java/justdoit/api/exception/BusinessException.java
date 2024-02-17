package justdoit.api.exception;

/**
 * BusinessException
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class BusinessException extends JandbException {

    public BusinessException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo);
    }
}
