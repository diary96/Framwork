/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.modele;

import java.util.ArrayList;

public class Categorie {
    private long idCategorie;
    private String nomCategorie; 
    private ArrayList<Question> question;
    public long getIdCategorie() {
        return idCategorie;
    }
    
    public void setIdCategorie(long idCategorie) {
        this.idCategorie = idCategorie;
    }
     public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public ArrayList<Question> getQuestion() {
      return question;
   }
    public void setQuestion(ArrayList<Question> newQuestion) {
        removeAllQuestion();
        this.question = newQuestion;
    }
   public void addQuestion(Question newQuestion) {
      if (newQuestion == null)
         return;
      if (this.question == null)
         this.question = new ArrayList<Question>();
      if (!this.question.contains(newQuestion))
         this.question.add(newQuestion);
   }
   public void removeQuestion(Question oldQuestion) {
      if (oldQuestion == null)
         return;
      if (this.question != null)
         if (this.question.contains(oldQuestion))
            this.question.remove(oldQuestion);
   }
   public void removeAllQuestion() {
      if(this.question!=null)question.clear();
   }

    public Categorie(long idCategorie, String nomCategorie) {
        this.setIdCategorie(idCategorie); 
        this.setNomCategorie(nomCategorie); 
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public Categorie(long idCategorie) {
        this.idCategorie = idCategorie;
    }
    
   
}
