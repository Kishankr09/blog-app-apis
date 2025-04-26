package com.kishan.blogappapis.payloads;

import jakarta.validation.constraints.*;


public class UserDto {

    private int id;

    @NotBlank
    @Size(min = 4, max = 20, message = "User Name Must Be min of 4 Char and Max 20 Char" )
    private String name;

    @NotBlank
    @Email(message = "Email address is not validate!")
    private String email;

    @NotBlank
    @Size(min = 4, max = 20, message = "Password Must Be min of 4 Char and Max 20 Char" )
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{4,20}$",
            message = "Password must contain at least one letter, one number, and one special character"
    )
    private String password;

    @NotBlank
    private String about;

    public UserDto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
