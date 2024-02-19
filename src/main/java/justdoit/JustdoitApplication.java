package justdoit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"justdoit"})
public class JustdoitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustdoitApplication.class, args);
	}

}
