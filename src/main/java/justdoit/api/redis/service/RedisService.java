package justdoit.api.redis.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import justdoit.api.serialize.LocalDateDeserializer;
import justdoit.api.serialize.LocalDateSerializer;
import justdoit.api.serialize.LocalDateTimeDeserializer;
import justdoit.api.serialize.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * RedisService
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Slf4j
@Service
public class RedisService<V> {

    private final Gson gson;

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .create();

        this.redisTemplate = redisTemplate;
    }

    //private final RedisService<dto> redisService;
    //private final RedisService<Map<String, dto>> redisService;
    //redisService.set("REDIS_KEY", dto or map, Duration.of(24L, ChronoUnit.HOURS));
    public void set(String key, V value, Duration timeout) {
        try {
            redisTemplate.opsForValue().set(key, gson.toJson(value), timeout);
        } catch (Exception e) {
            log.error("redis set error : {}", e.getMessage());
        }
    }

    public String getJsonString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    //redisService.getOrNull("REDIS_KEY", Dto.class);
    public <T> T get(String key, Class<T> clazz) {
        String value = getJsonString(key);

        if (ObjectUtils.isEmpty(value)) {
            return null;
        }

        return gson.fromJson(value, clazz);
    }

    //Type mapType = new TypeToken<HashMap<String, Dto>>(){}.getType();
    //Type listType = new TypeToken<List<Dto>>(){}.getType();
    //redisService.getOrNull("REDIS_KEY", mapType);
    public <T> T get(String key, Type type) {
        String value = getJsonString(key);

        if (ObjectUtils.isEmpty(value)) {
            return null;
        }

        return gson.fromJson(value, type);
    }
}
