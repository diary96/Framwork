/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import s6.quizz.modele.Categorie;

/**
 *
 * @author lenovo
 */
public class CategorieDaoTest {
    
    public CategorieDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class CategorieDao.
     */
    @Test
    public void testSave() throws Exception {
        int id = CategorieDao.currval();
        Categorie categorie = new Categorie(id,"test");
        CategorieDao.save(categorie);
    
        
        Categorie verifier = CategorieDao.findById(id);
       
        CategorieDao.delete(categorie);
        
        assertEquals(categorie.getIdCategorie(), verifier.getIdCategorie());
        assertEquals(categorie.getNomCategorie(), categorie.getNomCategorie());
    }

    /**
     * Test of update method, of class CategorieDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int id=CategorieDao.currval();
        Categorie a = new Categorie(id, "test");
        CategorieDao.save(a);
        a = new Categorie(id,"seconde");
        CategorieDao.update(a);
        
        Categorie verif = CategorieDao.findById(id);
        
        CategorieDao.delete(a);
        
        assertEquals(a.getIdCategorie(), verif.getIdCategorie());
        assertEquals(a.getNomCategorie(), verif.getNomCategorie());
    }

    /**
     * Test of delete method, of class CategorieDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id=CategorieDao.currval();
        Categorie a = new Categorie(id, "test");
        CategorieDao.save(a);
        
        CategorieDao.delete(a);
        
        assertEquals(CategorieDao.findById(id), null);
    }

    /**
     * Test of findAll method, of class CategorieDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ArrayList<Categorie> expResult = CategorieDao.findAll();
        
        int id=CategorieDao.currval();
        Categorie a = new Categorie(id, "test");
        CategorieDao.save(a);
        
        ArrayList<Categorie> result = CategorieDao.findAll();
        
        CategorieDao.delete(a);
        
        assertEquals(expResult.size()+1, result.size());
    }

    /**
     * Test of findById method, of class CategorieDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id=CategorieDao.currval();
        Categorie a = new Categorie(id, "test");
        CategorieDao.save(a);
        
        Categorie verif = CategorieDao.findById(id);
        
        CategorieDao.delete(a);
        
        assertEquals(a.getIdCategorie(), verif.getIdCategorie());
        assertEquals(a.getNomCategorie(), verif.getNomCategorie());
    }
    
}
