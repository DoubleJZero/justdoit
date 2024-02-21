package justdoit.api.jasypt;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JasyptProperty
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
@Data
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "encrypt")
@Component
public class JasyptProperty {
    String algolithm;
    int keyObtentionIterations;
    int poolSize;
    String saltGeneratorClassName;
    String stringOutputType;
}
