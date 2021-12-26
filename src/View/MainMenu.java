
package View;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Model.*;
import DAO.*;
import java.sql.Date;
import javax.swing.JOptionPane;
    



public class MainMenu extends javax.swing.JFrame {
    //Cachli, khaibao
    DefaultTableModel tableModel, model, modelNk, modelFee, modelFeeInfor;
    List<Khaibao> khaibaoList = new ArrayList<>();
    List<Cachly> cachlyList = new ArrayList<>();
    List<Nhankhau> nhankhauList = new ArrayList<>();
    List<ql_dong_gop> donggopList = new ArrayList<>();
    List<khoan_thu> khoanthuList=new ArrayList<>();
    int input = -1;
    int optionCv=-1;
    int idCv;
    
   

    public MainMenu() {
        initComponents();
       tab2.setVisible(false);
       tab3.setVisible(false);
       tab4.setVisible(false);
       showMain();
       
       tableModel = (DefaultTableModel) tblCovid.getModel();
       model = (DefaultTableModel) tblLs.getModel();
       modelNk = (DefaultTableModel) tblNk.getModel();
       modelFee = (DefaultTableModel) tblFee.getModel();
       modelFeeInfor = (DefaultTableModel) tbnFeeInfor.getModel();
       setLocationRelativeTo(null);
       
    }
    
    public void showMain(){
        nhankhauList = NhankhauDAOImpl.findALL();
        khoanthuList = daokhoanthuImpl.findALL();
        khaibaoList = KhaibaoDAOImpl.findALL();
        cachlyList = CachlyDAOImpl.findALL();
        int NuCl = 0;
        int ReFee = 0;

        for (int i = 0; i < nhankhauList.size(); i++) {
            if (!CachlyDAOImpl.find(nhankhauList.get(i).getSoCMT()).isEmpty()) {
                NuCl = NuCl + 1;
            }
        }
        for (int i = 0; i < khoanthuList.size(); i++) {
            if (khoanthuList.get(i).isBatbuoc()) {
                ReFee = ReFee + 1;
            }
        }
        
        
        NuPopu.setText(String.valueOf(nhankhauList.size()));
        NuFee.setText(String.valueOf(khoanthuList.size()));
        NuIso.setText(String.valueOf(NuCl));
        NuDe.setText(String.valueOf(khaibaoList.size()));
        NuReFee.setText(String.valueOf(ReFee));

    }
    
    public void resetNk() {
        txtName.setText("");
        txtID.setText("");
        txtPn.setText("");
        txtDoB.setText("");
        txtNa.setText("");
        txtEth.setText("");
        txtPoB.setText("");
        cbGen.setSelectedIndex(0);
        txtDiachi.setText("");
        input=-1;
    }
    
    public void showNk() {
        nhankhauList = NhankhauDAOImpl.findALL();

        modelNk.setRowCount(0);

        for (Nhankhau Nhankhau : nhankhauList) {
            modelNk.addRow(new Object[]{
                Nhankhau.getHo_ten(),
                Nhankhau.getSoCMT(),
                Nhankhau.getNamSinh(),
                Nhankhau.getGioiTinh(),
                Nhankhau.getSDT()
            });
        }
    }
    
    public void showdong_gop() {
        donggopList = daoqlthuImpl.findALL();
        modelFee.setRowCount(0);
        for (ql_dong_gop ql_dong_gop : donggopList) {

            modelFee.addRow(new Object[]{
                ql_dong_gop.getSo_CMT(),
                ql_dong_gop.getHo_ten(),
                ql_dong_gop.getTen_khoan_thu(),
                ql_dong_gop.getSotien(),
                ql_dong_gop.getNgaynopDate()   
            });
        }
    }
    
    public void resetFee() {
        
        txtFeeName.setText("");
        txtFee.setText("");
        input=-1;
        ChooseFeeFrame.setInput(-1);
        ChooseNameFrame.setInput(-1);
        
    }
    
    public void resetFeeInfor() {
        txtCost.setText("");
        txtNameFeeinfor.setText("");
        Cbcom.setSelected(false);
        input =-1;
        
    }
    
     public void showKt(){
        khoanthuList=daokhoanthuImpl.findALL();
        modelFeeInfor.setRowCount(0);
        for(khoan_thu a: khoanthuList){
            modelFeeInfor.addRow(new Object[]{
                a.getTen_khoan_thu(),
                a.getSotien(),
                a.isBatbuoc()
            });
        }
    }
    
     private void showCv() {
        nhankhauList = NhankhauDAOImpl.findALL();

        tableModel.setRowCount(0);

        for (Nhankhau Nhankhau : nhankhauList) {
            tableModel.addRow(new Object[]{
                Nhankhau.getHo_ten(),
                Nhankhau.getSoCMT(),
                Nhankhau.getNamSinh(),
                Nhankhau.getGioiTinh(),
                !KhaibaoDAOImpl.find(Nhankhau.getSoCMT()).isEmpty(),
                !CachlyDAOImpl.find(Nhankhau.getSoCMT()).isEmpty()
                
            });
        }
        input = -1;
    }
     
      private void  showTest() {
        
        Nhankhau Nk = nhankhauList.get(input);
        cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());
            model.setRowCount(0);

