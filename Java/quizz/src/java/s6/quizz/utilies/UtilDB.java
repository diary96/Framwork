/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.utilies;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lenovo
 */
public class UtilDB {
     public static Connection getConnPostgre() throws Exception
	{
            Class.forName("org.postgresql.Driver");
            Connection conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/framework","postgres", "diary");
            return conn;
	}
}
