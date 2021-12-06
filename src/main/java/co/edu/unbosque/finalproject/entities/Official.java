package co.edu.unbosque.finalproject.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Official")
@PrimaryKeyJoinColumn
public class Official extends UserApp {
    @Column(nullable = false)
    private String name;
}
