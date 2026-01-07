package estadis;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Main {

    private static final String URI =
            "mongodb+srv://25orioldorado_db_user:JT8qLYozyBYBerBN@tasques.by60xnh.mongodb.net/";

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create(URI)) {

            MongoDatabase database = mongoClient.getDatabase("estadis");
            EstadisDAO dao = new EstadisDAO(database);

            dao.mostrarEstadisPerPais("Espanya");
        }
    }
}
