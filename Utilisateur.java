import java.util.ArrayList;
import java.util.Comparator;

public class Utilisateur {
    private int id;
    private String nom, email, telephone, ville;
    private int age;
    private double soldePersonnel;

    public static ArrayList<Utilisateur> users = new ArrayList<>();

    public Utilisateur(int id, String nom, String email, int age, String tel, String ville, double solde) {
        this.id = id; this.nom = nom; this.email = email;
        this.age = age; this.telephone = tel; this.ville = ville; this.soldePersonnel = solde;
    }

    public static void ajouter(Utilisateur u)  {
       users.add(u);
    }

    public static void supprimer(int id)  {
        boolean removed = users.removeIf(u -> u.id == id);
    }

    public static double analyseSoldeGeneral()   {
        double total = users.stream().mapToDouble(u -> u.soldePersonnel).sum();
        return total;
    }

    public static Utilisateur utilisateurLePlusRiche() {
        return users.stream().max(Comparator.comparingDouble(u -> u.soldePersonnel)).orElse(null);
    }
}
