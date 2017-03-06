/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.modele;

/**
 *
 * @author lenovo
 */
import java.util.*;
public class NiveauQuestion {
   private long idNiveau;
   private int rankNiveau;
   private java.lang.String nomNiveau;  
   private ArrayList<Question> question;

    public long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public int getRankNiveau() {
        return rankNiveau;
    }

    public void setRankNiveau(int rankNiveau) {
        this.rankNiveau = rankNiveau;
    }

    public String getNomNiveau() {
        return nomNiveau;
    }

    public void setNomNiveau(String nomNiveau) {
        this.nomNiveau = nomNiveau;
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
      if (question != null)
         question.clear();
   }

    public NiveauQuestion(long idNiveau, int rankNiveau, String nomNiveau) {
        this.idNiveau = idNiveau;
        this.rankNiveau = rankNiveau;
        this.nomNiveau = nomNiveau;
    }
   
    public NiveauQuestion(int rankNiveau, String nomNiveau) {
        this.rankNiveau = rankNiveau;
        this.nomNiveau = nomNiveau;
    }

    public NiveauQuestion(long idNiveau) {
        this.idNiveau = idNiveau;
    }
    
    public NiveauQuestion() {
    }
   
}
