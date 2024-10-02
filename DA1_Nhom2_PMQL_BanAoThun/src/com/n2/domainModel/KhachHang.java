/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.domainModel;

import java.util.Date;

/**
 *
 * @author admin
 */
public class KhachHang {
    private String idKhachHang;
    private String maKH;
    private String tenKH;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String SDT;
    private String diaChi;
    private boolean trangThai;

    public KhachHang() {
    }

    public KhachHang(String idKhachHang, String maKH, String tenKH, Date ngaySinh, boolean gioiTinh, String SDT, String diaChi,boolean trangThai) {
        this.idKhachHang = idKhachHang;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idKhachHang=" + idKhachHang + ", maKH=" + maKH + ", tenKH=" + tenKH + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", SDT=" + SDT + ", diaChi=" + diaChi + ", trangThai=" + trangThai + '}';
    }

   
    public String layGT() {
        if (gioiTinh == true) {
            return "Nam";
        }else{
            return "Nữ";
        }
    }
    

    public String layTrangThai() {
        if (trangThai == true) {
            return "Đang hoạt động";
        }else {
            return "Ngừng hoạt động";
        }
    }
}
