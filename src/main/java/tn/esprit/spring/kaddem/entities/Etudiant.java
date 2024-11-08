package tn.esprit.spring.kaddem.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
@Entity
@Getter@Setter
public class Etudiant implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String nomE;
    private String prenomE;
    @Enumerated(EnumType.STRING)
    private Option op;
    @OneToMany(mappedBy="etudiant", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Contrat> Contracts;
    @ManyToOne
    @JsonIgnore
    private Departement departement;

    public Etudiant() {
        // TODO Auto-generated constructor stub
    }
    public Etudiant(String nomE, String rename) {
        this.nomE = nomE;
        this.prenomE = rename;
    }
    public Etudiant(String nomE, String rename, Option op) {
        super();
        this.nomE = nomE;
        this.prenomE = rename;
        this.op = op;
    }
    public Etudiant(Integer idEtudiant, String nomE, String rename, Option op) {
        super();
        this.idEtudiant = idEtudiant;
        this.nomE = nomE;
        this.prenomE = rename;
        this.op = op;
    }

}