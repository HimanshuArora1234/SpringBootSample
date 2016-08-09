import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "entities")
@EnableJpaRepositories(basePackages = "repositories")
@EnableSwagger2
@ComponentScan(basePackages = { "services", "controllers", "Utils" })
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    // see http://heidloff.net/article/usage-of-swagger-2-0-in-spring-boot-applications-to-document-apis/
    // for Swagger test

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .version("0.1.0")
                .contact("himanshu arora")
                .build();
    }
}
