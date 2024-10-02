﻿-- DROP DATABASE DUAN1_NHOM2

CREATE DATABASE DUAN1_NHOM2
GO

USE DUAN1_NHOM2
GO

-- NHAN VIEN
IF OBJECT_ID ('NHANVIEN') IS NOT NULL
DROP TABLE NHANVIEN
GO
CREATE TABLE NHANVIEN(
	   IDNV UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID() NOT NULL,
	   MANV VARCHAR(20) UNIQUE,
	   TENNV NVARCHAR(50),
	   GIOITINH BIT, -- 1.NAM || 2.NU
	   NGAYSINH DATE,
	   CCCD VARCHAR(13) UNIQUE,
	   DIACHI NVARCHAR(MAX),
	   SDT VARCHAR(13) UNIQUE,
	   TRANGTHAINV BIT, -- 1.LAM || 2.NGHI
	   CHUCVU NVARCHAR(20),
	   MATKHAU VARCHAR(20)
);

GO
-- MAU SAC
IF OBJECT_ID ('MAUSAC') IS NOT NULL
DROP TABLE MAUSAC
CREATE TABLE MAUSAC(
	   IDMS UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAMS VARCHAR(20) UNIQUE,
	   TENMS NVARCHAR(50),
	   TRANGTHAIMS BIT -- 1.CON || 0.HET HANG
);

GO
-- CHAT LIEU
IF OBJECT_ID ('CHATLIEU') IS NOT NULL
DROP TABLE CHATLIEU
CREATE TABLE CHATLIEU(
	   IDCL UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MACL VARCHAR(20) UNIQUE,
	   TENCL NVARCHAR(50),
	   TRANGTHAICL BIT 
);

GO
-- THUONG HIEU
IF OBJECT_ID ('THUONGHIEU') IS NOT NULL
DROP TABLE THUONGHIEU
CREATE TABLE THUONGHIEU(
	   IDTH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MATH VARCHAR(20) UNIQUE,
	   TENTH NVARCHAR(50),
	   TRANGTHAITH BIT
);

GO
-- KICH CO
IF OBJECT_ID ('KICHCO') IS NOT NULL
DROP TABLE KICHCO
CREATE TABLE KICHCO(
	   IDKC UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAKC VARCHAR(20) UNIQUE,
	   TENKC NVARCHAR(50),
	   TRANGTHAIKC BIT
);

GO
-- SAN PHAM
IF OBJECT_ID ('SANPHAM') IS NOT NULL
DROP TABLE SANPHAM
CREATE TABLE SANPHAM(
	   IDSP UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MASP VARCHAR(20) UNIQUE,
	   TENSP NVARCHAR(50),
	   TRANGTHAISP BIT
);

GO
-- SAN PHAM CHI TIET
IF OBJECT_ID ('SANPHAMCHITIET') IS NOT NULL
DROP TABLE SANPHAMCHITIET
CREATE TABLE SANPHAMCHITIET(
	   IDSPCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDMS UNIQUEIDENTIFIER,
	   IDCL UNIQUEIDENTIFIER,
	   IDTH UNIQUEIDENTIFIER,
	   IDKC UNIQUEIDENTIFIER,
	   IDSP UNIQUEIDENTIFIER,
	   IDNV UNIQUEIDENTIFIER,
	   MASPCT VARCHAR(20) UNIQUE,
	   SOLUONG INT,
	   MOTA NVARCHAR(MAX),
	   TRANGTHAISPCT BIT,
	   DONGIA FLOAT,

	   FOREIGN KEY (IDMS) REFERENCES MAUSAC(IDMS),
	   FOREIGN KEY (IDCL) REFERENCES CHATLIEU(IDCL),
	   FOREIGN KEY (IDTH) REFERENCES THUONGHIEU(IDTH),
	   FOREIGN KEY (IDKC) REFERENCES KICHCO(IDKC),
	   FOREIGN KEY (IDSP) REFERENCES SANPHAM(IDSP),
	   FOREIGN KEY (IDNV) REFERENCES NHANVIEN(IDNV)
);

GO
-- KHACH HANG
IF OBJECT_ID ('KHACHHANG') IS NOT NULL
DROP TABLE KHACHHANG
CREATE TABLE KHACHHANG(
	   IDKH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAKH VARCHAR(20) UNIQUE,
	   TENKH NVARCHAR(50),
	   NGAYSINH DATE,
	   GIOITINH BIT, -- 1.NAM || 0.NU
	   SDT VARCHAR(13) UNIQUE,
	   EMAIL VARCHAR(50) UNIQUE,
	   DIACHI NVARCHAR(MAX)
);

GO
-- KHUYEN MAI
IF OBJECT_ID ('KHUYENMAI') IS NOT NULL
DROP TABLE KHUYENMAI
CREATE TABLE KHUYENMAI(
	   IDKM UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   MAKM VARCHAR(20) UNIQUE,
	   TENKM NVARCHAR(50),
	   MUCGIAMGIA FLOAT,
	   LOAIDIEUKIEN VARCHAR(50),
	   DIEUKIEN FLOAT,
	   THOIGIANBATDAU DATE,
	   THOIGIANKETTHUC DATE,
	   SOLUONG INT,
	   TRANGTHAIKM BIT
	   -- XEM XÉT ĐIỀU KIỆN BÊN ERD
);

