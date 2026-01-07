package estadis;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EstadisDAO {

    private final MongoCollection<Document> estadis;

    public EstadisDAO(MongoDatabase database) {
        this.estadis = database.getCollection("estadis");
    }

    public void inserirEstadi(Document estadi) {
        estadis.insertOne(estadi);
    }

    public void mostrarEstadisPerPais(String pais) {
        for (Document doc : estadis.find(new Document("pais", pais))) {
            System.out.println(doc.toJson());
        }
    }

    public void actualitzarCapacitat(String nom, int capacitat) {
        estadis.updateOne(
                new Document("nom", nom),
                new Document("$set", new Document("capacitat", capacitat))
        );
    }

    public void eliminarEstadi(String nom) {
        estadis.deleteOne(new Document("nom", nom));
    }
}
