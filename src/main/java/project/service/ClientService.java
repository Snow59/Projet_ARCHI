package project.service;


import project.modele.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final List<Client> clients = new ArrayList<>();
    private Long nextId = 1L;

    // Méthode pour créer un client
    public Client createClient(Client client) {
        // Vérifier si un client avec le même email existe déjà
        Optional<Client> existingClient = clients.stream()
                .filter(c -> c.getEmail().equals(client.getEmail()))
                .findFirst();

        if (existingClient.isPresent()) {
            throw new IllegalArgumentException("Un client avec cet email existe déjà !");
        }

        // Assigner un ID unique et ajouter le client à la liste
        client.setId(nextId++);
        clients.add(client);
        return client;
    }

    // Méthode pour récupérer tous les clients
    public List<Client> getAllClients() {
        return new ArrayList<>(clients); // Retourne une copie pour éviter les modifications externes
    }

    // Méthode pour récupérer un client par ID
    public Client getClientById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Méthode pour mettre à jour un client
    public Client updateClient(Long id, Client clientDetails) {
        Client client = getClientById(id);
        if (client == null) {
            throw new IllegalArgumentException("Client non trouvé");
        }

        client.setNom(clientDetails.getNom());
        client.setEmail(clientDetails.getEmail());
        // Mettre à jour d'autres champs si nécessaire
        return client;
    }

    // Méthode pour supprimer un client
    public void deleteClient(Long id) {
        clients.removeIf(client -> client.getId().equals(id));
    }
}
