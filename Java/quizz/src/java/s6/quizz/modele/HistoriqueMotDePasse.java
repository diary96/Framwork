/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.modele;

import java.text.SimpleDateFormat;
import java.util.*;

public class HistoriqueMotDePasse {
   private long idHistorique;
   private Joueur joueur;
   private java.lang.String motDePasseHistorique;
   private java.util.Date dateAjoutHistorique;

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
   
    public long getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(long idHistorique) {
        this.idHistorique = idHistorique;
    }

    public String getMotDePasseHistorique() {
        return motDePasseHistorique;
    }

    public void setMotDePasseHistorique(String motDePasseHistorique) {
        this.motDePasseHistorique = motDePasseHistorique;
    }

    public Date getDateAjoutHistorique() {
        return dateAjoutHistorique;
    }

    public void setDateAjoutHistorique(Date dateAjoutHistorique) {
        this.dateAjoutHistorique = dateAjoutHistorique;
    }
    public void setDateAjoutHistorique(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          try {
            this.dateAjoutHistorique = formatter.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HistoriqueMotDePasse(long idHistorique, long joueur, String motDePasseHistorique, Date dateAjoutHistorique) {
        this.idHistorique = idHistorique;
        this.joueur = new Joueur(joueur);
        this.motDePasseHistorique = motDePasseHistorique;
        this.dateAjoutHistorique = dateAjoutHistorique;
    }
     public HistoriqueMotDePasse(long idHistorique, long joueur, String motDePasseHistorique, String dateAjoutHistorique) {
        this.idHistorique = idHistorique;
        this.joueur = new Joueur(joueur);
        this.motDePasseHistorique = motDePasseHistorique;
        this.setDateAjoutHistorique(dateAjoutHistorique);
    }
    
}  

