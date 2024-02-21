package justdoit.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "00 Sample", description = "Sample API")
public class SampleController {

    private final SampleService sampleService;

    /**
     * hello world!
     * @return hello world!
     */
    @Operation(summary = "sample hello world return", description = "hello world 를 반환한다.")
    @GetMapping
    public Response<SampleResponse> getHelloWorld() throws JandbException {

        return ResponseFactory.createSuccess(sampleService.getHelloWorld());
    }
}
