/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.modele;

import java.util.*;
public class Reponse {
   private long idReponse;
   private java.lang.String reponse;
   private Question question;
   private boolean ifVrai;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
   
    public long getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(long idReponse) {
        this.idReponse = idReponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public boolean getIfVrai() {
        return ifVrai;
    }

    public void setIfVrai(boolean ifVrai) {
        this.ifVrai = ifVrai;
    }
    public void setIfVrai(int ifVrai) {
        if(ifVrai==0) this.ifVrai = false;
        else this.ifVrai = true;
    }
    public int getIfvraiBase(){
        if(this.ifVrai==false)return 0;
        else return 1;
    }
    public Reponse(long idReponse, String reponse, Question question, boolean ifVrai) {
        this.setIdReponse(idReponse);
        this.setReponse(reponse);
        this.setQuestion(question);
        this.setIfVrai(ifVrai);
    }
    public Reponse(long idReponse, String reponse, Question question, int ifVrai) {
        this.setIdReponse(idReponse);
        this.setReponse(reponse);
        this.setQuestion(question);
        this.setIfVrai(ifVrai);
    }
    
    public Reponse(long idReponse, long question, String reponse, int ifVrai) {
        this.setIdReponse(idReponse);
        this.setReponse(reponse);
        this.setQuestion(new Question(question));
        this.setIfVrai(ifVrai);
    }

    public Reponse(String reponse, Question question, int ifVrai) {
        this.setReponse(reponse);
        this.setQuestion(question);
        this.setIfVrai(ifVrai);
    }
    
    
   
}
