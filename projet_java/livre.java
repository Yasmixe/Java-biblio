import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
public class livre extends media{ // heritage
    int date_emprunt_livre;
    int matricule_emprunt_livre; // declaration des variables 
    Scanner nb = new Scanner(System.in); // scanner 
//-------------------------Constructeur---------------------------------------------------
    public livre(String t, String a, int c, int n )
    {
        super(t,a,c,n); // par heritage, classe mere => media, on herite les attributs avec le mots cle extends et super();
    }
//----------------------------------------------------------------------------------------

//------------------------Les Methodes----------------------------------------------------
//------------------------Ajouter un livre---------------------------------------------------
    public void ajouter_livre(livre l, ArrayList<media> doc1, int quota) {
        int i= 0;  // d'abord on parcourt arraylist pour verifier si le livre qu'on veut ajouter existe deja ou nn
        // si le livre existe deja, on augmente les nombres d'exemplaires car comme la cote est unique une cote --> un livre precis
        // si le livre n'existe pas on l'ajoute 
        boolean existe = false;
        while(i< doc1.size() && existe==false)
        { // parcourir la liste avec une boucle while et faire le teste et les comparaisons avec la cote du livre qui est unique
            if(doc1.get(i).cote==l.getCote())
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==false) // ici le livre n'existe pas donc on l'ajoute avec la methode add
        {
            doc1.add(l); // ajouter le livre l qu'on a creer dans la class main
            System.out.println("livre ajoute");
        }
        else{
            l.nbr_exemplaires ++; // le livre existe dans la liste donc on augmente le nombre d'exemplaires
        }
    }
//----------------------------------------------------------------------------------------
//------------------------Supprimer un livre-----------------------------------------------
     static void supprimer_livre( ArrayList<media> doc1, int co)
    {       // dans la classe main on demande a l'utilisateur de saisir la cote du livre qu'on veut supprimer. 
           // comme la cote est unique il ya qu'un seul livre a supprimer. on faire un parcour de la liste et on teste avec les cotes des livres       
        int i= 0; 
        boolean existe = false;
        while(i< doc1.size() && existe==false)
        {
            if(doc1.get(i).cote==co) // parcourir la liste avec une boucle while et on teste, compare les cotes des livre 
            {
                existe = true;
            }
            else {
                i++;
            }
        } // la boucle while est une boucle de rechercher 
        if(existe==true) // ici on trouve que le livre existe dans la liste donc on peut supprimer avec la methode remove 
        {
            doc1.remove(doc1.get(i)); //pourquoi get i --> car quand on sort de la boucle while, on sort avec l'indice du livre qu'on trouvee 
            System.out.println("livre supprime");
        }
        else{
            System.out.println("ce livre n'existe pas"); // le livre n'existe pas donc on affiche un message seulement
        }
    }
//----------------------------------------------------------------------------------------
//--------------------------Modifier un livre---------------------------------------------
    static void modifier_livre(ArrayList<media> doc1, int co)
    {// on teste dabord si le livre existe deja dans notre arraylist, si c'est le cas on le modifie sinon on peut pas.
        int i= 0; 
        boolean existe = false;
        while(i< doc1.size() && existe==false) // on parcourt la liste comme precedement et on compare les cotes des livres avec celle qu'on veut modifier
        {
            if(doc1.get(i).cote==co) 
            {
                existe = true; 
            }
            else {
                i++;
            }
        }
        if(existe==true)// ici le livre existe dans la liste donc on demande au utilisateur dintroduire les infos du livre ( mise a jours)
        { // la mise a jour se fait par les setters
            Scanner nb = new Scanner(System.in);
            System.out.println("entrer les infos du livres que vous voulez modifier");
            System.out.println("donner un titre \n");
            String titrel = nb.next(); // lecture des infos
            System.out.println("donner son auteur \n");
            String auteurl = nb.next();
            System.out.println("donner un quota \n");
            int quo = nb.nextInt();
            doc1.get(i).setTitre(titrel); // mise a jours du titre ; get(i) car quand on sort de la boucle on sort avec l'indice du livre qu'on veut modifier
            doc1.get(i).setAuteur(auteurl); // mise a jours d'aueteur 
            doc1.get(i).setCote(quo); // mise a jours de la cote du livre  
            System.out.println("livre modifier");
        }
        else{
            System.out.println("ce livre n'existe pas"); // ici existe == false donc le livre nexiste donc on ne peut pas faire un changement
        }
    }
//----------------------------------------------------------------------------------------
//--------------------------emprunter un livre---------------------------------------------
    static void emprunter_livre(ArrayList<media> doc1, ArrayList<adherent> doc4, ArrayList<empruntt> empruntlivre, int co, int matriculeetd)
    {
        // idee => d'abord on cherche si letd qui veut emprunter existe dans notre array liste des adherents, 
        //si il existe, on cherche si le livre quil veut emprunter existe dans larray liste media(livre)
        int i= 0; // d'abord, on parcourt la liste des adherents pour chercher letudiant sil existe, on le cherche avec son mattricule car il est unique
        boolean existe = false;
        while(i< doc4.size() && existe==false)
        {
            if(doc4.get(i).matricule==matriculeetd)
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==true) // ici on trouve que letd qui veut emprunter existe dans la liste, donc il peut emprunter. 
        // maintenant, tester si le livre qu'il veut emprunter existe dans la liste des media 
        {
            // on cherche si le livre existe
        int j= 0; 
        boolean exists = false;
        while(j< doc1.size() && exists==false)
        {
            if(doc1.get(j).cote==co)
            { //  meme teste et parcourt qu'en haut, on boucle et on cherche. 
                exists = true;
            }
            else {
                j++;
            }
        }
        if(exists==true) //  ici le livre + ledt existent tous les deux dans leurs listes donc on peut empruneter
        // idee => on a defini une classe empruntt qui contient : date, cote du livre, matricule + date demprunt qui se faite automatiquement
        // le livre qu'on va emprunter s'ajoute dans la liste d'emprunt et on decremente le nb dexemplaire des livres. 
        // /!\ on teste si le nbr dexemplaire de ce livre est >0 car si ce n'est pas le cas, le livre ne peut etre empruntee. 
        {
            /// on fait notre emprunt
            if(doc1.get(j).nbr_exemplaires >0) // si le nombre d'exemplaires est >0 on fait l'emprunt. 
            {   
                empruntt book = new empruntt(doc1.get(j).titre, doc1.get(j).auteur, doc4.get(i).matricule, doc1.get(j).cote); // on cree un objet de type emprunt
                empruntlivre.add(book); // je l'ajoute a ma liste des emprunts livres 
                doc1.get(j).nbr_exemplaires--; // on decremente le nombre d'exemplaires des livres de la liste des livres
            }
            else{
                System.out.println("emprunt impossible ce livre n'existe plus"); // c le cas des nbr_exemplaires <0
            }
        }
        else{
            System.out.println("ce livre n'existe pas"); // le livre n'existe pas, ou etudiant n'existe pas 
        } 
        }
        else{
            System.out.println("cet etudiant n'existe pas");
        }
    }
//----------------------------------------------------------------------------------------
//--------------------------afficher la liste des livres----------------------------------
   static void afficher_liste_livre(ArrayList<media> doc1)
    {
        for(media elem:doc1) // parcourir la liste des livres avec une boucle et afficher le titre + l'auteur + cote et nbr exemplaires 
        {
            System.out.println(elem.titre+ " de "+ elem.auteur+ " "+ elem.cote+" "+  elem.nbr_exemplaires+ "\n");
        } 
    }
//----------------------------------------------------------------------------------------
//--------------------------afficher la liste des emprunts des livres---------------------
    static void affiche_liste_emprunt_livre(ArrayList<empruntt> emprunlivre)
    {
        for(empruntt elem:emprunlivre) //parcourir la liste des emprunts des livres avec une boucle et afficher le titre + l'auteur + cote et nbr exemplaires
        {
            System.out.println("le livre "+elem.titre+ "ecrit par "+elem.auteur +" dune cote de "+ elem.cote+" est emprunte par l'etudiant ayant le matricule  "+ elem.matricule+ " le jour  " + elem.date+"\n");
            
        } 
    }
//----------------------------------------------------------------------------------------
//--------------------------retourner un livre--------------------------------------------
    static void retourner_livre(int matret, int cotret, ArrayList<empruntt> empruntlivre, ArrayList<media> doc1, ArrayList<empruntt> list_noire, LocalDate  date_ret )
    { // idee pour retourner un livre => chercher d'abord si le livre qu'on veut retourner existe dans la liste des emprunts livres, on compare si le live X est emprunte par un matricule X sinon on retourne pas
        int j= 0;  // dans le cas ou livre existe, on retourne le livre 
        // pour cela, nous devons verifier une condition. comparer la date d'emprunt avec la date de retour et la comparer avec 10
        // si la diff >10 => ajouter l'etudiant dans la liste noir
        // sinon, retourner le livre, on increment le nbr d'exemplaires dans la liste des livre + remove le livre depuis la liste des emprunts
       boolean exists = false;
       while(j< empruntlivre.size() && exists==false)// parcourir la liste avec une boucle et tester 
       {
           if(empruntlivre.get(j).cote==cotret && empruntlivre.get(j).matricule ==matret) // comparer la cote du livre et le matricule 
           {
               exists = true;
           }
           else {
               j++;
           }
       }
       if(exists==true ) // si le matricule + la cote existent dans la liste des emprunts, on increment
       {    
        LocalDate myObj = LocalDate.now(); // Create a date object pour avoir la date de retour 
        System.out.println(myObj);
           
           if( Duration.between(empruntlivre.get(j).date, myObj).toDays()<10) // condition pour comparer les dates 
           // si la date de retour- date demprunt >10 => ajouter f la liste noire
           {
               list_noire.add(empruntlivre.get(j)); //ajouter lelm dans la liste noire 
               System.out.println("letudiant "+ empruntlivre.get(j).matricule +"est ajouter dans la liste noire");
               /*
               for(empruntt elem:list_noire)
        {
            System.out.println("etudiant avec ce matricule "+elem.matricule+"\n");
        }  */ 
           }
           else{ // si la date <10 => on fait notre retour, cad retourner le livre + ajouter le nbr dexemplaire +1 
               doc1.get(j).nbr_exemplaires++;
               
               System.out.println(" l'etudiant "+ empruntlivre.get(j).matricule +" a retourne le livre " );
               System.out.println(doc1.get(j).nbr_exemplaires);
           }
       }
       else{ 
           System.out.println("ce livre n'existe pas");
       } 
    }
}
