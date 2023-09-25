package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_nationality")
public class Nacionalidade {

    @Id
    @Column(name = "nationality_id")
    @SequenceGenerator(name = "nationality", sequenceName = "sq_nationality", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nationality")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value="country")
    private Pais country;
    public Nacionalidade() {
    }
}
