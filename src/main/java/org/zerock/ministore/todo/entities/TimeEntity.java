package org.zerock.ministore.todo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)

public abstract class TimeEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    protected LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="moddate")
    protected LocalDateTime modDate;
}
