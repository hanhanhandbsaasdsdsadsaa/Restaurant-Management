package Customer.Controller.Service;

import Customer.Model.AdminModel.HoaDon;
import Customer.Model.AdminModel.KhachHang;
import Customer.Model.AdminModel.ModelChart;
import Customer.Model.AdminModel.MonAn;
import Customer.Model.AdminModel.NhanVien;
import Customer.Model.AdminModel.PhieuNK;
import Customer.Controller.Connection.ConnectDatabase;
import Customer.Model.ModelNguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class AdminBL {

    // phương thức lấy danh sách món ăn từ database và sắp xếp tăng dần theo id
    public static ArrayList<MonAn> getListFood() {
        ArrayList<MonAn> lstFood = new ArrayList<>();
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement stm = conn.createStatement();
            String query = "select * from MONAN";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                MonAn food = new MonAn();
                food.setMaMA(rs.getString("ID_MONAN"));
                food.setTenMA(rs.getString("TENMON"));
                food.setDonGia(Double.parseDouble(rs.getString("DONGIA")));
                food.setLoaiMon(rs.getString("LOAI"));
                food.setTrangThai(rs.getString("TRANGTHAI"));
                lstFood.add(food);
            }
            // sắp xếp danh sách món ăn theo id
            lstFood.sort((t1, t2) -> {
                int x = Integer.parseInt(t1.getMaMA());
                int y = Integer.parseInt(t2.getMaMA());
                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                }
                return 0;
            });
            return lstFood;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức lọc những món ăn theo tên
    public static ArrayList<MonAn> getFilterFood(String foodname) {
        ArrayList<MonAn> lstFood = getListFood();
        List<MonAn> lst = lstFood.stream().filter(x -> x.getTenMA().contains(foodname)).collect(Collectors.toList());
        return (ArrayList<MonAn>) lst;
    }

    // phương thức lấy loại món ăn
    public static ArrayList<String> getDSLoaiMonAn() {
        ArrayList<String> dsLoaiMon = new ArrayList<>();
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            String query = "select distinct LOAI from MONAN";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String loaiMon = rs.getString("LOAI");
                dsLoaiMon.add(loaiMon);
            }
            return dsLoaiMon;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức thêm món ăn vào danh sách món ăn
    public static int addFood(MonAn food) {
        if (!checkExitIDFood(food.getMaMA()) && !checkExitNameFood(food.getTenMA())) {
            String query = "insert into MONAN values (?,?,?,?,?)";
            try (Connection conn = ConnectDatabase.ConnectData()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, food.getMaMA());
                ps.setString(2, food.getTenMA());
                ps.setDouble(3, food.getDonGia());
                ps.setString(4, food.getLoaiMon());
                ps.setString(5, food.getTrangThai());
                return ps.executeUpdate();
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    // phương thức sửa thông tin món ăn thông qua mã món ăn
    public static int updateFood(MonAn food) {
        String query = "update MONAN set TENMON = ?, DONGIA = ?, LOAI = ? where ID_MONAN = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, food.getTenMA());
            ps.setDouble(2, food.getDonGia());
            ps.setString(3, food.getLoaiMon());
            ps.setString(4, food.getMaMA());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

// phương thức ngưng kinh doanh món ăn
    public static int stopBuiseneFood(String idMonAn) {
        String query = "update MONAN set TRANGTHAI = 'Ngung kinh doanh' where ID_MONAN = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idMonAn);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức ngưng kinh doanh món ăn
    public static int openBuiseneFood(String idMonAn) {
        String query = "update MONAN set TRANGTHAI = 'Dang kinh doanh' where ID_MONAN = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idMonAn);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức lấy danh sách nhân viên và sắp xếp tăng dần theo mã nhân viên
    public static ArrayList<NhanVien> getListStaff() {
        ArrayList<NhanVien> lstStaff = new ArrayList<>();
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement stm = conn.createStatement();
            String query = "select ID_NV, TENNV,CONVERT(VARCHAR, NGAYVAOLAM, 105) AS NGAYVAOLAM, SDT, CHUCVU, ID_NQL, TINHTRANG from NHANVIEN";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                NhanVien staff = new NhanVien();
                staff.setMaNV(rs.getString("ID_NV"));
                staff.setTenNV(rs.getString("TENNV"));
                staff.setNgayVL(rs.getString("NGAYVAOLAM"));
                staff.setDienThoai(rs.getString("SDT"));
                staff.setChucVu(rs.getString("CHUCVU"));
                staff.setMaNQL(rs.getString("ID_NQL"));
                staff.setTinhTrang(rs.getString("TINHTRANG"));

                lstStaff.add(staff);
            }
            // sắp xếp danh sách món ăn theo id
            lstStaff.sort((t1, t2) -> {
                int x = Integer.parseInt(t1.getMaNV());
                int y = Integer.parseInt(t2.getMaNV());
                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                }
                return 0;
            });
            return lstStaff;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức lọc những nhân viên theo tên
    public static ArrayList<NhanVien> getFilterStaff(String staffName) {
        ArrayList<NhanVien> lstStaff = getListStaff();
        List<NhanVien> lst = lstStaff.stream().filter(x -> x.getTenNV().contains(staffName)).collect(Collectors.toList());
        return (ArrayList<NhanVien>) lst;
    }

    // phương thức lấy chức vụ nhân viên
    public static ArrayList<String> getDSChucVu() {
        ArrayList<String> dsChucVu = new ArrayList<>();
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            String query = "select distinct CHUCVU from NHANVIEN";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String chucVu = rs.getString("CHUCVU");
                dsChucVu.add(chucVu);
            }
            return dsChucVu;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức thêm nhân viên nhưng không có tài khoản
    public static int addStaff(NhanVien nv) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(nv.getNgayVL(), formatter);
        if (!checkExitIDStaff(nv.getMaNV()) && checkExitIDManager(nv.getMaNQL())) {
            String query = "INSERT INTO NhanVien(ID_NV,TenNV,NGAYVAOLAM,SDT,Chucvu,ID_ND,ID_NQL,Tinhtrang) VALUES (?,?,?,?,?,?,?,?)";
            try (Connection conn = ConnectDatabase.ConnectData()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nv.getMaNV());
                ps.setString(2, nv.getTenNV());
                ps.setString(3, date.toString());
                ps.setString(4, nv.getDienThoai());
                ps.setString(5, nv.getChucVu());
                ps.setString(6, null);
                ps.setString(7, nv.getMaNQL());
                ps.setString(8, nv.getTinhTrang());
                return ps.executeUpdate();
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    // phương thức sửa thông tin nhân viên
    public static int updateInforStaff(NhanVien staff) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(staff.getNgayVL(), formatter);
        if (checkExitIDStaff(staff.getMaNV()) && checkExitIDManager(staff.getMaNQL())) {
            String query = "update NHANVIEN set TENNV = ?, NGAYVAOLAM = ?, SDT = ?, CHUCVU = ?, ID_NQL = ? where ID_NV = ?";
            try (Connection conn = ConnectDatabase.ConnectData()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, staff.getTenNV());
                ps.setString(2, date.toString());
                ps.setString(3, staff.getDienThoai());
                ps.setString(4, staff.getChucVu());
                ps.setString(5, staff.getMaNQL());
                ps.setString(6, staff.getMaNV());
                return ps.executeUpdate();
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    // phương thức cập nhật đuổi việc của nhân viên
    public static int stopDoStaff(String idNV) {
        String query = "update NHANVIEN set TINHTRANG = 'Da nghi viec' where ID_NV = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idNV);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức lấy danh sách hóa đơn từ database và lọc theo móc thời gian tatca/ngay/thang/nam
    public static ArrayList<HoaDon> getStatistBill(String date) {
        ArrayList<HoaDon> lstBill = new ArrayList<>();
        String query = "select ID_HOADON, ID_KH, ID_BAN, CONVERT(VARCHAR, NGAYHD, 105) AS NGAYHD, "
                + "TIENMONAN, CODE_VOUCHER, TIENGIAM, TONGTIEN, TRANGTHAI"
                + " from HOADON";
        if (date.equals("Tất cả")) {
            query = "select ID_HOADON, ID_KH, ID_BAN, CONVERT(VARCHAR, NGAYHD, 105) AS NGAYHD, "
                    + "TIENMONAN, CODE_VOUCHER, TIENGIAM, TONGTIEN, TRANGTHAI"
                    + " from HOADON";
        } else if (date.equals("Năm này")) {
            query = "select ID_HOADON, ID_KH, ID_BAN, CONVERT(VARCHAR, NGAYHD, 105) AS NGAYHD, "
                    + "TIENMONAN, CODE_VOUCHER, TIENGIAM, TONGTIEN, TRANGTHAI"
                    + " from HOADON"
                    + " where datepart(yyyy,NGAYHD) = datepart(yyyy,GETDATE())";
        } else if (date.equals("Tháng này")) {
            query = "select ID_HOADON, ID_KH, ID_BAN, CONVERT(VARCHAR, NGAYHD, 105) AS NGAYHD, "
                    + "TIENMONAN, CODE_VOUCHER, TIENGIAM, TONGTIEN, TRANGTHAI"
                    + " from HOADON"
                    + " where datepart(mm,NGAYHD) = datepart(mm,GETDATE()) and datepart(yyyy,NGAYHD) = datepart(yyyy,GETDATE())";
        } else if (date.equals("Hôm nay")) {
            query = "select ID_HOADON, ID_KH, ID_BAN, CONVERT(VARCHAR, NGAYHD, 105) AS NGAYHD, "
                    + "TIENMONAN, CODE_VOUCHER, TIENGIAM, TONGTIEN, TRANGTHAI"
                    + " from HOADON"
                    + " where CONVERT(DATE, NGAYHD) = CONVERT(DATE, GETDATE())";
        }
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                HoaDon bill = new HoaDon();
                bill.setMaHD(rs.getString("ID_HOADON"));
                bill.setMaKH(rs.getString("ID_KH"));
                bill.setMaBan(rs.getString("ID_BAN"));
                bill.setNgayHD(rs.getString("NGAYHD"));
                bill.setTienMonAn(rs.getDouble("TIENMONAN"));
                bill.setCodeVourcher(rs.getString("CODE_VOUCHER"));
                bill.setTienGiam(rs.getDouble("TIENGIAM"));
                bill.setTongTien(rs.getDouble("TONGTIEN"));
                bill.setTrangThai(rs.getString("TRANGTHAI"));
                lstBill.add(bill);
            }
            return lstBill;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức tính tổng doanh thu hóa đơn theo mốc thời gian ngay/thang/nam
    public static double totalBill(String date) {
        String query = "select sum(TONGTIEN) as total from HOADON where TRANGTHAI = 'Da thanh toan'";
        if (date.equals("Năm này")) {
            query = "select sum(TONGTIEN) as total from HOADON where DATEPART(yyyy,NGAYHD) = DATEPART(yyyy,GETDATE()) and TRANGTHAI = 'Da thanh toan'";
        } else if (date.equals("Tháng này")) {
            query = "select sum(TONGTIEN) as total from HOADON where DATEPART(mm,NGAYHD) = DATEPART(mm,GETDATE()) and DATEPART(yyyy,NGAYHD) = DATEPART(yyyy,GETDATE())  and TRANGTHAI = 'Da thanh toan'";
        } else if (date.equals("Hôm nay")) {
            query = "select sum(TONGTIEN) as total from HOADON where CONVERT(DATE, NGAYHD) = CONVERT(DATE, GETDATE()) and TRANGTHAI = 'Da thanh toan'";
        }
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            double kq = 0;
            if (rs.next()) {
                kq = rs.getDouble("total");
            }
            return kq;
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức tính tổng doanh thu hóa đơn tháng trước
    public static double totalBillLastMonth() {
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            String query = "select sum(TONGTIEN) as total from HOADON where DATEPART(mm,NGAYHD) = (DATEPART(mm,DATEADD(MONTH, -1, GETDATE()))) and TRANGTHAI = 'Da thanh toan'"
                    + "and DATEPART(yyyy,NGAYHD) = DATEPART(yyyy,GETDATE())";
            ResultSet rs = st.executeQuery(query);
            double kq = 0;
            if (rs.next()) {
                kq = rs.getDouble("total");
            }
            return kq;
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức lấy danh sách tháng và tổng tiền hóa đơn (*)
    private static HashMap<String, Double> getMapBillForMonth() {
        String query = "SELECT FORMAT(NGAYHD, 'MMMM') AS 'month', SUM(TONGTIEN) as 'total' "
                + "FROM HOADON "
                + "WHERE TRANGTHAI = 'Da thanh toan' AND YEAR(NgayHD) = YEAR(GETDATE()) "
                + "GROUP BY FORMAT(NGAYHD, 'MMMM'), FORMAT(NGAYHD, 'MMyyyy') "
                + "ORDER BY MAX(NGAYHD) DESC";

        try (Connection conn = ConnectDatabase.ConnectData()) {
            HashMap<String, Double> hmap = new HashMap<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String month = rs.getString("month");
                double total = rs.getDouble("total");
                hmap.put(month, total);
            }
            return hmap;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức lấy danh sách phiếu nhập từ database và lọc theo móc thời gian tatca/ngay/thang/nam
    public static ArrayList<PhieuNK> getImportBill(String date) {
        ArrayList<PhieuNK> lstImportBill = new ArrayList<>();
        String query = "select ID_NK, ID_NV, CONVERT(VARCHAR, NGAYNK, 105) AS NGAYNK, TONGTIEN from PHIEUNK";
        if (date.equals("Tất cả")) {
            query = "select ID_NK, ID_NV, CONVERT(VARCHAR, NGAYNK, 105) AS NGAYNK, TONGTIEN from PHIEUNK";
        } else if (date.equals("Năm này")) {
            query = "select ID_NK, ID_NV, CONVERT(VARCHAR, NGAYNK, 105) AS NGAYNK, TONGTIEN from PHIEUNK where datepart(yyyy,NGAYNK) = datepart(yyyy,GETDATE())";
        } else if (date.equals("Tháng này")) {
            query = "select ID_NK, ID_NV, CONVERT(VARCHAR, NGAYNK, 105) AS NGAYNK, TONGTIEN from PHIEUNK where datepart(mm,NGAYNK) = datepart(mm,GETDATE()) and datepart(yyyy,NGAYNK) = datepart(yyyy,GETDATE())";
        } else if (date.equals("Hôm nay")) {
            query = "select ID_NK, ID_NV, CONVERT(VARCHAR, NGAYNK, 105) AS NGAYNK, TONGTIEN from PHIEUNK where CONVERT(DATE, NGAYNK) = CONVERT(DATE, GETDATE())";
        }
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                PhieuNK bill = new PhieuNK();
                bill.setId_NK(rs.getString("ID_NK"));
                bill.setId_NV(rs.getString("ID_NV"));
                bill.setNgayNK(rs.getString("NGAYNK"));
                bill.setTongTien(rs.getDouble("TONGTIEN"));
                lstImportBill.add(bill);
            }
            return lstImportBill;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức tính tổng doanh thu phiếu nhập theo mốc thời gian ngay/thang/nam
    public static double totalImportBill(String date) {
        String query = "select sum(TONGTIEN) as total from PHIEUNK";
        if (date.equals("Năm này")) {
            query = "select sum(TONGTIEN) as total from PHIEUNK where DATEPART(yyyy,NGAYNK) = DATEPART(yyyy,GETDATE())";
        } else if (date.equals("Tháng này")) {
            query = "select sum(TONGTIEN) as total from PHIEUNK where DATEPART(mm,NGAYNK) = DATEPART(mm,GETDATE()) and datepart(yyyy,NGAYNK) = datepart(yyyy,GETDATE())";
        } else if (date.equals("Hôm nay")) {
            query = "select sum(TONGTIEN) as total from PHIEUNK where CONVERT(DATE, NGAYNK) = CONVERT(DATE, GETDATE())";
        }
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            double kq = 0;
            if (rs.next()) {
                kq = rs.getDouble("total");
            }
            return kq;
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức tính tổng doanh thu phiếu nhập tháng trước
    public static double totalImportBillLastMonth() {
        String query = "select sum(TONGTIEN) as total from PHIEUNK where DATEPART(MM,NGAYNK) = DATEPART(MM,DATEADD(MONTH, -1, GETDATE()))"
                + "and DATEPART(yyyy,NGAYHD) = DATEPART(yyyy,GETDATE())";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            double kq = 0;
            if (rs.next()) {
                kq = rs.getDouble("total");
            }
            return kq;
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức lấy danh sách tháng và tổng tiền phiếu nhập (*)
    private static HashMap<String, Double> getMapImportBillForMonth() {
        String query = "SELECT FORMAT(NGAYNK, 'MMMM') AS 'month', SUM(TONGTIEN) as 'total' "
                + "FROM PHIEUNK "
                + "WHERE YEAR(NgayNK) = YEAR(GETDATE()) "
                + "GROUP BY FORMAT(NGAYNK, 'MMMM'), FORMAT(NGAYNK, 'MMyyyy') "
                + "ORDER BY MAX(NGAYNK) DESC";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            HashMap<String, Double> hmap = new HashMap<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String month = rs.getString("month");
                double total = rs.getDouble("total");
                hmap.put(month, total);
            }
            return hmap;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức lấy danh sách doanh thu, chi phí, lợi nhuận theo từng tháng
    public static ArrayList<ModelChart> getListModelChart() {
        HashMap<String, Double> hmapBill = getMapBillForMonth();
        HashMap<String, Double> hmapImportBill = getMapImportBillForMonth();
        ArrayList<ModelChart> lst = new ArrayList<>();

        String[] nameMonth = new String[]{"Janualy", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int month = 1; month <= 12; ++month) {
            double revenue = hmapBill.getOrDefault(nameMonth[month - 1], 0.0);
            double expenses = hmapImportBill.getOrDefault(nameMonth[month - 1], 0.0);
            double profit = revenue - expenses;
            ModelChart mc = new ModelChart(nameMonth[month - 1], new double[]{revenue, expenses, profit});
            lst.add(mc);
        }
        return lst;
    }

//    public static ArrayList<ModelChart> getRevenueCostProfit_byMonth() {
//        ArrayList<ModelChart> list = new ArrayList<>();
//        HashMap<Integer, Double> revenueMap = new HashMap<>();
//        HashMap<Integer, Double> costMap = new HashMap<>();
//
//        try (Connection conn = ConnectDatabase.ConnectData()) {
//            // Lấy doanh thu theo tháng
//            String sql_Revenue = "SELECT MONTH(NgayHD) AS Thang, SUM(TONGTIEN) AS DoanhThu FROM HoaDon WHERE YEAR(NgayHD) = YEAR(GETDATE()) GROUP BY MONTH(NgayHD) ORDER BY Thang";
//            PreparedStatement p_R = conn.prepareStatement(sql_Revenue);
//            ResultSet r_R = p_R.executeQuery();
//            while (r_R.next()) {
//                revenueMap.put(r_R.getInt("Thang"), r_R.getDouble("DoanhThu"));
//            }
//
//            // Lấy chi phí theo tháng
//            String sql_Cost = "SELECT MONTH(NgayNK) AS Thang, SUM(TONGTIEN) AS ChiPhi FROM PhieuNK WHERE YEAR(NgayNK) = YEAR(GETDATE()) GROUP BY MONTH(NgayNK) ORDER BY Thang";
//            PreparedStatement p_C = conn.prepareStatement(sql_Cost);
//            ResultSet r_C = p_C.executeQuery();
//            while (r_C.next()) {
//                costMap.put(r_C.getInt("Thang"), r_C.getDouble("ChiPhi"));
//            }
//
//            // Tính toán lợi nhuận và thêm vào danh sách
//            for (int month = 1; month <= 12; month++) {
//                double revenue = revenueMap.getOrDefault(month, 0.0);
//                double expenses = costMap.getOrDefault(month, 0.0);
//                double profit = revenue - expenses;
//                ModelChart data = new ModelChart("Tháng " + month, new double[]{revenue, expenses, profit});
//                list.add(data);
//            }
//            return list;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    // phương thức lấy danh sách khách hàng
    public static ArrayList<KhachHang> getListCustomer() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        try (Connection conn = ConnectDatabase.ConnectData()) {
            String query = "select ID_KH, TENKH,CONVERT(VARCHAR, NGAYTHAMGIA, 105) AS NGAYTHAMGIA, DOANHSO, DIEMTICHLUY from KHACHHANG";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("ID_KH"));
                kh.setTenKH(rs.getString("TENKH"));
                kh.setNgayThamGia(rs.getString("NGAYTHAMGIA"));
                kh.setDoanhSo(rs.getFloat("DOANHSO"));
                kh.setDiemTichLuy(rs.getFloat("DIEMTICHLUY"));
                lst.add(kh);
            }
            return lst;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức lọc những khách hàng theo tên
    public static ArrayList<KhachHang> getFilterCustomer(String customerName) {
        ArrayList<KhachHang> lstCus = getListCustomer();
        List<KhachHang> lst = lstCus.stream().filter(x -> x.getTenKH().contains(customerName)).collect(Collectors.toList());
        return (ArrayList<KhachHang>) lst;
    }

    // phương thức cập nhật thông tin khách hàng
    public static int updateCustomer(KhachHang kh) {
        String query = "update KHACHHANG set TENKH = ?, NGAYTHAMGIA = ?, DOANHSO = ?, DIEMTICHLUY = ? where ID_KH = ?";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(kh.getNgayThamGia(), formatter);
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, date.toString());
            ps.setFloat(3, kh.getDoanhSo());
            ps.setFloat(4, kh.getDiemTichLuy());
            ps.setString(5, kh.getMaKH());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức lấy nhân viên khi biết ID_NGUOIDUNG
    public static NhanVien getStaff(String id_nd) {
        NhanVien nv = new NhanVien();
        String query = "select ID_NV, TENNV, CONVERT(VARCHAR, NGAYVAOLAM, 105) AS NGAYVAOLAM, TINHTRANG from NGUOIDUNG nd, NHANVIEN nv where nd.ID_ND = ? and nd.ID_ND = nv.ID_ND";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id_nd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setMaNV(rs.getString("ID_NV"));
                nv.setTenNV(rs.getString("TENNV"));
                nv.setNgayVL(rs.getString("NGAYVAOLAM"));
                nv.setTinhTrang(rs.getString("TINHTRANG"));
            }
            return nv;
        } catch (Exception e) {
            return null;
        }
    }

    // phương thức lấy thông tin tài khoản dựa vào Email
    public static ModelNguoiDung getUser(String email) {
        String query = "select EMAIL, MATKHAU, VAITRO from NGUOIDUNG where EMAIL = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ModelNguoiDung nd = new ModelNguoiDung();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nd.setEmail(rs.getString("EMAIL"));
                nd.setPassword(rs.getString("MATKHAU"));
                nd.setRole(rs.getString("VAITRO"));
            }
            return nd;
        } catch (Exception e) {
            return null;
        }
    }

//    public static void main(String[] args) {
//        if(getUser("ndh@gmail.com") != null) {
//            System.out.println("thanh cong");
//        } else {
//            System.out.println("that bai");
//        }
//    }
// validate 
    // phương thức kiểm tra mã món ăn đã tồn tại trong danh sách
    private static boolean checkExitIDFood(String id_ma) {
        String query = "select * from MONAN where ID_MONAN = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id_ma);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkExitNameFood(String nameFood) {
        String query = "select * from MONAN where TENMON = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nameFood);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkExitIDStaff(String id_nv) {
        String query = "select * from NHANVIEN where ID_NV = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id_nv);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkExitIDManager(String id_nql) {
        String query = "select * from NHANVIEN where ID_NQL = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id_nql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }
}
