import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;


public class Controlador {

    private Model model;
    private Vista vista;
    private Scanner sc;

    public Controlador() {
        this.model = new Model();
        this.vista = new Vista();
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }

    public void iniciar() {
        int opcio;
        do {
            opcio = vista.menu();
            opcio = Integer.parseInt(sc.nextLine());
            
            switch (opcio) {
                case 1:
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Ciutat: ");
                    String ciutat = sc.nextLine();
                    System.out.print("País: ");
                    String pais = sc.nextLine();
                    System.out.print("Club principal: ");
                    String clubPrincipal = sc.nextLine();
                    System.out.print("Capacitat: ");
                    int capacitat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Any inauguració: ");
                    int anyInauguracio = sc.nextInt();
                    sc.nextLine();
                    
                    Estadi e = new Estadi(nom, ciutat, pais, clubPrincipal, capacitat, anyInauguracio, Arrays.asList(2.17, 41.38));
                    model.inserirEstadi(e);
                    System.out.println("Estadi afegit correctament.");
                    break;

                case 2:
                    System.out.print("Nom de l'estadi a eliminar: ");
                    String nomEliminar = sc.nextLine();
                    List<Document> estadisEliminar = model.buscarPerNom(nomEliminar);
                    
                    if (estadisEliminar.isEmpty()) {
                        System.out.println("No s'ha trobat cap estadi amb aquest nom.");
                    } else {
                        for (Document d : estadisEliminar) {
                            ObjectId id = d.getObjectId("_id");
                            model.eliminarEstadi(id);
                            System.out.println("Estadi eliminat: " + d.getString("nom"));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nom de l'estadi a modificar: ");
                    String nomModificar = sc.nextLine();
                    List<Document> estadisModificar = model.buscarPerNom(nomModificar);
                    
                    if (estadisModificar.isEmpty()) {
                        System.out.println("No s'ha trobat cap estadi amb aquest nom.");
                    } else {
                        for (Document d : estadisModificar) {
                            ObjectId id = d.getObjectId("_id");
                            System.out.println("\nQuin camp vols modificar?");
                            System.out.println("1. Nom");
                            System.out.println("2. Ciutat");
                            System.out.println("3. País");
                            System.out.println("4. Club principal");
                            System.out.println("5. Capacitat");
                            System.out.println("6. Any inauguració");
                            System.out.print("Opció: ");
                            int opcio2 = sc.nextInt();
                            sc.nextLine();
                            
                            switch (opcio2) {
                                case 1:
                                    System.out.print("Nou nom: ");
                                    String nouNom = sc.nextLine();
                                    model.modificarEstadi(id, "nom", nouNom);
                                    System.out.println("Nom modificat correctament.");
                                    break;
                                case 2:
                                    System.out.print("Nova ciutat: ");
                                    String novaCiutat = sc.nextLine();
                                    model.modificarEstadi(id, "ciutat", novaCiutat);
                                    System.out.println("Ciutat modificada correctament.");
                                    break;
                                case 3:
                                    System.out.print("Nou país: ");
                                    String nouPais = sc.nextLine();
                                    model.modificarEstadi(id, "pais", nouPais);
                                    System.out.println("País modificat correctament.");
                                    break;
                                case 4:
                                    System.out.print("Nou club principal: ");
                                    String nouClub = sc.nextLine();
                                    model.modificarEstadi(id, "clubPrincipal", nouClub);
                                    System.out.println("Club principal modificat correctament.");
                                    break;
                                case 5:
                                    System.out.print("Nova capacitat: ");
                                    int novaCapacitat = sc.nextInt();
                                    sc.nextLine();
                                    model.modificarEstadi(id, "capacitat", novaCapacitat);
                                    System.out.println("Capacitat modificada correctament.");
                                    break;
                                case 6:
                                    System.out.print("Nou any inauguració: ");
                                    int nouAny = sc.nextInt();
                                    sc.nextLine();
                                    model.modificarEstadi(id, "anyInauguracio", nouAny);
                                    System.out.println("Any inauguració modificat correctament.");
                                    break;
                                default:
                                    System.out.println("Opció no vàlida.");
                            }
                        }
                    }
                    break;

                case 4:
                    List<Document> estadis = model.getAllEstadis();
                    vista.mostrarEstadis(estadis);
                    break;

                case 5:
                    System.out.print("Any inicial: ");
                    int anyInici = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Any final: ");
                    int anyFi = sc.nextInt();
                    sc.nextLine();
                    List<Document> estadisAny = model.buscarPerAny(anyInici, anyFi);
                    
                    if (estadisAny.isEmpty()) {
                        System.out.println("No s'han trobat estadis en aquest rang d'anys.");
                    } else {
                        System.out.println("Estadis entre " + anyInici + " i " + anyFi + ":");
                        vista.mostrarEstadis(estadisAny);
                    }
                    break;

                case 6:
                    System.out.print("Nom a buscar: ");
                    String nomBuscar = sc.nextLine();
                    List<Document> estadisNom = model.buscarPerNom(nomBuscar);
                    vista.mostrarEstadis(estadisNom);
                    break;

                case 0:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 0);
        
        sc.close();
    }
}