            for (Cachly cachly : cachlyList) {
                model.addRow(new Object[]{
                    model.getRowCount() + 1,
                    cachly.getHinh_thuc_test(),
                    cachly.getKet_qua_test(),
                    cachly.getThoi_gian_test(),});
            }
    }
      
     public void resetCv() {
        txtbieu_hienpanel.setText("");
        txtVung_dichpanel.setText("");
        txtdateKBpanel.setText("");
        CbKetqua.setSelectedIndex(0);
        txtkieutestpanel.setText("");
        txtdateClpanel.setText("");
        txtphanloaipanel.setText("");
        txtDateTest.setText("");
        
    }
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInfor = new javax.swing.JPanel();
        layout1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        MenuLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        FeeLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BtnCovid = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelSW = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NuPopu = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        NuFee = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        NuReFee = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        NuDe = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        NuIso = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDoB = new javax.swing.JTextField();
        txtNa = new javax.swing.JTextField();
        txtPoB = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbGen = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEth = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPn = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnEditPo = new javax.swing.JButton();
        btnDeletePo = new javax.swing.JButton();
        btnAddPo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNk = new javax.swing.JTable();
        txtFindPo = new javax.swing.JTextField();
        CbFindPo = new javax.swing.JComboBox<>();
        btnFindPo = new javax.swing.JButton();
        tab3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        FeeTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFee = new javax.swing.JTable();
        txtFindFee = new javax.swing.JTextField();
        cbFindFee = new javax.swing.JComboBox<>();
        btnFindFee = new javax.swing.JButton();
        ReFee = new javax.swing.JButton();
        resetTblFee = new javax.swing.JButton();
        FeeInforTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbnFeeInfor = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtNameFeeinfor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        Cbcom = new javax.swing.JCheckBox();
        btnAddFeeInfor = new javax.swing.JButton();
        btnEditFeeInfor = new javax.swing.JButton();
        btnDeleteFeeInfor = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtFee = new javax.swing.JLabel();
        btnDeleteFee = new javax.swing.JButton();
        btnAddFee = new javax.swing.JButton();
        txtFeeName = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCovid = new javax.swing.JTable();
        btnFindCv = new javax.swing.JButton();
        CbFindCv = new javax.swing.JComboBox<>();
        txtFindCv = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtbieu_hienpanel = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtVung_dichpanel = new javax.swing.JTextField();
        txtdateKBpanel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnDeleteKbpanel = new javax.swing.JButton();
        btnSaveKbpanel = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtdateClpanel = new javax.swing.JTextField();
        txtphanloaipanel = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtkieutestpanel = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtDateTest = new javax.swing.JTextField();
        CbKetqua = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLs = new javax.swing.JTable();
        btnDeleteCl = new javax.swing.JButton();
        btnEditCl = new javax.swing.JButton();
        btnAddCl = new javax.swing.JButton();

        javax.swing.GroupLayout PanelInforLayout = new javax.swing.GroupLayout(PanelInfor);
        PanelInfor.setLayout(PanelInforLayout);
        PanelInforLayout.setHorizontalGroup(
            PanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
        PanelInforLayout.setVerticalGroup(
            PanelInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        layout1.setBackground(new java.awt.Color(0, 51, 153));
        layout1.setForeground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));

        MenuLabel.setBackground(new java.awt.Color(51, 102, 255));
        MenuLabel.setFont(new java.awt.Font("Arial Black", 3, 16)); // NOI18N
        MenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_home_white_24dp.png"))); // NOI18N
        MenuLabel.setText("Main Menu");
        MenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenu(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_supervised_user_circle_white_24dp.png"))); // NOI18N
        jLabel2.setText("Quarter Manager");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        FeeLabel.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        FeeLabel.setForeground(new java.awt.Color(255, 255, 255));
        FeeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_monetization_on_white_24dp.png"))); // NOI18N
        FeeLabel.setText("Fee, Contributions");
        FeeLabel.setMaximumSize(new java.awt.Dimension(160, 48));
        FeeLabel.setMinimumSize(new java.awt.Dimension(160, 48));
        FeeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FeeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(45, 136, 226));

        BtnCovid.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        BtnCovid.setForeground(new java.awt.Color(255, 255, 255));
        BtnCovid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_coronavirus_white_24dp.png"))); // NOI18N
        BtnCovid.setText("Covid-19");
        BtnCovid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCovidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnCovid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnCovid, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 65, 198));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_group_white_24dp.png"))); // NOI18N
        jLabel3.setText("Population");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPopu(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        PanelSW.setBackground(new java.awt.Color(204, 204, 204));

        tab1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel7.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_people_white_36dp.png"))); // NOI18N
        jLabel1.setText("POPULATION");

        NuPopu.setFont(new java.awt.Font("Arial", 1, 80)); // NOI18N
        NuPopu.setForeground(new java.awt.Color(255, 255, 255));
        NuPopu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NuPopu.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NuPopu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NuPopu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 204));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/outline_monetization_on_white_24dp.png"))); // NOI18N
        jLabel22.setText("FEE");

        NuFee.setFont(new java.awt.Font("Arial", 1, 75)); // NOI18N
        NuFee.setForeground(new java.awt.Color(255, 255, 255));
        NuFee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NuFee.setText("0");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("IN THERE:");

        NuReFee.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        NuReFee.setForeground(new java.awt.Color(255, 255, 255));
        NuReFee.setText("0");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("REQUIRED FEES");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(NuReFee, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NuFee, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NuFee, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NuReFee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(51, 153, 255));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("DECLARED");

        NuDe.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        NuDe.setForeground(new java.awt.Color(255, 255, 255));
        NuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NuDe.setText("0");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(NuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(51, 204, 255));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("ISOLATE");

        NuIso.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        NuIso.setForeground(new java.awt.Color(255, 255, 255));
        NuIso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NuIso.setText("0");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(NuIso, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NuIso, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        tab2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Private Information"));

        jLabel4.setText("Full name");

        jLabel5.setText("ID Card");

        jLabel6.setText("Date of Birth");

        jLabel7.setText("Gender");

        jLabel8.setText("Place of Birth");

        cbGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel9.setText("National");

        jLabel10.setText("Ethnic");

        jLabel11.setText("Phone Number");

        btnEditPo.setText("Edit");
        btnEditPo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPoActionPerformed(evt);
            }
        });

        btnDeletePo.setText("Delete");
        btnDeletePo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePoActionPerformed(evt);
            }
        });

        btnAddPo.setText("Add");
        btnAddPo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPoActionPerformed(evt);
            }
        });

        jLabel13.setText("Address");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDoB, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(txtPoB))
                            .addComponent(txtNa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                        .addComponent(txtEth))
                                    .addComponent(cbGen, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(btnDeletePo, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(0, 18, Short.MAX_VALUE)
                                        .addComponent(btnEditPo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddPo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDiachi))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(txtPn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel12))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtEth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeletePo)
                        .addComponent(btnEditPo)))
                .addContainerGap())
        );

        tblNk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full name", "ID Card", "Date of Birth", "Gender", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNk);

        CbFindPo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Card", "Full name" }));

        btnFindPo.setText("Find");
        btnFindPo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindPoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFindPo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CbFindPo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindPo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbFindPo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindPo)
                    .addComponent(txtFindPo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Tab3(evt);
            }
        });

        FeeTab.setBackground(new java.awt.Color(204, 204, 204));

        tblFee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Card", "Full name", "Fee", "Cost", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFee);

        cbFindFee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Fee", "ID Card" }));

        btnFindFee.setText("Find");
        btnFindFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindFeeActionPerformed(evt);
            }
        });

        ReFee.setText("Required Fee");
        ReFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReFeeActionPerformed(evt);
            }
        });

        resetTblFee.setText("Reset");
        resetTblFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTblFeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FeeTabLayout = new javax.swing.GroupLayout(FeeTab);
        FeeTab.setLayout(FeeTabLayout);
        FeeTabLayout.setHorizontalGroup(
            FeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(FeeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReFee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetTblFee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFindFee, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFindFee, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindFee)
                .addContainerGap())
        );
        FeeTabLayout.setVerticalGroup(
            FeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FeeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFindFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindFee)
                    .addComponent(txtFindFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReFee)
                    .addComponent(resetTblFee))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fee", FeeTab);

        FeeInforTab.setBackground(new java.awt.Color(204, 204, 204));

        tbnFeeInfor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fee Name", "Cost", "Compulsory ?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbnFeeInfor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeeInfor(evt);
            }
        });
        jScrollPane3.setViewportView(tbnFeeInfor);

        jLabel14.setText("Fee name");

        jLabel15.setText("Cost");

        Cbcom.setText("Compulsory");

        btnAddFeeInfor.setText("Add");
        btnAddFeeInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFeeInforActionPerformed(evt);
            }
        });

        btnEditFeeInfor.setText("Edit");
        btnEditFeeInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditFeeInforActionPerformed(evt);
            }
        });

        btnDeleteFeeInfor.setText("Delete");
        btnDeleteFeeInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFeeInforActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FeeInforTabLayout = new javax.swing.GroupLayout(FeeInforTab);
        FeeInforTab.setLayout(FeeInforTabLayout);
        FeeInforTabLayout.setHorizontalGroup(
            FeeInforTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FeeInforTabLayout.createSequentialGroup()
                .addGroup(FeeInforTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FeeInforTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FeeInforTabLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FeeInforTabLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(txtNameFeeinfor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FeeInforTabLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FeeInforTabLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FeeInforTabLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Cbcom))
                    .addGroup(FeeInforTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDeleteFeeInfor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditFeeInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddFeeInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );
        FeeInforTabLayout.setVerticalGroup(
            FeeInforTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
            .addGroup(FeeInforTabLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameFeeinfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cbcom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FeeInforTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteFeeInfor)
                    .addComponent(btnEditFeeInfor)
                    .addComponent(btnAddFeeInfor))
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Fee Information", FeeInforTab);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setText("Full name");

        jLabel17.setText("Fee");

        txtFee.setBackground(new java.awt.Color(255, 255, 255));
        txtFee.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFeeMouseClicked(evt);
            }
        });

        btnDeleteFee.setText("Delete");
        btnDeleteFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFeeActionPerformed(evt);
            }
        });

        btnAddFee.setText("Add");
        btnAddFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFeeActionPerformed(evt);
            }
        });

        txtFeeName.setBackground(new java.awt.Color(255, 255, 255));
        txtFeeName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFeeName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFeeNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(4, 4, 4)
                        .addComponent(txtFeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(btnDeleteFee)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddFee, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFeeName, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFee)
                    .addComponent(btnDeleteFee))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab4.setBackground(new java.awt.Color(204, 204, 204));

        tblCovid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full name", "ID Card", "Date of Birth", "Gender", "Declaration", "Isolation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCovid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCovidMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCovid);

        btnFindCv.setText("Find");
        btnFindCv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCvActionPerformed(evt);
            }
        });

        CbFindCv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Card", "Full name" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFindCv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CbFindCv, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindCv, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbFindCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFindCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCv))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Information for Medical Declaration"));

        jLabel18.setText("Unusual health signs:");

        jLabel19.setText("The epidemic area has passed:");

        txtdateKBpanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setText("Date:");

        btnDeleteKbpanel.setText("Delete");
        btnDeleteKbpanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKbpanelActionPerformed(evt);
            }
        });

        btnSaveKbpanel.setText("Save");
        btnSaveKbpanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKbpanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addGap(0, 164, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(btnDeleteKbpanel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSaveKbpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtdateKBpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtVung_dichpanel))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtbieu_hienpanel)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtbieu_hienpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVung_dichpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdateKBpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(38, 38, 38)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteKbpanel)
                    .addComponent(btnSaveKbpanel))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Medical Declaration", jPanel15);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Information for Medical Isolation"));

        jLabel27.setText("Isolaton level:");

        jLabel28.setText("Start date:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtphanloaipanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdateClpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtphanloaipanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtdateClpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Information for Covid-19 Test"));

        jLabel25.setText("Types of Covid-19 test:");

        jLabel26.setText("Result:");

        jLabel20.setText("Date");

        CbKetqua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negative", "Positive" }));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtkieutestpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateTest, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbKetqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtkieutestpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(CbKetqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtDateTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("History of Covid-19 Test"));

        tblLs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Types of Covid Test", "Result", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLs.getTableHeader().setReorderingAllowed(false);
        tblLs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblLs);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        btnDeleteCl.setText("Delete");
        btnDeleteCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClActionPerformed(evt);
            }
        });

        btnEditCl.setText("Edit");
        btnEditCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClActionPerformed(evt);
            }
        });

        btnAddCl.setText("Add");
        btnAddCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteCl)
                .addGap(18, 18, 18)
                .addComponent(btnEditCl)
                .addGap(18, 18, 18)
                .addComponent(btnAddCl)
                .addGap(10, 10, 10))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCl)
                    .addComponent(btnEditCl)
                    .addComponent(btnAddCl))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Medical Isolation", jPanel16);

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4Layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );

        javax.swing.GroupLayout PanelSWLayout = new javax.swing.GroupLayout(PanelSW);
        PanelSW.setLayout(PanelSWLayout);
        PanelSWLayout.setHorizontalGroup(
            PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSWLayout.setVerticalGroup(
            PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelSWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout1Layout = new javax.swing.GroupLayout(layout1);
        layout1.setLayout(layout1Layout);
        layout1Layout.setHorizontalGroup(
            layout1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelSW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout1Layout.setVerticalGroup(
            layout1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layout1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layout1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//menu chính
    private void btnMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu
        // TODO add your handling code here:
        
       layout1.setBackground(new Color(0,51,153));
       tab1.setVisible(true);
       tab2.setVisible(false);
       tab3.setVisible(false);
       tab4.setVisible(false);
       showMain();
       
       
       
       
    }//GEN-LAST:event_btnMenu

//menu ql thu phí
    private void FeeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FeeLabelMouseClicked
        // TODO add your handling code here:
        layout1.setBackground(new Color(0,102,204));
        tab3.setVisible(true);
        tab1.setVisible(false);
        tab2.setVisible(false);
        tab4.setVisible(false);
        showdong_gop();
        showKt();
    }//GEN-LAST:event_FeeLabelMouseClicked

//menu ql covid
    private void BtnCovidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCovidMouseClicked
        // TODO add your handling code here:
        layout1.setBackground(new Color(45,136,226));
        tab4.setVisible(true);
        tab1.setVisible(false);
        tab2.setVisible(false);
        tab3.setVisible(false);
        
        tableModel = (DefaultTableModel) tblCovid.getModel();
        model = (DefaultTableModel) tblLs.getModel();
        showCv();
    }//GEN-LAST:event_BtnCovidMouseClicked

//menu ql dân cư
    private void btnPopu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPopu
        // TODO add your handling code here:
        layout1.setBackground(new Color(0,65,198));
        tab2.setVisible(true);
        tab1.setVisible(false);
        tab3.setVisible(false);
        tab4.setVisible(false);
        showNk();
    }//GEN-LAST:event_btnPopu

