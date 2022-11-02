package org.example;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class WSClient {
    public static void main(String[] args) {
        BanqueService stub=new BanqueWS().getBanqueServicePort();
        System.out.println(stub.convert(6));
        Compte cp=stub.getCompte(500);
        System.out.println("sold :"+cp.getSolde());
    }
}