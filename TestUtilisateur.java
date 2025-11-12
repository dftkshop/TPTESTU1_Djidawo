
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TestUtilisateur {

    @BeforeEach
    void resetList() {
        Utilisateur.users.clear(); // vide la liste avant chaque test
    }

    @Test
    void testAjouterUtilisateurValide() throws EmailInvalidException {
        Utilisateur u = new Utilisateur(1, "Jean", "jean@gmail.com", 25, "678900123", "Yaoundé", 5000);
        Utilisateur.ajouter(u);
        assertEquals(1, Utilisateur.users.size());
    }

    @Test
    void testAjouterEmailInvalide() {
        Utilisateur u = new Utilisateur(2, "Marie", "email_invalide", 20, "690223344", "Douala", 6000);
        assertThrows(EmailInvalidException.class, () -> Utilisateur.ajouter(u));
    }

    @Test
    void testSupprimerUtilisateurValide() throws Exception {
        Utilisateur u = new Utilisateur(3, "Paul", "paul@gmail.com", 30, "678901122", "Bafoussam", 8000);
        Utilisateur.ajouter(u);
        Utilisateur.supprimer(3);
        assertTrue(Utilisateur.users.isEmpty());
    }

    @Test
    void testSupprimerUtilisateurInexistant() {
        assertThrows(SuppressionInvalidException.class, () -> Utilisateur.supprimer(999));
    }

    @Test
    void testAnalyseSoldeGeneralPositif() throws Exception {
        Utilisateur.ajouter(new Utilisateur(1, "A", "a@gmail.com", 20, "600000001", "Yaoundé", 1000));
        Utilisateur.ajouter(new Utilisateur(2, "B", "b@gmail.com", 22, "600000002", "Douala", 2000));
        assertEquals(3000, Utilisateur.analyseSoldeGeneral());
    }

    @Test
    void testAnalyseSoldeGeneralNegatif() throws Exception {
        Utilisateur.ajouter(new Utilisateur(1, "A", "a@gmail.com", 20, "600000001", "Yaoundé", -1000));
        assertThrows(NegativeGeneralBalanceException.class, () -> Utilisateur.analyseSoldeGeneral());
    }

    @Test
    void testUtilisateurLePlusRiche() throws Exception {
        Utilisateur.ajouter(new Utilisateur(1, "A", "a@gmail.com", 20, "600000001", "Yaoundé", 1000));
        Utilisateur.ajouter(new Utilisateur(2, "B", "b@gmail.com", 22, "600000002", "Douala", 7000));
        Utilisateur.ajouter(new Utilisateur(3, "C", "c@gmail.com", 25, "600000003", "Buea", 5000));

        Utilisateur plusRiche = Utilisateur.utilisateurLePlusRiche();
        assertEquals("B", plusRiche.getNom());
        assertEquals(7000, plusRiche.getSoldePersonnel());
    }
}
