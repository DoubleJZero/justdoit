package justdoit.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.customizers.OpenApiBuilderCustomizer;
import org.springdoc.core.customizers.ServerBaseUrlCustomizer;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.JavadocProvider;
import org.springdoc.core.service.OpenAPIService;
import org.springdoc.core.service.SecurityService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.filter.ForwardedHeaderFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
@Profile("!prod")
public class SwaggerConfig {

    @Value("${swagger.host.domain}")
    private String domain;

    @Value("${swagger.host.protocol}")
    private String protocol;

    public Info apiInfo() {
        return new Info().title("justdoit api").description("just do it !!").version("1.0.0");
    }

    @Bean
    public OpenAPI defaultOpenApi() {

        //우측 상단에 Authorize 버튼이 생성
        //로그인을 하여 accessToken 값을 입력하면 인증 완료
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");

        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
                .security(Collections.singletonList(securityRequirement))
                .info(apiInfo());
    }

    @Bean
    public ForwardedHeaderFilter forwardedHeaderFilter() {
        return new SwaggerForwardedHeaderFilter();
    }

    public static class SwaggerForwardedHeaderFilter extends ForwardedHeaderFilter {

        @Override
        protected boolean shouldNotFilter(HttpServletRequest request) {

            return !request.getRequestURI().contains("swagger") || super.shouldNotFilter(request);
        }
    }

    @Primary
    public OpenAPIService prefixAdjustedOpenApiService(
        Optional<OpenAPI> openApi,
        SecurityService securityParser,
        SpringDocConfigProperties springDocConfigProperties,
        PropertyResolverUtils propertyResolverUtils,
        Optional<List<OpenApiBuilderCustomizer>> openApiBuilderCustomizerList,
        Optional<List<ServerBaseUrlCustomizer>> serverBaseUrlCustomizerList,
        Optional<JavadocProvider> javadocProvider
    ) {

        return new PrefixAdjustedOpenApiService(
                openApi
                , securityParser
                , springDocConfigProperties
                , propertyResolverUtils
                , openApiBuilderCustomizerList
                , serverBaseUrlCustomizerList
                , javadocProvider);
    }

    public  class PrefixAdjustedOpenApiService extends OpenAPIService {

        /**
         * Instantiates a new Open api builder.
         *
         * @param openAPI                   the open api
         * @param securityParser            the security parser
         * @param springDocConfigProperties the spring doc config properties
         * @param propertyResolverUtils     the property resolver utils
         * @param openApiBuilderCustomizers the open api builder customisers
         * @param serverBaseUrlCustomizers  the server base url customizers
         * @param javadocProvider           the javadoc provider
         */
        public PrefixAdjustedOpenApiService(
                Optional<OpenAPI> openAPI
                , SecurityService securityParser
                , SpringDocConfigProperties springDocConfigProperties
                , PropertyResolverUtils propertyResolverUtils
                , Optional<List<OpenApiBuilderCustomizer>> openApiBuilderCustomizers
                , Optional<List<ServerBaseUrlCustomizer>> serverBaseUrlCustomizers
                , Optional<JavadocProvider> javadocProvider) {

            super(openAPI, securityParser, springDocConfigProperties
                    , propertyResolverUtils, openApiBuilderCustomizers
                    , serverBaseUrlCustomizers, javadocProvider);
        }

        @Override
        public void updateServers(OpenAPI openApi) {
            openApi.setServers(Collections.singletonList(new Server().url(protocol + "://" + domain)));
        }
    }
}
