package justdoit.api.exception;

/**
 * JandbExceptionFactory
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
public class JandbExceptionFactory {

    /**
     * createException
     * @param info ExceptionInfo
     * @return JandbException
     */
    public static JandbException createException(ExceptionInfo info){

        return switch (info.getHttpStatus()) {
            case BAD_REQUEST -> new BadRequestException(info);
            case UNAUTHORIZED -> new UnauthorizedException(info);
            case FORBIDDEN -> new ForbiddenException(info);
            case NOT_FOUND -> new NotFoundException(info);
            default -> new BusinessException(info);
        };
    }
}
