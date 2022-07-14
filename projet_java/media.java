public class media{ //classe mere 
    String auteur, titre;
    int cote, nbr_exemplaires, matricule_emprunt;
    // classe mere que gere les 3 classes livre + memoire + cd
//-------------------------------------------------------------------------
    public media (String titre, String auteur, int cote, int nbr_exemplaires)
    {
         this.titre = titre; // titre du media
         this.auteur = auteur; // auteur du media
         this.cote = cote; // cote unique 
         this.nbr_exemplaires = nbr_exemplaires;
    }
//--------------------------------------------------------------------------
    public int getMatricule_emprunt() {
        return matricule_emprunt;
    }
//--------------------------------------------------------------------------
    public void setMatricule_emprunt(int matricule_emprunt) {
        this.matricule_emprunt = matricule_emprunt;
    }
//--------------------------------------------------------------------------
    public String getAuteur() {
        return auteur;
    }
//--------------------------------------------------------------------------
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
//--------------------------------------------------------------------------
    public String getTitre() {
        return titre;
    }
//--------------------------------------------------------------------------
    public void setTitre(String titre) {
        this.titre = titre;
    }
//--------------------------------------------------------------------------
    public int getCote() {
        return cote;
    }
//--------------------------------------------------------------------------
    public void setCote(int cote) {
        this.cote = cote;
    }
//--------------------------------------------------------------------------
    public int getNbr_exemplaires() {
        return nbr_exemplaires;
    }
//--------------------------------------------------------------------------
    public void setNbr_exemplaires(int nbr_exemplaires) {
        this.nbr_exemplaires = nbr_exemplaires;
    }
//--------------------------------------------------------------------------
}