package thinhluffy.com.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import thinhluffy.com.test.model.NhanVien;
import thinhluffy.com.test.model.NhomNhanVien;

public interface NhanVienRepository extends PagingAndSortingRepository<NhanVien, Integer> {
    Iterable<NhanVien> findAllByNhomNhanVien(NhomNhanVien nhomNhanVien);

    Page<NhanVien> findAllByTenContaining(String ten, Pageable pageable);
}
