package justdoit.api.redis.constance;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisKeys {

    SAMPLE("sample_redis");

    private final String name;
}
