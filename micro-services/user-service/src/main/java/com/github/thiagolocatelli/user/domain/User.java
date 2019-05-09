package com.github.thiagolocatelli.user.domain;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @PrePersist
    public void preInsert() {
        if (this.createdAt == null)
            this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("createdAt", createdAt).toString();
    }
}