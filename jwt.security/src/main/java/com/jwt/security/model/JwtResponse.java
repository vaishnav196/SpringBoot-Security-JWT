package com.jwt.security.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class JwtResponse{

    private String jwtToken;
    private String username;



}
