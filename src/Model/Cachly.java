
package Model;


/**
 *
 * @author DELL
 */
public class Cachly {
    private int ID;
    private String SoCMT;
    private String tgian_bat_dau;
    private String thoi_gian_test;
    private String hinh_thuc_test;
    private String Ket_qua_test;
    private String muc_do_cach_ly;

    public Cachly(int ID, String SoCMT, String tgian_bat_dau, String thoi_gian_test, String hinh_thuc_test, String Ket_qua_test, String muc_do_cach_ly) {
        this.ID = ID;
        this.SoCMT = SoCMT;
        this.tgian_bat_dau = tgian_bat_dau;
        this.thoi_gian_test = thoi_gian_test;
        this.hinh_thuc_test = hinh_thuc_test;
        this.Ket_qua_test = Ket_qua_test;
        this.muc_do_cach_ly = muc_do_cach_ly;
    }

    public Cachly(String SoCMT, String tgian_bat_dau, String thoi_gian_test, String hinh_thuc_test, String Ket_qua_test, String muc_do_cach_ly) {
        this.SoCMT = SoCMT;
        this.tgian_bat_dau = tgian_bat_dau;
        this.thoi_gian_test = thoi_gian_test;
        this.hinh_thuc_test = hinh_thuc_test;
        this.Ket_qua_test = Ket_qua_test;
        this.muc_do_cach_ly = muc_do_cach_ly;
    }

    public Cachly(int ID, String tgian_bat_dau, String thoi_gian_test, String hinh_thuc_test, String Ket_qua_test, String muc_do_cach_ly) {
        this.ID = ID;
        this.tgian_bat_dau = tgian_bat_dau;
        this.thoi_gian_test = thoi_gian_test;
        this.hinh_thuc_test = hinh_thuc_test;
        this.Ket_qua_test = Ket_qua_test;
        this.muc_do_cach_ly = muc_do_cach_ly;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSoCMT() {
        return SoCMT;
    }

    public void setSoCMT(String SoCMT) {
        this.SoCMT = SoCMT;
    }

    public String getTgian_bat_dau() {
        return tgian_bat_dau;
    }

    public void setTgian_bat_dau(String tgian_bat_dau) {
        this.tgian_bat_dau = tgian_bat_dau;
    }

    public String getThoi_gian_test() {
        return thoi_gian_test;
    }

    public void setThoi_gian_test(String thoi_gian_test) {
        this.thoi_gian_test = thoi_gian_test;
    }

    public String getHinh_thuc_test() {
        return hinh_thuc_test;
    }

    public void setHinh_thuc_test(String hinh_thuc_test) {
        this.hinh_thuc_test = hinh_thuc_test;
    }

    public String getKet_qua_test() {
        return Ket_qua_test;
    }

    public void setKet_qua_test(String Ket_qua_test) {
        this.Ket_qua_test = Ket_qua_test;
    }

    public String getMuc_do_cach_ly() {
        return muc_do_cach_ly;
    }

    public void setMuc_do_cach_ly(String muc_do_cach_ly) {
        this.muc_do_cach_ly = muc_do_cach_ly;
    }

    
    
}