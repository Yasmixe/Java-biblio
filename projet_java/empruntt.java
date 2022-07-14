
import java.time.LocalDate;


public class empruntt {
    int matricule, cote, nbex;
    LocalDate date = LocalDate.now();
    String titre, auteur;

    public empruntt(String titre, String auteur, int matricule, int cote)
    {
        this.titre = titre;
        this.auteur = auteur;
        this.matricule = matricule;
        this.cote = cote;
        
    }
}


