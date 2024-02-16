package justdoit.api.service;

import justdoit.api.dto.response.SampleResponse;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public SampleResponse getHelloWorld() {
        return SampleResponse.of("Hello World!");
    }
}
