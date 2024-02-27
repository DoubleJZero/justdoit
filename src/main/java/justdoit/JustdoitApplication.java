package justdoit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * JustdoitApplication
 *
 * <pre>
 * code history (Record changes as needed)
 * </pre>
 *
 * @author JandB
 * @since 1.0
 */
//@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@EnableCaching
@ComponentScan(basePackages = {"justdoit"})
public class JustdoitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustdoitApplication.class, args);
	}

}
