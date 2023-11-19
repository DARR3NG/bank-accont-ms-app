package com.elkastali.accountservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String firstName;
    private String LastName;
    private String email;

}
