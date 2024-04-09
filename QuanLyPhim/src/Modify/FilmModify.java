/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modify;
import Module.Film;
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
public class FilmModify {
    public static List<Film> findAll() {
        List<Film> FilmList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select *from filmmanagement.film";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Film tmp = new Film(resultSet.getString("MaPhim"),
                        resultSet.getString("TenPhim"), resultSet.getString("DongPhim"),
                        resultSet.getString("TheLoai"), resultSet.getDouble("DanhGia"));
                FilmList.add(tmp);
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

        return FilmList;
    }
    
    public static List<Film> ListFilm() {
        List<Film> FilmList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select *from filmmanagement.film";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Film tmp = new Film(resultSet.getString("MaPhim"),
                        resultSet.getString("TenPhim"), resultSet.getString("DongPhim"),
                        resultSet.getString("TheLoai"), resultSet.getDouble("DanhGia"));
                FilmList.add(tmp);
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

        return FilmList;
    }

    public static void insert(Film tmp) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "insert into film(maphim , tenphim, dongphim, theloai, danhgia) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, tmp.getMaPhim());
            statement.setString(2, tmp.getTenPhim());
            statement.setString(3, tmp.getDongPhim());
            statement.setString(4, tmp.getTheLoai());
            if(tmp.getDanhGia()!= null) 
            {
                statement.setDouble(5, tmp.getDanhGia());
            } 
            else 
            {
                statement.setObject(5, null); // Đặt giá trị null cho trường danhgia
            }
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

    public static void delete(String MaPhim) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "DELETE FROM film WHERE maphim = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, MaPhim);

            statement.executeUpdate();
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
    
    public static void update(Film tmp) {
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        // Kết nối đến cơ sở dữ liệu
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

        // Câu lệnh SQL để update dữ liệu
        String sql = "UPDATE film SET tenphim=?, dongphim=?, theloai=?, danhgia=? WHERE maphim=?";
        statement = connection.prepareStatement(sql);

        // Thiết lập các tham số cho câu lệnh PreparedStatement
        statement.setString(1, tmp.getTenPhim());
        statement.setString(2, tmp.getDongPhim());
        statement.setString(3, tmp.getTheLoai());
        if(tmp.getDanhGia()!= null) 
        {
            statement.setDouble(4, tmp.getDanhGia());
        } 
        else 
        {
            statement.setObject(4, null); // Đặt giá trị null cho trường danhgia
        }
        statement.setString(5, tmp.getMaPhim());

        // Thực thi câu lệnh update
        statement.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(FilmModify.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Đóng kết nối và các tài nguyên liên quan
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
    // Kết thúc.
}
    
    public static List<Film> findByMaPhim(String maphim) {
        List<Film> FilmList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select * from film where maphim like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, maphim);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film tmp = new Film(resultSet.getString("MaPhim"),
                        resultSet.getString("TenPhim"), resultSet.getString("DongPhim"),
                        resultSet.getString("TheLoai"), resultSet.getDouble("DanhGia"));
                FilmList.add(tmp);
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

        return FilmList;
    }
    
    public static List<Film> findByTenPhim(String tenphim) {
        List<Film> FilmList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select * from film where tenphim like ? order by danhgia DESC";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + tenphim + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film tmp = new Film(resultSet.getString("MaPhim"),
                        resultSet.getString("TenPhim"), resultSet.getString("DongPhim"),
                        resultSet.getString("TheLoai"), resultSet.getDouble("DanhGia"));
                FilmList.add(tmp);
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

        return FilmList;
    }
    
    public static List<Film> findByDongPhim(String dongphim) {
        List<Film> FilmList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select * from film where dongphim like ? order by danhgia DESC";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + dongphim + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film tmp = new Film(resultSet.getString("MaPhim"),
                        resultSet.getString("TenPhim"), resultSet.getString("DongPhim"),
                        resultSet.getString("TheLoai"), resultSet.getDouble("DanhGia"));
                FilmList.add(tmp);
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

        return FilmList;
    }
    
    public static List<Film> findByTheLoai(String theloai) {
        List<Film> FilmList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select * from film where theloai like ? order by danhgia DESC";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + theloai + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film tmp = new Film(resultSet.getString("MaPhim"),
                        resultSet.getString("TenPhim"), resultSet.getString("DongPhim"),
                        resultSet.getString("TheLoai"), resultSet.getDouble("DanhGia"));
                FilmList.add(tmp);
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

        return FilmList;
    }
    
}
