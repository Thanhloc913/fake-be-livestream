package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Create sample users if they don't exist
        if (!userRepository.existsByEmail("admin@example.com")) {
            User admin = new User();
            admin.setEmail("huynhthanhloc913@gmail.com");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            admin.setName("Administrator");
            admin.setAvatarUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKAqh9kLO2kw1u9_XN16gyCeKsekEovMnUhP1WaI0ylJnT695nKasAiBmNwMiGV1kk6LlwWVsmjmNRJq8Qc0ih_ZPH2ws1nxULIpGXkig");
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
            
            System.out.println("Created admin user: admin@example.com / admin123456");
        }
        
        if (!userRepository.existsByEmail("user@example.com")) {
            User user = new User();
            user.setEmail("user@example.com");
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123456"));
            user.setName("Regular User");
            user.setAvatarUrl(null);
            user.setRole(User.Role.USER);
            userRepository.save(user);
            
            System.out.println("Created regular user: user@example.com / user123456");
        }
        
        if (!userRepository.existsByEmail("moderator@example.com")) {
            User moderator = new User();
            moderator.setEmail("moderator@example.com");
            moderator.setUsername("moderator");
            moderator.setPassword(passwordEncoder.encode("mod123456"));
            moderator.setName("Moderator User");
            moderator.setAvatarUrl(null);
            moderator.setRole(User.Role.MODERATOR);
            userRepository.save(moderator);
            
            System.out.println("Created moderator user: moderator@example.com / mod123456");
        }
    }
}