package thinhluffy.com.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thinhluffy.com.test.model.NhanVien;
import thinhluffy.com.test.model.NhomNhanVien;

public interface NhanVienService {
    Page<NhanVien> findAll(Pageable pageable);

    NhanVien findById(Integer id);

    void save(NhanVien nhanVien);

    void remove(Integer id);

    Iterable<NhanVien> findAllByNhomNhanVien(NhomNhanVien nhomNhanVien);

    Page<NhanVien> findAllByTenContaining(String ten, Pageable pageable);
}
