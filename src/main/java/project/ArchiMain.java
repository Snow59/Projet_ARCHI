package project;

import project.modele.Client;
import project.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ArchiMain {

    public static void main(String[] args) {
        // Démarrer l'application Spring Boot et récupérer le contexte
        ApplicationContext context = SpringApplication.run(ArchiMain.class, args);

        // Récupérer le service ClientService depuis le contexte Spring
        ClientService clientService = context.getBean(ClientService.class);

        // 1. Créer un client
        Client client = new Client();
        client.setNom("Hamza Yahiani");
        client.setEmail("hamza@example.com");
        Client savedClient = clientService.createClient(client);
        System.out.println("Client créé : " + savedClient);

        // 2. Récupérer tous les clients
        System.out.println("Liste de tous les clients : " + clientService.getAllClients());

        // 3. Récupérer un client par ID
        Client fetchedClient = clientService.getClientById(savedClient.getId());
        System.out.println("Client récupéré par ID : " + fetchedClient);

        // 4. Mettre à jour le client
        fetchedClient.setNom("Hamza Y.");
        Client updatedClient = clientService.updateClient(fetchedClient.getId(), fetchedClient);
        System.out.println("Client mis à jour : " + updatedClient);

        // 5. Supprimer le client
        clientService.deleteClient(updatedClient.getId());
        System.out.println("Client supprimé. Liste actuelle des clients : " + clientService.getAllClients());
    }
}
