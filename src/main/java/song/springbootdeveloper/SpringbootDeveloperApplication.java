package song.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //엔티티의 createdAt, updatedAt을 자동으로 업데이트 하는 어노테이션
@SpringBootApplication
public class SpringbootDeveloperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDeveloperApplication.class, args);
    }

}
