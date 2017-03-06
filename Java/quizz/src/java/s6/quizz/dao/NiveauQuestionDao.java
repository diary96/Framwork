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
import s6.quizz.modele.NiveauQuestion;
import s6.quizz.utilies.UtilDB;

/**
 *
 * @author lenovo
 */
public class NiveauQuestionDao {
    private static final String save = "INSERT INTO niveau_question(id_niveau,rank_niveau,nom_niveau) VALUES (?,?,?)";
    private static final String update = "UPDATE niveau_question SET rank_niveau=?, nom_niveau=?  WHERE id_niveau=?";
    private static final String delete = "DELETE FROM niveau_question WHERE id_niveau=?";
    private static final String findById = "SELECT * FROM niveau_question WHERE id_niveau=?";
    private static final String findAll = "SELECT * FROM niveau_question";   
    public static void save(NiveauQuestion niveau)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(save);
            stmt.setLong(1,niveau.getIdNiveau());
            stmt.setInt(2,niveau.getRankNiveau());
            stmt.setString(3,niveau.getNomNiveau());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void update(NiveauQuestion niveau)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
             conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(update);
            stmt.setInt(1,niveau.getRankNiveau());
            stmt.setString(2,niveau.getNomNiveau());
            stmt.setLong(3,niveau.getIdNiveau());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void delete(NiveauQuestion niveau)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(delete);
            stmt.setLong(1,niveau.getIdNiveau());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static ArrayList<NiveauQuestion> findAll() throws Exception{
        ArrayList<NiveauQuestion> reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findAll);
            res = stmt.executeQuery();
            reponse = new ArrayList<NiveauQuestion>();
            while(res.next()){
                reponse.add(new NiveauQuestion(res.getLong("id_niveau"),res.getInt("rank_niveau"),res.getString("nom_niveau")));
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
    public static NiveauQuestion findById(int id) throws Exception{
        NiveauQuestion reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findById);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = new NiveauQuestion(res.getLong("id_niveau"),res.getInt("rank_niveau"),res.getString("nom_niveau"));
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
            String sql = "SELECT nextval('niveau_question_id_niveau_seq')";
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
