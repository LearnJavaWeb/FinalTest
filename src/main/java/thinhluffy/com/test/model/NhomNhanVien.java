package thinhluffy.com.test.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhomnv")
public class NhomNhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public NhomNhanVien() {

    }

    public NhomNhanVien(String name) {
        this.name = name;
    }
    @OneToMany(targetEntity = NhanVien.class)
    private List<NhanVien> nhanVienList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }

    public void setNhanVienList(List<NhanVien> nhanVienList) {
        this.nhanVienList = nhanVienList;
    }
}
