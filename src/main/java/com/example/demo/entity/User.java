package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;
    
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    
    // Profile Info
    @Column(name = "avatar_url")
    private String avatarUrl;
    
    @Column(name = "cover_url")
    private String coverUrl;
    
    private String bio;
    
    private LocalDate birthdate;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    // Social Info
    @Column(name = "followers_count")
    private Integer followersCount = 0;
    
    @Column(name = "following_count")
    private Integer followingCount = 0;
    
    // Stream Info
    @Column(name = "is_live")
    private Boolean isLive = false;
    
    @Column(name = "stream_title")
    private String streamTitle;
    
    @Column(name = "stream_category")
    private String streamCategory;
    
    @Column(name = "stream_url")
    private String streamUrl;
    
    // Video Info
    @Column(name = "video_count")
    private Integer videoCount = 0;
    
    // Timestamps
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Enums
    public enum Role {
        USER, MODERATOR, ADMIN
    }
    
    public enum Gender {
        MALE, FEMALE, OTHER
    }
}