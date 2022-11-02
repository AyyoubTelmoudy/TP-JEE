package ws;
import jakarta.xml.ws.Endpoint;

public class ServerJWS{
    public static void main(String[] args)
    {
        Endpoint.publish("http://localhost:9191/",new BanqueService());
        System.out.print("web service deployé sur l'dresse http://localhost:9191");
    }
}