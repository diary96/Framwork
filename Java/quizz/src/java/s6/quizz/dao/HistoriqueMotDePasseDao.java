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
import s6.quizz.modele.HistoriqueMotDePasse;
import s6.quizz.utilies.UtilDB;

/**
 *
 * @author lenovo
 */
public class HistoriqueMotDePasseDao {
    public static void save(HistoriqueMotDePasse historiqueMotDePasse)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            String sql = "INSERT INTO historique_mot_de_passe(id_historique,id_joueur,mot_de_passe_historique,date_ajout_historique) VALUES (?,?,?,?)";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
             stmt.setLong(1,historiqueMotDePasse.getIdHistorique());
            stmt.setLong(2,historiqueMotDePasse.getJoueur().getIdJoueur());
            stmt.setString(3, historiqueMotDePasse.getMotDePasseHistorique());
            stmt.setDate(4, new java.sql.Date(historiqueMotDePasse.getDateAjoutHistorique().getTime()));
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void update(HistoriqueMotDePasse historiqueMotDePasse)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            String sql = "UPDATE historique_mot_de_passe SET mot_de_passe_historique = ? WHERE id_historique = ?";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,historiqueMotDePasse.getMotDePasseHistorique());
            stmt.setLong(2,historiqueMotDePasse.getIdHistorique());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static void delete(HistoriqueMotDePasse historiqueMotDePasse)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            String sql = "DELETE FROM  historique_mot_de_passe WHERE id_historique = ?";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,historiqueMotDePasse.getIdHistorique());
            stmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
    }
    public static ArrayList<HistoriqueMotDePasse> findAll() throws Exception{
        ArrayList<HistoriqueMotDePasse> reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            String sql = "SELECT * FROM  historique_mot_de_passe";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();
            reponse = new ArrayList<HistoriqueMotDePasse>();
            while(res.next()){
                reponse.add(new HistoriqueMotDePasse(res.getLong("id_historique"),res.getLong("id_joueur"),res.getString("mot_de_passe_historique"),res.getDate("date_ajout_historique")));
            }
        }catch(Exception e){
            throw e;
        }finally{
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
        return reponse;
    }
    public static HistoriqueMotDePasse findById(int id) throws Exception{
        HistoriqueMotDePasse reponse =null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            String sql = "SELECT * FROM  historique_mot_de_passe where id_historique = ?";
            conn = UtilDB.getConnPostgre();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            while(res.next()){
                reponse = new HistoriqueMotDePasse(res.getLong("id_historique"),res.getLong("id_joueur"),res.getString("mot_de_passe_historique"),res.getDate("date_ajout_historique"));
              }
        }catch(Exception e){
            throw e;
        }finally{
            if(res!=null)res.close();
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
            String sql = "SELECT nextval('historique_mot_de_passe_id_historique_seq')";
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
