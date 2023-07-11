package com.example.quanly_sinhvien_api.Service;

import com.example.quanly_sinhvien_api.model.SinhVien;

import java.util.List;

public interface ISinhVIenService {

     void add(SinhVien sv);

     void delete(Integer id);

     void update(Integer id,SinhVien sv);

     List<SinhVien> HienThi();

}