// tìm dân cư
    private void btnFindPoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindPoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String text = txtFindPo.getText();
        if (text != null && text.length() > 0) {
            nhankhauList = NhankhauDAOImpl.find(text, CbFindPo.getSelectedIndex());
            System.out.println(CbFindPo.getSelectedIndex());
            modelNk.setRowCount(0);
            for (Nhankhau Nhankhau : nhankhauList) {
                modelNk.addRow(new Object[]{
                    Nhankhau.getHo_ten(),
                    Nhankhau.getSoCMT(),
                    Nhankhau.getNamSinh(),
                    Nhankhau.getGioiTinh(),
                    Nhankhau.getSDT()
                });
            }
        } else {
            showNk();
        }
      
    }//GEN-LAST:event_btnFindPoActionPerformed

// thêm dân cư
    private void btnAddPoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPoActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtName.getText()) || "".equals(txtID.getText()) || "".equals(txtNa.getText()) || "".equals(txtDoB.getText()) || "".equals(txtPoB.getText()) || "".equals(txtEth.getText())) {

            JOptionPane.showMessageDialog(this, "Please enter required information");
        } else {
            String SoCmt = txtID.getText();
            String Ho_ten = txtName.getText();
            System.out.println(Ho_ten);
            String namSinh = txtDoB.getText();
            String gioiTinh = cbGen.getSelectedItem().toString();
            String noiSinh = txtPoB.getText();
            String danToc = txtEth.getText();
            String quocTich = txtNa.getText();
            String diaChiHienNay = txtDiachi.getText();
            String SDT = txtPn.getText();
            int size = nhankhauList.size();
            if (size == 0) {
                Nhankhau Nk = new Nhankhau(SoCmt, Ho_ten, namSinh, gioiTinh, noiSinh, danToc, quocTich, diaChiHienNay, SDT);
                NhankhauDAOImpl.insert(Nk);
                showNk();
                resetNk();
            } else {
                for (int i = 0; i < size; i++) {
                    if (nhankhauList.get(i).getSoCMT().equals(SoCmt)) {
                        JOptionPane.showMessageDialog(this, "This information is existed!");
                    } else {
                        Nhankhau Nk = new Nhankhau(SoCmt, Ho_ten, namSinh, gioiTinh, noiSinh, danToc, quocTich, diaChiHienNay, SDT);
                        NhankhauDAOImpl.insert(Nk);
                        showNk();
                        resetNk();
                    }
                }
            }
        }

        

    }//GEN-LAST:event_btnAddPoActionPerformed

