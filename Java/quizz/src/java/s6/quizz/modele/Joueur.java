
package s6.quizz.modele;

import java.text.SimpleDateFormat;
import java.util.*;
public class Joueur {
   private long idJoueur;
   private java.lang.String nomJoueur;
   private java.util.Date naissanceJoueur;
   private java.lang.String emailJoueur;
  
   private java.lang.String motDePasseJoueur;
   private ArrayList<HistoriqueMotDePasse> historiqueMotDePasse;

    public long getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(long idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public Date getNaissanceJoueur() {
        return naissanceJoueur;
    }

    public void setNaissanceJoueur(Date naissanceJoueur) {
        this.naissanceJoueur = naissanceJoueur;
    }
    
    public void setNaissanceJoueur(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          try {
            this.naissanceJoueur = formatter.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getEmailJoueur() {
        return emailJoueur;
    }

    public void setEmailJoueur(String emailJoueur) {
        this.emailJoueur = emailJoueur;
    }

    public String getMotDePasseJoueur() {
        return motDePasseJoueur;
    }

    public void setMotDePasseJoueur(String motDePasseJoueur) {
        this.motDePasseJoueur = motDePasseJoueur;
    }
   
   public ArrayList<HistoriqueMotDePasse> getHistoriqueMotDePasse() {
      return historiqueMotDePasse;
   }
   public void setHistoriqueMotDePasse(ArrayList<HistoriqueMotDePasse> newHistoriqueMotDePasse) {
      removeAllHistoriqueMotDePasse();
      this.historiqueMotDePasse = newHistoriqueMotDePasse;
   }
   public void addHistoriqueMotDePasse(HistoriqueMotDePasse newHistoriqueMotDePasse) {
      if (newHistoriqueMotDePasse == null)
         return;
      if (this.historiqueMotDePasse == null)
         this.historiqueMotDePasse = new ArrayList<HistoriqueMotDePasse>();
      if (!this.historiqueMotDePasse.contains(newHistoriqueMotDePasse))
         this.historiqueMotDePasse.add(newHistoriqueMotDePasse);
   }
   public void removeHistoriqueMotDePasse(HistoriqueMotDePasse oldHistoriqueMotDePasse) {
      if (oldHistoriqueMotDePasse == null)
         return;
      if (this.historiqueMotDePasse != null)
         if (this.historiqueMotDePasse.contains(oldHistoriqueMotDePasse))
            this.historiqueMotDePasse.remove(oldHistoriqueMotDePasse);
   }
   public void removeAllHistoriqueMotDePasse() {
      if (historiqueMotDePasse != null)
         historiqueMotDePasse.clear();
   }

    public Joueur(long idJoueur, Date naissanceJoueur, String emailJoueur, String motDePasseJoueur) {
        this.idJoueur = idJoueur;
        this.naissanceJoueur = naissanceJoueur;
        this.emailJoueur = emailJoueur;
        this.motDePasseJoueur = motDePasseJoueur;
    }

    public Joueur(long idJoueur, String nomJoueur, Date naissanceJoueur, String emailJoueur, String motDePasseJoueur) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.naissanceJoueur = naissanceJoueur;
        this.emailJoueur = emailJoueur;
        this.motDePasseJoueur = motDePasseJoueur;
    }
     public Joueur(long idJoueur, String nomJoueur, String naissanceJoueur, String emailJoueur, String motDePasseJoueur) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.setNaissanceJoueur(naissanceJoueur);
        this.emailJoueur = emailJoueur;
        this.motDePasseJoueur = motDePasseJoueur;
    }
    
    public Joueur() {
    }

    public Joueur(long idJoueur) {
        this.idJoueur = idJoueur;
    }
   
}
