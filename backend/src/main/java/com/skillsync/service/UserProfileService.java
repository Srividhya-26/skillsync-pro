package com.skillsync.service;

import com.skillsync.dto.UserProfileDTO;
import com.skillsync.entity.UserProfile;
import com.skillsync.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // Convert DTO to Entity
    private UserProfile convertToEntity(UserProfileDTO dto) {
        return UserProfile.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .headline(dto.getHeadline())
                .location(dto.getLocation())
                .about(dto.getAbout())
                .github(dto.getGithub())
                .linkedIn(dto.getLinkedIn())
                .build();
    }

    // Convert Entity to DTO
    private UserProfileDTO convertToDTO(UserProfile profile) {
        return UserProfileDTO.builder()
                .id(profile.getId())
                .name(profile.getName())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .headline(profile.getHeadline())
                .location(profile.getLocation())
                .about(profile.getAbout())
                .github(profile.getGithub())
                .linkedIn(profile.getLinkedIn())
                .build();
    }

    // ✅ Create new profile
    public UserProfile createUserProfile(UserProfileDTO dto) {
        UserProfile entity = convertToEntity(dto);
        return userProfileRepository.save(entity);
    }

    // ✅ Get all profiles
    public List<UserProfileDTO> getAllProfiles() {
        return userProfileRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get single profile by ID
    public UserProfileDTO getProfileById(Long id) {
        return userProfileRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    // ✅ Delete profile
    public void deleteProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
