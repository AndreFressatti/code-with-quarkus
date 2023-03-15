package org.acme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldErrror {
    private String field;
    private String message;

    public FieldErrror(String field, String message){
        this.field = field;
        this.message = message;
    }
}
