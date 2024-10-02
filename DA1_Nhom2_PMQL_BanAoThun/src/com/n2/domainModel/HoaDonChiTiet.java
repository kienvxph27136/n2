/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.domainModel;

import java.util.Date;

/**
 *
 * @author vxkie
 */
public class HoaDonChiTiet {
     private String idHDCT;
     private String idHD;
     private String idSPCT;
     private String maHDCT;
     private Date ngayTao;
     private int soLuong;
     private float donGia;
     private float donGiaSauKhiGiam;
     private boolean phuongThucThanhToan;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHDCT, String idHD, String idSPCT, String maHDCT, Date ngayTao, int soLuong, float donGia, float donGiaSauKhiGiam, boolean phuongThucThanhToan) {
        this.idHDCT = idHDCT;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.maHDCT = maHDCT;
        this.ngayTao = ngayTao;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaSauKhiGiam = donGiaSauKhiGiam;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(String idHDCT) {
        this.idHDCT = idHDCT;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(String idSPCT) {
        this.idSPCT = idSPCT;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getDonGiaSauKhiGiam() {
        return donGiaSauKhiGiam;
    }

    public void setDonGiaSauKhiGiam(float donGiaSauKhiGiam) {
        this.donGiaSauKhiGiam = donGiaSauKhiGiam;
    }

    public boolean isPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(boolean phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
     
}
