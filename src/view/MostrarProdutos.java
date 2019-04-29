package view;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import model.dao.PessoaDAO;

public class MostrarProdutos extends javax.swing.JFrame {
    
    PessoaDAO pdao = new PessoaDAO();
    Produto p = new Produto();
    
    public MostrarProdutos() {
        initComponents();
        
//        DefaultTableModel modelo = (DefaultTableModel) jTableProdutosVenda.getModel();
        jTableProdutosVenda.getTableHeader().setReorderingAllowed(false);
        jTableProdutosVenda.setSelectionBackground(new java.awt.Color(51,153,255));
        readJTableProduto();
    }
    
    //Consultar Produtos
    public void readJTableProduto(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutosVenda.getModel();
        
        for (Produto p : pdao.readProdutoAtivo()){
            
            modelo.addRow(new Object[]{
                p.getCOD_Produto(),
                p.getNome(),
                df.format(p.getValor_Venda()),
                p.getDescricao()
            });
        }
    }
    
    NumberFormat df = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutosVenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Produtos");

        jTableProdutosVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Código", "Nome", "Valor", "Descrição"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jTableProdutosVenda.setToolTipText(null);
    jScrollPane1.setViewportView(jTableProdutosVenda);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(MostrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutosVenda;
    // End of variables declaration//GEN-END:variables
}
