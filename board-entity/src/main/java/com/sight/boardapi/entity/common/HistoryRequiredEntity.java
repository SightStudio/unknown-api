package com.sight.boardapi.entity.common;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class HistoryRequiredEntity {

    @CreatedDate
    @Column(name = "reg_date")
    protected LocalDateTime regDate;
}