package justdoit.api.exception;

import justdoit.api.payload.Response;
import justdoit.api.payload.ResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * JandbExceptionHandler
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@ControllerAdvice(annotations = RestController.class)
@RestController
@Slf4j
public class JandbExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BadRequestException.class)
    public Response<?> handleException(BadRequestException ex){
        return createCustomError(ex);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Response<?> handleException(UnauthorizedException ex){
        return createCustomError(ex);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public Response<?> handleException(ForbiddenException ex){
        return createCustomError(ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Response<?> handleException(NotFoundException ex){
        return createCustomError(ex);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public Response<?> handleException(BusinessException ex){
        return createCustomError(ex);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public Response<?> handleException(Exception ex){
        log.error("##################################################################");
        log.error(ex.getMessage());
        log.error("##################################################################");
        return createCustomError(JandbExceptionFactory.createException(ExceptionType.UNKNOWN));
    }

    private Response<?> createCustomError(JandbException ex){
        return ResponseFactory.createError(ex);
    }
}