GO
-- KHUYEN MAI CHI TIET
IF OBJECT_ID ('KHUYENMAICHITIET') IS NOT NULL
DROP TABLE KHUYENMAICHITIET
CREATE TABLE KHUYENMAICHITIET(
	   IDKMCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDKM UNIQUEIDENTIFIER,
	   IDSPCT UNIQUEIDENTIFIER,
	   MAKMCT VARCHAR(20) UNIQUE,
	   TRANGTHAIKMCT BIT, -- 1.CON || 2.KET THUC
	   
	   FOREIGN KEY (IDKM) REFERENCES KHUYENMAI(IDKM),
	   FOREIGN KEY (IDSPCT) REFERENCES SANPHAMCHITIET(IDSPCT)
);
GO
-- HOA DON
IF OBJECT_ID ('HOADON') IS NOT NULL
DROP TABLE HOADON
CREATE TABLE HOADON(
	   IDHD UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDKH UNIQUEIDENTIFIER,
	   IDNV UNIQUEIDENTIFIER,
	   IDKM UNIQUEIDENTIFIER,
	   MAHD VARCHAR(20) UNIQUE,
	   NGAYTAO DATE,
	   LYDOHUY NVARCHAR(100),
	   NGAYTHANHTOAN DATE,
	   DONGIA FLOAT,
	   DONGIASAUGIAM FLOAT,
	   TONGTIEN FLOAT,
	   PHUONGTHUCTHANHTOAN BIT, -- 1. TIEN MAT || 2. CHUYEN KHOAN
	   TRANGTHAIHD BIT,

	   FOREIGN KEY (IDKH) REFERENCES KHACHHANG(IDKH),
	   FOREIGN KEY (IDNV) REFERENCES NHANVIEN(IDNV),
	   FOREIGN KEY (IDKM) REFERENCES KHUYENMAI(IDKM)
);
GO
-- HOA DON CHI TIET
IF OBJECT_ID ('HOADONCT') IS NOT NULL
DROP TABLE HOADONCT
CREATE TABLE HOADONCT(
	   IDHDCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	   IDHD UNIQUEIDENTIFIER,
	   IDSPCT UNIQUEIDENTIFIER,
	   MAHDCT VARCHAR(20) UNIQUE,
	   NGAYTAO DATE,
	   SOLUONG INT,
	   DONGIA FLOAT,
	   DONGIASAUKHIGIAM FLOAT,
	   PHUONGTHUCTHANHTOAN BIT, --1. TIEN MAT || 0. CHUYEN KHOAN

	   FOREIGN KEY (IDHD) REFERENCES HOADON(IDHD),
	   FOREIGN KEY (IDSPCT) REFERENCES SANPHAMCHITIET(IDSPCT)
);

GO
-- NHAN VIEN
INSERT INTO NHANVIEN (MANV, TENNV, GIOITINH, NGAYSINH, CCCD, DIACHI, SDT, TRANGTHAINV, CHUCVU, MATKHAU)
VALUES 
('NV001', N'Nguyen Van A', 1, '1990-01-01', '1234567890123', N'123 Đường A, Q1', '0912345678', 1, N'Quan ly', 'password123'),
('NV002', N'Tran Thi B', 0, '1992-02-02', '1234567890124', N'456 Đường B, Q2', '0912345679', 1, N'Nhan vien', 'password456');

-- MAU SAC
INSERT INTO MAUSAC (MAMS, TENMS, TRANGTHAIMS)
VALUES 
('MS001', N'Đỏ', 1),
('MS002', N'Xanh', 1);

-- CHAT LIEU
INSERT INTO CHATLIEU (MACL, TENCL, TRANGTHAICL)
VALUES 
('CL001', 'Cotton', 1),
('CL002', 'Polyester', 1);

-- THUONG HIEU
INSERT INTO THUONGHIEU (MATH, TENTH, TRANGTHAITH)
VALUES 
('TH001', 'Nike', 1),
('TH002', 'Adidas', 1);

-- KICH CO
INSERT INTO KICHCO (MAKC, TENKC, TRANGTHAIKC)
VALUES 
('KC001', 'S', 1),
('KC002', 'M', 1);

-- SAN PHAM
INSERT INTO SANPHAM (MASP, TENSP, TRANGTHAISP)
VALUES 
('SP001', 'Ao thun', 1),
('SP002', 'Quan jeans', 1);

-- SAN PHAM CHI TIET
INSERT INTO SANPHAMCHITIET (IDMS, IDCL, IDTH, IDKC, IDSP, IDNV, MASPCT, SOLUONG, MOTA, TRANGTHAISPCT, DONGIA)
VALUES 
((SELECT IDMS FROM MAUSAC WHERE MAMS = 'MS001'), (SELECT IDCL FROM CHATLIEU WHERE MACL = 'CL001'), 
(SELECT IDTH FROM THUONGHIEU WHERE MATH = 'TH001'), (SELECT IDKC FROM KICHCO WHERE MAKC = 'KC001'), 
(SELECT IDSP FROM SANPHAM WHERE MASP = 'SP001'), (SELECT IDNV FROM NHANVIEN WHERE MANV = 'NV001'), 
'SPCT001', 100, 'Mô tả sản phẩm 1', 1, 200000),

