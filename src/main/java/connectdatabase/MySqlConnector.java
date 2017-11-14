/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author ngohoa
 */
public class MySqlConnector {
    Connection conn;
    public MySqlConnector(String DBName) throws ClassNotFoundException, SQLException, FileNotFoundException {
        int port =3306;
        Connection conn = null;
        Scanner scanner = new Scanner(new File("src/main/java/passDB.txt"));
        String userName = scanner.nextLine();
        String password = scanner.nextLine();
        String url = "jdbc:mysql://localhost:";
        url=url.concat(Integer.toString(port)).concat("/").concat(DBName);
        System.out.println(url);
        // String url = "jdbc:mysql://localhost:3306/dulichbui"; 
        //               jdbc:mysql://127.0.0.1:6996/bank_site1
        Class.forName("org.gjt.mm.mysql.Driver");
        this.conn = DriverManager.getConnection(url,userName,password);
        System.out.println("Da ket noi csdl");
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
        MySqlConnector test = new MySqlConnector("film_recommend");
        
    }
}
