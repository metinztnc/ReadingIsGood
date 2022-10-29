package com.readingIsGood.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Book extends BaseEntity{

    /**
     * ID of an Instance in Long type.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /**
     * Book name in String type.
     */
    private String name;
    /**
     * Book price in BigDecimal type.
     */
    private BigDecimal price;
    /**
     * Book unique stock Code in Long type
     */
    private Long stockCode;
    /**
     * Book amount in String type.
     */
    private Long amount;
    /**
     * Book createDate time in LocalDateTime type.
     */
    @CreatedDate
    private Date createDateTime;



}
