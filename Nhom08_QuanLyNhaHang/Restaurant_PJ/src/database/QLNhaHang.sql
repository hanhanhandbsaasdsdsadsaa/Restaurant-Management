use master
create database DB_QLNhaHang on primary(
	name = NhaHang_PRIMARY,
	filename = 'E:\Nam_3\HK2\Cong_Nghe_Java\DoAn_Java\DB_QuanLyNhaHang\NhaHang_PRIMARY.MDF',
	size = 5mb,
	maxsize = 10mb,
	Filegrowth = 10%
),
(
	name= NhaHang_SECOND1,
	filename = 'E:\Nam_3\HK2\Cong_Nghe_Java\DoAn_Java\DB_QuanLyNhaHang\NhaHang_SECOND1.NDF',
	size =3mb,
	maxsize = 5mb,
	Filegrowth = 10%
),
(
	name= NhaHang_SECOND2,
	filename = 'E:\Nam_3\HK2\Cong_Nghe_Java\DoAn_Java\DB_QuanLyNhaHang\NhaHang_SECOND2.NDF',
	size =3mb,
	maxsize = 5mb,
	Filegrowth = 10%
)
LOG ON (
	name = NhaHang_LOG,
	filename = 'E:\Nam_3\HK2\Cong_Nghe_Java\DoAn_Java\DB_QuanLyNhaHang\NhaHang_LOG.ldf',
	size = 2mb,
	maxsize = 5mb,
	Filegrowth = 15%
)
GO
use DB_QLNhaHang
GO
-------------------------------------Tạo bảng----------------------------------------
----Tao bang NGUOIDUNG
create table NGUOIDUNG(
	ID_ND varchar(10),
	EMAIL varchar(50) NOT NULL,
	MATKHAU varchar(20) NOT NULL,
	VERIFYCODE varchar(10) DEFAULT NULL,
	TRANGTHAI nvarchar(10) DEFAULT '',
	VAITRO nvarchar(20)
	constraint PK_NGUOIDUNG primary key(ID_ND)
)
GO
---Them rang buoc NGUOIDUNG
alter table NGUOIDUNG
add constraint chk_NGUOIDUNG_VAITRO check (VAITRO in ('Khach Hang','Nhan Vien','Nhan Vien Kho','Quan Ly'))

----Tao bang NHANVIEN
create table NHANVIEN(
	ID_NV varchar(10),
	TENNV nvarchar(50) NOT NULL,
	NGAYVAOLAM date NOT NULL,
	SDT varchar(10) NOT NULL,
	CHUCVU nvarchar(50),
	ID_ND varchar(10) DEFAULT NULL,
	ID_NQL varchar(10),
	TINHTRANG nvarchar(50)
	constraint PK_NHANVIEN primary key(ID_NV)
)
GO
---Them rang buoc NHANVIEN
alter table NHANVIEN
add constraint chk_NHANVIEN_CHUCVU check (CHUCVU IN ('Phuc vu','Tiep tan','Thu ngan','Bep','Kho','Quan ly'))
alter table NHANVIEN
add constraint chk_NHANVIEN_TINHTRANG check (TINHTRANG IN ('Dang lam viec','Da nghi viec'));
GO
----Tao bang KHACHHANG
create table KHACHHANG(
	ID_KH varchar(10),
	TENKH nvarchar(50) NOT NULL,
	NGAYTHAMGIA date NOT NULL,
	DOANHSO float DEFAULT 0,
	DIEMTICHLUY int DEFAULT 0,
	ID_ND varchar(10) NOT NULL,
	constraint PK_KHACHHANG primary key(ID_KH)
)
GO
----Tao bang MONAN
create table MONAN(
	ID_MONAN varchar(10),
	TENMON nvarchar(50) NOT NULL,
	DONGIA float NOT NULL,
	LOAI nvarchar(50),
	TRANGTHAI nvarchar(30),
	constraint PK_MONAN primary key(ID_MONAN)
)
GO
---Them rang buoc MONAN
alter table MONAN
add constraint chk_MONAN_LOAI check (LOAI in ('Aries','Taurus','Gemini','Cancer','Leo','Virgo'
                                          ,'Libra','Scorpio','Sagittarius','Capricorn','Aquarius','Pisces'))
alter table MONAN
add constraint chk_MONAN_TRANGTHAI check (TRANGTHAI in('Dang kinh doanh','Ngung kinh doanh'))   
GO
----Tao bang BAN
create table BAN(
	ID_BAN varchar(10),
	TENBAN nvarchar(50) NOT NULL,
	VITRI nvarchar(50) NOT NULL,
	TRANGTHAI nvarchar(50),
	constraint PK_BAN primary key(ID_BAN)
)
GO
---Them rang buoc BAN
alter table BAN
add constraint chk_BAN_TRANGTHAI check (TRANGTHAI in ('Con trong','Dang dung bua','Da dat truoc'));
GO
----Tao bang VOUCHER
create table VOUCHER(
	CODE_VOUCHER varchar(10),
	MOTA nvarchar(50) NOT NULL,
	PHANTRAM int,
	LOAIMA nvarchar(50),
	SOLUONG int,
	DIEM float,
	constraint PK_VOUCHER primary key(CODE_VOUCHER)
)
GO
---Them rang buoc VOUCHER
alter table VOUCHER
add constraint chk_VOUCHER_Phantram check (PHANTRAM > 0 AND Phantram <= 100)
alter table VOUCHER
add constraint chk_VOUCHER_LoaiMA check (LOAIMA in ('All','Aries','Taurus','Gemini','Cancer','Leo','Virgo'
                                                 ,'Libra','Scorpio','Sagittarius','Capricorn','Aquarius','Pisces'))
