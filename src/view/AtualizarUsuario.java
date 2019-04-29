package view;

import javax.swing.JOptionPane;
import model.bean.Usuario;
import model.dao.PessoaDAO;

public class AtualizarUsuario extends javax.swing.JFrame {
    
//    TelaPrincipalAdmin tpadm = new TelaPrincipalAdmin();
    
    
    public AtualizarUsuario() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabelLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jRadioButtonFuncionario = new javax.swing.JRadioButton();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        jRadioButtonAtivo = new javax.swing.JRadioButton();
        jRadioButtonInativo = new javax.swing.JRadioButton();
        txtSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Cadastrar Usuário");
        setUndecorated(true);

        jLabelLogin.setText("Login");

        txtLogin.setEditable(false);
        txtLogin.setBackground(new java.awt.Color(204, 204, 204));

        jLabelSenha.setText("Senha");

        jLabelTipo.setText("Tipo");

        buttonGroup1.add(jRadioButtonFuncionario);
        jRadioButtonFuncionario.setText("Funcionário");

        buttonGroup1.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setText("Admin");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));

        jLabelStatus.setText("Status");

        buttonGroup2.add(jRadioButtonAtivo);
        jRadioButtonAtivo.setText("Ativo");

        buttonGroup2.add(jRadioButtonInativo);
        jRadioButtonInativo.setText("Inativo");

        txtSenha.setEditable(false);
        txtSenha.setBackground(new java.awt.Color(204, 204, 204));
        txtSenha.setText("?");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("ALTERAR USUÁRIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jButtonConfirmar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCodigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelTipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabelSenha)
                                                    .addComponent(jLabelLogin))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                    .addComponent(txtSenha)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButtonFuncionario)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButtonAdmin)))))
                                .addGap(0, 7, Short.MAX_VALUE)))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonAtivo)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButtonInativo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonFuncionario)
                    .addComponent(jRadioButtonAdmin)
                    .addComponent(jLabelTipo))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatus)
                    .addComponent(jRadioButtonAtivo)
                    .addComponent(jRadioButtonInativo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        TelaPrincipalAdmin tpadm = new TelaPrincipalAdmin();
        
        tpadm.setVisible(true);
//        tpadm.jButtonUsuarios.doClick();
        this.dispose();
        
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        
        Usuario u = new Usuario();
        PessoaDAO dao = new PessoaDAO();

//        if(txtLogin.getText().equals("") || txtSenha.getText().equals("")){
//                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
//                return;
//        }

//        u.setLogin(txtLogin.getText().toLowerCase());
//        u.setSenha(txtSenha.getText());

        if(jRadioButtonFuncionario.isSelected()){
                u.setTipo_usuario("Funcionário");
        }else{
                u.setTipo_usuario("Admin");
        }
        
        if(jRadioButtonAtivo.isSelected()){
            u.setStatus(true);
        }else{
            u.setStatus(false);
        }
        
        u.setCOD_Usuario(Integer.parseInt(txtCodigo.getText()));

        dao.updateUsuario(u);

        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonUsuarios.doClick();
        this.dispose();
        
        
    }//GEN-LAST:event_jButtonConfirmarActionPerformed
    
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
            java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTipo;
    public javax.swing.JRadioButton jRadioButtonAdmin;
    public javax.swing.JRadioButton jRadioButtonAtivo;
    public javax.swing.JRadioButton jRadioButtonFuncionario;
    public javax.swing.JRadioButton jRadioButtonInativo;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtLogin;
    public javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
