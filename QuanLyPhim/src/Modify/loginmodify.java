/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modify;

import Module.Film;
import Module.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author This PC
 */
public class loginmodify {
    
    public static List<Login> findAll() {
        List<Login> AccountList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select *from filmmanagement.loginfilm";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Login tmp = new Login(resultSet.getString("account"), resultSet.getString("password"));
                AccountList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return AccountList;
    }
    
    public static List<Login> ListSV() {
        List<Login> AccountList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select *from filmmanagement.loginfilm";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Login tmp = new Login(resultSet.getString("account"), resultSet.getString("password"));
                AccountList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return AccountList;
    }

    public static void insert(Login tmp) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "insert into loginfilm(account , password) values(?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, tmp.getUsername());
            statement.setString(2, tmp.getPassword());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static boolean CheckLog(String account, String password) {
        List<Login> AccountList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");
            //query
            String sql = "select * from loginfilm WHERE account = ? and password = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,account);
            statement.setString(2,password);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) 
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return false;
    }
}
