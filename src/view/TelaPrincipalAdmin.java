package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pessoa;
import model.dao.PessoaDAO;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.bean.Mensalidade;
import model.bean.Produto;
import model.bean.Usuario;

public class TelaPrincipalAdmin extends javax.swing.JFrame {
    
    PessoaDAO dao = new PessoaDAO();
    Mensalidade m = new Mensalidade();
    Pessoa p = new Pessoa();
    ConfirmarSenha csenha = new ConfirmarSenha();
    Usuario u = new Usuario();
    AtualizarUsuario attusu = new AtualizarUsuario();
    TelaSobre ts = new TelaSobre();
    
    String tipo = new String("");
    String tipoAux = new String("");
    String statusAux = new String("");
//    String redWord = "";
    String redWordDois = "";
    String menStatus = "";
    int xx,xy;
    
    //Inicializar
    public TelaPrincipalAdmin() {
        initComponents();
        
//        jButtonRelatorio.setVisible(false);
        DefaultTableModel modelo = (DefaultTableModel) jTPessoas.getModel();
        jTPessoas.setRowSorter(new TableRowSorter(modelo));
        jTPessoas.getTableHeader().setReorderingAllowed(false);
        jTPessoas.setRowSorter(null);
    }
    
    
//    Icon icon = new ImageIcon("/view/images/newimg.png");/////////////
    
    AtualizarProfessor profatt = new AtualizarProfessor();
    CadastroAluno cadalu = new CadastroAluno();
    AtualizarAluno aluatt = new AtualizarAluno();
    CadastrarProdutos cadprod = new CadastrarProdutos();
    AtualizarProdutos prodatt = new AtualizarProdutos();
    CadastrarUsuario cadusu = new CadastrarUsuario();
    
    //Mostrar double "Salário" no formato "R$ 1.234,56"
    NumberFormat df = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
    //Set Color
    void resetColor(JPanel panel){
            panel.setBackground(new Color(85,65,118));
    }

    //Reset Color
    void setColor(JPanel panel){
            panel.setBackground(new Color(64,43,100));
    }
    
    //Resize columns
    public void Resize(){
        
        jTPessoas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF );
        
