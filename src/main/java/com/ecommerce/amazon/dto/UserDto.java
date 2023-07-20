package com.ecommerce.amazon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

        private String name;
        private LocalDate dob;
        private String gender;
        private String email;
  private String phoneno;
  private String password;
    }

