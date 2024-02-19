package justdoit.api.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import justdoit.api.exception.ExceptionType;
import justdoit.api.exception.JandbExceptionFactory;
import justdoit.api.exception.UnauthorizedException;
import justdoit.api.payload.ResponseFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 유효한 자격증명을 제공하지 않고 접근하려 할때 401
        //ResponseFactory.createError(JandbExceptionFactory.createException(ExceptionType.UNAUTHORIZED));
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
