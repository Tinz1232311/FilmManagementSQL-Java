/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author This PC
 */
public class Film {
    String MaPhim, TenPhim, DongPhim, TheLoai;
    Double DanhGia;

    public String getMaPhim() {
        return MaPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public String getDongPhim() {
        return DongPhim;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public Double getDanhGia() {
        return DanhGia;
    }

    public void setMaPhim(String MaPhim) {
        this.MaPhim = MaPhim;
    }

    public void setTenPhim(String TenPhim) {
        this.TenPhim = TenPhim;
    }

    public void setDongPhim(String DongPhim) {
        this.DongPhim = DongPhim;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public void setDanhGia(Double DanhGia) {
        this.DanhGia = DanhGia;
    }

    public Film(String MaPhim, String TenPhim, String DongPhim, String TheLoai, Double DanhGia) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.DongPhim = DongPhim;
        this.TheLoai = TheLoai;
        this.DanhGia = DanhGia;
    }
    
}
