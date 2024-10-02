
package com.n2.domainModel;

import java.util.Date;


public class NhanVien {
    private String idNV;
    private String maNV;
    private String tenNV;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String cccd;
    private String diaChi;
    private String sdt;
    private boolean trangThaiNV;
    private String chucVu;
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(String idNV, String maNV, String tenNV, boolean gioiTinh, Date ngaySinh, String cccd, String diaChi, String sdt, boolean trangThaiNV, String chucVu, String matKhau) {
        this.idNV = idNV;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThaiNV = trangThaiNV;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
    }

    
    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isTrangThaiNV() {
        return trangThaiNV;
    }

    public void setTrangThaiNV(boolean trangThaiNV) {
        this.trangThaiNV = trangThaiNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
     public String layGioiTinh() {
        if (gioiTinh == true) {
            return "Nam";
        } else if (gioiTinh == false) {
            return "Nữ";
        } else {
            return null;
        }
    }
 
     public String layTrangThai() {
        if (trangThaiNV == true) {
            return "Đang hoạt động";
        }else {
            return "Ngừng hoạt động";
        }
    }
     
     public String layChucVu() {
        if ("Nhân viên".equalsIgnoreCase(chucVu)) {
            return "Nhân viên";
        } else {
            return "Quản lý";
        }
    }
}
