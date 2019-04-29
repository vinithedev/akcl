package view;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import model.bean.Pessoa;
import document.DocLimit;
import model.dao.PessoaDAO;
import document.DocFilter;
import document.DocSalario;
import java.io.IOException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.reflect.Array.getLength;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class AtualizarProfessor extends javax.swing.JFrame {
    
    public boolean isNumeric(int index){
        return Character.isDigit(txtTelefone.getText().charAt(index));
    }
    
    DocFilter df = new DocFilter();
    DocSalario ds = new DocSalario();
    
    public AtualizarProfessor() {
        initComponents();
        
        txtRg.setDocument(new DocLimit(50));
        txtEndereco.setDocument(new DocLimit(50));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupStatus = new javax.swing.ButtonGroup();
        jLabelNome = new javax.swing.JLabel();
        jLabelRG = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelSalario = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        jLabelFaixa = new javax.swing.JLabel();
        jComboBoxFaixa = new javax.swing.JComboBox<>();
        jLabelEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabelCadProf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        jRadioButtonAtivo = new javax.swing.JRadioButton();
        jRadioButtonInativo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Alterar Professor");
        setUndecorated(true);

        jLabelNome.setText("Nome");

        jLabelRG.setText("RG");

        jLabelCPF.setText("CPF");

        jLabelTelefone.setText("Telefone");

        jLabelSalario.setText("Salário (ex: 1234,56)");

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
        });
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        txtSalario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalarioFocusGained(evt);
            }
        });
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioKeyTyped(evt);
            }
        });

        jLabelFaixa.setText("Faixa");

        jComboBoxFaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branca", "Azul", "Amarela", "Vermelha", "Laranja", "Verde", "Roxa", "Marrom 1", "Marrom 2", "Preta" }));

        jLabelEndereco.setText("Endereço");

        jLabelCadProf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelCadProf.setText("ALTERAR PROFESSOR");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)*####-###*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusGained(evt);
            }
        });
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyReleased(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabelStatus.setText("Status");

        buttonGroupStatus.add(jRadioButtonAtivo);
        jRadioButtonAtivo.setText("Ativo");
        jRadioButtonAtivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonAtivoMouseClicked(evt);
            }
        });
        jRadioButtonAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAtivoActionPerformed(evt);
            }
        });

        buttonGroupStatus.add(jRadioButtonInativo);
        jRadioButtonInativo.setText("Inativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabelCadProf))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelNome)
                        .addGap(73, 73, 73)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelRG)
                        .addGap(85, 85, 85)
                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelCPF)
                        .addGap(81, 81, 81)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelTelefone)
                        .addGap(58, 58, 58)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelEndereco)
                        .addGap(54, 54, 54)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSalario)
                        .addGap(39, 39, 39)
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelFaixa)
                        .addGap(74, 74, 74)
                        .addComponent(jComboBoxFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabelCodigo)
                        .addGap(7, 7, 7)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelStatus)
                        .addGap(69, 69, 69)
                        .addComponent(jRadioButtonAtivo)
                        .addGap(50, 50, 50)
                        .addComponent(jRadioButtonInativo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButtonCancelar)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonConfirmar)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCadProf)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRG)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCPF)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSalario)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFaixa)
                    .addComponent(jComboBoxFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatus)
                    .addComponent(jRadioButtonAtivo)
                    .addComponent(jRadioButtonInativo))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped

    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(df);
        df.max = 200;
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyTyped

    }//GEN-LAST:event_txtSalarioKeyTyped

    private void txtSalarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyPressed

    }//GEN-LAST:event_txtSalarioKeyPressed

    private void txtSalarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyReleased

    }//GEN-LAST:event_txtSalarioKeyReleased

    private void txtSalarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalarioFocusGained
        ((AbstractDocument) txtSalario.getDocument()).setDocumentFilter(ds);
        ds.max = 50;
    }//GEN-LAST:event_txtSalarioFocusGained

    private void txtTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyReleased
        int caretPosition = txtTelefone.getCaretPosition();
        
        if( caretPosition == 4 && isNumeric(1) && isNumeric(2) && !isNumeric(4) && !isNumeric(5) && !isNumeric(6) && !isNumeric(7) && !isNumeric(8) && !isNumeric(10) && !isNumeric(11) && !isNumeric(12) && !isNumeric(13) ){
            txtTelefone.setCaretPosition(5);
        }
        
    }//GEN-LAST:event_txtTelefoneKeyReleased

    private void txtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneFocusGained

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed

    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyPressed
        
        int caretPosition = txtTelefone.getCaretPosition();
        
        if( caretPosition == 14 && isDigit(evt.getKeyChar()) && isNumeric(1) && isNumeric(2) && !isNumeric(4) && isNumeric(5) && isNumeric(6) && isNumeric(7) && isNumeric(8) && isNumeric(10) && isNumeric(11) && isNumeric(12) && isNumeric(13) ){
            StringBuilder str = new StringBuilder(txtTelefone.getText());
            
            str.setCharAt(4, txtTelefone.getText().charAt(5));
            str.setCharAt(5, txtTelefone.getText().charAt(6));
            str.setCharAt(6, txtTelefone.getText().charAt(7));
            str.setCharAt(7, txtTelefone.getText().charAt(8));
            str.setCharAt(8, txtTelefone.getText().charAt(10));
            // -
            str.setCharAt(10, txtTelefone.getText().charAt(11));
            str.setCharAt(11, txtTelefone.getText().charAt(12));
            str.setCharAt(12, txtTelefone.getText().charAt(13));
            str.setCharAt(13, evt.getKeyChar());
            
            txtTelefone.setText(str.toString());
        }
        
    }//GEN-LAST:event_txtTelefoneKeyPressed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        
        if(txtNome.getText().equals("") || txtRg.getText().equals("") || txtCpf.getText().equals("   .   .   -  ") || txtTelefone.getText().equals("(  )     -    ") || txtEndereco.getText().equals("") || txtSalario.getText().equals("") || jComboBoxFaixa.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
            return;
        }
        
        int occurance = StringUtils.countMatches(txtSalario.getText(), ".");
        int occurancedois = StringUtils.countMatches(txtSalario.getText(), ",");
        if(occurance + occurancedois > 1){
            JOptionPane.showMessageDialog(null, "Campo salário foi digitado incorretamente");
            return;
        }
        
        Pessoa p = new Pessoa();
        PessoaDAO dao = new PessoaDAO();

        p.setNome(txtNome.getText());
        p.setRG(txtRg.getText());
        p.setCPF(txtCpf.getText());
        p.setTelefone(txtTelefone.getText());
        p.setEndereco(txtEndereco.getText());

        //Converte "1234,56" para "1234.56"
        String tSalario = new String(txtSalario.getText());
        tSalario = tSalario.replaceAll(",",".");
        p.setSalario(Double.parseDouble(tSalario));

        p.setFaixa((String)jComboBoxFaixa.getSelectedItem());
        p.setCOD_Pessoa(Integer.parseInt(txtCodigo.getText()));

        if(jRadioButtonAtivo.isSelected() == true){
            p.setStatus(true);
        }
        else if(jRadioButtonAtivo.isSelected() == false){
            p.setStatus(false);
        }

        dao.updateProfessor(p);
        
        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonProfessores.doClick();
        this.dispose();

    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonProfessores.doClick();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonAtivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonAtivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAtivoMouseClicked

    private void jRadioButtonAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAtivoActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        
        StringBuilder sb = new StringBuilder(txtNome.getText());
        
        if(sb.length() > 0 && isLowerCase(sb.charAt(0))){
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            txtNome.setText(sb.toString());
        }
        
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AtualizarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupStatus;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    public javax.swing.JComboBox<String> jComboBoxFaixa;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCadProf;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelFaixa;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRG;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTelefone;
    public javax.swing.JRadioButton jRadioButtonAtivo;
    public javax.swing.JRadioButton jRadioButtonInativo;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JFormattedTextField txtCpf;
    public javax.swing.JTextField txtEndereco;
    public javax.swing.JTextField txtNome;
    public javax.swing.JTextField txtRg;
    public javax.swing.JTextField txtSalario;
    public javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
