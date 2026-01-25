import java.util.List;

import org.bson.Document;

public class Vista {

    public void mostrarEstadis(List<Document> estadis) {
        if (estadis.isEmpty()) {
            System.out.println("No s'han trobat resultats.");
        } else {
            for (Document d : estadis) {
                System.out.println(d);
            }
        }
    }

    public int menu() {
        System.out.println("\n--- MENÚ ESTADIS ---");
        System.out.println("1. Afegir estadi");
        System.out.println("2. Eliminar estadi");
        System.out.println("3. Modificar estadi");
        System.out.println("4. Llistar tots els estadis");
        System.out.println("5. Buscar per any de construcció");
        System.out.println("6. Buscar per nom");
        System.out.println("0. Sortir");
        System.out.print("Opció: ");
        return 0;
    }
}
