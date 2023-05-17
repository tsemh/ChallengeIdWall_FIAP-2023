package br.com.fiap.ChallengeIdWall.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_CRIME")
public class Crime {
    @Id
    @Column(name = "id_crime")
    @SequenceGenerator(name = "crime", sequenceName = "SQ_CRIME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crime")
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_procurado")
    @JsonBackReference(value="crimes")
    private Procurado procurado;

    public Crime() {}

    public Crime(int id, String tipo, String descricao, Procurado procurado) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.procurado = procurado;
    }

    @JsonBackReference
    public Procurado getProcurado() {
        return procurado;
    }

    public void setProcurado(Procurado procurado) {
        this.procurado = procurado;
    }


    public Integer getId() {
        return id;
    }

    public Crime setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
