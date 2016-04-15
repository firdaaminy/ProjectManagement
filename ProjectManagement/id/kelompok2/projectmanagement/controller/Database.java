/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

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
        Class.forName("oracle.jdb.driver.OracleDriver");
        this.koneksi=DriverManager.getConnection("jdbc:");
    }
}
