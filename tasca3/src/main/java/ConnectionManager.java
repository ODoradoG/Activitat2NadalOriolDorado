import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {

    private static final String URI = "mongodb+srv://25orioldorado_db_user:lHM0LMT1Tkj9sNUF@tasques.by60xnh.mongodb.net/";

    public static MongoDatabase getConnection() {
        MongoClient client = MongoClients.create(URI);
        return client.getDatabase("estadis");
    }
}
