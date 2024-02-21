package justdoit.api.service;

import justdoit.api.dto.response.SampleResponse;
import justdoit.api.exception.ExceptionType;
import justdoit.api.exception.JandbException;
import justdoit.api.exception.JandbExceptionFactory;
import justdoit.api.security.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * SampleService
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Service
@Slf4j
public class SampleService {

    public SampleResponse getHelloWorld() throws JandbException {

        //String userId = SecurityUtil.getCurrentUsername().orElse("");

        //log.warn("######################### userId : {} #########################", userId);

        Random random = new Random(System.currentTimeMillis());

        if (0 == random.nextInt(100)) {
            throw JandbExceptionFactory.createException(ExceptionType.BUSINESS);
        }

        return SampleResponse.of("Hello World!");
    }
}
