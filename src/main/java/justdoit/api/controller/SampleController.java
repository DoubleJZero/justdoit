package justdoit.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import justdoit.api.dto.response.SampleResponse;
import justdoit.api.exception.JandbException;
import justdoit.api.payload.Response;
import justdoit.api.payload.ResponseFactory;
import justdoit.api.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    @Operation(summary = "sample hello world return", description = "hello world 를 반환한다.")
    public Response<SampleResponse> getHelloWorld() throws JandbException {

        return ResponseFactory.createSuccess(sampleService.getHelloWorld());
    }

    @GetMapping("/getRedis")
    @Operation(summary = "get redis", description = "hello wold get to redis")
    public Response<SampleResponse> getRedis() throws JandbException {

        return ResponseFactory.createSuccess(sampleService.getRedis());
    }

    @PutMapping("/saveRedis")
    @Operation(summary = "save redis", description = "hello wold save to redis")
    public Response<Void> saveRedis() throws JandbException {

        sampleService.saveSampleRedis();

        return ResponseFactory.createSuccess();
    }

    /**
     * cache sample
     * @param strnum string number
     * @return sample
     */
    @Cacheable(cacheNames = "cacheStore", key = "#strnum")
    @GetMapping("/{strnum}")
    @Operation(summary = "cache sample", description = "cache sample guide.")
    public Response<String> getCacheSmaple(@PathVariable("strnum") String strnum)
            throws JandbException {

        return ResponseFactory.createSuccess(sampleService.getCacheSmaple(strnum));
    }

    /**
     * delete cache
     * @param strnum string number
     * @return void
     */
    @CacheEvict(cacheNames = "cacheStore", key = "#strnum")
    @DeleteMapping("/deleteCache/{strnum}")
    @Operation(summary = "cache sample delete", description = "cache sample delete guide.")
    public Response<Void> deleteCache(@PathVariable("strnum") String strnum) {

        return ResponseFactory.createSuccess();
    }
}
