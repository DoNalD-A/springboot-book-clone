package song.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class) // JPA에서 엔티티의 생성,수정 정보를 자동으로 관리할 때 사용
@Entity
@Getter //lombok이 제공하는 메서드 -> 필드값을 get하는 메서드를 추가해준다
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자(접근 제어자: protected)
public class Article {
    @Id //기본키를 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT와 같은 기능
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder //빌더 패턴 -> 어떤 필드에 값을 할당하는지 확인하기 좋음 (가독성 up)
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //수정(UPDATE)를 위한 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //엔티티가 생성될 때 생성 시간 저장
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //엔티티가 수정될 때 수정 시간 저장
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}