package justdoit.api.controller;

import justdoit.api.dto.response.SampleResponse;
import justdoit.api.exception.JandbException;
import justdoit.api.payload.Response;
import justdoit.api.payload.ResponseFactory;
import justdoit.api.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SampleControllerTest
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sample/helloword")
public class SampleController {

    private final SampleService sampleService;

    /**
     * hello world!
     * @return hello world!
     */
    @GetMapping
    public Response<SampleResponse> getHelloWorld() throws JandbException {

        return ResponseFactory.createSuccess(sampleService.getHelloWorld());
    }
}
