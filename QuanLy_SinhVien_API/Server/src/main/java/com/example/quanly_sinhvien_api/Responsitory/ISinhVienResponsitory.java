package com.example.quanly_sinhvien_api.Responsitory;

import com.example.quanly_sinhvien_api.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinhVienResponsitory extends JpaRepository<SinhVien,Integer> {
}
