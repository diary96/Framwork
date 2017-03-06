/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.modele;
import java.util.*;
public class Question {
   private long idQuestion;
   private Categorie categorie;
   private NiveauQuestion niveau;
   private java.lang.String question;
   private ArrayList<Reponse> reponse;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public NiveauQuestion getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauQuestion niveau) {
        this.niveau = niveau;
    }
   
    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
   public ArrayList<Reponse> getReponse() {
      return reponse;
   }
   public void setReponse(ArrayList<Reponse> newReponse) {
      removeAllReponse();
      this.reponse = newReponse;
   }
   public void addReponse(Reponse newReponse) {
      if (newReponse == null)
         return;
      if (this.reponse == null)
         this.reponse = new ArrayList<Reponse>();
      if (!this.reponse.contains(newReponse))
         this.reponse.add(newReponse);
   }
   public void removeReponse(Reponse oldReponse) {
      if (oldReponse == null)
         return;
      if (this.reponse != null)
         if (this.reponse.contains(oldReponse))
            this.reponse.remove(oldReponse);
   }
   public void removeAllReponse() {
      if (reponse != null)
         reponse.clear();
   }

    public Question() {
    }
   
    public Question(long idQuestion, Categorie categorie, NiveauQuestion niveau, String question) {
        this.setIdQuestion(idQuestion);
        this.setCategorie(categorie);
        this.setNiveau(niveau);
        this.setQuestion(question);
    }
     public Question(long idQuestion, long categorie, long niveau, String question) {
        this.setIdQuestion(idQuestion);
        this.setCategorie( new Categorie(categorie));
        this.setNiveau(new NiveauQuestion(niveau));
        this.setQuestion(question);
    }

    public Question(long idQuestion) {
        this.idQuestion = idQuestion;
    }
     
   
}
