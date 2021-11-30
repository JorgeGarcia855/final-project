package co.edu.unbosque.finalproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pet")
public class Pet {
    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @Column(unique = true)
    private String microchip;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String sex;

    @Column
    private String picture;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "username")
    private Owner owner;

    @JsonIgnore
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PetCase> petCases = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Visit> visits = new ArrayList<>();


}
