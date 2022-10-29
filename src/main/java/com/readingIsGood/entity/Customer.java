package com.readingIsGood.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    /**
     * ID of an Instance in Long type.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /**
     * Customer name in String type.
     */
    private String name;
    /**
     * Customer name in String type.
     */
    private String address;
    /**
     * Customer Type in String type.
     */
    private String customerType;
    /**
     * Customer email in String type.
     */
    private String email;
    /**
     * Customer phone in String Type
     */
    private String phone;
    /**
     * Customer createDate Time in LocalDateTime type.
     */
    @CreatedDate
    private LocalDateTime createDateTime;



}
