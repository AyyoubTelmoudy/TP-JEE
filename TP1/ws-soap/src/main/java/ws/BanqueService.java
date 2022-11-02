package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName ="Convert")
    public double conversion(@WebParam(name ="montant") int mnt){
        return  mnt*11;
    }
    @WebMethod
    public String test(){
        return  "test";
    }
     @WebMethod
    public  Compte getCompte(@WebParam(name = "code") int num )
    {
        return  new Compte(2,500);
    }
}
