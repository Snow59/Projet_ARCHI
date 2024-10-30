package com.imt.hamza.Archi_project;



import com.imt.hamza.Archi_project.Client;
import com.imt.hamza.Archi_project.Compte;
import com.imt.hamza.Archi_project.Contrat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ArchiMain {

    public static void main(String[] args) {
        // Créer un client
        Client client = new Client();
        client.setNom("Hamza Yahiani");
        client.setEmail("hamza@example.com");

        // Créer des comptes pour ce client
        Compte compte1 = new Compte();
        compte1.setNom("Compte courant");
        compte1.setType("Courant");
        compte1.setSolde(new BigDecimal("1500.00"));
        compte1.setClient(client);
        compte1.setId(1);

        Compte compte2 = new Compte();
        compte2.setNom("Livret A");
        compte2.setType("Épargne");
        compte2.setSolde(new BigDecimal("3000.00"));
        compte2.setClient(client);
        compte2.setId(2);

        client.setComptes(List.of(compte1, compte2));

        System.out.println("Comptes associés au client " + client.getNom() + " :");
        for (Compte compte : client.getAllComptes()) {
            System.out.println(compte);
        }
    }
}


