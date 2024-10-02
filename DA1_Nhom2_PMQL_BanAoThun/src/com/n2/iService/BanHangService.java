/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.iService;

import com.n2.domainModel.HoaDon;
import com.n2.domainModel.HoaDonChiTiet;
import com.n2.domainModel.SanPham;
import com.n2.domainModel.SanPhamChiTiet;
import com.n2.iRepository.BanHangRepository;
import com.n2.service.iBanHangService;
import java.util.List;

/**
 *
 * @author vxkie
 */
public class BanHangService implements iBanHangService {

    private BanHangRepository banHangRepository = new BanHangRepository();

    @Override
    public List<SanPhamChiTiet> getAllSP() {
        return banHangRepository.getAllSP();
    }

    @Override
    public List<HoaDon> getAllHD() {
        return banHangRepository.getAllHD();
    }

    @Override
    public String insertHD(HoaDon hd) {
        return banHangRepository.insertHD(hd);
    }

    @Override
    public String findByIdKH(String idKH) {
        return this.banHangRepository.findByIdKH(idKH);
    }

    @Override
    public String findByIdNV(String idNV) {
        return this.banHangRepository.findByIdNV(idNV);
    }

    @Override
    public void deleteHD(String maHD) {
        this.banHangRepository.deleteHD(maHD);
    }

    @Override
    public List<SanPham> getSanPhamGH(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTiet> getHDCT(String maHDCT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
