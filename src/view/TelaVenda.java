package view;

import document.DocNumeric;
import document.DocSalario;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import model.bean.Produto;
import model.dao.PessoaDAO;
import org.apache.commons.lang3.StringUtils;

public class TelaVenda extends javax.swing.JFrame {
    
    MostrarProdutos mp = new MostrarProdutos();
    DocNumeric dn = new DocNumeric();
    PessoaDAO dao = new PessoaDAO();
    DocSalario ds = new DocSalario();
    Produto p = new Produto();
    
    NumberFormat df = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
    public TelaVenda() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutosVenda.getModel();
        
        jTableProdutosVenda.getTableHeader().setReorderingAllowed(false);
        jTableProdutosVenda.setSelectionBackground(new java.awt.Color(51,153,255));
        
        txtCodigo.requestFocusInWindow();
        txtQuantidade.setValue(1);
        
        jLabelFormatoInvalido.setVisible(false);
        
    }
    
    public void calcTroco(){
        if(!txtValorRecebido.getText().isEmpty() && !txtTotal.getText().isEmpty() && !txtValorRecebido.getText().equals(",") && !txtValorRecebido.getText().equals(".")){
            
            if( (StringUtils.countMatches(txtValorRecebido.getText(), ",")) + (StringUtils.countMatches(txtValorRecebido.getText(), ".")) > 1){
                jLabelFormatoInvalido.setVisible(true);
                return;
            }else{
                jLabelFormatoInvalido.setVisible(false);
            }
            
            Double vtotal = Double.parseDouble( txtTotal.getText().substring(3).replace(".", "").replace(",", ".") );
            Double vrecebido = Double.parseDouble( txtValorRecebido.getText().replace(",", ".") );
            Double vtroco = vrecebido-vtotal;

            txtTroco.setText(df.format(vtroco));
        
        }
    }
    
    public void calcTotal(){
        
        Double totalzao = 0.0;
        
        for (int row = 0; row < jTableProdutosVenda.getRowCount(); row++){

            Double dvalor = (Double.parseDouble( ( (String) jTableProdutosVenda.getValueAt(row, 5) ).substring(3).replace(".", "").replace(",", ".") ) );

            totalzao += dvalor;

        }

        txtTotal.setText(df.format(totalzao));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutosVenda = new javax.swing.JTable();
        txtPreco = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        txtValorRecebido = new javax.swing.JTextField();
        jLabelValorRecebido = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelNomeDoProduto = new javax.swing.JLabel();
        jButtonMostrarProdutos = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JSpinner();
        jLabelTroco = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();
        jLabelFormatoInvalido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Vendas");
        setUndecorated(true);

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFocusGained(evt);
            }
        });
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        jTableProdutosVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Código", "Nome", "Descrição", "Qtd", "Valor Unit.", "Total"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jTableProdutosVenda.setToolTipText(null);
    jScrollPane1.setViewportView(jTableProdutosVenda);

    txtPreco.setEditable(false);
    txtPreco.setBackground(new java.awt.Color(204, 204, 204));
    txtPreco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            txtPrecoFocusGained(evt);
        }
    });

    txtTotal.setEditable(false);
    txtTotal.setBackground(new java.awt.Color(204, 204, 204));
    txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

    jLabelCodigo.setText("Código");

    jLabelQuantidade.setText("Qtde");

    jLabelPreco.setText("Valor Unitário");

    jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabelTotal.setText("Total");

    txtNomeProduto.setEditable(false);
    txtNomeProduto.setBackground(new java.awt.Color(204, 204, 204));
    txtNomeProduto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    txtNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtNomeProdutoKeyReleased(evt);
        }
    });

    txtValorRecebido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtValorRecebido.setText("00,00");
    txtValorRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            txtValorRecebidoFocusGained(evt);
        }
    });
    txtValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtValorRecebidoKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtValorRecebidoKeyReleased(evt);
        }
    });

    jLabelValorRecebido.setText("Valor recebido (ex: 12,34)");

    jButtonFinalizar.setText("Finalizar");
    jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonFinalizarActionPerformed(evt);
        }
    });

    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonCancelarActionPerformed(evt);
        }
    });

    jLabelNomeDoProduto.setText("Nome do Produto");

    jButtonMostrarProdutos.setText("Mostrar Produtos");
    jButtonMostrarProdutos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonMostrarProdutosActionPerformed(evt);
        }
    });

    txtQuantidade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            txtQuantidadeFocusGained(evt);
        }
    });
    txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtQuantidadeKeyPressed(evt);
        }
    });

    jLabelTroco.setText("Troco");

    txtTroco.setEditable(false);
    txtTroco.setBackground(new java.awt.Color(204, 204, 204));
    txtTroco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

    jButtonAdicionar.setText("Adicionar");
    jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonAdicionarActionPerformed(evt);
        }
    });

    jButtonDeletar.setText("Deletar");
    jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonDeletarActionPerformed(evt);
        }
    });

    jLabelFormatoInvalido.setForeground(new java.awt.Color(255, 51, 51));
    jLabelFormatoInvalido.setText("Formato inválido*");

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel1.setText("VENDAS");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelValorRecebido)
                        .addComponent(jLabelFormatoInvalido))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTotal)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTroco)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jButtonFinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDeletar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigo)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonMostrarProdutos)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelQuantidade)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(74, 74, 74)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelPreco)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonAdicionar))))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabelNomeDoProduto)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(36, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(17, 17, 17)
            .addComponent(jLabelNomeDoProduto)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelQuantidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCodigo)
                                .addComponent(jButtonMostrarProdutos))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelPreco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAdicionar))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButtonDeletar)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonFinalizar)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelValorRecebido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelFormatoInvalido))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTroco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotal)
                                .addGap(4, 4, 4)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        
        if(txtCodigo.getText().equals("")){
            dao.checkProduto(p, -1);
            txtNomeProduto.setText(p.getNome());
            txtPreco.setText(df.format(p.getValor_Venda()));
        }else{
            dao.checkProduto(p, Integer.parseInt(txtCodigo.getText()));
            txtNomeProduto.setText(p.getNome());
            txtPreco.setText(df.format(p.getValor_Venda()));
        }
        
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtNomeProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoKeyReleased
//        readJTableVendaNome(txtNomeProduto.getText());
    }//GEN-LAST:event_txtNomeProdutoKeyReleased

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        new TelaPrincipalAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        new TelaPrincipalAdmin().setVisible(true);
        this.dispose();
        //PROVISÓRIO!!
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonMostrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarProdutosActionPerformed
        if(!mp.isVisible()){
            mp.setVisible(true);
        }else{
            mp.setVisible(false);
        }
        
    }//GEN-LAST:event_jButtonMostrarProdutosActionPerformed

    private void txtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusGained
        ((AbstractDocument) txtCodigo.getDocument()).setDocumentFilter(dn);
        dn.max = 50;
    }//GEN-LAST:event_txtCodigoFocusGained

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtPrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoFocusGained

    private void txtQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusGained
        
    }//GEN-LAST:event_txtQuantidadeFocusGained

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutosVenda.getModel();
        
        int Qtd = Integer.parseInt(txtQuantidade.getValue().toString());
        
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            if(txtNomeProduto.getText().equals("") || txtNomeProduto.getText().equals("Código incorreto!") || Qtd < 1 || txtQuantidade.equals("")){
                    JOptionPane.showMessageDialog(null, "Código de barras inválido!");
                    return;
            }else{
                    dao.checkProduto(p, Integer.parseInt(txtCodigo.getText()));

                    modelo.addRow(new Object[]{
                            p.getCOD_Produto(),
                            p.getNome(),
                            p.getDescricao(),
                            txtQuantidade.getValue(),
                            df.format(p.getValor_Venda()),
                            df.format(p.getValor_Venda() * Qtd)
                    });
                    
                    calcTotal();
                    calcTroco();
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutosVenda.getModel();
        
        int Qtd = Integer.parseInt(txtQuantidade.getValue().toString());
        
        if(txtNomeProduto.getText().equals("") || txtNomeProduto.getText().equals("Código incorreto!") || Qtd < 1 || txtQuantidade.equals("")){
                JOptionPane.showMessageDialog(null, "Código de barras inválido!");
                return;
        }else{
                dao.checkProduto(p, Integer.parseInt(txtCodigo.getText()));

                modelo.addRow(new Object[]{
                        p.getCOD_Produto(),
                        p.getNome(),
                        p.getDescricao(),
                        txtQuantidade.getValue(),
                        df.format(p.getValor_Venda()),
                        df.format(p.getValor_Venda() * Qtd)
                });
                
                calcTotal();
                calcTroco();
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutosVenda.getModel();
        
        if(jTableProdutosVenda.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum item foi selecionado!");
            return;
        }
        
        modelo.removeRow(jTableProdutosVenda.getSelectedRow());
        
        calcTotal();
        calcTroco();
        
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void txtValorRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebidoKeyReleased
        
        calcTroco();
        
    }//GEN-LAST:event_txtValorRecebidoKeyReleased

    private void txtValorRecebidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorRecebidoFocusGained
        
        ((AbstractDocument) txtValorRecebido.getDocument()).setDocumentFilter(ds);
        ds.max = 50;
        
    }//GEN-LAST:event_txtValorRecebidoFocusGained

    private void txtValorRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebidoKeyPressed
        
    }//GEN-LAST:event_txtValorRecebidoKeyPressed
    
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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonMostrarProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelFormatoInvalido;
    private javax.swing.JLabel jLabelNomeDoProduto;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JLabel jLabelValorRecebido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutosVenda;
    private javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JSpinner txtQuantidade;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorRecebido;
    // End of variables declaration//GEN-END:variables
}
