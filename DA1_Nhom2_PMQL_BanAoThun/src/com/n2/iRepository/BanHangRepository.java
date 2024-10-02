/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.iRepository;

import com.n2.domainModel.HoaDon;
import com.n2.domainModel.HoaDonChiTiet;
import com.n2.domainModel.SanPham;
import com.n2.domainModel.SanPhamChiTiet;
import com.n2.repository.iBanHangRepository;
import com.n2.util.DBConnection;
import com.n2.util.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vxkie
 */
public class BanHangRepository implements iBanHangRepository {

    @Override
    public List<SanPhamChiTiet> getAllSP() {
        List<SanPhamChiTiet> listSPCT = new ArrayList<>();
        String sql = "SELECT dbo.SANPHAMCHITIET.IDSPCT,dbo.CHATLIEU.TENCL, dbo.KICHCO.TENKC, dbo.MAUSAC.TENMS, dbo.SANPHAM.TENSP, dbo.SANPHAMCHITIET.SOLUONG, dbo.SANPHAMCHITIET.DONGIA, dbo.THUONGHIEU.TENTH, \n"
                + "                         dbo.SANPHAMCHITIET.TRANGTHAISPCT,dbo.SANPHAMCHITIET.MASPCT\n"
                + "FROM            dbo.CHATLIEU INNER JOIN\n"
                + "                         dbo.SANPHAMCHITIET ON dbo.CHATLIEU.IDCL = dbo.SANPHAMCHITIET.IDCL INNER JOIN\n"
                + "                         dbo.KICHCO ON dbo.SANPHAMCHITIET.IDKC = dbo.KICHCO.IDKC INNER JOIN\n"
                + "                         dbo.MAUSAC ON dbo.SANPHAMCHITIET.IDMS = dbo.MAUSAC.IDMS INNER JOIN\n"
                + "                         dbo.SANPHAM ON dbo.SANPHAMCHITIET.IDSP = dbo.SANPHAM.IDSP INNER JOIN\n"
                + "                         dbo.THUONGHIEU ON dbo.SANPHAMCHITIET.IDTH = dbo.THUONGHIEU.IDTH\n"
                + "						 where dbo.SANPHAMCHITIET.TRANGTHAISPCT = 1";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setIdSP(rs.getString(1));
                spct.setIdCL(rs.getString(2));
                spct.setIdKC(rs.getString(3));
                spct.setIdMS(rs.getString(4));
                spct.setIdSP(rs.getString(5));
                spct.setSoLuong(rs.getInt(6));
                spct.setDonGia(rs.getFloat(7));
                spct.setIdTH(rs.getString(8));
                spct.setTrangThaiSPCT(rs.getBoolean(9));
                spct.setMaSPCT(rs.getString(10));
                listSPCT.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSPCT;
    }

    @Override
    public List<HoaDon> getAllHD() {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "SELECT        dbo.HOADON.IDHD, dbo.HOADON.MAHD, dbo.NHANVIEN.TENNV, dbo.HOADON.NGAYTAO, dbo.HOADON.TRANGTHAIHD\n"
                + "FROM            dbo.HOADON INNER JOIN\n"
                + "                         dbo.NHANVIEN ON dbo.HOADON.IDNV = dbo.NHANVIEN.IDNV\n"
                + "						 where dbo.HOADON.TRANGTHAIHD = 0";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getString(1));
                hd.setMaHD(rs.getString(2));
                hd.setIdNV(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                hd.setTrangThaiHD(rs.getBoolean(5));
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    @Override
    public String insertHD(HoaDon hd) {
        String sql = "INSERT INTO HOADON(MAHD,IDNV,NGAYTAO,TRANGTHAIHD,IDKH) VALUES (?,?,?,?,?)";
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getIdNV());
            ps.setObject(3, hd.getNgayTao());
            ps.setObject(4, hd.isTrangThaiHD());
            ps.setObject(5, hd.getIdKH());
            if (ps.executeUpdate() > 0) {
                return "Thêm hóa đơn thành công";
            }
        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        }

        return "Thêm hóa đơn thất bại";
    }

    @Override
    public String findByIdKH(String idKH) {
         String sql = "select id from KHACHHANG where IDKH = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idKH);
            if (rs.next()) {
                String id = rs.getString("id");
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String findByIdNV(String idNV) {
        String sql = "select id from NHANVIEN where IDNV = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idNV);
            if (rs.next()) {
                String id = rs.getString("id");
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteHD(String maHD) {
         String sql = "update HoaDon where maHD =?";
        DBConnection.ExcuteDungna(sql,maHD);
    }

    @Override
    public List<SanPham> getSanPhamGH(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTiet> getHDCT(String maHDCT) {
        List<HoaDonChiTiet>list = new ArrayList<>();
        String sql = "";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, maHDCT);
            while(rs.next()){
                HoaDonChiTiet hdct = new HoaDonChiTiet();
//                hdct.getMaHDCT(
            }
        } catch (Exception e) {
        }
        return list;
    }
}
