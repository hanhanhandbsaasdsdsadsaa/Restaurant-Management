package Customer.Model.AdminModel;

public class PhieuNK {

    private String id_NK, id_NV, NgayNK;
    private Double tongTien;

    public PhieuNK() {
    }

    public PhieuNK(String id_NK, String id_NV, String NgayNK, Double tongTien) {
        this.id_NK = id_NK;
        this.id_NV = id_NV;
        this.NgayNK = NgayNK;
        this.tongTien = tongTien;
    }

    public String getId_NK() {
        return id_NK;
    }

    public void setId_NK(String id_NK) {
        this.id_NK = id_NK;
    }

    public String getId_NV() {
        return id_NV;
    }

    public void setId_NV(String id_NV) {
        this.id_NV = id_NV;
    }

    public String getNgayNK() {
        return NgayNK;
    }

    public void setNgayNK(String NgayNK) {
        this.NgayNK = NgayNK;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

}
