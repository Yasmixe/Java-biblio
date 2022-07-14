import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Duration;
public class memoir extends media { // heriter de la classe mere qui est media tous les attribut ainsi que les getters et les setters 
    // constructeur--------------------------------------
 //------------------------------------------------------------------------------------------------  
    public memoir(String t, String a, int c, int n) {
        super(t,a,c,n );  
    }// pour l'heritage on utiliser les mots cles extends et super
//------------------------------------------------------------------------------------------------
    public void ajouter_memoire(media m, ArrayList<media> doc2, int quota) {
        // idee => comme pour la classe livre, le processus s'applique sur les memoires et les cd. 
        // c-a-d : verifier d'abords si le livre existe deja dans la base de donne, s'il n'existe pas on lajoute sinon on augmente le nbr dexemplaires
        int i= 0; // fonctionnement : parcourir l'arrayliste avec une boucle while et faire le teste avec la cote de memoire 
        boolean existe = false;
        while(i< doc2.size() && existe==false) // parcours de l'arraylist
        {
            if(doc2.get(i).cote==m.getCote())
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==false) // cas memoir n'existe pas dans la base de donne donc on l'ajoute avec la methode add(<nom obj>);
        {
            doc2.add(m);
            System.out.println("memoir ajoute");
        }
        else{//cas ou le llivre existe deja donc on augmente que le nombre des exemplaires 
            m.nbr_exemplaires++; // 
            System.out.println("memoire existe deja, nous avons augementer le nbr d'exemplaires");
        }
    }
//------------------------------------------------------------------------------------------------
    static void afficher_liste_memoir(ArrayList<media> doc2)
    {// parcourir la liste des memoires  avec une boucle et afficher le titre + l'auteur + cote et nbr exemplaires 
        for(media elem:doc2)
        {
            System.out.println(elem.titre+ " de "+ elem.auteur+"\n");
        } 
    }
//------------------------------------------------------------------------------------------------   
    static void supprimer_memoire(ArrayList<media> doc2, int com)
    { // dans la classe main on demande a l'utilisateur de saisir la cote de memoire qu'on veut supprimer. 
    // comme la cote est unique il ya qu'un seul memoire a supprimer. on vas faire un parcour de la liste et on teste avec les cotes des memoires 
        int i2= 0; 
                boolean existe2 = false;
                while(i2< doc2.size() && existe2==false)
        {
            if(doc2.get(i2).cote==com) // parcourir la liste avec une boucle while et on teste, compare les cotes des memoires 
            {
                existe2 = true;
            }
            else {
                i2++;
            }
        }// la boucle while est une boucle de rechercher 
        if(existe2==true)// ici on trouve que le memoire existe dans la liste donc on peut supprimer avec la methode remove 
        {
            doc2.remove(doc2.get(i2)); //pourquoi get i2 --> car quand on sort de la boucle while, on sort avec l'indice de memoire qu'on trouvee 
            System.out.println("memoire supprime"); 
        }
        else{
            System.out.println("ce memoire n'existe pas");  // le livre n'existe pas donc on affiche un message seulement
        }
    }
//-----------------------------------------------------------------------------------------------------
    static void modifier_memoire(ArrayList<media> doc2, int cote)
    {// on teste dabord si le memoire existe deja dans notre arraylist, si c'est le cas on le modifie sinon on peut pas.
        int j= 0; 
        boolean exist = false;
        while(j< doc2.size() && exist==false) // on parcourt la liste comme precedement et on compare les cotes des memoires avec celle qu'on veut modifier
        {
            if(doc2.get(j).cote==cote)
            {
                exist = true;
            }
            else {
                j++;
            }
        }
        if(exist==true)// ici le memoire existe dans la liste donc on demande au utilisateur dintroduire les infos du livre ( mise a jours)
        {// la mise a jour se fait par les setters
            Scanner nb = new Scanner(System.in);
            System.out.println("entrer les infos du livres que vous voulez modifier");
            System.out.println("donner un titre \n");
            String titrm = nb.next();
            System.out.println("donner son auteur \n");
            String auteurmm = nb.next();
            System.out.println("donner un quota \n");
            int coo = nb.nextInt();
            doc2.get(j).setTitre(titrm);// mise a jours du titre ; get(i) car quand on sort de la boucle on sort avec l'indice de memoire qu'on veut modifier
            doc2.get(j).setAuteur(auteurmm);
            doc2.get(j).setCote(coo);
            System.out.println("livre modifier");
        }
        else{
            System.out.println("ce livre n'existe pas");
        }
    }
//-----------------------------------------------------------------------------------------------------------------
static void emprunter_memoire(ArrayList<media> doc2, ArrayList<adherent> doc4, ArrayList<empruntt> empruntmemoire, int co, int matriculeetd)
    {   // idee => d'abord on cherche si letd qui veut emprunter existe dans notre array liste des adherents, 
    //si il existe, on cherche si le memoire quil veut emprunter existe dans larray liste media(mem)
        //verifier si d'abord le matricule existe. 
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
        if(existe==true)// ici on trouve que letd qui veut emprunter existe dans la liste, donc il peut emprunter. 
        // maintenant, tester si le mem qu'il veut emprunter existe dans la liste des media 
        {
            // on cherche si le mem existe
            int j= 0; 
        boolean exists = false;
        while(j< doc2.size() && exists==false)
        {
            if(doc2.get(j).cote==co)
            {
                exists = true; //  meme teste et parcourt qu'en haut, on boucle et on cherche. 
            }
            else {
                j++;
            }
        }
        if(exists==true)//  ici le mem + ledt existent tous les deux dans leurs listes donc on peut empruneter
        // idee => on a defini une classe empruntt qui contient : date, cote du mem, matricule + date demprunt qui se faite automatiquement
        // le mem qu'on va emprunter s'ajoute dans la liste d'emprunt et on decremente le nb dexemplaire des memes. 
        // /!\ on teste si le nbr dexemplaire de ce mem est >0 car si ce n'est pas le cas, le mem ne peut etre empruntee. 
        {
            /// on fait notre emprunt
            if(doc2.get(j).nbr_exemplaires >0)  // si le nombre d'exemplaires est >0 on fait l'emprunt. 
            {  
                empruntt book = new empruntt(doc2.get(i).titre, doc2.get(i).auteur, doc4.get(i).matricule, doc2.get(j).cote);// on cree un objet de type emprunt
                empruntmemoire.add(book); // je l'ajoute a ma liste des emprunts mem 
                doc2.get(j).nbr_exemplaires--;
            }// on decremente le nombre d'exemplaires des mem de la liste des mem
            else{
                System.out.println("emprunt impossible ce memoire n'existe plus"); // c le cas des nbr_exemplaires <0
            }
        }
        else{
            System.out.println("ce memoire n'existe pas"); // le mem n'existe pas, ou etudiant n'existe pas 
        } 
        }
        else{
            System.out.println("cet etudiant n'existe pas");
        }
    }
//------------------------------------------------------------------------------------------------
    static void affiche_liste_emprunt_memoire(ArrayList<empruntt> empruntmemoire)
    {
        for(empruntt elem:empruntmemoire)
        {
            System.out.println(" le memoire "+ elem.titre+ "redige par "+ elem.auteur + " "+ elem.cote+ " de "+ elem.matricule+ " jour " + elem.date.now()+"\n");
        } 
    }
//------------------------------------------------------------------------------------------------
    static void retourner_memoire(int matret, int cotret, ArrayList<empruntt> empruntmemoire, ArrayList<media> doc2, ArrayList<empruntt> list_noire, LocalDate  date_ret )
    {
        // idee pour retourner un mem => chercher d'abord si le mem qu'on veut retourner existe dans la liste des emprunts mem, on compare si le live X est emprunte par un matricule X sinon on retourne pas
          // dans le cas ou mem existe, on retourne le mem 
        // pour cela, nous devons verifier une condition. comparer la date d'emprunt avec la date de retour et la comparer avec 10
        // si la diff >10 => ajouter l'etudiant dans la liste noir
        // sinon, retourner le mem, on increment le nbr d'exemplaires dans la liste des mem + remove le mem depuis la liste des emprunts
        int j= 0; 
       boolean exists = false;
       while(j< empruntmemoire.size() && exists==false) // parcourir la liste avec une boucle et tester 
       {
           if(empruntmemoire.get(j).cote==cotret && empruntmemoire.get(j).matricule ==matret)
           {
               exists = true;
           }
           else {
               j++;
           }
       }
       if(exists==true )
       {   LocalDate myObj = LocalDate.now(); // Create a date object
           System.out.println(myObj);
           int x =10;
           if(Duration.between(empruntmemoire.get(j).date, myObj).toDays()<10 )
           {
               list_noire.add(empruntmemoire.get(j));
               System.out.println("letudiant "+ empruntmemoire.get(j).matricule +"est ajouter dans la liste noire");
               
           }
           else{
               doc2.get(j).nbr_exemplaires++;
               System.out.println(" l'etudiant "+ empruntmemoire.get(j).matricule +" a retourne le livre "+empruntmemoire.get(j).titre );
               System.out.println(doc2.get(j).nbr_exemplaires);
           }
       }
       else{ 
           System.out.println("ce memoire n'existe pas");
       } 
    }
//------------------------------------------------------------------------------------------------
}
