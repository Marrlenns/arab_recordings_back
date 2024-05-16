package com.example.arab_recording.entities;

import com.example.arab_recording.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "users_table")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    @Column(unique = true)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String activationtoken;
    private Integer code;
    private LocalDateTime code_expiration;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    private Expert expert;

    @OneToOne(cascade = CascadeType.ALL)
    private Admin admin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_DEFAULT"));
        }
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

