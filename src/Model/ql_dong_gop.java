package Model;

import java.sql.Date;



public class ql_dong_gop {

    private int id;
    private String So_CMT;
    private String Ho_ten;
    private int ID_khoan_thu;
    private int Sotien;
    private Date NgaynopDate;
    private String ten_khoan_thu;

    public ql_dong_gop(int id, String So_CMT, String Ho_ten, int ID_khoan_thu, int Sotien, Date NgaynopDate, String ten_khoan_thu) {
        this.id = id;
        this.So_CMT = So_CMT;
        this.Ho_ten = Ho_ten;
        this.ID_khoan_thu = ID_khoan_thu;
        this.Sotien = Sotien;
        this.NgaynopDate = NgaynopDate;
        this.ten_khoan_thu = ten_khoan_thu;
    }

    public ql_dong_gop(String So_CMT, String Ho_ten, int ID_khoan_thu, int Sotien, Date NgaynopDate, String ten_khoan_thu) {
        this.So_CMT = So_CMT;
        this.Ho_ten = Ho_ten;
        this.ID_khoan_thu = ID_khoan_thu;
        this.Sotien = Sotien;
        this.NgaynopDate = NgaynopDate;
        this.ten_khoan_thu = ten_khoan_thu;
    }

    public ql_dong_gop(String So_CMT, int ID_khoan_thu, Date NgaynopDate) {
        this.So_CMT = So_CMT;
        this.ID_khoan_thu = ID_khoan_thu;
        this.NgaynopDate = NgaynopDate;
    }
    
    
    
    

    public String getTen_khoan_thu() {
        return ten_khoan_thu;
    }

    public void setTen_khoan_thu(String ten_khoan_thu) {
        this.ten_khoan_thu = ten_khoan_thu;
    }

   
    public String getHo_ten() {
        return Ho_ten;
    }

    public void setHo_ten(String Ho_ten) {
        this.Ho_ten = Ho_ten;
    }

    public int getSotien() {
        return Sotien;
    }

    public void setSotien(int Sotien) {
        this.Sotien = Sotien;
    }

    public Date getNgaynopDate() {
        return NgaynopDate;
    }

    public void setNgaynopDate(Date NgaynopDate) {
        this.NgaynopDate = NgaynopDate;
    }
    
    

    public ql_dong_gop(String So_CMT, int ID_khoan_thu) {
        this.So_CMT = So_CMT;
        this.ID_khoan_thu = ID_khoan_thu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSo_CMT() {
        return So_CMT;
    }

    public void setSo_CMT(String So_CMT) {
        this.So_CMT = So_CMT;
    }

    public int getID_khoan_thu() {
        return ID_khoan_thu;
    }

    public void setID_khoan_thu(int ID_khoan_thu) {
        this.ID_khoan_thu = ID_khoan_thu;
    }

  
}
