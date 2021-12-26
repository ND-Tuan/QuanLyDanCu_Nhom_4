package Model;

public class khoan_thu {
    private int ID;
    private String ten_khoan_thu;
    private int Sotien;
    private boolean Batbuoc;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen_khoan_thu() {
        return ten_khoan_thu;
    }

    public void setTen_khoan_thu(String ten_khoan_thu) {
        this.ten_khoan_thu = ten_khoan_thu;
    }

    public int getSotien() {
        return Sotien;
    }

    public void setSotien(int Sotien) {
        this.Sotien = Sotien;
    }

    public boolean isBatbuoc() {
        return Batbuoc;
    }

    public void setBatbuoc(boolean Batbuoc) {
        this.Batbuoc = Batbuoc;
    }

    public khoan_thu(int ID, String ten_khoan_thu, int Sotien, boolean Batbuoc) {
        this.ID = ID;
        this.ten_khoan_thu = ten_khoan_thu;
        this.Sotien = Sotien;
        this.Batbuoc = Batbuoc;
    }

    public khoan_thu(String ten_khoan_thu, int Sotien, boolean Batbuoc) {
        this.ten_khoan_thu = ten_khoan_thu;
        this.Sotien = Sotien;
        this.Batbuoc = Batbuoc;
    }
    
    
    
}
