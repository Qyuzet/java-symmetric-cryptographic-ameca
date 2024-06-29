/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dashboard;

/**
 *
 * @author Riki AS
 */
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import jdk.jshell.spi.ExecutionControl;
public class frmDashboard extends javax.swing.JFrame {

    /**
     * Creates new form frmDashboard
     */
    String mode_ameca = "nan";
    String key_ameca = "";
    boolean keyStat;
    boolean flag_encrypt;
    boolean flag_decrypt;
    String searchData;
    //----------------------------------------------------
    public Statement st;
    public ResultSet rs;
    Connection cn = connect.dbConnection.openConnection();
    //---------------------------------------------------
    
    
    public frmDashboard() {
        
        initComponents();
        ShowData();
    }
    
    //-----------------------CRYPTOGRAPHY CLASS----------------------------------------------------------------

    public class SymmetricEncryption {
    private SecretKeySpec secretKey;
    private byte[] key;
    
    
    

    public SymmetricEncryption(String myKey) {
        key = myKey.getBytes(StandardCharsets.UTF_8);
        secretKey = new SecretKeySpec(key, "AES");
    }

    public String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There's a problem in the key or encryption");
        }
        return null;
    }

    public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "It is not the encrypted text");
        }
        return null;
    }
    }
    //-------------------------------------------------------------------------------------------------------------
    
    
    private void checkKey(){
            if (txtKey.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Set the keys first");
        }else{

            int keyLength = txtKey.getText().length();
            if(keyLength == 16 || keyLength == 24 || keyLength == 32){
                key_ameca = txtKey.getText();
                keyStat = true;

            }else{
                JOptionPane.showMessageDialog(null, "The key must be 16, 24 or 32 characters, your key is "+keyLength+" characters");
                keyStat = false;
            }
        }
        return;
        }
    
    private void Clear(){
    txtInput.setText("");
    txtOutput.setText("");
    txtSender.setText("");
    txtKey.setText("");


    btnProcess.setText("PROCESS");
    txtSender.setEditable(true);
    txtKey.setEditable(true);
    txtInput.setEditable(true);
    txtOutput.setEditable(true);
    }
    
    
    
    private void ShowData(){
    try{
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM dashboard");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("SENDER");
        model.addColumn("KEY");
        model.addColumn("PLAIN TEXT");
        model.addColumn("CIPHER TEXT");

        int no = 1;

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);

        while (rs.next()){
            Object[] data = {
                no++,
                rs.getString("sender"),
                rs.getString("enKey"),
                rs.getString("plain"),
                rs.getString("cipher")
            };

            model.addRow(data);
            tblData.setModel(model);
        }

    }catch (Exception e){

    }
    }
    
    
    private void FindData(){
        
        try{
            
            
            if (cmbSearch.getSelectedItem().toString().equals("Sender")){
                searchData = "sender";
            }else if (cmbSearch.getSelectedItem().toString().equals("Key")){
                searchData = "enKey";
            }else if (cmbSearch.getSelectedItem().toString().equals("Plain Text")){
                searchData = "plain";
            }
            
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM dashboard WHERE "
                    +searchData+
                    " LIKE '%"+ txtSearch.getText() + "%'");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("SENDER");
            model.addColumn("KEY");
            model.addColumn("PLAIN TEXT");
            model.addColumn("CIPHER TEXT");

            int no = 1;

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);

            while (rs.next()){
                Object[] data = {
                    no++,
                    rs.getString("sender"),
                    rs.getString("enKey"),
                    rs.getString("plain"),
                    rs.getString("cipher")
                };

                model.addRow(data);
                tblData.setModel(model);
            }

        }catch (Exception e){

    }
    }
    
          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbMode = new javax.swing.JComboBox<>();
        btnProcess = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSender = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        cmbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eos-64.png"))); // NOI18N
        jLabel1.setText(" A M E C A");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setText("Symmetric Cryptography Encryptor & Decryptor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-security-aes-32.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setText("AES Standard");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Developed by Riki A & Faza © 2023");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(180, 180, 180)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setOpaque(false);

        cmbMode.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        cmbMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encryption", "Decryption" }));
        cmbMode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModeActionPerformed(evt);
            }
        });

        btnProcess.setBackground(new java.awt.Color(51, 153, 255));
        btnProcess.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnProcess.setForeground(new java.awt.Color(255, 255, 255));
        btnProcess.setText("PROCESS");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 204, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 153, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 168, 255));
        jLabel2.setText("INPUT");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 173, 224));
        jLabel3.setText("OUTPUT");

        txtSender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenderActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-user-32.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-key-32.png"))); // NOI18N

        btnCancel.setBackground(new java.awt.Color(204, 204, 204));
        btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sender", "Key", "Plain Text" }));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel9.setText("Search Data : ");

        txtInput.setActionCommand("null");
        jScrollPane3.setViewportView(txtInput);

        jSeparator1.setForeground(new java.awt.Color(204, 221, 219));
        jSeparator1.setOpaque(true);

        txtOutput.setActionCommand("null");
        txtOutput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(txtOutput);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SENDER", "KEY", "PLAIN TEXT", "CIPHER TEXT"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblData);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSender, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtSender, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProcess)
                            .addComponent(btnClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenderActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        
        try{
            st = cn.createStatement();
            if (key_ameca.equals("")){
                checkKey();
            }else{
                if (txtSender.getText().equals("")){
                    checkKey();
                   JOptionPane.showMessageDialog(null, "Sender data cannot be empty", "Sender Data",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    
                    if (cmbMode.getSelectedItem().toString().equals("Encryption")){
                        
                        checkKey();
                        if (txtInput.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Please input text", "Input Text",JOptionPane.INFORMATION_MESSAGE);
                        return;
                        }else{
                            //aksi simpan data
                            if (btnProcess.getText() == "PROCESS"){

                                String key = key_ameca;
                                SymmetricEncryption encryption = new SymmetricEncryption(key_ameca);
                                String encryptedText = encryption.encrypt(txtInput.getText());
                                txtOutput.setText(encryptedText);


                                String sql = "INSERT INTO dashboard VALUES ('" + txtSender.getText() + 
                                        "','" + txtKey.getText()+ 
                                        "','" + txtInput.getText()+
                                        "','" + txtOutput.getText()+ "')";
                                st.executeUpdate(sql);
                                JOptionPane.showMessageDialog(null, "Text Encrypted");

                                ShowData();
                            }else{
                                //aksi ubah data
                                String update = "UPDATE dashboard SET sender = '"+ txtSender.getText()+ "'"+" WHERE cipher = '"+txtOutput.getText()+"'";

                                st.executeUpdate(update);
                                JOptionPane.showMessageDialog(null, "Data changed");
                                Clear();
                                ShowData();

                            }

                        }
                    }
                    else if (cmbMode.getSelectedItem().toString().equals("Decryption")){
                        
                        checkKey();
                        if (txtInput.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Please input text", "Input Text",JOptionPane.INFORMATION_MESSAGE);
                        return;
                        }else{
                            //aksi simpan data
                            if (btnProcess.getText() == "PROCESS"){

                                String key = key_ameca;
                                SymmetricEncryption encryption = new SymmetricEncryption(key_ameca);
                                String decryptedText = encryption.decrypt(txtInput.getText());
                                txtOutput.setText(decryptedText);


                                String sql = "INSERT INTO dashboard VALUES ('" + txtSender.getText() + 
                                        "','" + txtKey.getText()+ 
                                        "','" + txtOutput.getText()+
                                        "','" + txtInput.getText()+ "')";
                                st.executeUpdate(sql);
                                

                                ShowData();
                            }else{
                                //aksi ubah data
                                String update = "UPDATE dashboard SET sender = '"+ txtSender.getText()+ "'"+" WHERE cipher = '"+txtOutput.getText()+"'";

                                st.executeUpdate(update);
                                JOptionPane.showMessageDialog(null, "Data changed");
                                Clear();
                                
                                ShowData();

                            }

                        }
                    }

                }
                
       
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtInput.setText("");
        txtOutput.setText("");
        txtInput.setEditable(true);
        txtOutput.setEditable(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        
        txtSender.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        txtKey.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        txtInput.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        txtOutput.setText(tblData.getValueAt(tblData.getSelectedRow(), 4).toString());
        
        txtKey.setEditable(false);
        txtInput.setEditable(false);
        txtOutput.setEditable(false);
        btnProcess.setText("CHANGE");
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        if(txtSender.getText().equals("")){
        JOptionPane.showMessageDialog(this, "Please select the data to be deleted");
        }else{
            int jawab = JOptionPane.showConfirmDialog(null, "This data will be deleted, continue?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
            if (jawab == 0){
                try{
                    st = cn.createStatement();
                    String sql = "DELETE FROM dashboard WHERE cipher = '" + txtOutput.getText()+ "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data deleted successfully");
                    ShowData();
                    Clear();
                    
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        
        Clear();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        FindData();
    }//GEN-LAST:event_txtSearchKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnProcess;
    private javax.swing.JComboBox<String> cmbMode;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtOutput;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSender;
    // End of variables declaration//GEN-END:variables
}