GO
----Tao bang HOADON
create table HOADON(
	ID_HOADON varchar(10),
	ID_KH varchar(10),	
	ID_BAN varchar(10),	
	NGAYHD date NOT NULL,
	TIENMONAN float ,
	CODE_VOUCHER varchar(10),
	TIENGIAM float,
	TONGTIEN float,
	TRANGTHAI nvarchar(50),
	constraint PK_HOADON primary key(ID_HOADON)
)
GO
---Them rang buoc HOADON
alter table HOADON
	add constraint chk_HOADON_TRANGTHAI check (TRANGTHAI in ('Chua thanh toan','Da thanh toan'));
ALTER TABLE HOADON
	ADD CONSTRAINT df_TIENMONAN DEFAULT 0 FOR TIENMONAN;
GO
----Tao bang CTHD
create table CTHD(
	ID_HOADON varchar(10),
	ID_MONAN varchar(10),
	SOLUONG int NOT NULL,
	THANHTIEN float,
	constraint PK_CTHD primary key(ID_HOADON, ID_MONAN)
)
GO
----Tao bang NGUYENLIEU
create table NGUYENLIEU(
	ID_NL varchar(10),
	TENNL nvarchar(50) NOT NULL,
	DONGIA float NOT NULL, 
	DONVITINH nvarchar(20),
	constraint PK_NGUYENLIEU primary key(ID_NL)
)
GO
---Them rang buoc NGUYENLIEU
alter table NGUYENLIEU
    add constraint chk_NGUYENLIEU_DONVITINH check (DONVITINH in ('g','kg','ml','l'));
GO
----Tao bang KHO
create table KHO(
	ID_NL varchar(10),
	SLTON int DEFAULT 0,
	constraint PK_KHO primary key(ID_NL)
)
GO
----Tao bang PHIEUNK
create table PHIEUNK(
	ID_NK varchar(10),
	ID_NV varchar(10),
	NGAYNK date NOT NULL,
	TONGTIEN float DEFAULT 0,
	constraint PK_PHIEUNK primary key(ID_NK)
)
GO
----Tao bang PHIEUNK
create table CTNK(
	ID_NK varchar(10),
	ID_NL varchar(10),
	SOLUONG int NOT NULL,
	THANHTIEN float,
	constraint PK_CTNK primary key(ID_NK,ID_NL)
)
GO
----Tao bang PHIEUXK
create table PHIEUXK(
	ID_XK varchar(10),
	ID_NV varchar(10),
	NGAYXK date NOT NULL,
	constraint PK_PHIEUXK primary key(ID_XK)
)
GO
----Tao bang CTXK
create table CTXK(
	ID_XK varchar(10),
	ID_NL varchar(10),
	SOLUONG int NOT NULL,
	constraint PK_CTXK primary key(ID_XK,ID_NL)
)
GO


------------------------------------Khóa Ngoại-------------------------------------
------------Khoa ngoai NHANVIEN
alter table NHANVIEN
add constraint FK_NHANVIEN_NGUOIDUNG foreign key(ID_ND) references NGUOIDUNG(ID_ND)-------1

alter table NHANVIEN
add constraint FK_NHANVIEN_NHANVIEN foreign key(ID_NQL) references NHANVIEN(ID_NV)

------------Khoa ngoai KHACHHANG
alter table KHACHHANG
add constraint FK_KHACHHANG_NGUOIDUNG foreign key(ID_ND) references NGUOIDUNG(ID_ND)

------------Khoa ngoai HOADON
alter table HOADON
add constraint FK_HOADON_KHACHHANG foreign key(ID_KH) references KHACHHANG(ID_KH)

alter table HOADON
add constraint FK_HOADON_BAN foreign key(ID_BAN) references BAN(ID_BAN)

alter table HOADON
add constraint FK_HOADON_VOUCHER foreign key(CODE_VOUCHER) references VOUCHER(CODE_VOUCHER)

------------Khoa ngoai CTHD
alter table CTHD
add constraint FK_CTHD_HOADON foreign key(ID_HOADON) references HOADON(ID_HOADON)

alter table CTHD
add constraint FK_CTHD_MONAN foreign key(ID_MONAN) references MONAN(ID_MONAN)

------------Khoa ngoai KHO
alter table KHO
add constraint FK_KHO_NGUYENLIEU foreign key(ID_NL) references NGUYENLIEU(ID_NL)

------------Khoa ngoai PHIEUNK
alter table PHIEUNK
add constraint FK_PHIEUNK_NHANVIEN foreign key(ID_NV) references NHANVIEN(ID_NV)

------------Khoa ngoai CTNK
alter table CTNK
add constraint FK_CTNK_PHIEUNK foreign key(ID_NK) references PHIEUNK(ID_NK)

