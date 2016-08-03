import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "entities")
@EnableJpaRepositories(basePackages = "repositories")
@ComponentScan(basePackages = { "services", "controllers" })
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