// sửa dân cư
    private void btnEditPoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPoActionPerformed
        // TODO add your handling code here:
        if (input >= 0) {
            String SoCmt = txtID.getText();
            String Ho_ten = txtName.getText();
            System.out.println(Ho_ten);
            String namSinh = txtDoB.getText();
            String gioiTinh = cbGen.getSelectedItem().toString();
            String noiSinh = txtPoB.getText();
            String danToc = txtEth.getText();
            String quocTich = txtNa.getText();
            String diaChiHienNay = txtDiachi.getText();
            String SDT = txtPn.getText();
            Nhankhau Nk = new Nhankhau(SoCmt, Ho_ten, namSinh, gioiTinh, noiSinh, danToc, quocTich, diaChiHienNay, SDT);
            NhankhauDAOImpl.update(Nk);
            showNk();
        } else {
            JOptionPane.showMessageDialog(this, "Please choose information to edit");
        }
        resetNk();             
    }//GEN-LAST:event_btnEditPoActionPerformed

// xóa nhân khẩu
    private void btnDeletePoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePoActionPerformed
        // TODO add your handling code here:
        if (input >= 0) {
            Nhankhau Nk = nhankhauList.get(input);
            khaibaoList = KhaibaoDAOImpl.find(Nk.getSoCMT());
            cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());
            donggopList = daoqlthuImpl.findcmt(Nk.getSoCMT());
      
            int option = JOptionPane.showConfirmDialog(this,
                    "Are you sure to delete this information ?",
                    "About",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (option == 0) {
                if (!khaibaoList.isEmpty()) {
                    KhaibaoDAOImpl.delete(Nk.getSoCMT());
                }
                if (!cachlyList.isEmpty()) {
                    CachlyDAOImpl.deletecmt(Nk.getSoCMT());
                }
                if (!donggopList.isEmpty()) {
                    daoqlthuImpl.deletecmt(Nk.getSoCMT());  
                    System.out.println("View.MainMenu.btnDeletePoActionPerformed");
                }
                
                NhankhauDAOImpl.delete(Nk);
                showNk();
            }
            resetNk();
        } else{
            JOptionPane.showMessageDialog(this, "Please choose information to delete");
        }
       
    }//GEN-LAST:event_btnDeletePoActionPerformed

