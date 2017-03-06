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
import s6.quizz.modele.Reponse;
import s6.quizz.utilies.UtilDB;

/**
 *
 * @author lenovo
 */
public class ReponseDao {
     private static final String save = "INSERT INTO reponse(id_reponse,id_question,reponse,ifvrai) VALUES (?,?,?,?)";
    private static final String update = "UPDATE reponse SET id_question=?, reponse=?,ifvrai=?  WHERE id_reponse=?";
    private static final String delete = "DELETE FROM reponse WHERE id_reponse=?";
    private static final String findById = "SELECT * FROM reponse WHERE id_reponse=?";
    private static final String findAll = "SELECT * FROM reponse";   
    public static void save(Reponse reponse)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(save);
            
            stmt.setLong(1,reponse.getIdReponse());
            stmt.setLong(2,reponse.getQuestion().getIdQuestion());
            stmt.setString(3,reponse.getReponse());
            stmt.setInt(4,reponse.getIfvraiBase());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void update(Reponse reponse)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(update);
            stmt.setLong(1,reponse.getQuestion().getIdQuestion());
            stmt.setString(2,reponse.getReponse());
            stmt.setInt(3,reponse.getIfvraiBase());
            stmt.setLong(4,reponse.getIdReponse());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void delete(Reponse reponse)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(delete);
            stmt.setLong(1,reponse.getIdReponse());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static ArrayList<Reponse> findAll() throws Exception{
        ArrayList<Reponse> reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findAll);
            res = stmt.executeQuery();
            reponse = new ArrayList<Reponse>();
            while(res.next()){
                reponse.add(new Reponse(res.getLong("id_reponse"),res.getLong("id_question"),res.getString("reponse"),res.getInt("ifvrai")));
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
    public static Reponse findById(int id) throws Exception{
        Reponse reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findById);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = new Reponse(res.getLong("id_reponse"),res.getLong("id_question"),res.getString("reponse"),res.getInt("ifvrai"));
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
            String sql = "SELECT nextval('reponse_id_reponse_seq')";
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
