package Customer.Model.AdminModel;

public class NhanVien {

    private String maNV, tenNV, ngayVL, dienThoai, chucVu, maNQL, tinhTrang;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String ngayVL, String dienThoai, String chucVu, String maNQL, String tinhTrang) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngayVL = ngayVL;
        this.dienThoai = dienThoai;
        this.chucVu = chucVu;
        this.maNQL = maNQL;
        this.tinhTrang = tinhTrang;
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

    public String getNgayVL() {
        return ngayVL;
    }

    public void setNgayVL(String ngayVL) {
        this.ngayVL = ngayVL;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMaNQL() {
        return maNQL;
    }

    public void setMaNQL(String maNQL) {
        this.maNQL = maNQL;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