// bảng đóng góp
    private void tblFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeeMouseClicked
      input = tblFee.getSelectedRow();
      if(input >=1){
          ql_dong_gop Dg = donggopList.get(input);
          txtFeeName.setText(Dg.getHo_ten());
          txtFee.setText(Dg.getTen_khoan_thu());
      }
    }//GEN-LAST:event_tblFeeMouseClicked

// bảng Covid
    private void tblCovidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCovidMouseClicked
        // TODO add your handling code here:
      resetCv();
        int selectedIndex = tblCovid.getSelectedRow();
        input = selectedIndex;
        if (selectedIndex >= 0) {
            Nhankhau Nk = nhankhauList.get(input);
            khaibaoList = KhaibaoDAOImpl.find(Nk.getSoCMT());
            cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());
            if (!khaibaoList.isEmpty()) {
                
                Khaibao Kb = khaibaoList.get(0);
                txtbieu_hienpanel.setText(Kb.getTrang_thai_suc_khoe());
                txtVung_dichpanel.setText(Kb.getDa_di_qua());
                String date = String.valueOf(Kb.getNgay_khai_bao());
                txtdateKBpanel.setText(date);
            }
            if (!cachlyList.isEmpty()) {
                Cachly Cal = cachlyList.get(cachlyList.size() - 1);
                if ("Negative".equals(Cal.getKet_qua_test())) {
                    CbKetqua.setSelectedIndex(0);
                } else {
                    CbKetqua.setSelectedIndex(1);
                }
                txtkieutestpanel.setText(Cal.getHinh_thuc_test());
                txtdateClpanel.setText(Cal.getTgian_bat_dau());
                txtphanloaipanel.setText(Cal.getMuc_do_cach_ly());
                txtDateTest.setText(Cal.getThoi_gian_test());
                showTest();

            }
        }
    }//GEN-LAST:event_tblCovidMouseClicked