        for (int column = 0; column < jTPessoas.getColumnCount(); column++){
            
            TableColumn tableColumn = jTPessoas.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = 0;
            TableCellRenderer rend = jTPessoas.getTableHeader().getDefaultRenderer();
            TableCellRenderer rendCol = tableColumn.getHeaderRenderer();
            if (rendCol == null) rendCol = rend;
            Component header = rendCol.getTableCellRendererComponent(jTPessoas, tableColumn.getHeaderValue(), false, false, 0, column);
            maxWidth = header.getPreferredSize().width;
            
            for (int row = 0; row < jTPessoas.getRowCount(); row++){
                
                TableCellRenderer cellRenderer = jTPessoas.getCellRenderer(row, column);
                Component c = jTPessoas.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jTPessoas.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
                
                //  We've exceeded the maximum width, no need to check other rows
                if (preferredWidth <= maxWidth){
                    preferredWidth = maxWidth;
                    break;
                }
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    
    //CorNaLinha
    public void CorNaLinha() {
        
        jTPessoas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                //Pinta de vermelho "Observações" do Aluno
                if(tipo == "Aluno" && column == 11){
                    setForeground(Color.RED);
                    return this;
                }
                
                //Pinta de vermelho "Menor" do Aluno e "Inativo" do Aluno e Professor
                if(tipo == "Aluno" && (value == redWordDois) && column == 10){
                    setForeground(Color.RED);
                }else if (tipo == "Professor" && (value == redWordDois) && column == 8){
                    setForeground(Color.RED);
                }else if(tipo == "Produto" && (value == "Inativo") && (column == 5)){
                    setForeground(Color.RED);
                }else{
                    setForeground(Color.BLACK);
                }
                
                jTPessoas.setSelectionBackground(new java.awt.Color(51,153,255));
                
                return label;
            }
        });
    }
    
    //Consultar Professor
    public void readJTableProfessor(String nome){
        
        DefaultTableModel modelo = (DefaultTableModel) jTPessoas.getModel();
        
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        PessoaDAO pdao = new PessoaDAO();
        
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("RG");
        modelo.addColumn("CPF");
        modelo.addColumn("Endereço");
        modelo.addColumn("Telefone");
        modelo.addColumn("Faixa");
        modelo.addColumn("Salário");
        
        modelo.addColumn("Status");
        redWordDois = "Inativo";
        
        for (Pessoa p : pdao.readProfessor(nome)){
            
            if(p.getStatus() == true){
                statusAux = "Ativo";
            }
            else if(p.getStatus() == false){
                statusAux = "Inativo";
            }
            
            modelo.addRow(new Object[]{
                p.getCOD_Pessoa(),
                p.getNome(),
                p.getRG(),
                p.getCPF(),
                p.getEndereco(),
                p.getTelefone(),
                p.getFaixa(),
                df.format(p.getSalario()),
                statusAux,
            });
        }
        CorNaLinha();
    }

    //Consultar Produtos
    public void readJTableProduto(String nome){
        
        DefaultTableModel modelo = (DefaultTableModel) jTPessoas.getModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        PessoaDAO pdao = new PessoaDAO();
        
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Valor Venda");
        modelo.addColumn("Descrição");
        modelo.addColumn("Fornecedor");
        modelo.addColumn("Status");
        modelo.addColumn("Valor Compra");
        
        for (Produto p : pdao.readProduto(nome)){
            
            if(p.getStatus() == true){
                statusAux = "Ativo";
            }
            else if(p.getStatus() == false){
                statusAux = "Inativo";
            }
            
            modelo.addRow(new Object[]{
                p.getCOD_Produto(),
                p.getNome(),
                df.format(p.getValor_Venda()),
                p.getDescricao(),
                p.getFornecedor(),
                statusAux,
                df.format(p.getValor_Compra()),
                    
            });
            
        }
        Resize();
        CorNaLinha();
    }
    
    //Consultar Aluno
    public void readJTableAluno(String nome){
        
        DefaultTableModel modelo = (DefaultTableModel) jTPessoas.getModel();
//        jTPessoas.setRowSorter(null);
        
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        PessoaDAO pdao = new PessoaDAO();
        Mensalidade m = new Mensalidade();
        
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Mensalidade");
        modelo.addColumn("RG");
        modelo.addColumn("CPF");
        modelo.addColumn("Data de Nascimento");
        modelo.addColumn("Idade");
        modelo.addColumn("Cidade");
        modelo.addColumn("Endereço");
        modelo.addColumn("Telefone");
        
        modelo.addColumn("Situação");
        redWordDois = "Inativo";
        
        modelo.addColumn("Observações");
        modelo.addColumn("Nome Responsável");
        modelo.addColumn("Tel. Responsável 1");
        modelo.addColumn("Tel. Responsável 2");
        modelo.addColumn("End. Responsável");
        modelo.addColumn("RG Responsável");
        modelo.addColumn("CPF Responsável");
        
        for (Pessoa p : pdao.readAluno(nome)){
            
            PessoaDAO dao = new PessoaDAO();
            
            dao.checkAge(p);
            
            if(p.getStatus() == true){
                statusAux = "Ativo";
            }
            else if(p.getStatus() == false){
                statusAux = "Inativo";
            }
            
            dao.retrieveMensalidade(p,m);
            
            menStatus = m.getDescricao();
            
            modelo.addRow(new Object[]{
                p.getCOD_Pessoa(),
                p.getNome(),
                menStatus,
                p.getRG(),
                p.getCPF(),
                p.getData_nasc(),
                p.getIdade(),
                p.getCidade(),
                p.getEndereco(),
                p.getTelefone(),
                statusAux,
                p.getObservacoes(),
                p.getNome_responsavel(),
                p.getTel_responsavel_um(),
                p.getTel_responsavel_dois(),
                p.getEndereco_responsavel(),
                p.getRG_responsavel(),
                p.getCPF_responsavel()
                    
            });
        }
        Resize();
        CorNaLinha();
    }
    
    //Consultar Usuário
    public void readJTableUsuario(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTPessoas.getModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        PessoaDAO pdao = new PessoaDAO();
        
        modelo.addColumn("Código");
        modelo.addColumn("Tipo");
        modelo.addColumn("Login");
        modelo.addColumn("Status");
        
        for (Usuario u : pdao.readUsuario()){
            
            if(u.getStatus() == true){
                statusAux = "Ativo";
            }
            else if(u.getStatus() == false){
                statusAux = "Inativo";
            }
            
            modelo.addRow(new Object[]{
                u.getCOD_Usuario(),
                u.getTusuario(),
                u.getLogin(),
                statusAux
            });
//            u.setTipo_usuario("");
        }
//        Resize();
//        CorNaLinha();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jPanelSidepane = new javax.swing.JPanel();
        jPanelCadastrar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelAlunos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelVendas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelProfessores = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelProdutos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelEventos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelUsuarios = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanelAlterar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPesquisarNome = new javax.swing.JTextField();
        jLabelPesquisarNome = new javax.swing.JLabel();
        jPanelUsuarios1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPessoas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Principal");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1366, 728));
        setMinimumSize(new java.awt.Dimension(1366, 728));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 728));

        jPanelBackground.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSidepane.setBackground(new java.awt.Color(54, 33, 89));
        jPanelSidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCadastrar.setBackground(new java.awt.Color(85, 65, 118));
        jPanelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelCadastrarMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar...");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadastrarLayout = new javax.swing.GroupLayout(jPanelCadastrar);
        jPanelCadastrar.setLayout(jPanelCadastrarLayout);
        jPanelCadastrarLayout.setHorizontalGroup(
            jPanelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanelCadastrarLayout.setVerticalGroup(
            jPanelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelSidepane.add(jPanelCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 120, 40));

        jPanelAlunos.setBackground(new java.awt.Color(85, 65, 118));
        jPanelAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelAlunosMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alunos");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlunosLayout = new javax.swing.GroupLayout(jPanelAlunos);
        jPanelAlunos.setLayout(jPanelAlunosLayout);
        jPanelAlunosLayout.setHorizontalGroup(
            jPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunosLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );
        jPanelAlunosLayout.setVerticalGroup(
            jPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlunosLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelAlunos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 360, -1));

        jPanelVendas.setBackground(new java.awt.Color(85, 65, 118));
        jPanelVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelVendasMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vendas...");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVendasLayout = new javax.swing.GroupLayout(jPanelVendas);
        jPanelVendas.setLayout(jPanelVendasLayout);
        jPanelVendasLayout.setHorizontalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 95, Short.MAX_VALUE))
        );
        jPanelVendasLayout.setVerticalGroup(
            jPanelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVendasLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 360, -1));

        jPanelProfessores.setBackground(new java.awt.Color(85, 65, 118));
        jPanelProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelProfessoresMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Professores");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProfessoresLayout = new javax.swing.GroupLayout(jPanelProfessores);
        jPanelProfessores.setLayout(jPanelProfessoresLayout);
        jPanelProfessoresLayout.setHorizontalGroup(
            jPanelProfessoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfessoresLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 86, Short.MAX_VALUE))
        );
        jPanelProfessoresLayout.setVerticalGroup(
            jPanelProfessoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfessoresLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelProfessores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 350, -1));

        jPanelProdutos.setBackground(new java.awt.Color(85, 65, 118));
        jPanelProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelProdutosMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Produtos");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProdutosLayout = new javax.swing.GroupLayout(jPanelProdutos);
        jPanelProdutos.setLayout(jPanelProdutosLayout);
        jPanelProdutosLayout.setHorizontalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 94, Short.MAX_VALUE))
        );
        jPanelProdutosLayout.setVerticalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProdutosLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 360, -1));

        jPanelEventos.setBackground(new java.awt.Color(85, 65, 118));
        jPanelEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelEventosMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Eventos...");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEventosLayout = new javax.swing.GroupLayout(jPanelEventos);
        jPanelEventos.setLayout(jPanelEventosLayout);
        jPanelEventosLayout.setHorizontalGroup(
            jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEventosLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 96, Short.MAX_VALUE))
        );
        jPanelEventosLayout.setVerticalGroup(
            jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEventosLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 360, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanelSidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 20));

        jPanelUsuarios.setBackground(new java.awt.Color(85, 65, 118));
        jPanelUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelUsuariosMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Usuários");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 360, -1));

        jPanelAlterar.setBackground(new java.awt.Color(85, 65, 118));
        jPanelAlterar.setPreferredSize(new java.awt.Dimension(130, 40));
        jPanelAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelAlterarMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Alterar...");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlterarLayout = new javax.swing.GroupLayout(jPanelAlterar);
        jPanelAlterar.setLayout(jPanelAlterarLayout);
        jPanelAlterarLayout.setHorizontalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanelAlterarLayout.setVerticalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelSidepane.add(jPanelAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 120, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("AKCL");
        jPanelSidepane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 166, 38));

        txtPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarNomeActionPerformed(evt);
            }
        });
        txtPesquisarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisarNomeKeyTyped(evt);
            }
        });
        jPanelSidepane.add(txtPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 10, 140, -1));

        jLabelPesquisarNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPesquisarNome.setForeground(new java.awt.Color(204, 204, 204));
        jLabelPesquisarNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisarNome.setText("Pesquisar");
        jPanelSidepane.add(jLabelPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 38));

        jPanelUsuarios1.setBackground(new java.awt.Color(85, 65, 118));
        jPanelUsuarios1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelUsuarios1MousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sobre");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarios1Layout = new javax.swing.GroupLayout(jPanelUsuarios1);
        jPanelUsuarios1.setLayout(jPanelUsuarios1Layout);
        jPanelUsuarios1Layout.setHorizontalGroup(
            jPanelUsuarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarios1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );
        jPanelUsuarios1Layout.setVerticalGroup(
            jPanelUsuarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarios1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelSidepane.add(jPanelUsuarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 360, -1));

        jPanelBackground.add(jPanelSidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 730));

        jTPessoas.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane2.setViewportView(jTPessoas);

    jPanelBackground.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 1110, 500));

    jPanel1.setBackground(new java.awt.Color(122, 72, 221));
    jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            jPanel1MouseDragged(evt);
        }
    });
    jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jPanel1MousePressed(evt);
        }
    });

    jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(204, 204, 204));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("Academia de Karatê Caminho Livre");

    jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(204, 204, 204));
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("AKCL");

    jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));

    jLabelX.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    jLabelX.setForeground(new java.awt.Color(54, 33, 89));
    jLabelX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelX.setText("X");
    jLabelX.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jLabelXMousePressed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(104, 104, 104)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(52, 52, 52)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 870, Short.MAX_VALUE)
                    .addComponent(jLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(67, Short.MAX_VALUE))
    );

    jPanelBackground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, -6, 1130, 240));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarNomeActionPerformed

    private void txtPesquisarNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarNomeKeyPressed
        
    }//GEN-LAST:event_txtPesquisarNomeKeyPressed

    private void txtPesquisarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarNomeKeyReleased
        if(tipo == "Professor"){
            readJTableProfessor(txtPesquisarNome.getText());
        }
        else if(tipo == "Aluno"){
            readJTableAluno(txtPesquisarNome.getText());
        }else if(tipo == "Produto"){
            readJTableProduto(txtPesquisarNome.getText());
        }
        
    }//GEN-LAST:event_txtPesquisarNomeKeyReleased

    private void txtPesquisarNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarNomeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarNomeKeyTyped

    private void jPanelAlunosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlunosMousePressed
