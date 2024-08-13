package Customer.Model.AdminModel;

public class MonAn {

    private String maMA;
    private String tenMA;
    private double donGia;
    private String loaiMon;
    private String trangThai;

    public MonAn() {
    }

    public MonAn(String maMA, String tenMA, double donGia, String loaiMon, String trangThai) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.donGia = donGia;
        this.loaiMon = loaiMon;
        this.trangThai = trangThai;
    }

    public String getMaMA() {
        return maMA;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
