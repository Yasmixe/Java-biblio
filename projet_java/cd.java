import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
public class cd extends media{
    public cd(String t, int q, int n) {
        super(t," ", q,n);
    }
    // methode
    public void ajouter_cd(cd m, ArrayList<media> doc3, int quotacd) {
        
        int i= 0; 
        boolean existe = false;
        while(i< doc3.size() && existe==false)
        {
            if(doc3.get(i).cote==m.getCote())
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==false)
        {
            doc3.add(m);
            System.out.println("cd ajoute");
        }
        else{
            m.nbr_exemplaires ++;
        }
    }
    static void afficher_liste_cd(ArrayList<media> doc3)
    {
        for(media elem:doc3)
        {
            System.out.println(elem.titre+ elem.cote+"\n");
        } 
    }
    static void supprimer_cd(ArrayList<media> doc3, int cdd)
    {
        int k= 0; 
                boolean exists = false;
                while(k< doc3.size() && exists==false)
        {
            if(doc3.get(k).cote==cdd)
            {
                exists = true;
            }
            else {
                k++;
            }
        }
        if(exists==true)
        {
            doc3.remove(doc3.get(k));
            System.out.println("cd supprime");
        }
        else{
            System.out.println("ce cd n'existe pas");
        }
    }
    static void modifier_cd(ArrayList<media> doc3, int cdd)
    {
        int i= 0; 
        boolean existe = false;
        while(i< doc3.size() && existe==false)
        {
            if(doc3.get(i).cote==cdd)
            {
                existe = true;
            }
            else {
                i++;
            }
        }
        if(existe==true)
        {
            Scanner nb = new Scanner(System.in);

            System.out.println("entrer les infos du cd que vous voulez modifier");
            System.out.println("donner un titre \n");
            String titrecd = nb.next();

            System.out.println("donner un quota \n");
            int quo = nb.nextInt();
            
            doc3.get(i).setTitre(titrecd);
            doc3.get(i).setCote(quo);
            System.out.println("cd modifier");
        }
        else{
            System.out.println("ce cd n'existe pas");
        }
    }


    static void emprunter_livre(ArrayList<media> doc3, ArrayList<adherent> doc4, ArrayList<empruntt> empruntcd, int co, int matriculeetd)
    {
        //verifier si d'abord le matricule existe. 
        int i= 0; 
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
        if(existe==true)
        {
            // on cherche si le livre existe
            int j= 0; 
        boolean exists = false;
        while(j< doc3.size() && exists==false)
        {
            if(doc3.get(j).cote==co)
            {
                exists = true;
            }
            else {
                j++;
            }
        }
        if(exists==true)
        {
            /// on fait notre emprunt
            if(doc3.get(j).nbr_exemplaires >0)
            {  
                empruntt book = new empruntt(doc3.get(i).titre,"", doc4.get(i).matricule, doc3.get(j).cote);
                empruntcd.add(book); 
                doc3.get(j).nbr_exemplaires--;
            }
            else{
                System.out.println("emprunt impossible ce cd n'existe plus");
            }
            

        }
        else{
            System.out.println("ce cd n'existe pas");
        } 
        }
        else{
            System.out.println("cet etudiant n'existe pas");
        }
    }
    static void affiche_liste_emprunt_cd(ArrayList<empruntt> empruntcd)
    {
        for(empruntt elem:empruntcd)
        {
            System.out.println(elem.cote+ " de "+ elem.matricule+ " jour " + elem.date.now()+"\n");
        } 
    }

    static void retourner_cd(int matret, int cotret, ArrayList<empruntt> empruntcd, ArrayList<media> doc3, ArrayList<empruntt> list_noire, LocalDate  date_ret )
    {
        int j= 0; 
       boolean exists = false;
       while(j< empruntcd.size() && exists==false)
       {
           if(empruntcd.get(j).cote==cotret && empruntcd.get(j).matricule ==matret)
           {
               exists = true;
           }
           else {
               j++;
           }
       }
       if(exists==true )
       {  
           if( empruntcd.get(j).date.plusDays(10).isAfter(LocalDate.now()))
           {
               list_noire.add(empruntcd.get(j));
               System.out.println("letudiant "+ empruntcd.get(j).matricule +"est ajouter dans la liste noire");

               
           }
           else{
               doc3.get(j).nbr_exemplaires++;
               System.out.println(" l'etudiant "+ empruntcd.get(j).matricule +" a retourne le cd "+empruntcd.get(j).titre );
           }
       }
       else{ 
           System.out.println("ce cd n'existe pas");
       } 
    }

}
