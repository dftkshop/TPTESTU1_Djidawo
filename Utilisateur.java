import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
@Data
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

    public static void ajouter(Utilisateur u) throws EmailInvalidException {
        if (!u.email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new EmailInvalidException("Email invalide !");
        users.add(u);
    }

    public static void supprimer(int id) throws SuppressionInvalidException {
        boolean removed = users.removeIf(u -> u.id == id);
        if (!removed) throw new SuppressionInvalidException("Utilisateur inexistant !");
    }

    public static double analyseSoldeGeneral() throws NegativeGeneralBalanceException {
        double total = users.stream().mapToDouble(u -> u.soldePersonnel).sum();
        if (total < 0) throw new NegativeGeneralBalanceException("Solde général négatif !");
        return total;
    }

    public static Utilisateur utilisateurLePlusRiche() {
        return users.stream().max(Comparator.comparingDouble(u -> u.soldePersonnel)).orElse(null);
    }
}

