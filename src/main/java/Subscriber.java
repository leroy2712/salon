import org.sql2o.*;
import java.util.List;

public class Subscriber {
    private String email;

    public Subscriber (String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public static List <Subscriber> all() {
        String sql = "SELECT email FROM newsletter;";
        try(Connection conn = DB.sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Subscriber.class);
        }
    }

    @Override
    public boolean equals (Object otherSubscriber){
        if(!(otherSubscriber instanceof Subscriber)){
            return false;
        } else {
            Subscriber newSubscriber = (Subscriber) otherSubscriber;
            return this.getEmail().equals(newSubscriber.getEmail());
        }
    }

    public void save (){
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO newsletter (email) VALUES (:email);";
            conn.createQuery(sql)
                .addParameter("email", this.email)
                .executeUpdate();
        }
    }
}