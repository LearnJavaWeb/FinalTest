package thinhluffy.com.test.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String ten;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;
    @NotEmpty
    private boolean gioiTinh;
    @NotEmpty
    private int soDienThoai;
    @NotEmpty
    private int cmnd;
    @Email
    private String email;
    @NotEmpty
    private String diaChi;

    public NhanVien() {

    }

    public NhanVien(@NotEmpty String ten, @NotEmpty Date ngaySinh, @NotEmpty boolean gioiTinh, @NotEmpty int soDienThoai, @NotEmpty int cmnd, @Email String email, @NotEmpty String diaChi) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.cmnd = cmnd;
        this.email = email;
        this.diaChi = diaChi;
    }
    @ManyToOne
    @JoinColumn(name = "nhomnv_id")
    private NhomNhanVien nhomNhanVien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public NhomNhanVien getNhomNhanVien() {
        return nhomNhanVien;
    }

    public void setNhomNhanVien(NhomNhanVien nhomNhanVien) {
        this.nhomNhanVien = nhomNhanVien;
    }
}
