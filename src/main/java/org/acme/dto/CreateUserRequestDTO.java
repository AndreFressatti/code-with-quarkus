package org.acme.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotNull(message = "Idade é obrigatória")
    private Integer idade;
}
