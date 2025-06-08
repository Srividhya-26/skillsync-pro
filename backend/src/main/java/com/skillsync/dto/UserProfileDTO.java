package com.skillsync.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String headline;
    private String location;
    private String about;
    private String github;
    private String linkedIn;
}