// xóa khai báo
    private void btnDeleteKbpanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKbpanelActionPerformed
        // TODO add your handling code here:
        if (input >= 0) {
            Nhankhau Nk = nhankhauList.get(input);
            int option = JOptionPane.showConfirmDialog(this,
                    "Are you sure to delete this declaration ?",
                    "About",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (option == 0) {
                String SoCMT = Nk.getSoCMT();
                KhaibaoDAOImpl.delete(SoCMT);
                resetCv();
                showCv();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please choose declaration to delete !");
        }
        
     
    }//GEN-LAST:event_btnDeleteKbpanelActionPerformed

// lưu khai báo (thêm và sửa)
    private void btnSaveKbpanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKbpanelActionPerformed
        // TODO add your handling code here:
       if (input >= 0) {
            long millis = System.currentTimeMillis();
            Nhankhau Nk = nhankhauList.get(input);
            khaibaoList = KhaibaoDAOImpl.find(Nk.getSoCMT());
            String trang_thai_suc_khoe = txtbieu_hienpanel.getText();
            String da_di_qua = txtVung_dichpanel.getText();
            if (!khaibaoList.isEmpty()) {
                Khaibao Kb = new Khaibao(Nk.getSoCMT(), da_di_qua, trang_thai_suc_khoe);
                KhaibaoDAOImpl.update(Kb);
                showCv();
            } else {
                Date ngay_khai_bao = new java.sql.Date(millis);
                Khaibao Kb = new Khaibao(Nk.getSoCMT(), da_di_qua, trang_thai_suc_khoe, ngay_khai_bao);
                KhaibaoDAOImpl.insert(Kb);
                showCv();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please choose person to declare !");
        }
        
    }//GEN-LAST:event_btnSaveKbpanelActionPerformed

// bảng lich sử test covid
    private void tblLsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLsMouseClicked
        // TODO add your handling code here:
       int selectedIndex = tblLs.getSelectedRow();
          Nhankhau Nk = nhankhauList.get(input);
          cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());
          Cachly Cal = cachlyList.get(selectedIndex);
          optionCv=selectedIndex;
          idCv = Cal.getID();
    }//GEN-LAST:event_tblLsMouseClicked

// xóa cách ly, test
    private void btnDeleteClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClActionPerformed
        // TODO add your handling code here:
        if (optionCv >= 0) {
            CachlyDAOImpl.delete(idCv);
            optionCv = -1;
            showTest();
            showCv();
            resetCv();

        } else {
            if (input >= 0) {
                Nhankhau Nk = nhankhauList.get(input);
                cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());
                Cachly Cal = cachlyList.get(cachlyList.size() - 1);
                int option = JOptionPane.showConfirmDialog(this,
                        "Are you sure to delete this information ?",
                        "About",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == 0) {
                    CachlyDAOImpl.delete(Cal.getID());
                    showTest();
                    resetCv();
                    showCv();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please choose information to delete !");
            }
        }
        
    }//GEN-LAST:event_btnDeleteClActionPerformed

// sửa cách ly, test
    private void btnEditClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClActionPerformed
        // TODO add your handling code here:
        if (input >= 0) {
            Nhankhau Nk = nhankhauList.get(input);
            cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());
            Cachly Cal = cachlyList.get(cachlyList.size()-1);
            
            String tgian_bat_dau = txtdateClpanel.getText();
            String thoi_gian_test = txtDateTest.getText();
            String hinh_thuc_test = txtkieutestpanel.getText();
            String Ket_qua_test = CbKetqua.getSelectedItem().toString();
            String muc_do_cach_ly = txtphanloaipanel.getText();
            Cachly Cal1 = new Cachly(Cal.getID(), tgian_bat_dau, thoi_gian_test, hinh_thuc_test, Ket_qua_test, muc_do_cach_ly);
            CachlyDAOImpl.update(Cal1);
            
            showTest();
            showCv();
            resetCv();
        } else {
            JOptionPane.showMessageDialog(this, "Please choose information to edit");
        }
       
    }//GEN-LAST:event_btnEditClActionPerformed

// thêm cách ly, test
    private void btnAddClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClActionPerformed
        // TODO add your handling code here:
        if (input >= 0) {
            Nhankhau Nk = nhankhauList.get(input);
            cachlyList = CachlyDAOImpl.find(Nk.getSoCMT());

            String tgian_bat_dau = txtdateClpanel.getText();
            String thoi_gian_test = txtDateTest.getText();
            String hinh_thuc_test = txtkieutestpanel.getText();
            String Ket_qua_test = CbKetqua.getSelectedItem().toString();
            String muc_do_cach_ly = txtphanloaipanel.getText();
            if ("".equals(tgian_bat_dau) && "".equals(muc_do_cach_ly)) {
                JOptionPane.showMessageDialog(this, "Please enter required information");
            } else {
                Cachly Cal = new Cachly(Nk.getSoCMT(), tgian_bat_dau, thoi_gian_test, hinh_thuc_test, Ket_qua_test, muc_do_cach_ly);
                CachlyDAOImpl.insert(Cal);
                showTest();
                showCv();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please choose person to add information of isolation!");
        }

    }//GEN-LAST:event_btnAddClActionPerformed

// tìm Covid
    private void btnFindCvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCvActionPerformed
        // TODO add your handling code here:
        String text = txtFindCv.getText();
        if (text != null && text.length() > 0) {
            nhankhauList = NhankhauDAOImpl.find(text, CbFindCv.getSelectedIndex());
            System.out.println(CbFindPo.getSelectedIndex());
            tableModel.setRowCount(0);
            for (Nhankhau Nhankhau : nhankhauList) {
                tableModel.addRow(new Object[]{
                     Nhankhau.getHo_ten(),
                Nhankhau.getSoCMT(),
                Nhankhau.getNamSinh(),
                Nhankhau.getGioiTinh(),
                !KhaibaoDAOImpl.find(Nhankhau.getSoCMT()).isEmpty(),
                !CachlyDAOImpl.find(Nhankhau.getSoCMT()).isEmpty()
                });
            }
        } else {
            showCv();
        }
    }//GEN-LAST:event_btnFindCvActionPerformed

