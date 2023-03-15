package org.acme.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponseError {
    public static final int UNPROCESSABLE_ENTITY_STATUS = 422;

    private String message;
    private Collection<FieldErrror> errors;

    public ResponseError(String message, Collection<FieldErrror> errors) {
        this.message = message;
        this.errors = errors;
    }

    public static <T> ResponseError createFromValidator(Set<ConstraintViolation<T>> violations) {
        List<FieldErrror> errors = violations
                .stream()
                .map(cv -> new FieldErrror(cv.getPropertyPath().toString(), cv.getMessage()))
                .collect(Collectors.toList());

        String message = "Validation Error";
        var responseError = new ResponseError(message, errors);
        return responseError;
    }

    public Response withStatusCode(int code){
        return Response.status(code).entity(this).build();
    }

}
