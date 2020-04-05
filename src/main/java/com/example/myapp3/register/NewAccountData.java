package com.example.myapp3.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewAccountData {

    private String name;

    private String password;

    private String email;

    private String comment;
}
