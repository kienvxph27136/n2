/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.domainModel;

/**
 *
 * @author vxkie
 */
public class SanPhamChiTiet {
    private String idSPCT;
    private String idMS;
    private String idCL;
    private String idTH;
    private String idKC;
    private String idSP;
    private String idNV;
    private String maSPCT;
    private int soLuong;
    private String moTa;
    private boolean trangThaiSPCT;
    private float donGia;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String idSPCT, String idMS, String idCL, String idTH, String idKC, String idSP, String idNV, String maSPCT, int soLuong, String moTa, boolean trangThaiSPCT, float donGia) {
        this.idSPCT = idSPCT;
        this.idMS = idMS;
        this.idCL = idCL;
        this.idTH = idTH;
        this.idKC = idKC;
        this.idSP = idSP;
        this.idNV = idNV;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.trangThaiSPCT = trangThaiSPCT;
        this.donGia = donGia;
    }

    public String getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(String idSPCT) {
        this.idSPCT = idSPCT;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getIdCL() {
        return idCL;
    }

    public void setIdCL(String idCL) {
        this.idCL = idCL;
    }

    public String getIdTH() {
        return idTH;
    }

    public void setIdTH(String idTH) {
        this.idTH = idTH;
    }

    public String getIdKC() {
        return idKC;
    }

    public void setIdKC(String idKC) {
        this.idKC = idKC;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThaiSPCT() {
        return trangThaiSPCT;
    }

    public void setTrangThaiSPCT(boolean trangThaiSPCT) {
        this.trangThaiSPCT = trangThaiSPCT;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    public String tt(boolean trangThai){
        if(trangThai){
            return "Còn hàng";
        } else {
            return "Hết hàng";
        }
    }
}