((SELECT IDMS FROM MAUSAC WHERE MAMS = 'MS002'), (SELECT IDCL FROM CHATLIEU WHERE MACL = 'CL002'), 
(SELECT IDTH FROM THUONGHIEU WHERE MATH = 'TH002'), (SELECT IDKC FROM KICHCO WHERE MAKC = 'KC002'), 
(SELECT IDSP FROM SANPHAM WHERE MASP = 'SP002'), (SELECT IDNV FROM NHANVIEN WHERE MANV = 'NV002'), 
'SPCT002', 150, 'Mô tả sản phẩm 2', 1, 300000);

-- KHACH HANG
INSERT INTO KHACHHANG (MAKH, TENKH, NGAYSINH, GIOITINH, SDT, EMAIL, DIACHI)
VALUES 
('KH001', N'Nguyen Minh C', '1985-05-05', 1, '0912345680', 'c@gmail.com', N'789 Đường C, Q3'),
('KH002', N'Le Thi D', '1990-03-03', 0, '0912345681', 'd@gmail.com', N'101 Đường D, Q4');

-- KHUYEN MAI
INSERT INTO KHUYENMAI (MAKM, TENKM, MUCGIAMGIA, LOAIDIEUKIEN, DIEUKIEN, THOIGIANBATDAU, THOIGIANKETTHUC, SOLUONG, TRANGTHAIKM)
VALUES 
('KM001', 'Khuyen mai A', 10, 'Tổng hóa đơn', 500000, '2024-09-01', '2024-09-30', 100, 1),
('KM002', 'Khuyen mai B', 15, 'Tổng hoá đơn', 10, '2024-10-01', '2024-10-31', 50, 1);

-- KHUYEN MAI CHI TIET
INSERT INTO KHUYENMAICHITIET (IDKM, IDSPCT, MAKMCT, TRANGTHAIKMCT)
VALUES 
((SELECT IDKM FROM KHUYENMAI WHERE MAKM = 'KM001'), (SELECT IDSPCT FROM SANPHAMCHITIET WHERE MASPCT = 'SPCT001'), 'KMCT001', 1),
((SELECT IDKM FROM KHUYENMAI WHERE MAKM = 'KM002'), (SELECT IDSPCT FROM SANPHAMCHITIET WHERE MASPCT = 'SPCT002'), 'KMCT002', 1);

-- HOA DON
INSERT INTO HOADON (IDKH, IDNV, IDKM, MAHD, NGAYTAO, LYDOHUY, NGAYTHANHTOAN, DONGIA, DONGIASAUGIAM, TONGTIEN, PHUONGTHUCTHANHTOAN, TRANGTHAIHD)
VALUES 
((SELECT IDKH FROM KHACHHANG WHERE MAKH = 'KH001'), (SELECT IDNV FROM NHANVIEN WHERE MANV = 'NV001'), 
(SELECT IDKM FROM KHUYENMAI WHERE MAKM = 'KM001'), 'HD001', '2024-09-25', NULL, '2024-09-26', 2000000, 1800000, 1800000, 1, 1),

((SELECT IDKH FROM KHACHHANG WHERE MAKH = 'KH002'), (SELECT IDNV FROM NHANVIEN WHERE MANV = 'NV002'), 
(SELECT IDKM FROM KHUYENMAI WHERE MAKM = 'KM002'), 'HD002', '2024-09-26', NULL, '2024-09-27', 1500000, 1350000, 1350000, 2, 1);

-- HOA DON CHI TIET
INSERT INTO HOADONCT (IDHD, IDSPCT, MAHDCT, NGAYTAO, SOLUONG, DONGIA, DONGIASAUKHIGIAM, PHUONGTHUCTHANHTOAN)
VALUES 
((SELECT IDHD FROM HOADON WHERE MAHD = 'HD001'), (SELECT IDSPCT FROM SANPHAMCHITIET WHERE MASPCT = 'SPCT001'), 
'HDCT001', '2024-09-25', 2, 1000000, 900000, 1),

((SELECT IDHD FROM HOADON WHERE MAHD = 'HD002'), (SELECT IDSPCT FROM SANPHAMCHITIET WHERE MASPCT = 'SPCT002'), 
'HDCT002', '2024-09-26', 1, 1500000, 1350000, 2);



SELECT * FROM NHANVIEN
SELECT * FROM MAUSAC
SELECT * FROM CHATLIEU
SELECT * FROM THUONGHIEU
SELECT * FROM SANPHAM
SELECT * FROM SANPHAMCHITIET
SELECT * FROM KHACHHANG
SELECT * FROM KHUYENMAI
SELECT * FROM KHUYENMAICHITIET
SELECT * FROM HOADON
SELECT * FROM HOADONCT
