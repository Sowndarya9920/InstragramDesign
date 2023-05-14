package com.example.InstagramDesign.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreatedDate;

    @OneToOne
    private User user;

    public AuthenticationToken(User user){
        this.user=user;
        this.tokenCreatedDate=LocalDate.now();
        this.token= UUID.randomUUID().toString();
    }
}