// xóa đóng góp
    private void btnDeleteFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFeeActionPerformed
        // TODO add your handling code here:
        if (input >= 0) {
            ql_dong_gop Fee = donggopList.get(input);
            int option = JOptionPane.showConfirmDialog(this,
                    "Are you sure to delete this information ?",
                    "About",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (option == 0) {
                daoqlthuImpl.delete(Fee);
                showdong_gop();
                
            }
            resetFee();
        } else {
            JOptionPane.showMessageDialog(this, "Please choose information to delete");
        }
        showdong_gop();
        resetFee();
    }//GEN-LAST:event_btnDeleteFeeActionPerformed

// thêm đóng góp
    private void btnAddFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFeeActionPerformed
        // TODO add your handling code here:
        if (ChooseNameFrame.getInput() >= 0 && ChooseFeeFrame.getInput() >= 0) {
            nhankhauList = NhankhauDAOImpl.findALL();
            nhankhauList = NhankhauDAOImpl.findALL();
            long millis = System.currentTimeMillis();
            Nhankhau Nk = nhankhauList.get(ChooseNameFrame.getInput());
            khoan_thu Kt = khoanthuList.get(ChooseFeeFrame.getInput());
            Date ngaynop = new java.sql.Date(millis);
            ql_dong_gop Dg = new ql_dong_gop(Nk.getSoCMT(), Kt.getID(), ngaynop);
            daoqlthuImpl.insert(Dg);
            showdong_gop();
 
        } else {
            JOptionPane.showMessageDialog(this, "Please enter required information");
        }
        resetFee();

    }//GEN-LAST:event_btnAddFeeActionPerformed

// tìm đóng góp
    private void btnFindFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindFeeActionPerformed
        // TODO add your handling code here:
        String text = txtFindFee.getText();
        if (text != null && text.length() > 0) {
            if(cbFindFee.getSelectedIndex()==0){
                donggopList = daoqlthuImpl.findname(text);
            } else if (cbFindFee.getSelectedIndex()==1) {
                donggopList = daoqlthuImpl.findThu(text);
            } else{
                donggopList = daoqlthuImpl.findcmt(text);
            }
            modelFee.setRowCount(0);
            for (ql_dong_gop ql_dong_gop : donggopList) {
                modelFee.addRow(new Object[]{
                    ql_dong_gop.getSo_CMT(),
                    ql_dong_gop.getHo_ten(),
                    ql_dong_gop.getTen_khoan_thu(),
                    ql_dong_gop.getSotien(),
                    ql_dong_gop.getNgaynopDate()
                });
            }
        } else {
            showdong_gop();
        }
    }//GEN-LAST:event_btnFindFeeActionPerformed

// xóa khoản thu
    private void btnDeleteFeeInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFeeInforActionPerformed
        // TODO add your handling code here:
        input = tbnFeeInfor.getSelectedRow();
        if (input >= 0) {
            int option = JOptionPane.showConfirmDialog(this,
                    "Are you sure to delete this fee ?\n"
                    + "This includes deleting list of people who have already paid this fee.",
                    "About",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (option == 0) {
                khoan_thu Kt = khoanthuList.get(input);
                donggopList = daoqlthuImpl.findThu(Kt.getTen_khoan_thu());
                if (!donggopList.isEmpty()) {
                    daoqlthuImpl.deleteIDkt(Kt.getID());
                }
                daokhoanthuImpl.delete(Kt);
                showKt();
                showdong_gop();
                resetFeeInfor();
            }
        }
    }//GEN-LAST:event_btnDeleteFeeInforActionPerformed

// sửa khoản thu
    private void btnEditFeeInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditFeeInforActionPerformed
        // TODO add your handling code here:
        String ten_khoan_phi = txtNameFeeinfor.getText();
        khoan_thu Kt = khoanthuList.get(input);
        int Sotien = Integer.parseInt(txtCost.getText());
        boolean Batbuoc = Cbcom.isSelected();

        if ("".equals(ten_khoan_phi) || "".equals(txtCost.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter required information!");
        } else if (Sotien <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid amount!");
        }else{
            khoan_thu Kt1 = new khoan_thu(Kt.getID() ,ten_khoan_phi, Sotien, Batbuoc);
            daokhoanthuImpl.update(Kt1);
            showKt();
            resetFeeInfor();
        }
    }//GEN-LAST:event_btnEditFeeInforActionPerformed

// thêm khoản thu
    private void btnAddFeeInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFeeInforActionPerformed
        // TODO add your handling code here:
        String ten_khoan_phi = txtNameFeeinfor.getText();
        String digit = "\\d";
        boolean Batbuoc = Cbcom.isSelected();
   
        if ("".equals(ten_khoan_phi) || "".equals(txtCost.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter required information!");
        } else if (txtCost.getText().matches(digit)) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        } else if( Integer.parseInt(txtCost.getText())<=0){
            JOptionPane.showMessageDialog(this, "Invalid amount!");
        } else if (khoanthuList.contains(ten_khoan_phi)) {
            JOptionPane.showMessageDialog(this, "Existed information!");
        }else{
            khoan_thu Kt = new khoan_thu(ten_khoan_phi, Integer.parseInt(txtCost.getText()), Batbuoc);
            daokhoanthuImpl.insert(Kt);
            showKt();
            resetFeeInfor();   
        }
        resetFeeInfor();

    }//GEN-LAST:event_btnAddFeeInforActionPerformed

// bảng khoản thu
    private void tblFeeInfor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeeInfor
        // TODO add your handling code here:
        input = tbnFeeInfor.getSelectedRow();
        if(input >=0){
            khoan_thu Kt = khoanthuList.get(input);
            txtNameFeeinfor.setText(Kt.getTen_khoan_thu());
            txtCost.setText(String.valueOf(Kt.getSotien()));
            Cbcom.setSelected(Kt.isBatbuoc());
            
        }
        
    }//GEN-LAST:event_tblFeeInfor

