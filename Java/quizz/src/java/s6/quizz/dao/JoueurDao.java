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
import s6.quizz.modele.Joueur;
import s6.quizz.utilies.UtilDB;

/**
 *
 * @author lenovo
 */
public class JoueurDao {
    private static final String save = "INSERT INTO joueur(id_joueur,nom_joueur,naissance_joueur,email_joueur,mot_de_passe_joueur) VALUES (?,?,?,?,?)";
    private static final String update = "UPDATE joueur SET nom_joueur=?, naissance_joueur=?, email_joueur=?, mot_de_passe_joueur=?  WHERE id_joueur=?";
    private static final String delete = "DELETE FROM joueur WHERE id_joueur=?";
    private static final String findById = "SELECT * FROM joueur WHERE id_joueur=?";
    private static final String findAll = "SELECT * FROM joueur";   
    public static void save(Joueur joueur)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
           conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(save);
            
            stmt.setLong(1,joueur.getIdJoueur());
            stmt.setString(2,joueur.getNomJoueur());
            stmt.setDate(3,new java.sql.Date(joueur.getNaissanceJoueur().getTime()));
            stmt.setString(4,joueur.getEmailJoueur());
            stmt.setString(5,joueur.getMotDePasseJoueur());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void update(Joueur joueur)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
             conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(update);
            stmt.setString(1,joueur.getNomJoueur());
            stmt.setDate(2,new java.sql.Date(joueur.getNaissanceJoueur().getTime()));
            stmt.setString(3,joueur.getEmailJoueur());
            stmt.setString(4,joueur.getMotDePasseJoueur());
            stmt.setLong(5,joueur.getIdJoueur());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void delete(Joueur joueur)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(delete);
            stmt.setLong(1,joueur.getIdJoueur());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static ArrayList<Joueur> findAll() throws Exception{
        ArrayList<Joueur> reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findAll);
            res = stmt.executeQuery();
            reponse = new ArrayList<Joueur>();
            while(res.next()){
                reponse.add(new Joueur(res.getLong("id_joueur"),res.getString("nom_joueur"),res.getDate("naissance_joueur"),res.getString("email_joueur"),res.getString("mot_de_passe_joueur")));
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
    public static Joueur findById(int id) throws Exception{
        Joueur reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(findById);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = new Joueur(res.getLong("id_joueur"),res.getString("nom_joueur"),res.getDate("naissance_joueur"),res.getString("email_joueur"),res.getString("mot_de_passe_joueur"));
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
            String sql = "SELECT nextval('joueur_id_joueur_seq')";
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
