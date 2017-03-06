/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import s6.quizz.modele.Question;
import s6.quizz.utilies.UtilDB;

/**
 *
 * @author lenovo
 */
public class QuestionDao {
    private static final String save = "INSERT INTO question(id_question,id_categorie,id_niveau,question) VALUES (?,?,?,?)";
    private static final String update = "UPDATE question SET id_categorie=?, id_niveau=?,question=?  WHERE id_question=?";
    private static final String delete = "DELETE FROM question WHERE id_question=?";
    private static final String findById = "SELECT * FROM question WHERE id_question=?";
    private static final String findAll = "SELECT * FROM question";   
    public static void save(Question question)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(save);
            stmt.setLong(1,question.getIdQuestion());
            stmt.setLong(2,question.getCategorie().getIdCategorie());
            stmt.setLong(3,question.getNiveau().getIdNiveau());
            stmt.setString(4,question.getQuestion());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void update(Question question)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
             conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(update);
            stmt.setLong(1,question.getCategorie().getIdCategorie());
            stmt.setLong(2,question.getNiveau().getIdNiveau());
            stmt.setString(3,question.getQuestion());
            stmt.setLong(4,question.getIdQuestion());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void delete(Question question)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(delete);
            stmt.setLong(1,question.getIdQuestion());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static ArrayList<Question> findAll() throws Exception{
        ArrayList<Question> reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findAll);
            res = stmt.executeQuery();
            reponse = new ArrayList<Question>();
            while(res.next()){
                reponse.add(new Question(res.getLong("id_question"),res.getLong("id_categorie"),res.getLong("id_niveau"),res.getString("question")));
            }
        }catch(Exception e){
            throw e;
        }finally{
            if(res!=null) res.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
        return reponse;
    }
    public static Question findById(int id) throws Exception{
        Question reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findById);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = new Question(res.getLong("id_question"),res.getLong("id_categorie"),res.getLong("id_niveau"),res.getString("question"));
              }
        }catch(Exception e){
            throw e;
        }finally{
            if(res!=null) res.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
        return reponse;
    }
     public static int currval()throws Exception{
        int reponse =-1;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            String sql = "SELECT nextval('question_id_question_seq')";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = res.getInt(1);
            }
        }catch(Exception e){
            throw e;
        }finally{
            if(res!=null) res.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
        return reponse;
       
    }
}