alter table CTNK
add constraint FK_CTNK_NGUYENLIEU foreign key(ID_NL) references NGUYENLIEU(ID_NL)

------------Khoa ngoai PHIEUXK
alter table PHIEUXK
add constraint FK_PHIEUXK_NHANVIEN foreign key(ID_NV) references NHANVIEN(ID_NV)

------------Khoa ngoai CTXK
alter table CTXK
add constraint FK_CTXK_PHIEUXK foreign key(ID_XK) references PHIEUXK(ID_XK)

alter table CTXK
add constraint FK_CTXK_NGUYENLIEU foreign key(ID_NL) references NGUYENLIEU(ID_NL)
GO



------------------------------Nhập liệu-----------------------------
-- Dữ liệu cho bảng NGUOIDUNG
-------Tai khoan Nguoi Dung Cua Nhan Vien
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (100,'NVHoangViet@gmail.com','123','Verified','Quan Ly')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (101,'NVHoangPhuc@gmail.com','123','Verified','Nhan Vien')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (102,'NVAnhHong@gmail.com','123','Verified','Nhan Vien Kho')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (103,'NVQuangDinh@gmail.com','123','Verified','Nhan Vien')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (114,'NDH@gmail.com','123','Verified','Quan Ly')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (115,'HQK@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (116,'PTH@gmail.com','123','Verified','Nhan Vien')
-------Tai khoan Nguoi Dung Cua Khach Hang
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (104,'KHThaoDuong@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (105,'KHTanHieu@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (106,'KHQuocThinh@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (107,'KHNhuMai@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (108,'KHBichHao@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (109,'KHMaiQuynh@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (110,'KHMinhQuang@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (111,'KHThanhHang@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (112,'KHThanhNhan@gmail.com','123','Verified','Khach Hang')
INSERT INTO NGUOIDUNG(ID_ND,Email,MatKhau,Trangthai,Vaitro) VALUES (113,'KHPhucNguyen@gmail.com','123','Verified','Khach Hang')





--select ID_NV, TENNV, NGAYVAOLAM, TINHTRANG, EMAIL, MATKHAU, VAITRO from NGUOIDUNG nd, NHANVIEN nv where nd.ID_ND = 114 and nd.ID_ND = nv.ID_ND
--select EMAIL, MATKHAU, VAITRO from NGUOIDUNG where EMAIL = 'ndh@gmail.com'

-- Dữ liệu cho bảng NHANVIEN
set dateformat DMY
--Co tai khoan
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (100,'Nguyen Hoang Viet','10/05/2023','0848044725','Quan ly',100,100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (101,'Nguyen Hoang Phuc','20/05/2023','0838033334','Tiep tan',101,100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (102,'Le Thi Anh Hong','19/05/2023','0838033234','Kho',102,100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (103,'Ho Quang Dinh','19/05/2023','0838033234','Tiep tan',103,100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (110,'Pham Tuan Han','19/05/2023','0838033234','Tiep tan',116,100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (111,'Nguyen Duc Hien','26/05/2024','0333172760','Quan ly',114,100,'Dang lam viec')
--Khong co tai khoan
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_NQL,Tinhtrang) VALUES (104,'Ha Thao Duong','10/05/2023','0838033232','Phuc vu',100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_NQL,Tinhtrang) VALUES (105,'Nguyen Quoc Thinh','11/05/2023','0838033734','Phuc vu',100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_NQL,Tinhtrang) VALUES (106,'Truong Tan Hieu','12/05/2023','0838033834','Phuc vu',100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_NQL,Tinhtrang) VALUES (107,'Nguyen Thai Bao','10/05/2023','0838093234','Phuc vu',100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_NQL,Tinhtrang) VALUES (108,'Tran Nhat Khang','11/05/2023','0838133234','Thu ngan',100,'Dang lam viec')
INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_NQL,Tinhtrang) VALUES (109,'Nguyen Ngoc Luong','12/05/2023','0834033234','Bep',100,'Dang lam viec')

-- Dữ liệu cho bảng KHACHHANG
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (100,'Ha Thao Duong','10/05/2023',104)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (101,'Truong Tan Hieu','10/05/2023',105)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (102,'Nguyen Quoc Thinh','10/05/2023',106)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (103,'Tran Nhu Mai','10/05/2023',107)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (104,'Nguyen Thi Bich Hao','10/05/2023',108)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (105,'Nguyen Mai Quynh','11/05/2023',109)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (106,'Hoang Minh Quang','11/05/2023',110)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (107,'Nguyen Thanh Hang','12/05/2023',111)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (108,'Nguyen Ngoc Thanh Nhan','11/05/2023',112)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (109,'Hoang Thi Phuc Nguyen','12/05/2023',113)
INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (110,'Huynh Quang Khiem','09/02/2003',115)

-- Dữ liệu cho bảng MONAN
--Aries
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(1,'DUI CUU NUONG XE NHO', 250000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(2,'BE SUON CUU NUONG GIAY BAC MONG CO', 230000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(3,'DUI CUU NUONG TRUNG DONG', 350000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(4,'CUU XOC LA CA RI', 129000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(5,'CUU KUNGBAO', 250000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(6,'BAP CUU NUONG CAY', 250000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(7,'CUU VIEN HAM CAY', 19000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(8,'SUON CONG NUONG MONG CO', 250000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(9,'DUI CUU LON NUONG TAI BAN', 750000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(10,'SUONG CUU NUONG SOT NAM', 450000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(11,'DUI CUU NUONG TIEU XANH', 285000,'Aries','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(12,'SUON CUU SOT PHO MAI', 450000,'Aries','Dang kinh doanh');

--Taurus
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(13,'Bit tet bo My khoai tay', 179000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(14,'Bo bit tet Uc',169000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(15,'Bit tet bo My BASIC', 179000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(16,'My Y bo bam', 169000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(17,'Thit suon Wagyu', 1180000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(18,'Steak Thit Vai Wagyu', 1290000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(19,'Steak Thit Bung Bo', 550000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(20,'Tomahawk', 2390000,'Taurus','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(21,'Salad Romaine Nuong', 180000,'Taurus','Dang kinh doanh');

--Gemini
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(22,'Combo Happy', 180000,'Gemini','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(23,'Combo Fantastic', 190000,'Gemini','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(24,'Combo Dreamer', 230000,'Gemini','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(25,'Combo Cupid', 180000,'Gemini','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(26,'Combo Poseidon', 190000,'Gemini','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(27,'Combo LUANG PRABANG', 490000,'Gemini','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(28,'Combo VIENTIANE', 620000,'Gemini','Dang kinh doanh');

--Cancer
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(29,'Cua KingCrab Duc sot', 3650000,'Cancer','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(30,'Mai Cua KingCrab Topping Pho Mai', 2650000,'Cancer','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(31,'Cua KingCrab sot Tu Xuyen', 2300000,'Cancer','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(32,'Cua KingCrab Nuong Tu Nhien', 2550000,'Cancer','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(33,'Cua KingCrab Nuong Bo Toi', 2650000,'Cancer','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(34,'Com Mai Cua KingCrab Chien', 1850000,'Cancer','Dang kinh doanh');

--Leo
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(35,'BOSSAM', 650000,'Leo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(36,'KIMCHI PANCAKE', 350000,'Leo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(37,'SPICY RICE CAKE', 250000,'Leo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(38,'SPICY SAUSAGE HOTPOT', 650000,'Leo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(39,'SPICY PORK', 350000,'Leo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(40,'MUSHROOM SPICY SILKY TOFU STEW', 350000,'Leo','Dang kinh doanh');
--Virgo
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(41,'Pavlova', 150000,'Virgo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(42,'Kesutera', 120000,'Virgo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(43,'Cremeschnitte', 250000,'Virgo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(44,'Sachertorte', 150000,'Virgo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(45,'Schwarzwalder Kirschtorte', 250000,'Virgo','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(46,'New York-Style Cheesecake', 250000,'Virgo','Dang kinh doanh');

--Libra
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(47,'Cobb Salad', 150000,'Libra','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(48,'Salad Israeli', 120000,'Libra','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(49,'Salad Dau den', 120000,'Libra','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(50,'Waldorf Salad', 160000,'Libra','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(51,'Salad Gado-Gado', 200000,'Libra','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(52,'Nicoise Salad', 250000,'Libra','Dang kinh doanh');

--Scorpio
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(53,'BULGOGI LUNCHBOX', 250000,'Scorpio','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(54,'CHICKEN TERIYAKI LUNCHBOX', 350000,'Scorpio','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(55,'SPICY PORK LUNCHBOX', 350000,'Scorpio','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(56,'TOFU TERIYAKI LUNCHBOX', 250000,'Scorpio','Dang kinh doanh');

--Sagittarius
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(57,'Thit ngua do tuoi', 250000,'Sagittarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(58,'Steak Thit ngua', 350000,'Sagittarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(59,'Thit ngua ban gang', 350000,'Sagittarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(60,'Long ngua xao dua', 150000,'Sagittarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(61,'Thit ngua xao sa ot', 250000,'Sagittarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(62,'Ngua tang', 350000,'Sagittarius','Dang kinh doanh');

--Capricorn
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(63,'Thit de xong hoi', 229000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(64,'Thit de xao rau ngo', 199000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(65,'Thit de nuong tang', 229000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(66,'Thit de chao', 199000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(67,'Thit de nuong xien', 199000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(68,'Nam de nuong/chao', 199000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(69,'Thit de xao lan', 19000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(70,'Dui de tan thuoc bac', 199000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(71,'Canh de ham duong quy', 199000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(72,'Chao de dau xanh', 50000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(73,'Thit de nhung me', 229000,'Capricorn','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(74,'Lau de nhu', 499000,'Capricorn','Dang kinh doanh');


--Aquarius
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(75,'SIGNATURE WINE', 3290000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(76,'CHILEAN WINE', 3990000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(77,'ARGENTINA WINE', 2890000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(78,'ITALIAN WINE', 5590000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(79,'AMERICAN WINE', 4990000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(80,'CLASSIC COCKTAIL', 200000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(81,'SIGNATURE COCKTAIL', 250000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(82,'MOCKTAIL', 160000,'Aquarius','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(83,'JAPANESE SAKE', 1490000,'Aquarius','Dang kinh doanh');

--Pisces
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(84,'Ca Hoi Ngam Tuong', 289000,'Pisces','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(85,'Ca Ngu Ngam Tuong', 289000,'Pisces','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(86,'IKURA:Trung ca hoi', 189000,'Pisces','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(87,'KARIN:Sashimi Ca Ngu', 149000,'Pisces','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(88,'KEIKO:Sashimi Ca Hoi', 199000,'Pisces','Dang kinh doanh');
insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(89,'CHIYO:Sashimi Bung Ca Hoi', 219000,'Pisces','Dang kinh doanh');

-- Dữ liệu cho bảng BAN
--Tang 1
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(100,'Ban T1.1','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(101,'Ban T1.2','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(102,'Ban T1.3','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(103,'Ban T1.4','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(104,'Ban T1.5','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(105,'Ban T1.6','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(106,'Ban T1.7','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(107,'Ban T1.8','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(108,'Ban T1.9','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(109,'Ban T1.10','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(110,'Ban T1.11','Tang 1','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(111,'Ban T1.12','Tang 1','Con trong');
--Tang 2
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(112,'Ban T2.1','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(113,'Ban T2.2','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(114,'Ban T2.3','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(115,'Ban T2.4','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(116,'Ban T2.5','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(117,'Ban T2.6','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(118,'Ban T2.7','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(119,'Ban T2.8','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(120,'Ban T2.9','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(121,'Ban T2.10','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(122,'Ban T2.11','Tang 2','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(123,'Ban T2.12','Tang 2','Con trong');
--Tang 3
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(124,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(125,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(126,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(127,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(128,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(129,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(130,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(131,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(132,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(133,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(134,'Ban T3.1','Tang 3','Con trong');
insert into Ban(ID_Ban,TenBan,Vitri,Trangthai) values(135,'Ban T3.1','Tang 3','Con trong');

-- Dữ liệu cho bảng VOUCHER
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('loQy','20% off for Aries Menu',20,'Aries',10,200);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('pCfI','30% off for Taurus Menu',30,'Taurus',5,300);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('pApo','20% off for Gemini Menu',20,'Gemini',10,200);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('ugQx','100% off for Virgo Menu',100,'Virgo',3,500);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('nxVX','20% off for All Menu',20,'All',5,300);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('Pwyn','20% off for Cancer Menu',20,'Cancer',10,200);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('bjff','50% off for Leo Menu',50,'Leo',5,600);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('YPzJ','20% off for Aquarius Menu',20,'Aquarius',5,200);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('Y5g0','30% off for Pisces Menu',30,'Pisces',5,300);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('7hVO','60% off for Aries Menu',60,'Aries',0,1000);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('WHLm','20% off for Capricorn Menu',20,'Capricorn',0,200);
insert into Voucher(Code_Voucher,MOTA,Phantram,LoaiMA,SoLuong,Diem) values ('GTsC','20% off for Leo Menu',20,'Leo',0,200);

-- Dữ liệu cho bảng HOADON
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (101,100,100,'10-1-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (102,104,102,'15-1-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (103,105,103,'20-1-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (104,101,101,'13-2-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (105,103,120,'12-2-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (106,104,100,'16-3-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (107,107,103,'20-3-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (108,108,101,'10-4-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (109,100,100,'20-4-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (110,103,101,'5-5-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (111,106,102,'10-5-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (112,108,103,'15-5-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (113,106,102,'20-5-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (114,108,103,'5-6-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (115,109,104,'7-6-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (116,100,105,'7-6-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (117,106,106,'10-6-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (118,102,106,'10-2-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (119,103,106,'12-2-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (120,104,106,'10-4-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (121,105,106,'12-4-2023',0,0,'Chua thanh toan');
INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) VALUES (122,107,106,'12-5-2023',0,0,'Chua thanh toan');

-- Dữ liệu cho bảng CTHD
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (101,1,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (101,3,1);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (101,10,3);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (102,1,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (102,2,1);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (102,4,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (103,12,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (104,30,3);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (104,59,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (105,28,1);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (105,88,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (106,70,3);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (106,75,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (106,78,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (107,32,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (107,12,5);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (108,12,1);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (108,40,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (109,45,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (110,34,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (110,43,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (111,65,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (111,47,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (112,49,3);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (112,80,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (112,31,5);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (113,80,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (113,80,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (114,30,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (114,32,3);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (115,80,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (116,57,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (116,34,1);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (117,67,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (117,66,3);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (118,34,10);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (118,35,5);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (119,83,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (119,78,2);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (120,38,5);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (120,39,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (121,53,5);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (121,31,4);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (122,33,5);
INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (122,34,6);

-- Dữ liệu cho bảng NGUYENLIEU
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(100,'Thit ga',40000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(101,'Thit heo',50000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(102,'Thit bo',80000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(103,'Tom',100000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(104,'Ca hoi',500000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(105,'Gao',40000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(106,'Sua tuoi',40000,'l');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(107,'Bot mi',20000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(108,'Dau ca hoi',1000000,'l');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(109,'Dau dau nanh',150000,'l');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(110,'Muoi',20000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(111,'Duong',20000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(112,'Hanh tay',50000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(113,'Toi',30000,'kg');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(114,'Dam',50000,'l');
INSERT INTO NguyenLieu(ID_NL,TenNL,Dongia,Donvitinh) VALUES(115,'Thit de',130000,'kg');

--Them data cho PhieuNK
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (100,102,'10-01-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (101,102,'11-02-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (102,102,'12-02-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (103,102,'12-03-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (104,102,'15-03-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (105,102,'12-04-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (106,102,'15-04-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (107,102,'12-05-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (108,102,'15-05-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (109,102,'5-06-2023');
INSERT INTO PhieuNK(ID_NK,ID_NV,NgayNK) VALUES (110,102,'7-06-2023');


--Them data cho CTNK
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (100,100,10);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (100,101,20);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (100,102,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,101,10);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,103,20);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,104,10);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,105,10);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,106,20);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,107,5);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (101,108,5);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (102,109,10);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (102,110,20);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (102,112,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (102,113,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (102,114,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (103,112,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (103,113,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (103,114,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (104,112,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (104,113,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (105,110,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (106,102,25);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (106,115,25);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (107,110,35);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (107,105,25);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (108,104,25);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (108,103,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (108,106,30);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (109,112,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (109,113,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (109,114,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (110,102,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (110,106,25);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (110,107,15);
INSERT INTO CTNK(ID_NK,ID_NL,SoLuong) VALUES (110,110,20);
 

--Them data cho PhieuXK
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (100,102,'10-01-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (101,102,'11-02-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (102,102,'12-03-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (103,102,'13-03-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (104,102,'12-04-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (105,102,'13-04-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (106,102,'12-05-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (107,102,'15-05-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (108,102,'20-05-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (109,102,'5-06-2023');
INSERT INTO PhieuXK(ID_XK,ID_NV,NgayXK) VALUES (110,102,'10-06-2023');


--Them data cho CTXK
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (100,100,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (100,101,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (100,102,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (101,101,7);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (101,103,10);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (101,104,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (101,105,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (101,106,10);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (102,109,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (102,110,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (102,112,10);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (102,113,8);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (102,114,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (103,114,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (103,104,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (104,101,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (104,112,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (105,113,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (105,102,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (106,103,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (106,114,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (107,105,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (107,106,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (108,115,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (108,110,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (109,110,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (109,112,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (110,113,5);
INSERT INTO CTXK(ID_XK,ID_NL,SoLuong) VALUES (110,114,5);

---TRIGGER
GO
--  Trigger Thanh tien o CTHD bang SoLuong x Dongia cua mon an do
CREATE OR ALTER TRIGGER Tg_CTHD_Thanhtien
ON CTHD
AFTER INSERT, UPDATE
AS
BEGIN
    DECLARE @gia DECIMAL;
    
    SELECT @gia = m.DonGia
    FROM MonAn m
    WHERE m.ID_MonAn = (SELECT ID_MonAn FROM inserted);
    
    UPDATE CTHD
    SET ThanhTien = i.SoLuong * @gia
    FROM CTHD
    INNER JOIN inserted i ON CTHD.ID_MONAN = i.ID_MONAN;
END;
GO
--Trigger Tinh Tien mon an o Hoa Don bang tong thanh tien o CTHD
CREATE OR ALTER TRIGGER Tg_HD_TienMonAn
ON CTHD
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
	IF(EXISTS(SELECT 1 FROM inserted))
	BEGIN
		DECLARE @ThanhTien DECIMAL
		SELECT @ThanhTien = SUM(ThanhTien) 
		FROM CTHD 
		WHERE CTHD.ID_HOADON IN (SELECT MAX(ID_HOADON) FROM inserted)
		 
		PRINT @ThanhTien

		UPDATE HoaDon
		SET TienMonAn = @ThanhTien
		WHERE HoaDon.ID_HOADON IN (SELECT MAX(ID_HOADON) FROM inserted)
	END

	IF(EXISTS(SELECT 1 FROM deleted))
	BEGIN
		DECLARE @ThanhTien2 DECIMAL
		SELECT @ThanhTien2 = SUM(ThanhTien) 
		FROM CTHD 
		WHERE CTHD.ID_HOADON IN (SELECT MAX(ID_HOADON) FROM deleted)

		IF(@ThanhTien2 IS NOT NULL)
		BEGIN
			UPDATE HoaDon
			SET TienMonAn = @ThanhTien2
			WHERE HoaDon.ID_HOADON IN (SELECT MAX(ID_HOADON) FROM deleted)
		END
		ELSE
		BEGIN
			UPDATE HoaDon
			SET TienMonAn = 0
			WHERE HoaDon.ID_HOADON IN (SELECT MAX(ID_HOADON) FROM deleted)
		END
	END
END;
GO

--Fuction Tinh tien mon an duoc giam khi them mot CTHD moi
CREATE OR ALTER FUNCTION CTHD_Tinhtiengiam (@Code NVARCHAR(50), @Id_HoaDon NVARCHAR(10), @v_loaiMA NVARCHAR(50))
RETURNS DECIMAL
AS 
BEGIN
    DECLARE @Tiengiam DECIMAL;
    DECLARE @v_Phantram DECIMAL;
    DECLARE @TongTien DECIMAL;
    
    SELECT @v_Phantram = Phantram
						 FROM Voucher
						 WHERE Code_Voucher = @Code;

	SELECT @TongTien = SUM(THANHTIEN)
					   FROM CTHD, MONAN
					   WHERE CTHD.ID_MONAN = MONAN.ID_MONAN
							 AND ID_HOADON = @Id_HoaDon
							 AND LOAI = @v_loaiMA

    SET @Tiengiam = ROUND(@TongTien * @v_Phantram / 100, 0);
	RETURN @Tiengiam
END;
GO

--Trigger Tien giam o Hoa Don = tong thanh tien cua mon An duoc giam  x Phantram
CREATE OR ALTER TRIGGER Tg_HD_TienGiam
ON CTHD
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    DECLARE @v_code NVARCHAR(50);
    DECLARE @v_loaiMA NVARCHAR(50);
    DECLARE @MA_Loai NVARCHAR(50);
    DECLARE @Id_HoaDon NVARCHAR(50);
    SET @v_code = NULL;

    IF (EXISTS(SELECT 1 FROM inserted))
    BEGIN
        SELECT @v_code = HoaDon.CODE_VOUCHER, @v_loaiMA = Voucher.LoaiMA, @Id_HoaDon = HOADON.ID_HOADON
        FROM HoaDon
        INNER JOIN Voucher ON Voucher.Code_Voucher = HoaDon.Code_Voucher
		WHERE ID_HOADON IN (SELECT MAX(ID_HOADON) FROM inserted)

        SELECT @MA_Loai = Loai
        FROM MonAn 
        WHERE ID_MonAn IN (SELECT ID_MonAn FROM inserted);
    END

    IF (EXISTS(SELECT 1 FROM deleted))
    BEGIN
        SELECT @v_code = HoaDon.Code_Voucher, @v_loaiMA = Voucher.LoaiMA, @Id_HoaDon = HOADON.ID_HOADON
        FROM HoaDon
        INNER JOIN Voucher ON Voucher.Code_Voucher = HoaDon.Code_Voucher
        WHERE ID_HOADON IN (SELECT MAX(ID_HOADON) FROM deleted)

        SELECT @MA_Loai = Loai
        FROM MonAn 
        WHERE ID_MonAn IN (SELECT ID_MonAn FROM deleted);
    END

    IF (@v_code IS NOT NULL)
    BEGIN
        IF (@v_loaiMA = 'All' OR @v_loaiMA = @MA_Loai)
        BEGIN
            IF EXISTS(SELECT 1 FROM inserted)
            BEGIN
				DECLARE @TienGiam DECIMAL
				SELECT @TienGiam = dbo.CTHD_Tinhtiengiam(@v_code, @Id_HoaDon, @v_loaiMA)
				IF(@TienGiam IS NOT NULL)
				BEGIN
					UPDATE HoaDon SET TIENGIAM = @TienGiam
					WHERE ID_HOADON IN (SELECT ID_HOADON FROM inserted)
				END
				ELSE
				BEGIN
					UPDATE HoaDon SET TIENGIAM = 0
					WHERE ID_HOADON IN (SELECT ID_HOADON FROM inserted)
				END
            END

			IF EXISTS(SELECT 1 FROM deleted)
            BEGIN
				DECLARE @TienGiam2 DECIMAL
				SELECT @TienGiam2 = dbo.CTHD_Tinhtiengiam(@v_code, @Id_HoaDon, @v_loaiMA)
				IF(@TienGiam2 IS NOT NULL)
				BEGIN
					UPDATE HoaDon SET TIENGIAM = @TienGiam2
					WHERE ID_HOADON IN (SELECT ID_HOADON FROM deleted)
				END
				ELSE
				BEGIN
					UPDATE HoaDon SET TIENGIAM = 0
					WHERE ID_HOADON IN (SELECT ID_HOADON FROM deleted)
				END
            END
        END
    END
END;
GO

-- Tong tien o Hoa Don = Tien mon an - Tien giam
CREATE OR ALTER TRIGGER Tg_HD_TongTien
ON CTHD
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
	IF(EXISTS(SELECT 1 FROM inserted))
	BEGIN
		UPDATE HOADON 
		SET TONGTIEN = TIENMONAN - TIENGIAM
		WHERE ID_HOADON IN (SELECT MAX(ID_HOADON) FROM inserted)
	END

	IF(EXISTS(SELECT 1 FROM deleted))
	BEGIN
		UPDATE HOADON 
		SET TONGTIEN = TIENMONAN - TIENGIAM
		WHERE ID_HOADON IN (SELECT MAX(ID_HOADON) FROM deleted)
	END
END
GO

-- Khi cap nhat Code_Voucher o HoaDon, Tinh tien giam theo thong tin cua Voucher do va giam Diem tich luy cua KH
CREATE OR ALTER TRIGGER Tg_HD_DoiVoucher
ON HoaDon
AFTER UPDATE
AS
BEGIN
    DECLARE @TongtienLoaiMonAnduocgiam DECIMAL
    DECLARE @v_Diemdoi INT
    DECLARE @v_Phantram DECIMAL
    DECLARE @v_LoaiMA NVARCHAR(50)

    IF EXISTS(SELECT 1 FROM inserted)
    BEGIN
        SELECT @v_Diemdoi = Diem,
               @v_Phantram = Phantram,
               @v_LoaiMA = LoaiMA
        FROM Voucher
        WHERE Code_Voucher IN (SELECT Code_Voucher 
							   FROM inserted
							   WHERE ID_HOADON = (SELECT MAX(ID_HOADON) FROM inserted));

		---- Giam Diem tich luy cua KH khi doi Voucher
		--IF(@v_Diemdoi IS NOT NULL)
		--BEGIN
		--	UPDATE KHACHHANG 
		--	SET Diemtichluy = Diemtichluy - @v_Diemdoi 
		--	WHERE ID_KH IN (SELECT ID_KH FROM inserted)
		--END

		----Giam So Luong cua Voucher di 1 khi KH doi Voucher
  --       UPDATE Voucher 
		-- SET SoLuong = SoLuong - 1 
		-- WHERE Code_Voucher IN (SELECT CODE_VOUCHER FROM inserted)

        IF (@v_LoaiMA = 'All')
        BEGIN
            SELECT @TongtienLoaiMonAnduocgiam = TienMonAn
            FROM inserted;
        END
        ELSE
        BEGIN
            SELECT @TongtienLoaiMonAnduocgiam = SUM(THANHTIEN)
											    FROM CTHD, MONAN
											    WHERE CTHD.ID_MONAN = MONAN.ID_MONAN
													  AND ID_HOADON IN (SELECT ID_HOADON FROM inserted)
													  AND LOAI = @v_loaiMA
        END
		IF(@TongtienLoaiMonAnduocgiam IS NOT NULL)
		BEGIN
			UPDATE HoaDon
			SET TIENGIAM = ROUND(@TongtienLoaiMonAnduocgiam * @v_Phantram / 100, 0),
				TONGTIEN = TIENMONAN - ROUND(@TongtienLoaiMonAnduocgiam * @v_Phantram / 100, 0)
			FROM HoaDon
			WHERE ID_HOADON IN (SELECT ID_HOADON FROM inserted)
		END
    END
END;
GO

--Trigger Doanh so cua Khach hang bang tong tien cua tat ca hoa don co trang thai 'Da thanh toan' 
--cua khach hang do
-- Diem tich luy cua Khach hang duoc tinh bang 0.005% Tong tien cua hoa don (1.000.000d tuong duong 50 diem)
CREATE OR ALTER TRIGGER Tg_KH_DoanhsovaDTL
ON HoaDon
AFTER UPDATE
AS
BEGIN
    IF UPDATE(Trangthai)
    BEGIN
        IF (SELECT Trangthai FROM inserted) = 'Da thanh toan'
        BEGIN
            UPDATE KhachHang
            SET Doanhso = Doanhso + (SELECT Tongtien FROM inserted),
                Diemtichluy = Diemtichluy + ROUND((SELECT Tongtien FROM inserted)*0.00005, 0)
            WHERE ID_KH = (SELECT ID_KH FROM inserted);
        END
    END
END;
GO

--Trigger khi khach hang them hoa don moi, trang thai ban chuyen tu 'Con trong' sang 'Dang dung bua'
-- Khi trang thai don hang tro thanh 'Da thanh toan' trang thai ban chuyen tu 'Dang dung bua' sang 'Con trong'*********
CREATE OR ALTER TRIGGER Tg_TrangthaiBan
ON HoaDon
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (SELECT 1 FROM inserted)
    BEGIN
        UPDATE Ban
        SET Trangthai = CASE 
                            WHEN i.Trangthai = 'Chua thanh toan' 
							THEN 'Dang dung bua'
							WHEN i.Trangthai = 'Da thanh toan' 
							THEN 'Con trong'
                        END
        FROM Ban b, inserted i
        WHERE b.ID_BAN = i.ID_BAN
    END
END;
GO




select * from HOADON
select * from CTHD
select * from KHACHHANG
where ID_KH = 100
select * from VOUCHER
select * from BAN
select * from NHANVIEN
select * from NGUOIDUNG

INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (1,1,1)

update KHACHHANG set DIEMTICHLUY = 1000 where ID_KH = 110
update HOADON set CODE_VOUCHER = 'loQy' where ID_HOADON = 101
update HOADON set TRANGTHAI = 'Da thanh toan' where ID_HOADON = 102
update HOADON set TRANGTHAI = 'Chua thanh toan'
update BAN set TRANGTHAI = 'Con trong'
delete CTHD 
delete HOADON
delete KHACHHANG

INSERT INTO HoaDon(ID_HoaDon,ID_KH,ID_Ban,NgayHD,TienMonAn,TienGiam,Trangthai) 
VALUES (102,110,100,'10-1-2023',0,0,'Chua thanh toan');

INSERT INTO CTHD(ID_HoaDon,ID_MonAn,SoLuong) VALUES (102,2,1);


delete KHACHHANG where ID_KH = 110

select * from HOADON
delete HOADON
select * from CTHD
delete CTHD

INSERT INTO KhachHang(ID_KH,TenKH,Ngaythamgia,ID_ND) VALUES (110,'Huynh Quang Khiem','09/02/2003',115)