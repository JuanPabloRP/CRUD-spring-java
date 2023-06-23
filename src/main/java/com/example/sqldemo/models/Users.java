package com.example.sqldemo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Data
@Table(name="users")
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
