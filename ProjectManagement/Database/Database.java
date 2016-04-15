/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Database {
    Connection koneksi;
    Statement statement;
    ResultSet rst;
    
    public Database() throws Exception{
        Class.forName("org.gjt.mm.mysql.Driver");
        this.koneksi=DriverManager.getConnection("jdbc:mysql://aktif.id:3306/aktifid_tubes","aktifid_tubes","HidupTelkom");
        this.statement=koneksi.createStatement();
    }
    
    public ResultSet getData(String SQLString) throws Exception{
        rst=statement.executeQuery(SQLString);
        return rst;
    }
    
    public void query(String SQLString) throws Exception{
        statement.executeUpdate(SQLString);
    }
    
    public void closeDB() throws Exception{
        koneksi.close();
    }
}