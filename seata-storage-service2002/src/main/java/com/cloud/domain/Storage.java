package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;

    private Long productId;

    private Integer residue;

    private Integer total;

    private Integer used;


}
