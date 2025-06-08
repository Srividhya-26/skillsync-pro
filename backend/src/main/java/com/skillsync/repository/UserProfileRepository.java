// src/main/java/com/skillsync/repository/UserProfileRepository.java
package com.skillsync.repository;

import com.skillsync.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
