import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Estadi {

    private ObjectId id;
    private String nom;
    private String ciutat;
    private String pais;
    private String clubPrincipal;
    private int capacitat;
    private int anyInauguracio;
    private List<Double> coordinates;

    public Estadi(String nom, String ciutat, String pais, String clubPrincipal, int capacitat, int anyInauguracio, List<Double> coordinates) {

        this.id = new ObjectId();
        this.nom = nom;
        this.ciutat = ciutat;
        this.pais = pais;
        this.clubPrincipal = clubPrincipal;
        this.capacitat = capacitat;
        this.anyInauguracio = anyInauguracio;
        this.coordinates = coordinates;
    }

    public Document toDocument() {
        Document ubicacio = new Document();
        ubicacio.put("type", "Point");
        ubicacio.put("coordinates", coordinates);

        Document doc = new Document();
        doc.put("_id", id);
        doc.put("nom", nom);
        doc.put("ciutat", ciutat);
        doc.put("pais", pais);
        doc.put("clubPrincipal", clubPrincipal);
        doc.put("capacitat", capacitat);
        doc.put("anyInauguracio", anyInauguracio);
        doc.put("ubicacio", ubicacio);

        return doc;
    }

    public ObjectId getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
