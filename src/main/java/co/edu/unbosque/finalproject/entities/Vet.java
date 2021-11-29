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
public class Vet extends UserApp {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;
}
