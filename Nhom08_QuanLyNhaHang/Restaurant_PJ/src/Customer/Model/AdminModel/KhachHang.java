package Customer.Model.AdminModel;

public class KhachHang {

    private String maKH, tenKH;
    private String ngayThamGia;
    private float doanhSo, diemTichLuy;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String ngayThamGia, float doanhSo, float diemTichLuy) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngayThamGia = ngayThamGia;
        this.doanhSo = doanhSo;
        this.diemTichLuy = diemTichLuy;
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

    public String getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(String ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    public float getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(float doanhSo) {
        this.doanhSo = doanhSo;
    }

    public float getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(float diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

}
