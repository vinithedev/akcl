package view;

import com.mxrck.autocompleter.TextAutoCompleter;
import document.DocFilter;
import document.DocLimit;
import document.DocSalario;
import java.awt.Color;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import static jdk.nashorn.internal.objects.NativeMath.round;
import model.bean.Mensalidade;
import model.bean.Pessoa;
import model.dao.PessoaDAO;
import org.apache.commons.lang3.StringUtils;

public class CadastroAluno extends javax.swing.JFrame {
    
    String idade;
    
    public boolean isNumeric(int index){
        return Character.isDigit(txtTelefoneAluno.getText().charAt(index));
    }
    
    public boolean isNumericDois(int index){
        return Character.isDigit(txtTelefoneResponsavelUm.getText().charAt(index));
    }
    
    public boolean isNumericTres(int index){
        return Character.isDigit(txtTelefoneResponsavelDois.getText().charAt(index));
    }
    
    DocFilter df = new DocFilter();
    DocSalario ds = new DocSalario();
    
    public CadastroAluno() {
        initComponents();
        
        ((AbstractDocument) txtNomeDoAluno.getDocument()).setDocumentFilter(df);
        txtRgAluno.setDocument(new DocLimit(50));
        txtCidadeAluno.setDocument(new DocLimit(100));
        txtEnderecoAluno.setDocument(new DocLimit(200));
        ((AbstractDocument) txtNomeResponsavel.getDocument()).setDocumentFilter(df);
        txtRgResponsavel.setDocument(new DocLimit(50));
        txtEnderecoResponsavel.setDocument(new DocLimit(200));
        txtObservacoes.setDocument(new DocLimit(800));
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(ds);
        
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtCidadeAluno);
        textAutoCompleter.addItem("Apucarana");
        textAutoCompleter.addItem("Arapongas");
        textAutoCompleter.addItem("Jandaia do Sul");
        textAutoCompleter.addItem("Mandaguari");
        textAutoCompleter.addItem("Rolândia");
        textAutoCompleter.addItem("Marialva");
        textAutoCompleter.addItem("Cambé");
        textAutoCompleter.addItem("Londrina");
        textAutoCompleter.addItem("Astorga");
        textAutoCompleter.addItem("Sarandi");
        textAutoCompleter.addItem("Maringá");
        textAutoCompleter.addItem("Faxinal");
        textAutoCompleter.addItem("Ibiporã");
        textAutoCompleter.addItem("Mandaguaçu");
        textAutoCompleter.addItem("Cambira");
        textAutoCompleter.addItem("Califórnia");
        textAutoCompleter.addItem("Ortigueira");
        textAutoCompleter.addItem("Sabáudia");
        textAutoCompleter.addItem("Pitangueiras");
        textAutoCompleter.addItem("Sabáudia");
        textAutoCompleter.addItem("Aricanduva");
        textAutoCompleter.addItem("Rio Bom");
        textAutoCompleter.addItem("Barreiro");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSituacao = new javax.swing.ButtonGroup();
        txtNomeDoAluno = new javax.swing.JTextField();
        txtRgAluno = new javax.swing.JTextField();
        txtEnderecoAluno = new javax.swing.JTextField();
        jLabelNomeDoAluno = new javax.swing.JLabel();
        jLabelRgAluno = new javax.swing.JLabel();
        jLabelCpfAluno = new javax.swing.JLabel();
        jLabelDataDeDanscimentoAluno = new javax.swing.JLabel();
        jLabelEnderecoAluno = new javax.swing.JLabel();
        jLabelTelefoneAluno = new javax.swing.JLabel();
        jLabelNomeResponsavel = new javax.swing.JLabel();
        txtNomeResponsavel = new javax.swing.JTextField();
        txtEnderecoResponsavel = new javax.swing.JTextField();
        jLabelTelefoneResponsavelUm = new javax.swing.JLabel();
        jRadioButtonInativo = new javax.swing.JRadioButton();
        jRadioButtonAtivo = new javax.swing.JRadioButton();
        jLabelDadosDoResponsavel = new javax.swing.JLabel();
        jLabelEnderecoResponsavel = new javax.swing.JLabel();
        jLabelSituacao = new javax.swing.JLabel();
        jLabelTelefoneResponsavelDois = new javax.swing.JLabel();
        jScrollPaneObservacoes = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        jLabelObservacoes = new javax.swing.JLabel();
        jLabelCpfResponsavel = new javax.swing.JLabel();
        txtCidadeAluno = new javax.swing.JTextField();
        jLabelCidadeAluno = new javax.swing.JLabel();
        txtCpfAluno = new javax.swing.JFormattedTextField();
        txtDataDeNascimentoAluno = new javax.swing.JFormattedTextField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        txtRgResponsavel = new javax.swing.JTextField();
        jLabelRgResponsavel = new javax.swing.JLabel();
        txtCpfResponsavel = new javax.swing.JFormattedTextField();
        jLabelMensalidade = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jLabelDiaDeVencimento = new javax.swing.JLabel();
        txtTelefoneAluno = new javax.swing.JFormattedTextField();
        txtTelefoneResponsavelUm = new javax.swing.JFormattedTextField();
        txtTelefoneResponsavelDois = new javax.swing.JFormattedTextField();
        jComboBoxDiaDeVencimento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Cadastrar Aluno");
        setUndecorated(true);

        txtNomeDoAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeDoAlunoFocusGained(evt);
            }
        });
        txtNomeDoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDoAlunoActionPerformed(evt);
            }
        });
        txtNomeDoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeDoAlunoKeyReleased(evt);
            }
        });

        txtRgAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgAlunoActionPerformed(evt);
            }
        });

        jLabelNomeDoAluno.setText("Nome do Aluno");

        jLabelRgAluno.setText("RG");

        jLabelCpfAluno.setText("CPF");

        jLabelDataDeDanscimentoAluno.setText("Data de Nascimento (DD/MM/AAAA)");

        jLabelEnderecoAluno.setText("Endereço");

        jLabelTelefoneAluno.setText("Telefone");

        jLabelNomeResponsavel.setText("Nome do Responsável ");

        txtNomeResponsavel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeResponsavelFocusGained(evt);
            }
        });
        txtNomeResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeResponsavelActionPerformed(evt);
            }
        });
        txtNomeResponsavel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeResponsavelKeyReleased(evt);
            }
        });

        txtEnderecoResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoResponsavelActionPerformed(evt);
            }
        });

        jLabelTelefoneResponsavelUm.setText("Telefone de Contato 1");

        buttonGroupSituacao.add(jRadioButtonInativo);
        jRadioButtonInativo.setText("Inativo");

        buttonGroupSituacao.add(jRadioButtonAtivo);
        jRadioButtonAtivo.setText("Ativo");
        jRadioButtonAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAtivoActionPerformed(evt);
            }
        });

        jLabelDadosDoResponsavel.setText("Dados do Responsável");

        jLabelEnderecoResponsavel.setText("Endereço");

        jLabelSituacao.setText("Situação");

        jLabelTelefoneResponsavelDois.setText("Telefone de Contato 2");

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(5);
        jScrollPaneObservacoes.setViewportView(txtObservacoes);

        jLabelObservacoes.setText("Observações");

        jLabelCpfResponsavel.setText("CPF");

        txtCidadeAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCidadeAlunoFocusGained(evt);
            }
        });
        txtCidadeAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeAlunoActionPerformed(evt);
            }
        });

        jLabelCidadeAluno.setText("Cidade");

        try {
            txtCpfAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataDeNascimentoAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataDeNascimentoAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataDeNascimentoAlunoFocusLost(evt);
            }
        });
        txtDataDeNascimentoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDeNascimentoAlunoActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Confirmar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        txtRgResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgResponsavelActionPerformed(evt);
            }
        });

        jLabelRgResponsavel.setText("RG");

        try {
            txtCpfResponsavel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelMensalidade.setText("Mensalidade");

        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
        });

        jLabelValor.setText("Valor (ex: 123,45)");

        jLabelDiaDeVencimento.setText("Dia de Vencimento");

        try {
            txtTelefoneAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)*####-###*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefoneAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneAlunoFocusGained(evt);
            }
        });
        txtTelefoneAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneAlunoActionPerformed(evt);
            }
        });
        txtTelefoneAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneAlunoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoneAlunoKeyReleased(evt);
            }
        });

        try {
            txtTelefoneResponsavelUm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)*####-###*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefoneResponsavelUm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneResponsavelUmFocusGained(evt);
            }
        });
        txtTelefoneResponsavelUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneResponsavelUmActionPerformed(evt);
            }
        });
        txtTelefoneResponsavelUm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneResponsavelUmKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoneResponsavelUmKeyReleased(evt);
            }
        });

        try {
            txtTelefoneResponsavelDois.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)*####-###*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefoneResponsavelDois.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneResponsavelDoisFocusGained(evt);
            }
        });
        txtTelefoneResponsavelDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneResponsavelDoisActionPerformed(evt);
            }
        });
        txtTelefoneResponsavelDois.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneResponsavelDoisKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoneResponsavelDoisKeyReleased(evt);
            }
        });

        jComboBoxDiaDeVencimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "10", "20", "25" }));

        jLabel1.setText("Dados do Aluno");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("CADASTRAR ALUNO");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabelDadosDoResponsavel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelNomeDoAluno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(txtNomeDoAluno))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelDataDeDanscimentoAluno)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelCidadeAluno)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelEnderecoAluno)
                                        .addComponent(jLabelTelefoneAluno)
                                        .addComponent(jLabelRgAluno)
                                        .addComponent(jLabelCpfAluno))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDataDeNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelRgResponsavel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelEnderecoResponsavel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelTelefoneResponsavelDois)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelNomeResponsavel)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabelCpfResponsavel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelTelefoneResponsavelUm)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRgResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEnderecoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefoneResponsavelUm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefoneResponsavelDois, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabelObservacoes)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelSituacao)
                                    .addGap(22, 22, 22)
                                    .addComponent(jRadioButtonAtivo)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButtonInativo))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonLimpar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSalvar))
                                    .addComponent(jScrollPaneObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabelMensalidade))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelDiaDeVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxDiaDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeDoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeDoAluno)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataDeNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataDeDanscimentoAluno)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRgAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCpfAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCidadeAluno)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEnderecoAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefoneAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDadosDoResponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeResponsavel)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCpfResponsavel)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRgResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRgResponsavel)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEnderecoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEnderecoResponsavel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefoneResponsavelUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTelefoneResponsavelUm)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefoneResponsavelDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTelefoneResponsavelDois, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMensalidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValor)
                            .addComponent(jLabelDiaDeVencimento)
                            .addComponent(jComboBoxDiaDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelObservacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSituacao)
                            .addComponent(jRadioButtonAtivo)
                            .addComponent(jRadioButtonInativo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLimpar)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonSalvar)))
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeDoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDoAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDoAlunoActionPerformed

    private void txtRgAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgAlunoActionPerformed

    private void txtNomeResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeResponsavelActionPerformed

    private void txtEnderecoResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoResponsavelActionPerformed

    private void jRadioButtonAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAtivoActionPerformed

    private void txtCidadeAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeAlunoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonAlunos.doClick();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Pessoa p = new Pessoa();
        PessoaDAO dao = new PessoaDAO();
        Mensalidade m = new Mensalidade();
        
        String tValor = txtValor.getText();
        
        //Se maior de idade, somente txtEnderecoAluno e txtObservacoes são opcionais.
        if(idade == "Maior" && ( txtNomeDoAluno.getText().equals("") || txtDataDeNascimentoAluno.getText().equals("  /  /    ") || txtRgAluno.getText().equals("") || txtCpfAluno.getText().equals("   .   .   -  ") || txtCidadeAluno.getText().equals("")  || txtTelefoneAluno.getText().equals("(  )     -    ")  || txtValor.getText().equals("") ) ){
            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");
            return;
        // Se menor de idade, txtRgAluno, txtCpfAluno, txtEnderecoAluno, txtTelefoneAluno, txtTelefoneResponsavelDois e txtObservacoes são opcionais.
        }else if(idade == "Menor" && ( txtNomeDoAluno.getText().equals("") || txtDataDeNascimentoAluno.getText().equals("  /  /    ") || txtCidadeAluno.getText().equals("") || txtNomeResponsavel.getText().equals("") || txtCpfResponsavel.getText().equals("   .   .   -  ") || txtRgResponsavel.getText().equals("") || txtEnderecoResponsavel.getText().equals("") || txtTelefoneResponsavelUm.getText().equals("(  )     -    ") || txtValor.getText().equals("")  ) ){
            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");
            return;
        }else if(idade != "Menor" && idade != "Maior"){
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento!");
            return;
        }else{
        
        int occurrence = StringUtils.countMatches(tValor, ".");
        int occurancedois = StringUtils.countMatches(tValor, ",");
        if(occurrence + occurancedois > 1){
            JOptionPane.showMessageDialog(null, "Campo valor foi digitado incorretamente");
            return;
        }
        
        //Qualquer aluno
        p.setNome(txtNomeDoAluno.getText());
        p.setData_nasc(txtDataDeNascimentoAluno.getText());
        p.setRG(txtRgAluno.getText());
        p.setCPF(txtCpfAluno.getText().equals("   .   .   -  ") ? "" : txtCpfAluno.getText());
        p.setCidade(txtCidadeAluno.getText());
        p.setEndereco(txtEnderecoAluno.getText());
        p.setTelefone(txtTelefoneAluno.getText().equals("(  )     -    ") ? "" : txtTelefoneAluno.getText());
        
        //Somente menores de idade
        p.setNome_responsavel(txtNomeResponsavel.getText());
        p.setCPF_responsavel(txtCpfResponsavel.getText().equals("   .   .   -  ") ? "" : txtCpfResponsavel.getText());
        p.setRG_responsavel(txtRgResponsavel.getText());
        p.setEndereco_responsavel(txtEnderecoResponsavel.getText());
        p.setTel_responsavel_um(txtTelefoneResponsavelUm.getText().equals("(  )     -    ") ? "" : txtTelefoneResponsavelUm.getText());
        p.setTel_responsavel_dois(txtTelefoneResponsavelDois.getText().equals("(  )     -    ") ? "" : txtTelefoneResponsavelDois.getText());
        
        //Mensalidade
        if(tValor.contains(",")) {
            tValor = tValor.replaceAll(",", ".");
        }
        
        Double dValor = (double)Double.parseDouble(tValor);
        
        p.setValor_mens(dValor);
        p.setDia_venc_mens (Integer.parseInt((String)jComboBoxDiaDeVencimento.getSelectedItem()));
        p.setObservacoes(txtObservacoes.getText());
        
        if(jRadioButtonAtivo.isSelected() == true){
            p.setStatus(true);
        }
        else if(jRadioButtonAtivo.isSelected() == false){
            p.setStatus(false);
        }
        
        dao.createAluno(p, m);
        
        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonAlunos.doClick();
        this.dispose();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        ((AbstractDocument) txtNomeDoAluno.getDocument()).setDocumentFilter(null);
        ((AbstractDocument) txtCidadeAluno.getDocument()).setDocumentFilter(null);
        ((AbstractDocument) txtNomeResponsavel.getDocument()).setDocumentFilter(null);
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(null);
        
        txtNomeDoAluno.setText("");
        txtRgAluno.setText("");
        txtCpfAluno.setText("");
        txtDataDeNascimentoAluno.setText("");
        txtCidadeAluno.setText("");
        txtEnderecoAluno.setText("");
        txtTelefoneAluno.setText("");
        txtNomeResponsavel.setText("");
        txtCpfResponsavel.setText("");
        txtEnderecoResponsavel.setText("");
        txtTelefoneResponsavelUm.setText("");
        txtTelefoneResponsavelDois.setText("");
        txtObservacoes.setText("");
        txtValor.setText("");
        jComboBoxDiaDeVencimento.setSelectedIndex(0);
        
        ((AbstractDocument) txtNomeDoAluno.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) txtCidadeAluno.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) txtNomeResponsavel.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(ds);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void txtRgResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgResponsavelActionPerformed

    private void txtDataDeNascimentoAlunoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataDeNascimentoAlunoFocusLost
        
        if(!txtDataDeNascimentoAluno.getText().contains(" ")){
            
            Pessoa p = new Pessoa();
            PessoaDAO dao = new PessoaDAO();

            p.setData_nasc(txtDataDeNascimentoAluno.getText());

            dao.checkAge(p);
            
            if(p.getIdade() >= 18){
                txtNomeResponsavel.setText(" ");
                txtNomeResponsavel.setEnabled(false);
                txtCpfResponsavel.setText("");
                txtCpfResponsavel.setEnabled(false);
                txtRgResponsavel.setText("");
                txtRgResponsavel.setEnabled(false);
                txtEnderecoResponsavel.setText("");
                txtEnderecoResponsavel.setEnabled(false);
                txtTelefoneResponsavelUm.setText("");
                txtTelefoneResponsavelUm.setEnabled(false);
                txtTelefoneResponsavelDois.setText("");
                txtTelefoneResponsavelDois.setEnabled(false);
                
                idade = "Maior";
                
            }else if(p.getIdade() < 18){
                txtNomeResponsavel.setEnabled(true);
                txtCpfResponsavel.setEnabled(true);
                txtRgResponsavel.setEnabled(true);
                txtEnderecoResponsavel.setEnabled(true);
                txtTelefoneResponsavelUm.setEnabled(true);
                txtTelefoneResponsavelDois.setEnabled(true);
                
                idade = "Menor";

            }
            
        }
        
    }//GEN-LAST:event_txtDataDeNascimentoAlunoFocusLost

    private void txtDataDeNascimentoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDeNascimentoAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDeNascimentoAlunoActionPerformed

    private void txtNomeDoAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDoAlunoKeyReleased
        
        StringBuilder sb = new StringBuilder(txtNomeDoAluno.getText());
        
        if(sb.length() > 0 && isLowerCase(sb.charAt(0))){
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            txtNomeDoAluno.setText(sb.toString());
        }
        
    }//GEN-LAST:event_txtNomeDoAlunoKeyReleased

    private void txtTelefoneAlunoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneAlunoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneAlunoFocusGained

    private void txtTelefoneAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneAlunoActionPerformed

    }//GEN-LAST:event_txtTelefoneAlunoActionPerformed

    private void txtTelefoneAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneAlunoKeyPressed

        int caretPosition = txtTelefoneAluno.getCaretPosition();

        if( caretPosition == 14 && isDigit(evt.getKeyChar()) && isNumeric(1) && isNumeric(2) && !isNumeric(4) && isNumeric(5) && isNumeric(6) && isNumeric(7) && isNumeric(8) && isNumeric(10) && isNumeric(11) && isNumeric(12) && isNumeric(13) ){
            StringBuilder str = new StringBuilder(txtTelefoneAluno.getText());

            str.setCharAt(4, txtTelefoneAluno.getText().charAt(5));
            str.setCharAt(5, txtTelefoneAluno.getText().charAt(6));
            str.setCharAt(6, txtTelefoneAluno.getText().charAt(7));
            str.setCharAt(7, txtTelefoneAluno.getText().charAt(8));
            str.setCharAt(8, txtTelefoneAluno.getText().charAt(10));
            // -
            str.setCharAt(10, txtTelefoneAluno.getText().charAt(11));
            str.setCharAt(11, txtTelefoneAluno.getText().charAt(12));
            str.setCharAt(12, txtTelefoneAluno.getText().charAt(13));
            str.setCharAt(13, evt.getKeyChar());

            txtTelefoneAluno.setText(str.toString());
        }

    }//GEN-LAST:event_txtTelefoneAlunoKeyPressed

    private void txtTelefoneAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneAlunoKeyReleased

        int caretPosition = txtTelefoneAluno.getCaretPosition();

        if( caretPosition == 4 && isNumeric(1) && isNumeric(2) && !isNumeric(4) && !isNumeric(5) && !isNumeric(6) && !isNumeric(7) && !isNumeric(8) && !isNumeric(10) && !isNumeric(11) && !isNumeric(12) && !isNumeric(13) ){
            txtTelefoneAluno.setCaretPosition(5);
        }

    }//GEN-LAST:event_txtTelefoneAlunoKeyReleased

    private void txtTelefoneResponsavelUmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelUmFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneResponsavelUmFocusGained

    private void txtTelefoneResponsavelUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelUmActionPerformed

    }//GEN-LAST:event_txtTelefoneResponsavelUmActionPerformed

    private void txtTelefoneResponsavelUmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelUmKeyPressed

        int caretPosition = txtTelefoneResponsavelUm.getCaretPosition();

        if( caretPosition == 14 && isDigit(evt.getKeyChar()) && isNumericDois(1) && isNumericDois(2) && !isNumericDois(4) && isNumericDois(5) && isNumericDois(6) && isNumericDois(7) && isNumericDois(8) && isNumericDois(10) && isNumericDois(11) && isNumericDois(12) && isNumericDois(13) ){
            StringBuilder str = new StringBuilder(txtTelefoneResponsavelUm.getText());

            str.setCharAt(4, txtTelefoneResponsavelUm.getText().charAt(5));
            str.setCharAt(5, txtTelefoneResponsavelUm.getText().charAt(6));
            str.setCharAt(6, txtTelefoneResponsavelUm.getText().charAt(7));
            str.setCharAt(7, txtTelefoneResponsavelUm.getText().charAt(8));
            str.setCharAt(8, txtTelefoneResponsavelUm.getText().charAt(10));
            // -
            str.setCharAt(10, txtTelefoneResponsavelUm.getText().charAt(11));
            str.setCharAt(11, txtTelefoneResponsavelUm.getText().charAt(12));
            str.setCharAt(12, txtTelefoneResponsavelUm.getText().charAt(13));
            str.setCharAt(13, evt.getKeyChar());

            txtTelefoneResponsavelUm.setText(str.toString());
        }

    }//GEN-LAST:event_txtTelefoneResponsavelUmKeyPressed

    private void txtTelefoneResponsavelUmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelUmKeyReleased

        int caretPosition = txtTelefoneResponsavelUm.getCaretPosition();

        if( caretPosition == 4 && isNumericDois(1) && isNumericDois(2) && !isNumericDois(4) && !isNumericDois(5) && !isNumericDois(6) && !isNumericDois(7) && !isNumericDois(8) && !isNumericDois(10) && !isNumericDois(11) && !isNumericDois(12) && !isNumericDois(13) ){
            txtTelefoneResponsavelUm.setCaretPosition(5);
        }

    }//GEN-LAST:event_txtTelefoneResponsavelUmKeyReleased

    private void txtTelefoneResponsavelDoisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelDoisFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneResponsavelDoisFocusGained

    private void txtTelefoneResponsavelDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelDoisActionPerformed

    }//GEN-LAST:event_txtTelefoneResponsavelDoisActionPerformed

    private void txtTelefoneResponsavelDoisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelDoisKeyPressed

        int caretPosition = txtTelefoneResponsavelDois.getCaretPosition();

        if( caretPosition == 14 && isDigit(evt.getKeyChar()) && isNumericTres(1) && isNumericTres(2) && !isNumericTres(4) && isNumericTres(5) && isNumericTres(6) && isNumericTres(7) && isNumericTres(8) && isNumericTres(10) && isNumericTres(11) && isNumericTres(12) && isNumericTres(13) ){
            StringBuilder str = new StringBuilder(txtTelefoneResponsavelDois.getText());

            str.setCharAt(4, txtTelefoneResponsavelDois.getText().charAt(5));
            str.setCharAt(5, txtTelefoneResponsavelDois.getText().charAt(6));
            str.setCharAt(6, txtTelefoneResponsavelDois.getText().charAt(7));
            str.setCharAt(7, txtTelefoneResponsavelDois.getText().charAt(8));
            str.setCharAt(8, txtTelefoneResponsavelDois.getText().charAt(10));
            // -
            str.setCharAt(10, txtTelefoneResponsavelDois.getText().charAt(11));
            str.setCharAt(11, txtTelefoneResponsavelDois.getText().charAt(12));
            str.setCharAt(12, txtTelefoneResponsavelDois.getText().charAt(13));
            str.setCharAt(13, evt.getKeyChar());

            txtTelefoneResponsavelDois.setText(str.toString());
        }

    }//GEN-LAST:event_txtTelefoneResponsavelDoisKeyPressed

    private void txtTelefoneResponsavelDoisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneResponsavelDoisKeyReleased
        
        int caretPosition = txtTelefoneResponsavelDois.getCaretPosition();

        if( caretPosition == 4 && isNumericTres(1) && isNumericTres(2) && !isNumericTres(4) && !isNumericTres(5) && !isNumericTres(6) && !isNumericTres(7) && !isNumericTres(8) && !isNumericTres(10) && !isNumericTres(11) && !isNumericTres(12) && !isNumericTres(13) ){
            txtTelefoneResponsavelDois.setCaretPosition(5);
        }
        
    }//GEN-LAST:event_txtTelefoneResponsavelDoisKeyReleased

    private void txtNomeDoAlunoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeDoAlunoFocusGained
        df.max = 200;
    }//GEN-LAST:event_txtNomeDoAlunoFocusGained

    private void txtCidadeAlunoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidadeAlunoFocusGained

    }//GEN-LAST:event_txtCidadeAlunoFocusGained

    private void txtNomeResponsavelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeResponsavelFocusGained
        // TODO add your handling code here:
        df.max = 200;
    }//GEN-LAST:event_txtNomeResponsavelFocusGained

    private void txtNomeResponsavelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeResponsavelKeyReleased
        
        StringBuilder sb = new StringBuilder(txtNomeResponsavel.getText());
        
        if(sb.length() > 0 && isLowerCase(sb.charAt(0))){
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            txtNomeResponsavel.setText(sb.toString());
        }
        
    }//GEN-LAST:event_txtNomeResponsavelKeyReleased

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        ds.max = 50;
    }//GEN-LAST:event_txtValorFocusGained
    
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
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSituacao;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxDiaDeVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCidadeAluno;
    private javax.swing.JLabel jLabelCpfAluno;
    private javax.swing.JLabel jLabelCpfResponsavel;
    private javax.swing.JLabel jLabelDadosDoResponsavel;
    private javax.swing.JLabel jLabelDataDeDanscimentoAluno;
    private javax.swing.JLabel jLabelDiaDeVencimento;
    private javax.swing.JLabel jLabelEnderecoAluno;
    private javax.swing.JLabel jLabelEnderecoResponsavel;
    private javax.swing.JLabel jLabelMensalidade;
    private javax.swing.JLabel jLabelNomeDoAluno;
    private javax.swing.JLabel jLabelNomeResponsavel;
    private javax.swing.JLabel jLabelObservacoes;
    private javax.swing.JLabel jLabelRgAluno;
    private javax.swing.JLabel jLabelRgResponsavel;
    private javax.swing.JLabel jLabelSituacao;
    private javax.swing.JLabel jLabelTelefoneAluno;
    private javax.swing.JLabel jLabelTelefoneResponsavelDois;
    private javax.swing.JLabel jLabelTelefoneResponsavelUm;
    private javax.swing.JLabel jLabelValor;
    public javax.swing.JRadioButton jRadioButtonAtivo;
    private javax.swing.JRadioButton jRadioButtonInativo;
    private javax.swing.JScrollPane jScrollPaneObservacoes;
    private javax.swing.JTextField txtCidadeAluno;
    private javax.swing.JFormattedTextField txtCpfAluno;
    private javax.swing.JFormattedTextField txtCpfResponsavel;
    private javax.swing.JFormattedTextField txtDataDeNascimentoAluno;
    private javax.swing.JTextField txtEnderecoAluno;
    private javax.swing.JTextField txtEnderecoResponsavel;
    private javax.swing.JTextField txtNomeDoAluno;
    private javax.swing.JTextField txtNomeResponsavel;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JTextField txtRgAluno;
    private javax.swing.JTextField txtRgResponsavel;
    public javax.swing.JFormattedTextField txtTelefoneAluno;
    public javax.swing.JFormattedTextField txtTelefoneResponsavelDois;
    public javax.swing.JFormattedTextField txtTelefoneResponsavelUm;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
