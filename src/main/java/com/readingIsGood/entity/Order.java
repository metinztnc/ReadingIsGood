package com.readingIsGood.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Order {

    /**
     * ID of an Instance in Long type.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /**
     * Order name in String type.
     */
    private String name;
    /**
     * Order price in BigDecimal type.
     */
    private BigDecimal totalPrice;
    /**
     * Ordering customer id in String type
     */
    private String customerId;
    /**
     * Ordered books in List type
     */
    private List<Book> bookList = new ArrayList<>();
    /**
     * Order createDate time in LocalDateTime type.
     */
    @CreatedDate
    private LocalDateTime createDateTime;



}
