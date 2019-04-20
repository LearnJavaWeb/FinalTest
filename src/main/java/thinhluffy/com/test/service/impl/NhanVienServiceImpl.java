package thinhluffy.com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thinhluffy.com.test.model.NhanVien;
import thinhluffy.com.test.model.NhomNhanVien;
import thinhluffy.com.test.repository.NhanVienRepository;
import thinhluffy.com.test.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> findAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public NhanVien findById(Integer id) {
        return nhanVienRepository.findOne(id);
    }

    @Override
    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void remove(Integer id) {
        nhanVienRepository.delete(id);
    }

    @Override
    public Iterable<NhanVien> findAllByNhomNhanVien(NhomNhanVien nhomNhanVien) {
        return nhanVienRepository.findAllByNhomNhanVien(nhomNhanVien);
    }

    @Override
    public Page<NhanVien> findAllByTenContaining(String ten, Pageable pageable) {
        return nhanVienRepository.findAllByTenContaining(ten, pageable);
    }
}
