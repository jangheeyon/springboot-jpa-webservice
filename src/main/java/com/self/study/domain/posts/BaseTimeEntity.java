package com.self.study.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //JPA 엔티티 클래스들이 이 엔티티를 상속할 경우 필드들도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)  //엔티티에 auditing 기능을 포함
public class BaseTimeEntity {

    //생성 일자
    @CreatedDate    //엔티티가 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    //수정 일자
    @LastModifiedDate   //조회한 엔티티의 값을 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;
}
