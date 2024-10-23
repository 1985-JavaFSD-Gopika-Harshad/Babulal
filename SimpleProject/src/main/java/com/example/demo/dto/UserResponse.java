package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserResponse {
	
	    private Long id;             
	    private String username;      
	    private String email;         
	    private String password;    
	    private String firstName; 
	    private String lastName;     
	    private String phoneNumber;
	    private String address;

}
