package justdoit.api.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import justdoit.api.config.constance.CacheType;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * CacheConfig
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Configuration
public class CacheConfig {

    @Bean
    public List<CaffeineCache> caffeineConfig() {
        return Arrays.stream(CacheType.values())
                .map(cache -> new CaffeineCache(cache.getCacheName(), Caffeine.newBuilder()
                                .recordStats()
                                .expireAfterWrite(cache.getExpireAfterWrite(),
                                        TimeUnit.SECONDS)
                                .maximumSize(cache.getMaximumSize())
                                .build()
                        )
                )
                .collect(Collectors.toList());
    }

    @Bean
    public CacheManager cacheManager(List<CaffeineCache> caffeineCaches) {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caffeineCaches);
        return cacheManager;
    }
}
