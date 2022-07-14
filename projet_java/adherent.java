import java.util.ArrayList;
import java.util.Scanner;
public class adherent {
    String nom, prenom;
    int matricule;
//----------------------------------constructeur------------------------------------------------------
    public adherent(String nom, String prenom, int matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }
//--------------------------------Getters & Setters---------------------------------------
    public String getNom() {
        return nom;
    }
//----------------------------------------------------------------------------------------
    public void setNom(String nom) {
        this.nom = nom;
    }
//----------------------------------------------------------------------------------------
    public String getPrenom() {
        return prenom;
    }
//----------------------------------------------------------------------------------------
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
//----------------------------------------------------------------------------------------
    public int getMatricule() {
        return matricule;
    }
//----------------------------------------------------------------------------------------
    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
//---------------------------------------------------------------------------------------- 
//-----------------------les methodes----------------------------------------------------- 
//------------------------Ajouter un Etudiant---------------------------------------------
    public void ajouter_etd(adherent m, ArrayList<adherent> doc4) {
        
        int i= 0; 
        boolean existe = false;
        while(i< doc4.size() && existe==false) // l'idee est de parcourir notre arrayliste pour tester si l'etudiant existe deja
        {// on teste avec le matricule car il est unique, on compare les matricules 
            if(doc4.get(i).matricule==m.getMatricule())
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==false) // ici on trouve que l'etd n'existe pas donc on l'ajoute 
        {
            doc4.add(m);
            System.out.println("etd ajoute");
        }
        else{ // l'etd est deja dans la liste donc on l'ajoute pas 
            System.out.println("cet etd existe deja");
        }
    }
//----------------------------------------------------------------------------------------
//------------------------Afficher la liste des Etudiants---------------------------------

    static void afficher_liste_etd(ArrayList<adherent> doc4) // on parcourt notre arrayliste et on affiche le nom, prenom et matricule
    {
        for(adherent elem:doc4) // boucle pour parcourir et afficher. 
        {
            System.out.println(elem.nom+ "  "+ elem.prenom+ "  "+ elem.matricule+"\n");
        } 
    }
//----------------------------------------------------------------------------------------
//------------------------modifier un  Etudiants------------------------------------------
    static void modifier_etd(ArrayList<adherent> doc4, int matricule)
    { // on teste dabord si l'etd existe deja dans notre arraylist, si c'est le cas on le modifie sinon on peut pas. 
        int j= 0; 
        boolean exist = false; 
        while(j< doc4.size() && exist==false)
        {
            if(doc4.get(j).matricule==matricule) // parcourir la liste des etudiants, tester avec le matricule et le comparer au matricule qu'on est entrain de chercher
            {
                exist = true;
            }
            else { j++; }
        }
        if(exist==true) // ici on trouve que l'etd existe dans la liste donc on demande au utilisateur dintroduire les nouvelles infos
        { // faire la mise a jours par la suite, pour cela on utilise les setters 
            Scanner nb = new Scanner(System.in);
            // lecture des nouveaux attributs.
            System.out.println("entrer les infos de letd que vous voulez modifier");
            System.out.println("donner un nom \n");
            String nom = nb.next();
            System.out.println("donner son prenom \n");
            String prenom = nb.next();
            System.out.println("donner un matricule \n");
            int mat = nb.nextInt();
            doc4.get(j).setNom(nom); // mise a jour du nom 
            doc4.get(j).setPrenom(prenom); // maj du prenom
            doc4.get(j).setMatricule(mat); // maj du matricule 
            System.out.println("etd modifier");
        }
        else{
            System.out.println("cet etd n'existe pas");
        }
    }
//----------------------------------------------------------------------------------------
//----------------------------Supprimer un etudiant---------------------------------------------
    static void supprimer_etd( ArrayList<adherent> doc4, int co)
    {          // on parcourt notre arraylist pareil, si on trouve la personne a laide de son matricule on la supprime   
        int i= 0; 
        boolean existe = false;
        while(i< doc4.size() && existe==false)
        { // parcourir la liste avec une boucle while, tester les maricules
            if(doc4.get(i).matricule==co)
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==true) // ici on trouve l'etd qu'on veut supprimer 
        {
            doc4.remove(doc4.get(i)); // methode remove permet de supprimer un objet( dans notre cas un etd)
            System.out.println("etd supprime");
        }
        else{
            System.out.println("cet etd n'existe pas"); // letd n'existe pas donc pas de suppression
        }
    }

}
