package justdoit.api.feign.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import feign.FeignException;
import feign.Logger;
import feign.Util;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.spring.SpringFormEncoder;
import justdoit.api.feign.response.DummyApiResponse;
import justdoit.api.serialize.LocalDateDeserializer;
import justdoit.api.serialize.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * DummyApiFeignConfig
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Slf4j
@AllArgsConstructor
public class DummyApiFeignConfig {

    private final ObjectFactory<HttpMessageConverters> messageConverters;
    private final ObjectProvider<HttpMessageConverterCustomizer> customizers;

    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .create();

    @Bean
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(() ->
                new HttpMessageConverters(new RestTemplate().getMessageConverters())));
    }

    @Bean
    public Decoder decoder() {
        return new SpringDecoder(messageConverters, customizers) {
            @Override
            public Object decode(feign.Response response, Type type) throws IOException, FeignException {

                final Type listType = new TypeToken<ArrayList<DummyApiResponse>>(){}.getType();
                final String json = Util.toString(response.body().asReader(Util.UTF_8));

                return gson.fromJson(json, listType);
            }
        };
    }

    @Bean
    public ErrorDecoder erorrDecoder() {
        return (methodKey, response) -> {
            log.error("dummyApi : [{}] 요청이 실패했습니다. status:[{}], body:[{}]", methodKey, response.status(), response.body());
            return new Exception("INTERNAL_SERVER_ERROR");
        };
    }

    @Bean
    Logger.Level dummyApiFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
