import org.sql2o.*;
import java.util.List;

public class Stylists {
    private int id;
    private String name;
    private String image;
    private int age;
    private String experience;
    private String specialties;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getAge() {
        return age;
    }

    public String getExperience() {
        return experience;
    }

    public String getSpecialties() {
        return specialties;
    }

    @Override
    public boolean equals(Object _testObj) {
        if (!(_testObj instanceof Stylists))
            return false;
        else {
            Stylists stylistCast = (Stylists) _testObj;
            return this.id == stylistCast.getId() && this.name.equals(stylistCast.getName());
        }
    }

    public static List<Stylists> getAll() {
        String sql = "SELECT * FROM stylists";
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(Stylists.class);
        }
    }

    public Stylists(String name) {
        this.name = name;
    }

    public static Stylists finds(int id) {
        try (Connection conn = DB.sql2o.open()) {
            String sql = "SELECT * FROM stylists WHERE id=:id";
            Stylists stylist = conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Stylists.class);
            return stylist;
        }
    }

    public static Stylists findAll(int id) {
        try (Connection conn = DB.sql2o.open()) {
            String sql = "SELECT * FROM clients WHERE id=:id";
            Stylists stylist = conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Stylists.class);
            return stylist;
        }
    }

    public void update(String name, int age, String experience, String specialties) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE stylists SET name= :name, age= :age, experience= :experience, specialties= :specialties WHERE id= :id";
            con.createQuery(sql).addParameter("name", name).addParameter("age", age)
                    .addParameter("experience", experience).addParameter("specialties", specialties)
                    .addParameter("id", id).executeUpdate();
        }
    }

    public void delete() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM stylists WHERE id = :id;";
            con.createQuery(sql).addParameter("id", id).executeUpdate();
        }
    }
}