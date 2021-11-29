package co.edu.unbosque.finalproject.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserApp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserApp {
    @Id @Column(nullable = false, updatable = false)
    private String username;
    @Column(nullable = false, updatable = false)
    private String password;
    @Column(nullable = false) @Email
    private String email;
    @Column(nullable = false, updatable = false)
    private String role;
}
