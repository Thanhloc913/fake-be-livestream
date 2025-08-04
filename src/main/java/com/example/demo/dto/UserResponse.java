package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String username;
    private String email;
    private User.Role role;
    
    // Profile Info
    private String avatarUrl;
    private String coverUrl;
    private String bio;
    private LocalDate birthdate;
    private User.Gender gender;
    
    // Social Info
    private Integer followersCount;
    private Integer followingCount;
    
    // Stream Info
    private Boolean isLive;
    private String streamTitle;
    private String streamCategory;
    private String streamUrl;
    
    // Video Info
    private Integer videoCount;
    
    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .avatarUrl(user.getAvatarUrl())
                .coverUrl(user.getCoverUrl())
                .bio(user.getBio())
                .birthdate(user.getBirthdate())
                .gender(user.getGender())
                .followersCount(user.getFollowersCount())
                .followingCount(user.getFollowingCount())
                .isLive(user.getIsLive())
                .streamTitle(user.getStreamTitle())
                .streamCategory(user.getStreamCategory())
                .streamUrl(user.getStreamUrl())
                .videoCount(user.getVideoCount())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}