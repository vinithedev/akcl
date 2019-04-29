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

public class AtualizarAluno extends javax.swing.JFrame {
    
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
    
    PessoaDAO dao = new PessoaDAO();
    Pessoa p = new Pessoa();
    Mensalidade m = new Mensalidade();
    
    public AtualizarAluno() {
        initComponents();
        
        txtRgAluno.setDocument(new DocLimit(50));
        txtCidadeAluno.setDocument(new DocLimit(100));
        txtEnderecoAluno.setDocument(new DocLimit(200));
        txtRgResponsavel.setDocument(new DocLimit(50));
        txtEnderecoResponsavel.setDocument(new DocLimit(200));
        txtObservacoes.setDocument(new DocLimit(800));
        
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
        txtNomeDoResponsavel = new javax.swing.JTextField();
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
        jLabelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButtonPagar = new javax.swing.JButton();
        jLabelMes = new javax.swing.JLabel();
        jComboBoxMensalidadeDescricao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AKCL - Alterar Aluno");
        setMinimumSize(new java.awt.Dimension(504, 674));
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

        jLabelEnderecoAluno.setText("Endereço (opcional)");

        jLabelTelefoneAluno.setText("Telefone");

        jLabelNomeResponsavel.setText("Nome do Responsável ");

        txtNomeDoResponsavel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeDoResponsavelFocusGained(evt);
            }
        });
        txtNomeDoResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDoResponsavelActionPerformed(evt);
            }
        });
        txtNomeDoResponsavel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeDoResponsavelKeyReleased(evt);
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

        jLabelCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));

        jButtonPagar.setText("PAGAR");
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        jLabelMes.setText("Mês");

        jComboBoxMensalidadeDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMensalidadeDescricaoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("ALTERAR ALUNO");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPaneObservacoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelNomeDoAluno)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNomeDoAluno))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelDataDeDanscimentoAluno)
                                            .addComponent(jLabelCodigo)
                                            .addComponent(jLabelRgAluno)
                                            .addComponent(jLabelCpfAluno)
                                            .addComponent(jLabelCidadeAluno)
                                            .addComponent(jLabelEnderecoAluno)
                                            .addComponent(jLabelTelefoneAluno))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDataDeNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelNomeResponsavel)
                                            .addComponent(jLabelCpfResponsavel)
                                            .addComponent(jLabelEnderecoResponsavel)
                                            .addComponent(jLabelRgResponsavel)
                                            .addComponent(jLabelTelefoneResponsavelUm)
                                            .addComponent(jLabelTelefoneResponsavelDois))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNomeDoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRgResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEnderecoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefoneResponsavelUm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefoneResponsavelDois, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelObservacoes, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelValor)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabelDiaDeVencimento))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelMes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxMensalidadeDescricao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxDiaDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonPagar))
                                        .addGap(36, 36, 36))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabelDadosDoResponsavel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabelMensalidade))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeDoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeDoAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDataDeDanscimentoAluno)
                    .addComponent(txtDataDeNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo)
                    .addComponent(jLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRgAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCpfAluno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCidadeAluno))
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
                    .addComponent(txtNomeDoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCpfResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRgResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRgResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnderecoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEnderecoResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneResponsavelUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefoneResponsavelUm))
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
                    .addComponent(jComboBoxDiaDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPagar)
                    .addComponent(jLabelMes)
                    .addComponent(jComboBoxMensalidadeDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
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
                    .addComponent(jButtonSalvar))
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

    private void txtNomeDoResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDoResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDoResponsavelActionPerformed

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
        }else if(idade == "Menor" && ( txtNomeDoAluno.getText().equals("") || txtDataDeNascimentoAluno.getText().equals("  /  /    ") || txtCidadeAluno.getText().equals("") || txtNomeDoResponsavel.getText().equals("") || txtCpfResponsavel.getText().equals("   .   .   -  ") || txtRgResponsavel.getText().equals("") || txtEnderecoResponsavel.getText().equals("") || txtTelefoneResponsavelUm.getText().equals("(  )     -    ") || txtValor.getText().equals("")  ) ){
            JOptionPane.showMessageDialog(null, "Campo obrigatório não preenchido!");
            return;
        }else if(idade != "Menor" && idade != "Maior"){
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento!");
            return;
        }else{
        
        int occurance = StringUtils.countMatches(tValor, ".");
        int occurancedois = StringUtils.countMatches(tValor, ",");
        if(occurance + occurancedois > 1){
            JOptionPane.showMessageDialog(null, "Campo ''VALOR'' foi digitado incorretamente");
            return;
        }
        
        //Qualquer aluno
        p.setNome(txtNomeDoAluno.getText());
        p.setCOD_Pessoa(Integer.parseInt(txtCodigo.getText()));
        p.setData_nasc(txtDataDeNascimentoAluno.getText());
        p.setRG(txtRgAluno.getText());
        p.setCPF(txtCpfAluno.getText().equals("   .   .   -  ") ? "" : txtCpfAluno.getText());
        p.setCidade(txtCidadeAluno.getText());
        p.setEndereco(txtEnderecoAluno.getText());
        p.setTelefone(txtTelefoneAluno.getText().equals("(  )     -    ") ? "" : txtTelefoneAluno.getText());
        
        //Somente menores de idade
        p.setNome_responsavel(txtNomeDoResponsavel.getText());
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
        
        dao.updateAluno(p, m);
        
        TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
        telapadmin.setVisible(true);
//        telapadmin.jButtonAlunos.doClick();
        this.dispose();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        ((AbstractDocument) txtNomeDoAluno.getDocument()).setDocumentFilter(null);
        ((AbstractDocument) txtCidadeAluno.getDocument()).setDocumentFilter(null);
        ((AbstractDocument) txtNomeDoResponsavel.getDocument()).setDocumentFilter(null);
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(null);
        
        txtNomeDoAluno.setText("");
        txtRgAluno.setText("");
        txtCpfAluno.setText("");
        txtDataDeNascimentoAluno.setText("");
        txtCidadeAluno.setText("");
        txtEnderecoAluno.setText("");
        txtTelefoneAluno.setText("");
        txtNomeDoResponsavel.setText("");
        txtCpfResponsavel.setText("");
        txtEnderecoResponsavel.setText("");
        txtTelefoneResponsavelUm.setText("");
        txtTelefoneResponsavelDois.setText("");
        txtObservacoes.setText("");
        txtValor.setText("");
        jComboBoxDiaDeVencimento.setSelectedIndex(0);
        
        ((AbstractDocument) txtNomeDoAluno.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) txtCidadeAluno.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) txtNomeDoResponsavel.getDocument()).setDocumentFilter(df);
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
                txtNomeDoResponsavel.setEnabled(false);
                txtCpfResponsavel.setEnabled(false);
                txtRgResponsavel.setEnabled(false);
                txtEnderecoResponsavel.setEnabled(false);
                txtTelefoneResponsavelUm.setEnabled(false);
                txtTelefoneResponsavelDois.setEnabled(false);
                
                idade = "Maior";
                
            }else if(p.getIdade() < 18){
                txtNomeDoResponsavel.setEnabled(true);
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
        ((AbstractDocument) txtNomeDoAluno.getDocument()).setDocumentFilter(df);
        df.max = 200;
    }//GEN-LAST:event_txtNomeDoAlunoFocusGained

    private void txtCidadeAlunoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidadeAlunoFocusGained

    }//GEN-LAST:event_txtCidadeAlunoFocusGained

    private void txtNomeDoResponsavelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeDoResponsavelFocusGained
        ((AbstractDocument) txtNomeDoResponsavel.getDocument()).setDocumentFilter(df);
        df.max = 200;
    }//GEN-LAST:event_txtNomeDoResponsavelFocusGained

    private void txtNomeDoResponsavelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDoResponsavelKeyReleased
        
        StringBuilder sb = new StringBuilder(txtNomeDoResponsavel.getText());
        
        if(sb.length() > 0 && isLowerCase(sb.charAt(0))){
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            txtNomeDoResponsavel.setText(sb.toString());
        }
        
    }//GEN-LAST:event_txtNomeDoResponsavelKeyReleased

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(ds);
        ds.max = 50;
    }//GEN-LAST:event_txtValorFocusGained

    private void jComboBoxMensalidadeDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMensalidadeDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMensalidadeDescricaoActionPerformed

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        
        if(jComboBoxMensalidadeDescricao.getSelectedIndex() != 0){
            
            String cbitem = jComboBoxDiaDeVencimento.getSelectedItem().toString();
            int comboxint = Integer.parseInt(cbitem);
            
            p.setCOD_Pessoa(Integer.parseInt(txtCodigo.getText()));
            p.setDia_venc_mens(comboxint);
            p.setValor_mens(Double.parseDouble(txtValor.getText()));
            
            dao.buttonPago(p, m);
            
            TelaPrincipalAdmin telapadmin = new TelaPrincipalAdmin();
            telapadmin.setVisible(true);
//            telapadmin.jButtonAlunos.doClick();
            this.dispose();
            
        }
        
    }//GEN-LAST:event_jButtonPagarActionPerformed
    
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
            java.util.logging.Logger.getLogger(AtualizarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSituacao;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonSalvar;
    public javax.swing.JComboBox<String> jComboBoxDiaDeVencimento;
    public javax.swing.JComboBox<String> jComboBoxMensalidadeDescricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCidadeAluno;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCpfAluno;
    private javax.swing.JLabel jLabelCpfResponsavel;
    private javax.swing.JLabel jLabelDadosDoResponsavel;
    private javax.swing.JLabel jLabelDataDeDanscimentoAluno;
    private javax.swing.JLabel jLabelDiaDeVencimento;
    private javax.swing.JLabel jLabelEnderecoAluno;
    private javax.swing.JLabel jLabelEnderecoResponsavel;
    private javax.swing.JLabel jLabelMensalidade;
    private javax.swing.JLabel jLabelMes;
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
    public javax.swing.JRadioButton jRadioButtonInativo;
    private javax.swing.JScrollPane jScrollPaneObservacoes;
    public javax.swing.JTextField txtCidadeAluno;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JFormattedTextField txtCpfAluno;
    public javax.swing.JFormattedTextField txtCpfResponsavel;
    public javax.swing.JFormattedTextField txtDataDeNascimentoAluno;
    public javax.swing.JTextField txtEnderecoAluno;
    public javax.swing.JTextField txtEnderecoResponsavel;
    public javax.swing.JTextField txtNomeDoAluno;
    public javax.swing.JTextField txtNomeDoResponsavel;
    public javax.swing.JTextArea txtObservacoes;
    public javax.swing.JTextField txtRgAluno;
    public javax.swing.JTextField txtRgResponsavel;
    public javax.swing.JFormattedTextField txtTelefoneAluno;
    public javax.swing.JFormattedTextField txtTelefoneResponsavelDois;
    public javax.swing.JFormattedTextField txtTelefoneResponsavelUm;
    public javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
