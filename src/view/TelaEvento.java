package view;

import document.DocSalario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import model.bean.Evento;
import model.dao.PessoaDAO;
import org.apache.commons.lang3.StringUtils;

public class TelaEvento extends javax.swing.JFrame {
    
    Evento e = new Evento();
    PessoaDAO dao = new PessoaDAO();
    
    DocSalario ds = new DocSalario();
    
    public TelaEvento() {
        initComponents();
        
        jButtonExcluirEvento.setVisible(false);
        jButtonIncluirParticipante.setVisible(false);
        
        readJTableEvento();
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(ds);
        
        jTableEventos.getTableHeader().setReorderingAllowed(false);
        jTableEventos.setSelectionBackground(new java.awt.Color(51,153,255));
    }
    
    //Consultar Evento
    public void readJTableEvento(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableEventos.getModel();
        
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Data");
        modelo.addColumn("Horário");
        modelo.addColumn("Valor");
        modelo.addColumn("Descrição");
        
        for (Evento e : dao.readEvento()){
            
            modelo.addRow(new Object[]{
                e.getCOD_Evento(),
                e.getNome(),
                e.getData(),
                e.getHorario(),
                e.getValor(),
                e.getDescricao()
                    
            });
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSelecioneoEvento = new javax.swing.JLabel();
        jComboBoxSelecionarEvento = new javax.swing.JComboBox<>();
        jLabelDataDoEvento = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEventos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabelDescricao = new javax.swing.JLabel();
        jButtonIncluirParticipante = new javax.swing.JButton();
        jLabelEventosCadastrados = new javax.swing.JLabel();
        jButtonSalvarEvento = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelHorario = new javax.swing.JLabel();
        jButtonExcluirEvento = new javax.swing.JButton();
        txtDataDoEvento = new javax.swing.JFormattedTextField();
        txtHorario = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Eventos");
        setUndecorated(true);

        jLabelSelecioneoEvento.setText("Selecione o evento:");

        jComboBoxSelecionarEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Exame de Faixa", "Curso (Gashuko)" }));

        jLabelDataDoEvento.setText("Data do evento");

        jLabelValor.setText("Valor (ex: 123,45)");

        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
        });
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        jTableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(jTableEventos);

    txtDescricao.setColumns(20);
    txtDescricao.setRows(5);
    jScrollPane2.setViewportView(txtDescricao);

    jLabelDescricao.setText("Descrição:");

    jButtonIncluirParticipante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButtonIncluirParticipante.setText("Incluir Participante");
    jButtonIncluirParticipante.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonIncluirParticipanteActionPerformed(evt);
        }
    });

    jLabelEventosCadastrados.setText("Eventos Cadastrados");

    jButtonSalvarEvento.setText("Salvar Evento");
    jButtonSalvarEvento.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonSalvarEventoActionPerformed(evt);
        }
    });

    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonCancelarActionPerformed(evt);
        }
    });

    jLabelHorario.setText("Horário");

    jButtonExcluirEvento.setText("Excluir Evento");
    jButtonExcluirEvento.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonExcluirEventoActionPerformed(evt);
        }
    });

    try {
        txtDataDoEvento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    try {
        txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel1.setText("GERENCIAR EVENTOS");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(54, 54, 54)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelEventosCadastrados)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabelDescricao)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonIncluirParticipante)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonExcluirEvento)
                            .addGap(11, 11, 11)
                            .addComponent(jButtonCancelar)
                            .addGap(11, 11, 11)
                            .addComponent(jButtonSalvarEvento)
                            .addGap(7, 7, 7)))
                    .addContainerGap(66, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabelSelecioneoEvento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBoxSelecionarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(83, 83, 83)
                                            .addComponent(txtDataDoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabelHorario)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(144, 144, 144)
                                            .addComponent(jLabel1)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(45, 45, 45))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelDataDoEvento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelValor)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(25, 25, 25)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelSelecioneoEvento)
                .addComponent(jComboBoxSelecionarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelDataDoEvento)
                .addComponent(jLabelValor)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelHorario)
                .addComponent(txtDataDoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabelDescricao)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
            .addComponent(jLabelEventosCadastrados)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonIncluirParticipante)
                .addComponent(jButtonSalvarEvento)
                .addComponent(jButtonCancelar)
                .addComponent(jButtonExcluirEvento))
            .addContainerGap(50, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void jButtonIncluirParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirParticipanteActionPerformed
        CadastroParticipante participante = new CadastroParticipante();
        participante.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonIncluirParticipanteActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       TelaPrincipalAdmin principal = new TelaPrincipalAdmin();
       principal.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarEventoActionPerformed
        
        if(txtDataDoEvento.getText().contains(" ") || txtHorario.getText().contains(" ") || txtValor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo obrigatório não informado!");
            return;
        }
        
        String tValor = txtValor.getText();
        
        int occurance = StringUtils.countMatches(tValor, ".");
        int occurancedois = StringUtils.countMatches(tValor, ",");
        if(occurance + occurancedois > 1){
            JOptionPane.showMessageDialog(null, "Campo VALOR foi digitado incorretamente!");
            return;
        }
        
        if(tValor.contains(",")) {
            tValor = tValor.replaceAll(",", ".");
        }
        
        Double dValor = (double)Double.parseDouble(tValor);
        
        e.setNome((String)jComboBoxSelecionarEvento.getSelectedItem());
        e.setDescricao(txtDescricao.getText());
        e.setData(txtDataDoEvento.getText());
        e.setHorario(txtHorario.getText());
        e.setValor((dValor == null) ? 0 : dValor);
        
        dao.createEvent(e);
        
        txtDataDoEvento.setText("");
        txtHorario.setText("");
        txtValor.setText("0");
        txtDescricao.setText("");
        
        readJTableEvento();
//        jTableEventos.repaint();
        
    }//GEN-LAST:event_jButtonSalvarEventoActionPerformed

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        ds.max = 50;
    }//GEN-LAST:event_txtValorFocusGained

    private void jButtonExcluirEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirEventoActionPerformed
        
    }//GEN-LAST:event_jButtonExcluirEventoActionPerformed
    
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
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluirEvento;
    private javax.swing.JButton jButtonIncluirParticipante;
    private javax.swing.JButton jButtonSalvarEvento;
    private javax.swing.JComboBox<String> jComboBoxSelecionarEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDataDoEvento;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelEventosCadastrados;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelSelecioneoEvento;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEventos;
    private javax.swing.JFormattedTextField txtDataDoEvento;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
