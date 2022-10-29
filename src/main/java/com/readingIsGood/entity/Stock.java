package com.readingIsGood.entity;



import com.readingIsGood.enumeration.GeneralEnumeration.StatusEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Stock extends BaseEntity{

    /**
     * ID of an Instance in Long type.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /**
     * StockCode for Books in String type.
     */
    private String stockCode;

    /**
     * status for Books in the stock String type.
     */
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.AVAILABLE;

    /**
     * Ordered books in List type
     */
    @OneToMany
    private List<Book> bookList = new ArrayList<>();
    /**
     * Order createDate time in LocalDateTime type.
     */
    @CreatedDate
    private LocalDateTime createDateTime;

}
