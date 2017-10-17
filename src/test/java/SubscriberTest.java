import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SubscriberTest {
    @Before
    public void setUp (){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/salon_test", "leroy", "2712");
    }

    @After
    public void tearDown (){
        try(Connection conn = DB.sql2o.open()){
            String sql = "DELETE FROM newsletter *;";
            conn.createQuery(sql).executeUpdate();
        }
    }

    @Test
    public void equals_returnsTrueIfSubscriberssAretheSame() {
        Subscriber firstSubscriber = new Subscriber("leroyomondi@gmail.com");
        Subscriber secondSubscriber = new Subscriber("leroyomondi@gmail.com");
        assertTrue(firstSubscriber.equals(secondSubscriber));
    }

    @Test
    public void save_returnsTrueIfSubscribersAretheSame() {
        Subscriber mySubscriber = new Subscriber("leroyomondi@gmail.com");
        mySubscriber.save();
        assertTrue(Subscriber.all().get(0).equals(mySubscriber));
    }
}