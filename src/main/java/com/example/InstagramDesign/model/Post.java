package com.example.InstagramDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Table
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
