/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Database {
    private static Connection koneksi;
    private static Statement statement;
    private static ResultSet rst;
    
    public Database() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        koneksi=DriverManager.getConnection("jdbc:mysql://aktif.id:3306/aktifid_tubes","aktifid_tubes","HidupTelkom");
        statement=koneksi.createStatement();
    }
    
    public Connection getConnection() {
        return koneksi;
    }
    
    public ResultSet getData(String SQLString) throws Exception{
        rst=statement.executeQuery(SQLString);
        return rst;
    }
    
    public void updateQuery(String SQLString) throws Exception{
        statement.executeUpdate(SQLString);
    }
    
    public void updateQuery(PreparedStatement preparedStatement) {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeDB() throws Exception{
        koneksi.close();
    }
}
