package project.modele;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    
    
	 // Relation OneToMany entre Client et Compte : 
	 // Un client peut avoir plusieurs comptes associés. 
	 // "mappedBy = 'client'" signifie que la relation est gérée par l'attribut "client" dans l'entité Compte.
	 // "cascade = CascadeType.ALL" permet d'appliquer toutes les opérations effectuées sur un Client
	 // (ajout, modification, suppression) à ses comptes associés.
	 // Par exemple, supprimer un Client supprimera automatiquement tous ses comptes associés dans la base de données.
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Compte> comptes;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @JsonIgnore
    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    
    @JsonIgnore
    // Méthode pour retourner tous les comptes du client
    public List<Compte> getAllComptes() {
        return comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
