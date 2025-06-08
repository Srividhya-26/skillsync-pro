// skillsync-pro/backend/src/main/java/com/skillsync/entity/UserProfile.java
package com.skillsync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for DB

    private String fullName;
    private String email;
    private String phone;
    private String linkedIn;
    private String github;
    private String portfolio;
}
