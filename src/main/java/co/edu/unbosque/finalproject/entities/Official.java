package co.edu.unbosque.finalproject.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn
public class Official extends UserApp {
    @Column(nullable = false)
    private String name;
}
