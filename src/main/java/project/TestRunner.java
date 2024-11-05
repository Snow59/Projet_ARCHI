package project;

import project.modele.Client;
import project.controller.ControllerLayer;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

//@Component   // ça veut dire qu'il démarre quand le client spring boot aura demarré 
public class TestRunner implements CommandLineRunner {

    private final ControllerLayer clientController;

    public TestRunner(ControllerLayer clientController) {
        this.clientController = clientController;
    }

    @Override
    public void run(String... args) throws Exception {
        // Test de création d'un client
        Client client = new Client();
        client.setNom("Hamza Yahiani");
        client.setEmail("hamza@example.com");
        
        ResponseEntity<Client> createdClientResponse = clientController.createClient(client);
        Client createdClient = createdClientResponse.getBody();
        System.out.println("Client créé : " + createdClient);

        // Test de récupération de tous les clients
        ResponseEntity<List<Client>> allClientsResponse = clientController.getAllClients();
        System.out.println("Liste de tous les clients : " + allClientsResponse.getBody());

        // Test de récupération d'un client par ID
        ResponseEntity<Client> fetchedClientResponse = clientController.getClientById(createdClient.getId());
        System.out.println("Client récupéré par ID : " + fetchedClientResponse.getBody());

        // Test de mise à jour du client
        Client clientDetails = new Client();
        clientDetails.setNom("Hamza Y.");
        clientDetails.setEmail("hamza_updated@example.com");
        
        ResponseEntity<Client> updatedClientResponse = clientController.updateClient(createdClient.getId(), clientDetails);
        System.out.println("Client mis à jour : " + updatedClientResponse.getBody());

        // Test de suppression du client
        ResponseEntity<Void> deleteResponse = clientController.deleteClient(createdClient.getId());
        System.out.println("Client supprimé, réponse : " + deleteResponse.getStatusCode());
        
        // Vérification que le client a bien été supprimé
        ResponseEntity<List<Client>> finalClientsResponse = clientController.getAllClients();
        System.out.println("Liste des clients après suppression : " + finalClientsResponse.getBody());
    }
}
