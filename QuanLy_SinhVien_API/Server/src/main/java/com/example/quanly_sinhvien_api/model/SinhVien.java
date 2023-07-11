package com.example.quanly_sinhvien_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "sinh_vien")
@Data
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ten;

    private String tuoi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "chuyen_nganh")
    private String chuyenNghanh;

    public SinhVien(String ten, String tuoi, Boolean gioiTinh, String chuyenNghanh) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.chuyenNghanh = chuyenNghanh;
    }

    public SinhVien() {

    }
}
