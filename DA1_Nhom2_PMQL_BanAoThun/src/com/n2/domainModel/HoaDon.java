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
public class HoaDon {
    private String idHD;
    private String idKH;
    private String idNV;
    private String idKM;
    private String maHD;
    private Date ngayTao;
    private String lyDoHuy;
    private Date ngayThanhToan;
    private float donGia;
    private float donGiaSauGiam;
    private float tongTien;
    private boolean phuongThucThanhToan;
    private boolean trangThaiHD;

    public HoaDon() {
    }

    public HoaDon(String idHD, String idKH, String idNV, String idKM, String maHD, Date ngayTao, String lyDoHuy, Date ngayThanhToan, float donGia, float donGiaSauGiam, float tongTien, boolean phuongThucThanhToan, boolean trangThaiHD) {
        this.idHD = idHD;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idKM = idKM;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.lyDoHuy = lyDoHuy;
        this.ngayThanhToan = ngayThanhToan;
        this.donGia = donGia;
        this.donGiaSauGiam = donGiaSauGiam;
        this.tongTien = tongTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.trangThaiHD = trangThaiHD;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getLyDoHuy() {
        return lyDoHuy;
    }

    public void setLyDoHuy(String lyDoHuy) {
        this.lyDoHuy = lyDoHuy;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getDonGiaSauGiam() {
        return donGiaSauGiam;
    }

    public void setDonGiaSauGiam(float donGiaSauGiam) {
        this.donGiaSauGiam = donGiaSauGiam;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(boolean phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public boolean isTrangThaiHD() {
        return trangThaiHD;
    }

    public void setTrangThaiHD(boolean trangThaiHD) {
        this.trangThaiHD = trangThaiHD;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHD=" + idHD + ", idKH=" + idKH + ", idNV=" + idNV + ", idKM=" + idKM + ", maHD=" + maHD + ", ngayTao=" + ngayTao + ", lyDoHuy=" + lyDoHuy + ", ngayThanhToan=" + ngayThanhToan + ", donGia=" + donGia + ", donGiaSauGiam=" + donGiaSauGiam + ", tongTien=" + tongTien + ", phuongThucThanhToan=" + phuongThucThanhToan + ", trangThaiHD=" + trangThaiHD + '}';
    }
    public String ttHD(boolean tt){
        System.out.println("hhhhhhhhhhhh"+tt);
        if(tt){
            return "Đã thanh toán";
        } else {
            return "Chưa thanh toán";
        }
    }
    
}
