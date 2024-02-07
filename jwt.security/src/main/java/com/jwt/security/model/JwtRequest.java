package com.jwt.security.model;

import lombok.*;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Data
public class JwtRequest {

    private  String email;
    private  String password;
}
