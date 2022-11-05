package com.readingIsGood.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomRestError {

    /**
     * Status of the customized REST error in Integer type.
     */
    private Integer status;

    /**
     * Message of the customized REST error in String type.
     */
    private String message;
}
