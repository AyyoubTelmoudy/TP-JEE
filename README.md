
# Contrôle           
# Matière : JEE 
Nom complet : Ayyoub TELMOUDY
Nom complet : Ayyoub TELMOUDY
Filière : IIR Niveau : 5 
Groupe : G3 / 32

1) customer-service:
 Dans cet etap on crée un microservice qui va gérer les clients et on lui envoie des requêtes http à travers son adresse :
 
![CHEESE!](TP3/steps/customers_microservice.PNG)

2) inventory-service:

 Dans cet etap on crée un microservice qui va gérer les produits et on va faire la même chose que l'étape précédent :
 
 ![CHEESE!](TP3/steps/products_microservice.PNG)
 
 3) Gateway Spring cloud :
    Gateway avec une Configuration statique du système de routage :
 
 ![CHEESE!](TP3/steps/gateway_static_configuration.PNG)

  le microservice customer-service à travers la gateway 

    ![CHEESE!](TP3/steps/customersgateway.PNG)

  le microservice inverntory-service à travers la gateway

    ![CHEESE!](TP3/steps/productsgateway.PNG)

 4) l'annuaire Eureka Discrovery Service :

   ![CHEESE!](TP3/steps/eruka_server.PNG)

 5) Configuration dynamique des routes de la gateway
