import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import  java.util.Calendar;
public  class main {
    public static void main(String [] args) {
        //-------------------------------------------------------------------------------------------
        ArrayList<media> doc1 = new ArrayList<media>(); // declaration dun arraylist de type livre
        ArrayList<media> doc2 = new ArrayList<media>(); // declaration dun arraylist de type memoire
        ArrayList<media> doc3 = new ArrayList<media>(); // declaration dun arraylist de type CD
        ArrayList<adherent> doc4 = new ArrayList<adherent>(); // declaration dun arraylist etudiant
        ArrayList<empruntt> empruntlivre = new ArrayList<empruntt>(); // declaration dune liste d'emprunt pour livre 
        ArrayList<empruntt> empruntmemoire = new ArrayList<empruntt>(); // declaration dune liste d'emprunt pour memoire
        ArrayList<empruntt> empruntcd = new ArrayList<empruntt>(); // declaration dune liste d'emprunt pour CD
        ArrayList<empruntt> list_noire = new ArrayList<empruntt>(); // liste noire des etds
        // etudiant 
        //--------------------------------------------------------------------------------------------
        adherent et1 = new adherent("hanafi", "yasmine", 1919);
        adherent et2 = new adherent("boulkaboul", "amira", 2020);
        adherent et3 = new adherent("laib", "wiwi", 1818);
        adherent et4 = new adherent("kaci", "imene", 1717);
        doc4.add(et1);
        doc4.add(et2);
        doc4.add(et3);
        doc4.add(et4);
        // ajouter quelques livres a la base de donnee ta3na. 
        livre  book1 = new livre("harry potter", "jk rowling", 100,5);
        livre  book2 = new livre("le malade imaginaire", "moliere", 18901,6);
        livre  book3 = new livre("algorithme", "Bessaa", 844,95);
        livre  book4 = new livre("grace", "paul lynch", 890,4);
        livre  book5 = new livre("les fleurs du mal ", "baudlere", 478,7);
        doc1.add(book1);
        doc1.add(book2);
        doc1.add(book3);
        doc1.add(book4);
        doc1.add(book5);
        // ajouter quelques memoires a la base de donnee ta3na. 
        memoir mem1 = new memoir("la conception dune base de donnee",  "Soumia", 7,8);
        memoir mem2 = new memoir("creation d'une application mobile", "Yasmine", 25,8);
        memoir mem3 = new memoir("l'effondrement de l'atlantide",  "wiwi", 147,6);
        memoir mem4 = new memoir("sommes nous seules dans l'univers", "Soumia",  235,2);
        memoir mem5 = new memoir("la langue vernaculaire vs la langue morte", "imene", 964,1);
        doc2.add(mem1); 
        doc2.add(mem2);  
        doc2.add(mem3);
        doc2.add(mem4);
        doc2.add(mem5);
        // ajouter quelque cd a notre base de donnee
        cd cd1 = new cd("without me", 47,4);
        cd cd2 = new cd("we don't talke anymore", 487,7);
        cd cd3 = new cd("blood sweet and tears - bts", 147,8);
        cd cd4 = new cd("wings - bts", 986,02);
        cd cd5 = new cd("spring days - bts", 423,36);
        doc3.add(cd1);
        doc3.add(cd2);
        doc3.add(cd3);
        doc3.add(cd4);
        doc3.add(cd5);
        Scanner nb = new Scanner(System.in);
        LocalDate myObj = LocalDate.now(); // Create a date object
        System.out.println(myObj);
        
        System.out.println("\n \n");
        System.out.println("------------- Bienvenue a la bibliotheque nationale d'alger------------\n");
        System.out.println("------------- choisissez une option------------\n");
        System.out.println("1-ajouter un livre\n"); //done juste 
        System.out.println("2-consulter la liste des livres \n"); //done juste 
        System.out.println("3-supprimer un livre \n"); // done juste 
        System.out.println("4-modifier un livre \n"); // setters c bon done 
        System.out.println("5-emprunter un livre \n");
        System.out.println("6-ajouter un memoire\n");//
        System.out.println("7-consulter la liste des memoires \n");//
        System.out.println("8-supprimer un memoire \n");//
        System.out.println("9-modifier un memoire \n");//
        System.out.println("10-emprunter un memoire \n");
        System.out.println("11-ajouter un CD\n");//
        System.out.println("12-consulter la liste des CD \n");//
        System.out.println("13-supprimer un CD \n");//
        System.out.println("14-modifier un CD \n");//
        System.out.println("15-emprunter un CD \n");
        System.out.println("16-ajouter un etudiant\n");//
        System.out.println("17-consulter la liste des etudiants \n");//
        System.out.println("18-modifier un etudiant \n");//
        System.out.println("19-supprimer un etudiant \n");//
        System.out.println("19-afficher liste demprunt livre \n");//
        System.out.println("20-afficher liste demprunt memoire \n");//
        System.out.println("21-afficher liste demprunt cd \n");//
        System.out.println("22-retourner un livre  \n");//
        System.out.println("23-retourner un memoire \n");//
        System.out.println("24-retourner un cd \n");//
        System.out.println("26-modifier un etudiant \n");//

         int x = 0;
         do{
             System.out.println("donner votre choix svp");
             int choix = nb.nextInt();
            switch (choix){
//----------------------------------------------------------------------------------------------------------------------------------
                case 1:  
                // ajouter un livre et tester si sa cote est unique
                System.out.println("entrer les infos du livres que vous voulez ajouter");
                System.out.println("donner un titre \n");
                String titrel = nb.next();
                System.out.println("donner son auteur \n");
                String auteurl = nb.next();
                System.out.println("donner un quota \n");
                int quo = nb.nextInt();
                System.out.println("donner le nbr dexemplaire \n");
                int nbe = nb.nextInt();
                livre l = new livre(titrel, auteurl, quo, nbe);
                l.ajouter_livre(l, doc1, l.getCote());// ajouter un livre
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 2: //consulter la liste des livres
                livre.afficher_liste_livre(doc1);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 3: //supprimer un livre
                System.out.println("entrer la cote du livres que vous voulez supprimer");
                int co =nb.nextInt();
                // supprimer_livre(l, doc1, co);
                livre.supprimer_livre(doc1, co);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 4://modifier 
                System.out.println("donner la cote du livre que vous voulez modifier");
                int co1 =nb.nextInt();
                livre.modifier_livre(doc1, co1);
                break;
//----------------------------------------------------------------------------------------------------------------------------------                
                case 5://emprunter-----------------------verifier si d'abord le matricule existe + verifier si le livre existe. 
                System.out.println("donner le matricule de l'etudiant qui veut emprunter un livre");
                int matriculeetd = nb.nextInt();
                System.out.println("donner la cote du livre");
                int col = nb.nextInt();
                livre.emprunter_livre(doc1, doc4, empruntlivre, col, matriculeetd);
                break; 
//----------------------------------------------------------------------------------------------------------------------------------                   
                case 6:
                // ajouter un memoir et tester si sa cote est unique
                System.out.println("entrer les infos du memoir que vous voulez ajouter");
                System.out.println("donner un titre \n");
                String titrem = nb.next();
                System.out.println("donner son auteur \n");
                String auteurm = nb.next();
                System.out.println("donner un quota \n");
                int quot = nb.nextInt();
                System.out.println("donner un nbr dexemplaire \n");
                int exe = nb.nextInt();
                memoir m  = new memoir(titrem, auteurm, quot,exe);
                m.ajouter_memoire(m, doc2, quot);// ajouter un livre
                break ;
//----------------------------------------------------------------------------------------------------------------------------------                   
                case 7: //aaficher liste des memoires
                memoir.afficher_liste_memoir(doc2);
                break;
//----------------------------------------------------------------------------------------------------------------------------------               
                case 8: //supprimer_memoire
                System.out.println("entrer la cote de memoire que vous voulez supprimer");
                int com =nb.nextInt();
                // 
                memoir.supprimer_memoire(doc2, com);
                break;
//----------------------------------------------------------------------------------------------------------------------------------                
                case 9: //modifier un memoire
                System.out.println("donner la cote du livre que vous voulez modifier");
                int cote =nb.nextInt();
                memoir.modifier_memoire(doc2, cote);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 10: //emprunter un memoire
                System.out.println("donner le matricule de l'etudiant qui veut emprunter un livre");
                int mat = nb.nextInt();
                System.out.println("donner la cote du livre");
                int cotte = nb.nextInt();
                memoir.emprunter_memoire(doc2, doc4, empruntmemoire, cotte, mat);
                break;
//----------------------------------------------------------------------------------------------------------------------------------               
                case 11: //ajouter cd
                // ajouter un cd et tester si sa cote est unique
                System.out.println("entrer les infos du cd que vous voulez ajouter");
                System.out.println("donner un titre \n");
                String titrecd = nb.next();
                System.out.println("donner un quota \n");
                int qucd = nb.nextInt();
                System.out.println("donner un nbr exemplaire \n");
                int nbex = nb.nextInt();
                cd c = new cd(titrecd, qucd, nbex);
                c.ajouter_cd(c, doc3, c.getCote());// ajouter un cd
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 12: //consulter liste des cd
                cd.afficher_liste_cd(doc3);
                break;
//----------------------------------------------------------------------------------------------------------------------------------                
                case 13://supprimer cd
                System.out.println("entrer la cote de cd que vous voulez supprimer");
                int cdd =nb.nextInt();
                // supprimer_livre(l, doc1, co);
                cd.supprimer_cd(doc3, cdd);
                break;
//----------------------------------------------------------------------------------------------------------------------------------                
                case 14: //modifier cd 
                System.out.println("donner la cote du cd que vous voulez modifier");
                int cdcote =nb.nextInt();
                cd.modifier_cd(doc3, cdcote);
                break;
//----------------------------------------------------------------------------------------------------------------------------------               
                case 15: //emprunter un cd
                System.out.println("donner le matricule de l'etudiant qui veut emprunter un cd");
                int matt = nb.nextInt();
                System.out.println("donner la cote du cd");
                int cotta = nb.nextInt();
                cd.emprunter_livre(doc3, doc4, empruntcd, cotta, matt);
                break;
//----------------------------------------------------------------------------------------------------------------------------------                
                case 16: //ajouter un etudiant
                System.out.println("entrer les infos de letudiant que vous voulez ajouter");
                System.out.println("donner un nom \n");
                String nometd = nb.next();
                System.out.println("donner un prenom \n");
                String prenom = nb.next();
                System.out.println("donner son matricule \n");
                int matricule = nb.nextInt();
                adherent et = new adherent(nometd, prenom, matricule);
                et.ajouter_etd(et, doc4);
                break;
//----------------------------------------------------------------------------------------------------------------------------------               
                case 17: // consulter la liste des etudiants
                adherent.afficher_liste_etd(doc4);
                break;
//----------------------------------------------------------------------------------------------------------------------------------               
                case 18: // modifier un etudiant
                System.out.println("donner le matricule de la personne que vous voulez changer\n");
                int met = nb.nextInt();
                adherent.modifier_etd(doc4, met);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 19: // supprimer un etudiant 
                System.out.println("donner le matricule de la personne que vous voulez supprimer\n");
                int mett = nb.nextInt();
                adherent.supprimer_etd(doc4, mett);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 20: // affichage la liste des emprunts des livres
                livre.affiche_liste_emprunt_livre(empruntlivre);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 21: // affichage la liste des emprunts des memoires 
                memoir.affiche_liste_emprunt_memoire(empruntmemoire);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 22: // affichage la liste des emprunts des CDs 
                cd.affiche_liste_emprunt_cd(empruntcd);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 23: // retourner un livre 
                System.out.println("donner le matricule de la personne qui veut retourner un livre\n");
                int matret = nb.nextInt();
                System.out.println("donner la cote du livre que vous voulez retourner\n");
                int cotret = nb.nextInt();
                LocalDate date_ret = LocalDate.now();
                
                livre.retourner_livre(matret, cotret, empruntlivre,doc1, list_noire, date_ret);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 24: // retourner un memoire
                System.out.println("donner le matricule de la personne qui veut retourner un memoire\n");
                int mattret = nb.nextInt();
                System.out.println("donner la cote du memoire que vous voulez retourner\n");
                int cottret = nb.nextInt();
                LocalDate date_rett = LocalDate.now();
                memoir.retourner_memoire(mattret, cottret, empruntlivre,doc2, list_noire, date_rett);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
                case 25: // retourner cd 
                System.out.println("donner le matricule de la personne qui veut retourner un cd\n");
                int matttret = nb.nextInt();
                System.out.println("donner la cote du cd que vous voulez retourner\n");
                int cotttret = nb.nextInt();
                LocalDate date_rettt = LocalDate.now();
               cd.retourner_cd(matttret, cotttret, empruntcd,doc3, list_noire, date_rettt);
                break;
//----------------------------------------------------------------------------------------------------------------------------------
               case 26:
               for(empruntt elem:list_noire) // parcourir la liste des livres avec une boucle et afficher le titre + l'auteur + cote et nbr exemplaires 
              {
            System.out.println(elem.titre+ " de "+ elem.auteur+ " "+ elem.cote+" "+  elem.matricule+ "\n");
              } 
               break;
            }
            
            
         }while(x!=27);
    }
}

