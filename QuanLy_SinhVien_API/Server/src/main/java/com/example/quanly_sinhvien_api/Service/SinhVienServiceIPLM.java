package com.example.quanly_sinhvien_api.Service;

import com.example.quanly_sinhvien_api.Responsitory.ISinhVienResponsitory;
import com.example.quanly_sinhvien_api.model.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceIPLM implements ISinhVIenService {

    @Autowired
    private ISinhVienResponsitory responsitory;

    @Override
    public void add(SinhVien sv) {
        responsitory.save(sv);
    }

    @Override
    public void delete(Integer id) {
        responsitory.deleteById(id);
    }

    @Override
    public void update(Integer id, SinhVien Newsv) {
        Newsv.setId(id);
        responsitory.save(Newsv);
    }

    @Override
    public List<SinhVien> HienThi() {
        return responsitory.findAll();
    }
}
