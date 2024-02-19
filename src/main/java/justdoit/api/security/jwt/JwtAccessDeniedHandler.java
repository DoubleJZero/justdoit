package justdoit.api.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import justdoit.api.exception.ExceptionType;
import justdoit.api.exception.JandbExceptionFactory;
import justdoit.api.payload.ResponseFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request
            , HttpServletResponse response
            , AccessDeniedException accessDeniedException) throws IOException {

        //필요한 권한이 없이 접근하려 할때 403
        //ResponseFactory.createError(JandbExceptionFactory.createException(ExceptionType.FORBIDDEN));
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}