// bảng dân cư
    private void tblNkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNkMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblNk.getSelectedRow();
        input = selectedIndex;
        if (selectedIndex >= 0) {
            Nhankhau Nk = nhankhauList.get(input);
            txtName.setText(Nk.getHo_ten());
            txtID.setText(Nk.getSoCMT());
            txtPn.setText(Nk.getSDT());
            txtDoB.setText(Nk.getNamSinh());
            if ("Male".equals(Nk.getGioiTinh())) {
                cbGen.setSelectedIndex(0);
            } else {
                cbGen.setSelectedIndex(1);
            }
            txtNa.setText(Nk.getQuocTich());
            txtDiachi.setText(Nk.getDiaChiHienNay());
            txtEth.setText(Nk.getDanToc());
            txtPoB.setText(Nk.getNoiSinh());
        }
    }//GEN-LAST:event_tblNkMouseClicked

    private void txtFeeNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFeeNameMouseClicked
        // TODO add your handling code here:
        ChooseNameFrame Popup = new ChooseNameFrame();
        Popup.setVisible(true);
    }//GEN-LAST:event_txtFeeNameMouseClicked

    private void Tab3(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab3
        // TODO add your handling code here:
        if(ChooseNameFrame.getInput()>=0){
              nhankhauList = NhankhauDAOImpl.findALL();
              Nhankhau Nk = nhankhauList.get(ChooseNameFrame.getInput());
              txtFeeName.setText(Nk.getHo_ten());
        }
        if(ChooseFeeFrame.getInput()>=0){
            khoan_thu Kt = khoanthuList.get(ChooseFeeFrame.getInput());
            txtFee.setText(Kt.getTen_khoan_thu());
        }
    }//GEN-LAST:event_Tab3

    private void txtFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFeeMouseClicked
        // TODO add your handling code here:
        ChooseFeeFrame popup = new ChooseFeeFrame();
        popup.setVisible(true);
    }//GEN-LAST:event_txtFeeMouseClicked

    private void ReFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReFeeActionPerformed
        // TODO add your handling code here:
        donggopList = daoqlthuImpl.findBatbuoc(true);
        modelFee.setRowCount(0);
            for (ql_dong_gop ql_dong_gop : donggopList) {
                modelFee.addRow(new Object[]{
                    ql_dong_gop.getSo_CMT(),
                    ql_dong_gop.getHo_ten(),
                    ql_dong_gop.getTen_khoan_thu(),
                    ql_dong_gop.getSotien(),
                    ql_dong_gop.getNgaynopDate()
                });
            }
    }//GEN-LAST:event_ReFeeActionPerformed

    private void resetTblFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTblFeeActionPerformed
        // TODO add your handling code here:
        showdong_gop();
    }//GEN-LAST:event_resetTblFeeActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnCovid;
    private javax.swing.JComboBox<String> CbFindCv;
    private javax.swing.JComboBox<String> CbFindPo;
    private javax.swing.JComboBox<String> CbKetqua;
    private javax.swing.JCheckBox Cbcom;
    private javax.swing.JPanel FeeInforTab;
    private javax.swing.JLabel FeeLabel;
    private javax.swing.JPanel FeeTab;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JLabel NuDe;
    private javax.swing.JLabel NuFee;
    private javax.swing.JLabel NuIso;
    private javax.swing.JLabel NuPopu;
    private javax.swing.JLabel NuReFee;
    private javax.swing.JPanel PanelInfor;
    private javax.swing.JPanel PanelSW;
    private javax.swing.JButton ReFee;
    private javax.swing.JButton btnAddCl;
    private javax.swing.JButton btnAddFee;
    private javax.swing.JButton btnAddFeeInfor;
    private javax.swing.JButton btnAddPo;
    private javax.swing.JButton btnDeleteCl;
    private javax.swing.JButton btnDeleteFee;
    private javax.swing.JButton btnDeleteFeeInfor;
    private javax.swing.JButton btnDeleteKbpanel;
    private javax.swing.JButton btnDeletePo;
    private javax.swing.JButton btnEditCl;
    private javax.swing.JButton btnEditFeeInfor;
    private javax.swing.JButton btnEditPo;
    private javax.swing.JButton btnFindCv;
    private javax.swing.JButton btnFindFee;
    private javax.swing.JButton btnFindPo;
    private javax.swing.JButton btnSaveKbpanel;
    private javax.swing.JComboBox<String> cbFindFee;
    private javax.swing.JComboBox<String> cbGen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel layout1;
    private javax.swing.JButton resetTblFee;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    public javax.swing.JTable tblCovid;
    private javax.swing.JTable tblFee;
    public javax.swing.JTable tblLs;
    public javax.swing.JTable tblNk;
    private javax.swing.JTable tbnFeeInfor;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDateTest;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtEth;
    private javax.swing.JLabel txtFee;
    private javax.swing.JLabel txtFeeName;
    private javax.swing.JTextField txtFindCv;
    private javax.swing.JTextField txtFindFee;
    private javax.swing.JTextField txtFindPo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNa;
    public javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameFeeinfor;
    private javax.swing.JTextField txtPn;
    private javax.swing.JTextField txtPoB;
    private javax.swing.JTextField txtVung_dichpanel;
    private javax.swing.JTextField txtbieu_hienpanel;
    private javax.swing.JTextField txtdateClpanel;
    private javax.swing.JLabel txtdateKBpanel;
    private javax.swing.JTextField txtkieutestpanel;
    private javax.swing.JTextField txtphanloaipanel;
    // End of variables declaration//GEN-END:variables
}