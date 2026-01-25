import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.regex;

public class Model {

    private MongoCollection<Document> collection;

    public Model() {
        MongoDatabase db = ConnectionManager.getConnection();
        collection = db.getCollection("estadis");
    }

    public void inserirEstadi(Estadi estadi) {
        collection.insertOne(estadi.toDocument());
    }

    public List<Document> getAllEstadis() {
        List<Document> llista = new ArrayList<>();
        for (Document d : collection.find()) {
            llista.add(d);
        }
        return llista;
    }

    public void eliminarEstadi(ObjectId id) {
        collection.deleteOne(eq("_id", id));
    }

    public void modificarEstadi(ObjectId id, String camp, Object valor) {
        Document dades = new Document();
        dades.put(camp, valor);
        collection.updateOne(eq("_id", id), new Document("$set", dades));
    }

    public List<Document> buscarPerNom(String nom) {
        List<Document> llista = new ArrayList<>();
        for (Document d : collection.find(regex("nom", nom, "i"))) {
            llista.add(d);
        }
        return llista;
    }

    public List<Document> buscarPerAny(int inici, int fi) {
        List<Document> llista = new ArrayList<>();
        for (Document d : collection.find(and(gte("anyInauguracio", inici), lte("anyInauguracio", fi)))) {
            llista.add(d);
        }
        return llista;
    }
}
