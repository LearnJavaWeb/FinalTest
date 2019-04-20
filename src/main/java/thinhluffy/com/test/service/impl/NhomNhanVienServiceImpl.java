package thinhluffy.com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thinhluffy.com.test.model.NhomNhanVien;
import thinhluffy.com.test.repository.NhomNhanVienRepository;
import thinhluffy.com.test.service.NhomNhanVienService;

@Service
public class NhomNhanVienServiceImpl implements NhomNhanVienService {
    @Autowired
    private NhomNhanVienRepository nhomNhanVienRepository;
    @Override
    public Iterable<NhomNhanVien> findAll() {
        return nhomNhanVienRepository.findAll();
    }

    @Override
    public NhomNhanVien findById(Integer id) {
        return nhomNhanVienRepository.findOne(id);
    }

    @Override
    public void save(NhomNhanVien nhomNhanVien) {
        nhomNhanVienRepository.save(nhomNhanVien);
    }

    @Override
    public void remove(Integer id) {
        nhomNhanVienRepository.delete(id);
    }
}
