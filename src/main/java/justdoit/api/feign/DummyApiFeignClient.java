package justdoit.api.feign;

import justdoit.api.feign.config.DummyApiFeignConfig;
import justdoit.api.feign.response.DummyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "dummyApi", url = "${dommy-feign.url}/products", configuration = DummyApiFeignConfig.class)
public interface DummyApiFeignClient {

    @GetMapping
    List<DummyApiResponse> getDummyApi();
}
