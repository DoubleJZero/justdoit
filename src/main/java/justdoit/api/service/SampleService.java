package justdoit.api.service;

import justdoit.api.dto.response.SampleResponse;
import justdoit.api.exception.ExceptionType;
import justdoit.api.exception.JandbException;
import justdoit.api.exception.JandbExceptionFactory;
import justdoit.api.feign.DummyApiFeignClient;
import justdoit.api.feign.response.DummyApiResponse;
import justdoit.api.redis.constance.RedisKeys;
import justdoit.api.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
@RequiredArgsConstructor
public class SampleService {

    private final RedisService<SampleResponse> redisService;

    private final DummyApiFeignClient dummyApiFeignClient;

    public SampleResponse getHelloWorld() throws JandbException {

        //String userId = SecurityUtil.getCurrentUsername().orElse("");

        //log.warn("######################### userId : {} #########################", userId);

        Random random = new Random(System.currentTimeMillis());

        if (0 == random.nextInt(100)) {
            throw JandbExceptionFactory.createException(ExceptionType.BUSINESS);
        }

        return SampleResponse.of("Hello World!");
    }

    public SampleResponse getRedis() throws JandbException {

        return redisService.get(RedisKeys.SAMPLE.getName(), SampleResponse.class);
    }

    public void saveSampleRedis() throws JandbException {
        StringBuilder sb = new StringBuilder("Hello World ");
        Random random = new Random(System.currentTimeMillis());

        sb.append(random.nextInt(100));

        redisService.set(RedisKeys.SAMPLE.getName(), SampleResponse.of(sb.toString()), Duration.of(24L, ChronoUnit.HOURS));
    }

    public String getCacheSmaple(String strnum) throws JandbException {
        StringBuilder sb = new StringBuilder("cache sample ");
        int num = 0;

        if (strnum == null) {
            num = 1;
        } else {
            num = Integer.parseInt(strnum);
        }

        Random random = new Random(System.currentTimeMillis());

        sb.append(random.nextInt(100) * num);

        return sb.toString();
    }

    public List<DummyApiResponse> getDummyApi() throws JandbException {

        return dummyApiFeignClient.getDummyApi();
    }
}