//        setColor(jPanelAlunos);
//        resetColor(jPanelProdutos);
//        resetColor(jPanelProfessores);
//        resetColor(jPanelUsuarios);
//        
//        if(tipo != "Aluno"){
//            txtPesquisarNome.setText("");
//        }
//        
//        tipo = "Aluno";
//        readJTableAluno(txtPesquisarNome.getText());
//        
//        Resize();
    }//GEN-LAST:event_jPanelAlunosMousePressed

    private void jPanelProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProdutosMousePressed
        
//        setColor(jPanelProdutos);
//        resetColor(jPanelAlunos);
//        resetColor(jPanelProfessores);
//        resetColor(jPanelUsuarios);
//        
//        if(tipo != "Produto"){
//            txtPesquisarNome.setText("");
//        }
//        
//        tipo = "Produto";
//        readJTableProduto(txtPesquisarNome.getText());
//        
//        Resize();
    }//GEN-LAST:event_jPanelProdutosMousePressed

    private void jPanelVendasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVendasMousePressed
//        new TelaVenda().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jPanelVendasMousePressed

    private void jPanelProfessoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfessoresMousePressed
//        setColor(jPanelProfessores);
//        resetColor(jPanelAlunos);
//        resetColor(jPanelProdutos);
//        resetColor(jPanelUsuarios);
//        
//        
//        if(tipo != "Professor"){
//            txtPesquisarNome.setText("");
//        }
//        
//        tipo = "Professor";
//        readJTableProfessor(txtPesquisarNome.getText());
//        
//        Resize();
    }//GEN-LAST:event_jPanelProfessoresMousePressed

    private void jPanelEventosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEventosMousePressed
//    TelaEvento evento = new TelaEvento();
//    evento.setVisible(true);
//    this.dispose();
    }//GEN-LAST:event_jPanelEventosMousePressed

    private void jPanelCadastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCadastrarMousePressed
//        if(tipo == "Professor"){
//            new CadastroProfessor().setVisible(true);
//            this.dispose();
//        } else if(tipo == "Aluno"){
//            cadalu.setVisible(true);
//            cadalu.jRadioButtonAtivo.doClick();
//            this.dispose();
//        } else if(tipo == "Produto"){
//            cadprod.setVisible(true);
//            cadprod.jRadioButtonAtivo.doClick();
//            this.dispose();
//        } else if(tipo == "Usuario"){
//            cadusu.setVisible(true);
//            this.dispose();
//        }
//        
//        else{
//            JOptionPane.showMessageDialog(null, "Selecione uma opção!");
//        }
    }//GEN-LAST:event_jPanelCadastrarMousePressed

    private void jPanelUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUsuariosMousePressed
//        setColor(jPanelUsuarios);
//        resetColor(jPanelAlunos);
//        resetColor(jPanelProdutos);
//        resetColor(jPanelProfessores);
//        
//        
//        if(tipo != "Usuario"){
//            txtPesquisarNome.setText("");
//        }
//        
//        tipo = "Usuario";
//        readJTableUsuario();
//        
//        Resize();
    }//GEN-LAST:event_jPanelUsuariosMousePressed

    private void jPanelAlterarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlterarMousePressed
