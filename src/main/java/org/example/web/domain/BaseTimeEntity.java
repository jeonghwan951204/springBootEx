package org.example.web.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // jpa 엔티티 클래스들이 이 클래스를 상속할 경우 여기 필드를 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)  //이 클래스에 Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate    // Entity가 생성되어 저장하는 시간이 자동으로 생성
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity 값이 변경되는 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
