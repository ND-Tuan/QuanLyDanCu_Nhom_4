package Model;



import java.sql.Date;

public class Khaibao {
    
    private int id_khaibao;
    private String SoCMT;
    private String da_di_qua;
    private String trang_thai_suc_khoe;
    private Date ngay_khai_bao;

    public Khaibao(int id_khaibao, String SoCMT, String da_di_qua, String trang_thai_suc_khoe, Date ngay_khai_bao) {
        this.id_khaibao = id_khaibao;
        this.SoCMT = SoCMT;
        this.da_di_qua = da_di_qua;
        this.trang_thai_suc_khoe = trang_thai_suc_khoe;
        this.ngay_khai_bao = ngay_khai_bao;
    }

    public Khaibao(String SoCMT, String da_di_qua, String trang_thai_suc_khoe, Date ngay_khai_bao) {
        this.SoCMT = SoCMT;
        this.da_di_qua = da_di_qua;
        this.trang_thai_suc_khoe = trang_thai_suc_khoe;
        this.ngay_khai_bao = ngay_khai_bao;
    }

    public Khaibao(String SoCMT, String da_di_qua, String trang_thai_suc_khoe) {
        this.SoCMT = SoCMT;
        this.da_di_qua = da_di_qua;
        this.trang_thai_suc_khoe = trang_thai_suc_khoe;
    }
    
    

    public int getId_khaibao() {
        return id_khaibao;
    }

    public void setId_khaibao(int id_khaibao) {
        this.id_khaibao = id_khaibao;
    }

    public String getSoCMT() {
        return SoCMT;
    }

    public void setSoCMT(String SoCMT) {
        this.SoCMT = SoCMT;
    }

    public String getDa_di_qua() {
        return da_di_qua;
    }

    public void setDa_di_qua(String da_di_qua) {
        this.da_di_qua = da_di_qua;
    }

    public String getTrang_thai_suc_khoe() {
        return trang_thai_suc_khoe;
    }

    public void setTrang_thai_suc_khoe(String trang_thai_suc_khoe) {
        this.trang_thai_suc_khoe = trang_thai_suc_khoe;
    }

    public Date getNgay_khai_bao() {
        return ngay_khai_bao;
    }

    public void setNgay_khai_bao(Date ngay_khai_bao) {
        this.ngay_khai_bao = ngay_khai_bao;
    }

   
}
