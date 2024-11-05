# Hamza Yahiani

Schema de l'architecture de mon Application java Bancaire.

![Aperçu de l'application](schema2.gif)





## 1 ControllerLayer :

- Point d'entrée de l'API.
- Reçoit les requêtes HTTP (POST, GET, PUT, DELETE) depuis l'extérieur.
- Transmet les données (comme un `Client`) à `ServiceLayer` pour traitement.
- Récupère la réponse de `ClientService` et renvoie une réponse HTTP au client (application front-end, autre service, etc.).

## 2 ServiceLayer :

- Contient la `logique` métier de l’application.
- Gère les opérations nécessaires pour chaque requête (création, mise à jour, suppression, etc.) en utilisant les méthodes du `RepositoryLayer`
- Peut appliquer des règles spécifiques avant de transmettre les données au dépôt (exemple : vérifier l'existence d'un client avant de l'ajouter).

## 3 RepositoryLayer : 

- S'occupe de l'accès aux données en interagissant directement avec la base de données.
- Étend `JpaRepository` ou `CrudRepository` pour bénéficier des méthodes CRUD de base sans écrire de SQL.
- Traite uniquement les opérations de persistance (sauvegarde, recherche, suppression) et ne contient pas de logique métier.


---

## Déploiement de la Base de Données avec Docker

Pour simplifier le déploiement de l'environnement de développement, nous utilisons Docker pour exécuter une instance de MariaDB, accessible à l'application Java via Docker Compose.

### Prérequis

- **Docker** : Assurez-vous que Docker est installé sur votre machine. Vous pouvez télécharger Docker Desktop depuis [le site officiel](https://www.docker.com/products/docker-desktop).
- **Docker Compose** : Docker Compose est généralement inclus avec Docker Desktop.

### Étapes de Déploiement avec Docker Compose

1. **Configurer le Fichier `docker-compose.yml`**

   Assurez-vous  de bien télécharger `docker-compose.yml` qui est à la racine du projet

2. **Lancer le docker**

   Pour déployer le docker vous pouvez utiliser la commande `docker-compose up -d` , assurez vous de l'utiliser à la racine du projet ( dans un cmd par exemple )

---

## Tester la Base de Données

Pour vérifier que la connexion à la base de données est bien configurée et que les opérations de base fonctionnent correctement, nous utiliserons les fichiers `DatabaseTest` et `GetDatabase`. Ces fichiers permettent respectivement d'ajouter des données dans la table Client et de récupérer les informations présentes dans cette table.
   
