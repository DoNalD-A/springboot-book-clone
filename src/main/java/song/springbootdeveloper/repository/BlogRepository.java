package song.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import song.springbootdeveloper.domain.Article;

// repository는 interface로 선언한 이유 -> JPA(Spring)가 프록시 객체를 생성하여 구현을 자동으로 제공하기 때문(?)
public interface BlogRepository extends JpaRepository<Article, Long> {
}
