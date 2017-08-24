import java.util.List;
import org.sql2o.*;

public class Admin {
    private String email;
    private String password;

    public Admin (String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> login() {
        try(Connection conn = DB.sql2o.open()){
            String sql = "SELECT email FROM admin WHERE email = :email AND password = :password;";
            return conn.createQuery(sql)
            .addParameter("email", this.email)
            .addParameter("password", this.password)
            .executeAndFetch(String.class);
        }
    }
}