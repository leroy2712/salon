import org.sql2o.*;
import java.util.List;

public class Clients {
    private String client;
    private String email;
    private String name;
    private int id;

    public Clients (String client){
        this.client = client;
    }

    public int getId (){
        return id;
    }

    public String getClient (){
        return client;
    }

    public String getEmail (){
        return email;
    }

    public String getName (){
        return name;
    }

    public static List<Clients> getAll() {
        String sql = "SELECT clients.client, clients.email, stylists.name FROM clients INNER JOIN stylists ON clients.stylist_id=stylists.id;";
        try (Connection conn = DB.sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Clients.class);
        }
    }
}