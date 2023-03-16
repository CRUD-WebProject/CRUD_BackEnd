package com.example.crud_backend.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenDTO {
    private String key;
    private String value;

    public RefreshTokenDTO refreshValue (String token) {
        this.value = token;
        return this;
    }
}
