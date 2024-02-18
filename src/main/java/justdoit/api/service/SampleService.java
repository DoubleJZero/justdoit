package justdoit.api.service;

import justdoit.api.dto.response.SampleResponse;
import justdoit.api.exception.ExceptionType;
import justdoit.api.exception.JandbException;
import justdoit.api.exception.JandbExceptionFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SampleService {

    public SampleResponse getHelloWorld() throws JandbException {
        Random random = new Random(System.currentTimeMillis());

        if (0 == random.nextInt(100)) {
            throw JandbExceptionFactory.createException(ExceptionType.BUSINESS);
        }

        return SampleResponse.of("Hello World!");
    }
}