//        
//        int index = jTPessoas.getSelectedRow();
//        TableModel model = jTPessoas.getModel();
//        
//        if(jTPessoas.getSelectedRow() == -1) {
//            JOptionPane.showMessageDialog(null, "Selecione algo para ser atualizado!");
//            return;
//        }
//        
//        //Alterar Professor
//        else if(tipo == "Professor"){
//            
//            String cod_pes = model.getValueAt(index, 0).toString();
//            String nome = model.getValueAt(index, 1).toString();
//            String rg = model.getValueAt(index, 2).toString();
//            String cpf = model.getValueAt(index, 3).toString();
//            String endereco = model.getValueAt(index, 4).toString();
//            String telefone = model.getValueAt(index, 5).toString();
//            String faixa = model.getValueAt(index, 6).toString();
//            
//            //Converte "R$ 1.234,56" para "1234.56"
//            String salario = model.getValueAt(index, 7).toString();
//            salario = salario.replace(".","");
//            salario = salario.replace("R$","");
//            salario = salario.replace(" ","");
//            
//            String status = model.getValueAt(index, 8).toString();
//            
//            profatt.setVisible(true);
//            profatt.pack();
//            profatt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            
//            profatt.txtNome.setText(nome);
//            profatt.txtRg.setText(rg);
//            profatt.txtCpf.setText(cpf);
//            profatt.txtTelefone.setText(telefone);
//            profatt.txtEndereco.setText(endereco);
//            profatt.txtSalario.setText(salario);
//            profatt.jComboBoxFaixa.setSelectedItem(faixa);
//            profatt.txtCodigo.setText(cod_pes);
//            
//            if(status == "Ativo"){
//                profatt.jRadioButtonAtivo.doClick();
//            }
//            else if(status == "Inativo"){
//                profatt.jRadioButtonInativo.doClick();
//            }
//            this.dispose();
//            }
//        
//        //Alterar Aluno
//        else if(tipo == "Aluno"){
//            
//            String cod = model.getValueAt(index, 0).toString();
//            String nomealuno = model.getValueAt(index, 1).toString();
//            //Mensalidade
//            String rg = model.getValueAt(index, 3) == null ? "" : model.getValueAt(index, 3).toString();
//            String cpf = model.getValueAt(index, 4) == null ? "" : model.getValueAt(index, 4).toString();
//            String datadenascimento = model.getValueAt(index, 5).toString();
//            String idade = model.getValueAt(index, 6).toString();
//            String cidade = model.getValueAt(index, 7).toString();
//            String endereco = model.getValueAt(index, 8) == null ? "" : model.getValueAt(index, 8).toString();
//            String telefonealuno = model.getValueAt(index, 9) == null ? "" : model.getValueAt(index, 9).toString();
//            String situacao = model.getValueAt(index, 10).toString();
//            String observacao = model.getValueAt(index, 11) == null ? "" : model.getValueAt(index, 11).toString();
//            String nomeresponsavel = model.getValueAt(index, 12) == null ? "" : model.getValueAt(index, 12).toString();
//            String telresponsavelum = model.getValueAt(index, 13) == null ? "" : model.getValueAt(index, 13).toString();
//            String telresponsaveldois = model.getValueAt(index, 14) == null ? "" : model.getValueAt(index, 14).toString();
//            String endresponsavel = model.getValueAt(index, 15) == null ? "" : model.getValueAt(index, 15).toString();
//            String rgresponsavel = model.getValueAt(index, 16) == null ? "" : model.getValueAt(index, 16).toString();
//            String cpfresponsavel = model.getValueAt(index, 17) == null ? "" : model.getValueAt(index, 17).toString();
//            
//            aluatt.txtNomeDoAluno.setText(nomealuno);
//            aluatt.txtDataDeNascimentoAluno.setText(datadenascimento);
//            aluatt.txtRgAluno.setText(rg);
//            aluatt.txtCpfAluno.setText(cpf);
//            aluatt.txtCidadeAluno.setText(cidade);
//            aluatt.txtEnderecoAluno.setText(endereco);
//            aluatt.txtTelefoneAluno.setText(telefonealuno);
//            aluatt.txtNomeDoResponsavel.setText(nomeresponsavel);
//            aluatt.txtCpfResponsavel.setText(cpfresponsavel);
//            aluatt.txtRgResponsavel.setText(rgresponsavel);
//            aluatt.txtEnderecoResponsavel.setText(endresponsavel);
//            aluatt.txtTelefoneResponsavelUm.setText(telresponsavelum);
//            aluatt.txtTelefoneResponsavelDois.setText(telresponsaveldois);
//            aluatt.txtCodigo.setText(cod);
//            aluatt.txtObservacoes.setText(observacao);
//            
//            p.setCOD_Pessoa(Integer.parseInt(cod));
//            dao.retrieveMensalidade(p,m);
//            dao.retrieveDayAndValue(p);
//            
//            aluatt.jComboBoxMensalidadeDescricao.addItem("");
//            aluatt.jComboBoxMensalidadeDescricao.addItem(m.getDescricao());
//            
//            aluatt.jComboBoxDiaDeVencimento.setSelectedItem(Integer.toString(p.getDia_venc_mens()));
//            aluatt.txtValor.setText(Double.toString(p.getValor_mens()));
//            
//            if(situacao == "Ativo"){
//                aluatt.jRadioButtonAtivo.doClick();
//            }
//            else if(situacao == "Inativo"){
//                aluatt.jRadioButtonInativo.doClick();
//            }
//            
//            aluatt.setVisible(true);
//            aluatt.pack();
//            aluatt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            
//            if(Integer.parseInt(idade) >= 18){
//                aluatt.txtNomeDoResponsavel.setEnabled(false);
//                aluatt.txtCpfResponsavel.setEnabled(false);
//                aluatt.txtRgResponsavel.setEnabled(false);
//                aluatt.txtEnderecoResponsavel.setEnabled(false);
//                aluatt.txtTelefoneResponsavelUm.setEnabled(false);
//                aluatt.txtTelefoneResponsavelDois.setEnabled(false);
//                
//                aluatt.idade = "Maior";
//                
//            }else if(Integer.parseInt(idade) < 18){
//                aluatt.txtNomeDoResponsavel.setEnabled(true);
//                aluatt.txtCpfResponsavel.setEnabled(true);
//                aluatt.txtRgResponsavel.setEnabled(true);
//                aluatt.txtEnderecoResponsavel.setEnabled(true);
//                aluatt.txtTelefoneResponsavelUm.setEnabled(true);
//                aluatt.txtTelefoneResponsavelDois.setEnabled(true);
//                
//                aluatt.idade = "Menor";
//                
//            }
//            
//            this.dispose();
//        }
//        
//        //Alterar Produto
//        else if(tipo == "Produto"){
//            
//            String codigo = model.getValueAt(index, 0).toString();
//            String nome = model.getValueAt(index, 1).toString();
//            String vvenda = model.getValueAt(index, 2).toString();
//            String descricao = model.getValueAt(index, 3) == null ? "" : model.getValueAt(index, 3).toString();
//            String fornecedor = model.getValueAt(index, 4).toString();
//            String status = model.getValueAt(index, 5).toString();
//            String vcompra = model.getValueAt(index, 6).toString();
//            
//            //Converte "R$ 1.234,56" para "1234.56"
//            vvenda = vvenda.replace(".","");
//            vvenda = vvenda.replace("R$","");
//            vvenda = vvenda.replace(" ","");
//            vcompra = vcompra.replace(".","");
//            vcompra = vcompra.replace("R$","");
//            vcompra = vcompra.replace(" ","");
//            
//            prodatt.setVisible(true);
//            prodatt.pack();
//            prodatt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            
//            prodatt.txtNomeDoProduto.setText(nome);
//            prodatt.txtCodigoDoProduto.setText(codigo);
//            prodatt.txtFornecedor.setText(fornecedor);
//            prodatt.txtValorDeCompra.setText(vcompra);
//            prodatt.txtValorDeVenda.setText(vvenda);
//            
//            if(status == "Ativo"){
//                prodatt.jRadioButtonAtivo.doClick();
//            }
//            else if(status == "Inativo"){
//                prodatt.jRadioButtonInativo.doClick();
//            }
//            
//            prodatt.txtDescricao.setText(descricao);
//            
//            this.dispose();
//        }
//        
//        else if(tipo == "Usuario"){
//            
////            Usuario u = new Usuario();
////            PessoaDAO dao = new PessoaDAO();
//
//            String codigo = model.getValueAt(index, 0).toString();
//            String tipo = model.getValueAt(index, 1).toString();
//            String login = model.getValueAt(index, 2).toString();
//            String status = model.getValueAt(index, 3).toString();
//            
//            attusu.txtLogin.setText(login);
//            attusu.txtCodigo.setText(codigo);
//            
//            if(tipo.equals("Admin")){
//                attusu.jRadioButtonAdmin.doClick();
//            }else{
//                attusu.jRadioButtonFuncionario.doClick();
//            }
//            
//            if(status.equals("Ativo")){
//                attusu.jRadioButtonAtivo.doClick();
//            }else{
//                attusu.jRadioButtonInativo.doClick();
//            }
//            
////            u.setCOD_Usuario(Integer.parseInt(codigo));
////            u.setTipo_usuario(tipo);
////            u.setLogin(login);
//            
////            if(status.equals("Ativo")){
////                u.setStatus(true);
////            }else{
////                u.setStatus(false);
////            }
//            
//            attusu.setVisible(true);
////            csenha.pack();
////            csenha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            this.dispose();
//            
//        }
    }//GEN-LAST:event_jPanelAlterarMousePressed

    private void jLabelXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelXMousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);  
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        
        int index = jTPessoas.getSelectedRow();
        TableModel model = jTPessoas.getModel();
        
        if(jTPessoas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser atualizado!");
            return;
        }
        
        //Alterar Professor
        else if(tipo == "Professor"){
            
            String cod_pes = model.getValueAt(index, 0).toString();
            String nome = model.getValueAt(index, 1).toString();
            String rg = model.getValueAt(index, 2).toString();
            String cpf = model.getValueAt(index, 3).toString();
            String endereco = model.getValueAt(index, 4).toString();
            String telefone = model.getValueAt(index, 5).toString();
            String faixa = model.getValueAt(index, 6).toString();
            
            //Converte "R$ 1.234,56" para "1234.56"
            String salario = model.getValueAt(index, 7).toString();
            salario = salario.replace(".","");
            salario = salario.replace("R$","");
            salario = salario.replace(" ","");
            
            String status = model.getValueAt(index, 8).toString();
            
            profatt.setVisible(true);
            profatt.pack();
            profatt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            profatt.txtNome.setText(nome);
            profatt.txtRg.setText(rg);
            profatt.txtCpf.setText(cpf);
            profatt.txtTelefone.setText(telefone);
            profatt.txtEndereco.setText(endereco);
            profatt.txtSalario.setText(salario);
            profatt.jComboBoxFaixa.setSelectedItem(faixa);
            profatt.txtCodigo.setText(cod_pes);
            
            if(status == "Ativo"){
                profatt.jRadioButtonAtivo.doClick();
            }
            else if(status == "Inativo"){
                profatt.jRadioButtonInativo.doClick();
            }
            this.dispose();
            }
        
        //Alterar Aluno
        else if(tipo == "Aluno"){
            
            String cod = model.getValueAt(index, 0).toString();
            String nomealuno = model.getValueAt(index, 1) == null ? "" : model.getValueAt(index, 1).toString();
            //Mensalidade
            String rg = model.getValueAt(index, 3) == null ? "" : model.getValueAt(index, 3).toString();
            String cpf = model.getValueAt(index, 4) == null ? "" : model.getValueAt(index, 4).toString();
            String datadenascimento = model.getValueAt(index, 5).toString();
            String idade = model.getValueAt(index, 6).toString();
            String cidade = model.getValueAt(index, 7) == null ? "" : model.getValueAt(index, 7).toString();
            String endereco = model.getValueAt(index, 8) == null ? "" : model.getValueAt(index, 8).toString();
            String telefonealuno = model.getValueAt(index, 9) == null ? "" : model.getValueAt(index, 9).toString();
            String situacao = model.getValueAt(index, 10).toString();
            String observacao = model.getValueAt(index, 11) == null ? "" : model.getValueAt(index, 11).toString();
            String nomeresponsavel = model.getValueAt(index, 12) == null ? "" : model.getValueAt(index, 12).toString();
            String telresponsavelum = model.getValueAt(index, 13) == null ? "" : model.getValueAt(index, 13).toString();
            String telresponsaveldois = model.getValueAt(index, 14) == null ? "" : model.getValueAt(index, 14).toString();
            String endresponsavel = model.getValueAt(index, 15) == null ? "" : model.getValueAt(index, 15).toString();
            String rgresponsavel = model.getValueAt(index, 16) == null ? "" : model.getValueAt(index, 16).toString();
            String cpfresponsavel = model.getValueAt(index, 17) == null ? "" : model.getValueAt(index, 17).toString();
            
            aluatt.txtNomeDoAluno.setText(nomealuno);
            aluatt.txtDataDeNascimentoAluno.setText(datadenascimento);
            aluatt.txtRgAluno.setText(rg);
            aluatt.txtCpfAluno.setText(cpf);
            aluatt.txtCidadeAluno.setText(cidade);
            aluatt.txtEnderecoAluno.setText(endereco);
            aluatt.txtTelefoneAluno.setText(telefonealuno);
            aluatt.txtNomeDoResponsavel.setText(nomeresponsavel);
            aluatt.txtCpfResponsavel.setText(cpfresponsavel);
            aluatt.txtRgResponsavel.setText(rgresponsavel);
            aluatt.txtEnderecoResponsavel.setText(endresponsavel);
            aluatt.txtTelefoneResponsavelUm.setText(telresponsavelum);
            aluatt.txtTelefoneResponsavelDois.setText(telresponsaveldois);
            aluatt.txtCodigo.setText(cod);
            aluatt.txtObservacoes.setText(observacao);
            
            p.setCOD_Pessoa(Integer.parseInt(cod));
            dao.retrieveMensalidade(p,m);
            dao.retrieveDayAndValue(p);
            
            aluatt.jComboBoxMensalidadeDescricao.addItem("");
            aluatt.jComboBoxMensalidadeDescricao.addItem(m.getDescricao());
            
            aluatt.jComboBoxDiaDeVencimento.setSelectedItem(Integer.toString(p.getDia_venc_mens()));
            aluatt.txtValor.setText(Double.toString(p.getValor_mens()));
            
            if(situacao == "Ativo"){
                aluatt.jRadioButtonAtivo.doClick();
            }
            else if(situacao == "Inativo"){
                aluatt.jRadioButtonInativo.doClick();
            }
            
            aluatt.setVisible(true);
            aluatt.pack();
            aluatt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            if(Integer.parseInt(idade) >= 18){
                aluatt.txtNomeDoResponsavel.setEnabled(false);
                aluatt.txtCpfResponsavel.setEnabled(false);
                aluatt.txtRgResponsavel.setEnabled(false);
                aluatt.txtEnderecoResponsavel.setEnabled(false);
                aluatt.txtTelefoneResponsavelUm.setEnabled(false);
                aluatt.txtTelefoneResponsavelDois.setEnabled(false);
                
                aluatt.idade = "Maior";
                
            }else if(Integer.parseInt(idade) < 18){
                aluatt.txtNomeDoResponsavel.setEnabled(true);
                aluatt.txtCpfResponsavel.setEnabled(true);
                aluatt.txtRgResponsavel.setEnabled(true);
                aluatt.txtEnderecoResponsavel.setEnabled(true);
                aluatt.txtTelefoneResponsavelUm.setEnabled(true);
                aluatt.txtTelefoneResponsavelDois.setEnabled(true);
                
                aluatt.idade = "Menor";
                
            }
            
            this.dispose();
        }
        
        //Alterar Produto
        else if(tipo == "Produto"){
            
            String codigo = model.getValueAt(index, 0).toString();
            String nome = model.getValueAt(index, 1).toString();
            String vvenda = model.getValueAt(index, 2).toString();
            String descricao = model.getValueAt(index, 3) == null ? "" : model.getValueAt(index, 3).toString();
            String fornecedor = model.getValueAt(index, 4).toString();
            String status = model.getValueAt(index, 5).toString();
            String vcompra = model.getValueAt(index, 6).toString();
            
            //Converte "R$ 1.234,56" para "1234.56"
            vvenda = vvenda.replace(".","");
            vvenda = vvenda.replace("R$","");
            vvenda = vvenda.replace(" ","");
            vcompra = vcompra.replace(".","");
            vcompra = vcompra.replace("R$","");
            vcompra = vcompra.replace(" ","");
            
            prodatt.setVisible(true);
            prodatt.pack();
            prodatt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            prodatt.txtNomeDoProduto.setText(nome);
            prodatt.txtCodigoDoProduto.setText(codigo);
            prodatt.txtFornecedor.setText(fornecedor);
            prodatt.txtValorDeCompra.setText(vcompra);
            prodatt.txtValorDeVenda.setText(vvenda);
            
            if(status == "Ativo"){
                prodatt.jRadioButtonAtivo.doClick();
            }
            else if(status == "Inativo"){
                prodatt.jRadioButtonInativo.doClick();
            }
            
            prodatt.txtDescricao.setText(descricao);
            
            this.dispose();
        }
        
        else if(tipo == "Usuario"){
            
//            Usuario u = new Usuario();
//            PessoaDAO dao = new PessoaDAO();

            String codigo = model.getValueAt(index, 0).toString();
            String tipo = model.getValueAt(index, 1).toString();
            String login = model.getValueAt(index, 2).toString();
            String status = model.getValueAt(index, 3).toString();
            
            attusu.txtLogin.setText(login);
            attusu.txtCodigo.setText(codigo);
            
            if(tipo.equals("Admin")){
                attusu.jRadioButtonAdmin.doClick();
            }else{
                attusu.jRadioButtonFuncionario.doClick();
            }
            
            if(status.equals("Ativo")){
                attusu.jRadioButtonAtivo.doClick();
            }else{
                attusu.jRadioButtonInativo.doClick();
            }
            
//            u.setCOD_Usuario(Integer.parseInt(codigo));
//            u.setTipo_usuario(tipo);
//            u.setLogin(login);
            
//            if(status.equals("Ativo")){
//                u.setStatus(true);
//            }else{
//                u.setStatus(false);
//            }
            
            attusu.setVisible(true);
//            csenha.pack();
//            csenha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        setColor(jPanelAlunos);
        resetColor(jPanelProdutos);
        resetColor(jPanelProfessores);
        resetColor(jPanelUsuarios);
        
        if(tipo != "Aluno"){
            txtPesquisarNome.setText("");
        }
        
        tipo = "Aluno";
        readJTableAluno(txtPesquisarNome.getText());
        
        Resize();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        setColor(jPanelProdutos);
        resetColor(jPanelAlunos);
        resetColor(jPanelProfessores);
        resetColor(jPanelUsuarios);
        
        if(tipo != "Produto"){
            txtPesquisarNome.setText("");
        }
        
        tipo = "Produto";
        readJTableProduto(txtPesquisarNome.getText());
        
        Resize();
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        new TelaVenda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        setColor(jPanelProfessores);
        resetColor(jPanelAlunos);
        resetColor(jPanelProdutos);
        resetColor(jPanelUsuarios);
        
        
        if(tipo != "Professor"){
            txtPesquisarNome.setText("");
        }
        
        tipo = "Professor";
        readJTableProfessor(txtPesquisarNome.getText());
        
        Resize();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
    TelaEvento evento = new TelaEvento();
    evento.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        setColor(jPanelUsuarios);
        resetColor(jPanelAlunos);
        resetColor(jPanelProdutos);
        resetColor(jPanelProfessores);
        
        
        if(tipo != "Usuario"){
            txtPesquisarNome.setText("");
        }
        
        tipo = "Usuario";
        readJTableUsuario();
        
        Resize();
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        if(tipo == "Professor"){
            new CadastroProfessor().setVisible(true);
            this.dispose();
        } else if(tipo == "Aluno"){
            cadalu.setVisible(true);
            cadalu.jRadioButtonAtivo.doClick();
            this.dispose();
        } else if(tipo == "Produto"){
            cadprod.setVisible(true);
            cadprod.jRadioButtonAtivo.doClick();
            this.dispose();
        } else if(tipo == "Usuario"){
            cadusu.setVisible(true);
            this.dispose();
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma opção!");
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
        if(!ts.isVisible()){
            ts.setVisible(true);
        }else{
            ts.setVisible(false);
        }
    }//GEN-LAST:event_jLabel13MousePressed

    private void jPanelUsuarios1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUsuarios1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelUsuarios1MousePressed

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
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPesquisarNome;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAlterar;
    public javax.swing.JPanel jPanelAlunos;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelCadastrar;
    public javax.swing.JPanel jPanelEventos;
    public javax.swing.JPanel jPanelProdutos;
    public javax.swing.JPanel jPanelProfessores;
    private javax.swing.JPanel jPanelSidepane;
    public javax.swing.JPanel jPanelUsuarios;
    public javax.swing.JPanel jPanelUsuarios1;
    public javax.swing.JPanel jPanelVendas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTPessoas;
    private javax.swing.JTextField txtPesquisarNome;
    // End of variables declaration//GEN-END:variables

    
}
