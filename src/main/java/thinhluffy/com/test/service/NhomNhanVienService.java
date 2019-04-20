package thinhluffy.com.test.service;

import thinhluffy.com.test.model.NhomNhanVien;

public interface NhomNhanVienService {
    Iterable<NhomNhanVien> findAll();

    NhomNhanVien findById(Integer id);

    void save(NhomNhanVien nhomNhanVien);

    void remove(Integer id);
}
