
package Model;

import java.sql.Date;

/**p
 *
 * @author DELL
 */
public class Nhankhau {
    private String soCMT;
    private String Ho_ten;
    private String namSinh;
    private String gioiTinh;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String quocTich;
    private String noiThuongTru;
    private String diaChiHienNay;
    private String SDT;

    public Nhankhau(String soCMT, String Ho_ten, String namSinh, String gioiTinh, String noiSinh, String nguyenQuan, String danToc, String quocTich, String noiThuongTru, String diaChiHienNay, String SDT) {
        this.soCMT = soCMT;
        this.Ho_ten = Ho_ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.noiThuongTru = noiThuongTru;
        this.diaChiHienNay = diaChiHienNay;
        this.SDT = SDT;
    }

    public Nhankhau(String soCMT, String Ho_ten, String namSinh, String gioiTinh, String noiSinh, String danToc, String quocTich, String diaChiHienNay, String SDT) {
        this.soCMT = soCMT;
        this.Ho_ten = Ho_ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.diaChiHienNay = diaChiHienNay;
        this.SDT = SDT;
    }

    
    
    

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getHo_ten() {
        return Ho_ten;
    }

    public void setHo_ten(String Ho_ten) {
        this.Ho_ten = Ho_ten;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNoiThuongTru() {
        return noiThuongTru;
    }

    public void setNoiThuongTru(String noiThuongTru) {
        this.noiThuongTru = noiThuongTru;
    }

    public String getDiaChiHienNay() {
        return diaChiHienNay;
    }

    public void setDiaChiHienNay(String diaChiHienNay) {
        this.diaChiHienNay = diaChiHienNay;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    
   
}
