package com.ffzu.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Base {
    private Integer code;
    private String message;
}
