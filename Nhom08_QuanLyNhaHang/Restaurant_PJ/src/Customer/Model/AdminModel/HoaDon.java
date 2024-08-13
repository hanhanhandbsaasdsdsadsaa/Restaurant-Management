package Customer.Model.AdminModel;

public class HoaDon {

    private String maHD, maKH, maBan, ngayHD;
    private Double tienMonAn;
    private String codeVourcher;
    private Double tienGiam, tongTien;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maKH, String maBan, String ngayHD, Double tienMonAn, String codeVourcher, Double tienGiam, Double tongTien, String trangThai) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maBan = maBan;
        this.ngayHD = ngayHD;
        this.tienMonAn = tienMonAn;
        this.codeVourcher = codeVourcher;
        this.tienGiam = tienGiam;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public Double getTienMonAn() {
        return tienMonAn;
    }

    public void setTienMonAn(Double tienMonAn) {
        this.tienMonAn = tienMonAn;
    }

    public String getCodeVourcher() {
        return codeVourcher;
    }

    public void setCodeVourcher(String codeVourcher) {
        this.codeVourcher = codeVourcher;
    }

    public Double getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(Double tienGiam) {
        this.tienGiam = tienGiam;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
