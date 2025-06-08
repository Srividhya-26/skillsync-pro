package com.skillsync.controller;

import com.skillsync.dto.UserProfileDTO;
import com.skillsync.entity.UserProfile;
import com.skillsync.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-profiles")
@CrossOrigin(origins = "*") // Enable frontend access
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    // ✅ GET all user profiles
    @GetMapping
    public List<UserProfileDTO> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }

    // ✅ POST - Create new user profile
    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfileDTO dto) {
        UserProfile createdProfile = userProfileService.createUserProfile(dto);
        return ResponseEntity.ok(createdProfile);
    }

    // ✅ Optionally: GET one profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getProfileById(@PathVariable Long id) {
        UserProfileDTO dto = userProfileService.getProfileById(id);
        return ResponseEntity.ok(dto);
    }

    // ✅ Optionally: DELETE profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        userProfileService.deleteProfile(id);
	userProfileService.getAllProfiles();
	userProfileService.getProfileById(id);


        return ResponseEntity.noContent().build();
    }
}
