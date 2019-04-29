package view;

import document.DocLimit;
import document.DocNumeric;
import document.DocSalario;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import model.bean.Produto;
import model.dao.PessoaDAO;
import org.apache.commons.lang3.StringUtils;

public class CadastrarProdutos extends javax.swing.JFrame {
    
    Produto p = new Produto();
    PessoaDAO dao = new PessoaDAO();
    DocSalario ds = new DocSalario();
    DocNumeric dn = new DocNumeric();
    
    public CadastrarProdutos() {
        initComponents();
        
        jRadioButtonInativo.setVisible(false);
        jRadioButtonAtivo.setVisible(false);
        jLabelSituacao.setVisible(false);
        ((AbstractDocument) txtCodigoDoProduto.getDocument()).setDocumentFilter(dn);
        txtNomeDoProduto.setDocument(new DocLimit(100));
        txtFornecedor.setDocument(new DocLimit(100));
        txtDescricao.setDocument(new DocLimit(300));
        ((AbstractDocument) txtValorDeCompra.getDocument()).setDocumentFilter(ds);
        ((AbstractDocument) txtValorDeVenda.getDocument()).setDocumentFilter(ds);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAtivoInativo = new javax.swing.ButtonGroup();
        jLabelNomeDoProduto = new javax.swing.JLabel();
        txtNomeDoProduto = new javax.swing.JTextField();
        jLabelValorDeCompra = new javax.swing.JLabel();
        txtValorDeCompra = new javax.swing.JTextField();
        jLabelValorDeVenda = new javax.swing.JLabel();
        txtValorDeVenda = new javax.swing.JTextField();
        jRadioButtonAtivo = new javax.swing.JRadioButton();
        jRadioButtonInativo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelFornecedor = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelCodigoDoProduto = new javax.swing.JLabel();
        txtCodigoDoProduto = new javax.swing.JTextField();
        jLabelSituacao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Cadastrar Produto");
        setUndecorated(true);

        jLabelNomeDoProduto.setText("Nome");

        txtNomeDoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDoProdutoActionPerformed(evt);
            }
        });

        jLabelValorDeCompra.setText("Valor de compra(ex: 12,34)");

        txtValorDeCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorDeCompraFocusGained(evt);
            }
        });

        jLabelValorDeVenda.setText("Valor de venda(ex: 12,34)");

        txtValorDeVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorDeVendaFocusGained(evt);
            }
        });

        buttonGroupAtivoInativo.add(jRadioButtonAtivo);
        jRadioButtonAtivo.setText("Ativo");

        buttonGroupAtivoInativo.add(jRadioButtonInativo);
        jRadioButtonInativo.setText("Inativo");
        jRadioButtonInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInativoActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jLabelDescricao.setText("Descrição");

        jLabelFornecedor.setText("Fornecedor");

        txtFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFornecedorActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Confirmar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelCodigoDoProduto.setText("Código");

        txtCodigoDoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoDoProdutoFocusGained(evt);
            }
        });
        txtCodigoDoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoDoProdutoActionPerformed(evt);
            }
        });

        jLabelSituacao.setText("Situação");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("CADASTRAR PRODUTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelFornecedor)
                                    .addComponent(jLabelValorDeCompra)
                                    .addComponent(jLabelValorDeVenda)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNomeDoProduto)
                                        .addComponent(jLabelCodigoDoProduto)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabelSituacao)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonAtivo)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonInativo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescricao)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeDoProduto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigoDoProduto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornecedor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorDeCompra))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorDeVenda))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabelSituacao))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonAtivo)
                        .addComponent(jRadioButtonInativo)))
                .addGap(28, 28, 28)
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonInativoActionPerformed

    private void txtNomeDoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDoProdutoActionPerformed

    private void txtFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFornecedorActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        TelaPrincipalAdmin principal = new TelaPrincipalAdmin();
        principal.setVisible(true);
//        principal.jButtonProdutos.doClick();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void txtCodigoDoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoDoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDoProdutoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        
        //Verificar campos obrigatórios
        if(txtNomeDoProduto.getText().equals("") || txtCodigoDoProduto.getText().equals("") || txtValorDeCompra.getText().equals("")  || txtValorDeVenda.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Todos os campos, exceto 'observação', devem ser preenchidos!");
            return;
        }
        
        //Verifica pontuação nos campos de R$
        String compraValor = txtValorDeCompra.getText();
        String vendaValor = txtValorDeVenda.getText();
        
        int compraOccurrencePonto = StringUtils.countMatches(compraValor, ".");
        int compraOccurrenceVirgula = StringUtils.countMatches(compraValor, ",");
        int vendaOccurrencePonto = StringUtils.countMatches(vendaValor, ".");
        int vendaOccurrenceVirgula = StringUtils.countMatches(vendaValor, ",");
        
        if( (compraOccurrencePonto+compraOccurrenceVirgula)>1 || (vendaOccurrencePonto+vendaOccurrenceVirgula)>1 ){
                JOptionPane.showMessageDialog(null, "Campo valor foi digitado incorretamente");
                return;
        }
        
        p.setNome(txtNomeDoProduto.getText());
        p.setCOD_Produto(Integer.parseInt(txtCodigoDoProduto.getText()));
        p.setFornecedor(txtFornecedor.getText());
        
        p.setValor_Compra(Double.parseDouble(compraValor.contains(",") ? compraValor.replaceAll(",", ".") : compraValor));
        p.setValor_Venda(Double.parseDouble(vendaValor.contains(",") ? vendaValor.replaceAll(",", ".") : vendaValor));
        
        p.setStatus(false);
        
//        p.setValor_Compra(Double.parseDouble(txtValorDeCompra.getText()));
//        p.setValor_Venda(Double.parseDouble(txtValorDeVenda.getText()));
        
//        if(jRadioButtonAtivo.isSelected() == true){
//            p.setStatus(true);
//        }
//        else if(jRadioButtonAtivo.isSelected() == false){
//            p.setStatus(false);
//        }
        
        p.setDescricao(txtDescricao.getText());
        
        dao.createProduto(p);
        
        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonProdutos.doClick();
        this.dispose();
        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void txtValorDeCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorDeCompraFocusGained
        ds.max = 50;
    }//GEN-LAST:event_txtValorDeCompraFocusGained

    private void txtValorDeVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorDeVendaFocusGained
        ds.max = 50;
    }//GEN-LAST:event_txtValorDeVendaFocusGained

    private void txtCodigoDoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoDoProdutoFocusGained
        dn.max = 200;
    }//GEN-LAST:event_txtCodigoDoProdutoFocusGained

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
            java.util.logging.Logger.getLogger(CadastrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAtivoInativo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCodigoDoProduto;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelNomeDoProduto;
    private javax.swing.JLabel jLabelSituacao;
    private javax.swing.JLabel jLabelValorDeCompra;
    private javax.swing.JLabel jLabelValorDeVenda;
    public javax.swing.JRadioButton jRadioButtonAtivo;
    public javax.swing.JRadioButton jRadioButtonInativo;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtCodigoDoProduto;
    public javax.swing.JTextArea txtDescricao;
    public javax.swing.JTextField txtFornecedor;
    public javax.swing.JTextField txtNomeDoProduto;
    public javax.swing.JTextField txtValorDeCompra;
    public javax.swing.JTextField txtValorDeVenda;
    // End of variables declaration//GEN-END:variables
}
