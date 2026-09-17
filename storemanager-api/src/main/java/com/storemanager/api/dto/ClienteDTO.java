package com.storemanager.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class ClienteDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String telefono;

    

}
