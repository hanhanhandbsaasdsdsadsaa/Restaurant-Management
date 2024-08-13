package Customer.Controller.Service;

import Customer.Model.AdminModel.Login;
import Customer.Controller.Connection.ConnectDatabase;
import Customer.Controller.Connection.DatabaseConnection;
import Customer.Model.ModelNguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class LoginBL {

    //Lay thong tin NGUOIDUNG tu email va matkhau do nguoi dung nhap tu Trang Login
    public static ModelNguoiDung getUser(String email, String password) {
        ModelNguoiDung user = new ModelNguoiDung();
        String query = "select ID_ND, Vaitro from NGUOIDUNG where EMAIL = ? and MATKHAU = ?";
        try (Connection ketNoi = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = ketNoi.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("ID_ND");
                String role = rs.getString("Vaitro");
                user = new ModelNguoiDung(userID, email, password, role);
            }
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    // phương thức đăng nhập
    public static String checkLogin(String email, String password) {
        String query = "select VAITRO from NGUOIDUNG where EMAIL = ? and MATKHAU = ?";
        try (Connection ketNoi = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = ketNoi.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new String(rs.getString("VAITRO"));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    private static int registerCustumer(String id_nd) {
        String query = "INSERT INTO KHACHHANG(ID_KH, TENKH, NGAYTHAMGIA, ID_ND) VALUES (?,?,?,?)";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(autoGenerateID()));
            ps.setString(2, "-");
            ps.setString(3, String.valueOf(new java.sql.Date(new Date().getTime())));
            ps.setString(4, id_nd);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    // phương thức đăng ký tài khoản khách hàng
    public static int registerLogin(Login log) {
        if (!checkEmailExit(log.getEmail()) && (log.getEmail().contains("gmail.com")) || log.getEmail().contains("yahoo.com")) {
            String query = "insert into NGUOIDUNG values (?,?,?,?,?,?)";
            try (Connection ketNoi = ConnectDatabase.ConnectData()) {
                PreparedStatement ps = ketNoi.prepareStatement(query);
                String id_nd = String.valueOf(autoGenerateID());
                ps.setString(1, id_nd);
                ps.setString(2, log.getEmail());
                ps.setString(3, log.getPassword());
                ps.setString(4, null);
                ps.setString(5, "Verified");
                ps.setString(6, "Khach Hang");
                int check_1 = ps.executeUpdate();
                if (check_1 != 0) {
                    return registerCustumer(id_nd);
                } else {
                    return 0;
                }
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    // phương thức phát sinh ID_ND ngẫu nhiên từ 1-99 không trùng lắp
    public static int autoGenerateID() {
        String query = "select * from NGUOIDUNG where ID_ND = ?";
        Random rd = new Random();
        int number = -1;
        while (true) {
            number = rd.nextInt(100);
            try (Connection ketNoi = ConnectDatabase.ConnectData()) {
                PreparedStatement ps = ketNoi.prepareStatement(query);
                ps.setString(1, String.valueOf(number));
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    break;
                }
            } catch (Exception e) {
            }
        }
        return number;
    }

    // phương thức gửi lại mật khẩu
    public static String sendPassword(String email) {
        String query = "select * from NGUOIDUNG where EMAIL = ?";
        try (Connection ketNoi = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = ketNoi.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("MATKHAU");
            } else {
                return "";
            }
        } catch (Exception e) {
            return null;
        }
    }
// validate
    // phương thức kiểm tra email đã tồn tại trong danh sách

    private static boolean checkEmailExit(String email) {
        String query = "select * from NGUOIDUNG where EMAIL = ?";
        try (Connection conn = ConnectDatabase.ConnectData()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }
}
