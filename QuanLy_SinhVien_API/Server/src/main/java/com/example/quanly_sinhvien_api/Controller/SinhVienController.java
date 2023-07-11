package com.example.quanly_sinhvien_api.Controller;

import com.example.quanly_sinhvien_api.Service.ISinhVIenService;
import com.example.quanly_sinhvien_api.model.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sinh-vien")
@CrossOrigin(origins = "*", maxAge = -1)
public class SinhVienController {

    @Autowired
    private ISinhVIenService service;

    @GetMapping("/hien-thi")
    public List<SinhVien> HienThi() {
        return service.HienThi();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody SinhVien sinhVien) throws ParseException {
        service.add(sinhVien);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody SinhVien sinhVien) {
        service.update(id, sinhVien);
    }
}

