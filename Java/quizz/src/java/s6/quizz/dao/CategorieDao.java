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
import s6.quizz.modele.Categorie;
import s6.quizz.utilies.UtilDB;

/**
 *
 * @author lenovo
 */
public class CategorieDao {
    public static void save(Categorie categorie)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            String sql = "INSERT INTO categorie(id_categorie,nom_categorie) VALUES (?,?)";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,categorie.getIdCategorie());
            stmt.setString(2,categorie.getNomCategorie());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void update(Categorie categorie)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            String sql = "UPDATE categorie SET nom_categorie = ? WHERE id_categorie = ?";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,categorie.getNomCategorie());
            stmt.setLong(2,categorie.getIdCategorie());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void delete(Categorie categorie)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            String sql = "DELETE FROM  categorie WHERE id_categorie = ? ";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,categorie.getIdCategorie()); 
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static ArrayList<Categorie> findAll() throws Exception{
        ArrayList<Categorie> reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            String sql = "SELECT * FROM  categorie";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();
            reponse = new ArrayList<Categorie>();
            while(res.next()){
                reponse.add(new Categorie(res.getLong("id_categorie"),res.getString("nom_categorie")));
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
    public static Categorie findById(int id) throws Exception{
        Categorie reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            String sql = "SELECT * FROM  categorie where id_categorie = ?";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = new Categorie(res.getLong("id_categorie"),res.getString("nom_categorie"));
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
            String sql = "SELECT nextval('categorie_id_categorie_seq')";
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
