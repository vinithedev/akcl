package model.dao;

import connection.ConnectionAcademia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Evento;
import model.bean.Mensalidade;
import model.bean.Pessoa;
import model.bean.Produto;
import model.bean.Usuario;
import view.TelaVenda;

public class PessoaDAO {
    
    //Incluir Produto
    public void createProduto(Produto p){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO tb_produto(cod_produto, nome, fornecedor, valor_compra, valor_venda, status, descricao) "
                                      + "VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getCOD_Produto());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getFornecedor());
            stmt.setDouble(4, p.getValor_Compra());
            stmt.setDouble(5, p.getValor_Venda());
            stmt.setBoolean(6, p.getStatus());
            stmt.setString(7, p.getDescricao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Incluir Evento
    public void createEvent(Evento e){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO tb_evento(cod_evento, nome, descricao, data, horario, valor) "
                                      + "VALUES(cod_evento_seq.nextval, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?)");
            stmt.setString(1,e.getNome());
            stmt.setString(2,e.getDescricao());
            stmt.setString(3,e.getData());
            stmt.setString(4,e.getHorario());
            stmt.setDouble(5,e.getValor());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar evento: " + ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Incluir Usuário
    public void createUsuario(Usuario u){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO tb_usuario(cod_usuario, tipo_usuario, login, senha, status) "
                                      + "VALUES                (cod_usuario_seq.nextval, ?,?,?,1)");
            stmt.setString(1,u.getTipo_usuario());
            stmt.setString(2,u.getLogin());
            stmt.setString(3,u.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Incluir Professor
    public void createProfessor(Pessoa p){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tb_pessoa(cod_pessoa, Nome, RG, CPF, Telefone, Endereco, Status) "
                                      + "VALUES               (cod_pessoa_seq.nextval,?,?,?,?,?,1)");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getRG());
            stmt.setString(3,p.getCPF());
            stmt.setString(4,p.getTelefone());
            stmt.setString(5,p.getEndereco());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("INSERT INTO tb_professor(cod_pessoa, Salario, Faixa) "
                                      + "VALUES                  (cod_pessoa_seq.currval,?,?)");
            stmt.setDouble(1,p.getSalario());
            stmt.setString(2,p.getFaixa());
            
            stmt.executeUpdate();
                    
            JOptionPane.showMessageDialog(null, "Professor salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar professor: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Consultar COD Produto
    public void checkProduto(Produto p, int cod){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            
            stmt = con.prepareStatement("SELECT * "
                                      + "FROM tb_produto "
                                      + "WHERE COD_Produto = ? "
                                      + "AND Status = 1");
            stmt.setInt(1, cod);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                p.setNome(rs.getString("nome"));
                p.setValor_Venda(rs.getDouble("valor_venda"));
                p.setCOD_Produto(rs.getInt("cod_produto"));
                p.setDescricao(rs.getString("descricao"));
                
            }else{
                p.setNome("Código incorreto!");
                p.setValor_Venda(.0);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        
    }
    
    //Consultar Usuário
    public List<Usuario> readUsuario(){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * "
                                      + "FROM tb_usuario");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Usuario usuario = new Usuario();
                
                usuario.setCOD_Usuario(rs.getInt("COD_Usuario"));
                usuario.setLogin(rs.getString("Login"));
                usuario.setStatus(rs.getBoolean("Status"));
                usuario.setTusuario(rs.getString("Tipo_usuario"));
                
                usuarios.add(usuario);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
    //Consultar Produto
    public List<Produto> readProduto(String nome){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * "
                                      + "FROM tb_produto "
                                      + "WHERE upper(nome) "
                                      + "LIKE ? ");
            stmt.setString(1, "%"+nome.toUpperCase()+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produto produto = new Produto();
                
                produto.setCOD_Produto(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setValor_Compra(rs.getDouble("valor_compra"));
                produto.setValor_Venda(rs.getDouble("valor_venda"));
                produto.setStatus(rs.getBoolean("status"));
                produto.setDescricao(rs.getString("descricao"));
                
                produtos.add(produto);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
    //Consultar Produto Ativo
    public List<Produto> readProdutoAtivo(){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * "
                                      + "FROM tb_produto "
                                      + "WHERE status = 1");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produto produto = new Produto();
                
                produto.setCOD_Produto(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setValor_Compra(rs.getDouble("valor_compra"));
                produto.setValor_Venda(rs.getDouble("valor_venda"));
                produto.setStatus(rs.getBoolean("status"));
                produto.setDescricao(rs.getString("descricao"));
                
                produtos.add(produto);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
    //Consultar Professor
    public List<Pessoa> readProfessor(String nome){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT a.*, to_char(b.salario, '9999999.99') as Salario, b.faixa "
                                      + "FROM tb_pessoa a, tb_professor b "
                                      + "WHERE upper(a.nome) "
                                      + "LIKE ? AND a.COD_PESSOA = b.COD_PESSOA");
            
            stmt.setString(1, "%"+nome.toUpperCase()+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Pessoa pessoa = new Pessoa();
                
                //Pessoa
                pessoa.setCOD_Pessoa(rs.getInt("COD_Pessoa"));
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setStatus(rs.getBoolean("Status"));          //Boolean getter
                pessoa.setEndereco(rs.getString("Endereco"));
                
                //Professor
                pessoa.setSalario(rs.getDouble("Salario"));
                pessoa.setFaixa(rs.getString("Faixa"));
                
                
                pessoas.add(pessoa);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return pessoas;
    }
    
    //Buscar Dia de Vencimento e Valor da Mensalidade na tabela Aluno
    public void retrieveDayAndValue(Pessoa p){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT valor_mens, dia_venc_mens "
                                      + "FROM tb_aluno "
                                      + "WHERE cod_pessoa = ?");
            stmt.setInt(1,p.getCOD_Pessoa());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                p.setValor_mens(rs.getDouble("valor_mens"));
                p.setDia_venc_mens(rs.getInt("dia_venc_mens"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Valor e Dia de Vencimento da Mensalidade: " + ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    
    }
    
    //Buscar Descrição Mensalidade
    public void retrieveMensalidade(Pessoa p, Mensalidade m){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT descricao "
                                      + "FROM tb_mensalidade "
                                      + "WHERE status = 'Em aberto' "
                                      + "AND cod_pessoa = ?");
            stmt.setInt(1,p.getCOD_Pessoa());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                m.setDescricao(rs.getString("Descricao"));
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar descrição da mensalidade: " + ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    
    }
    
    //Checar Idade
    public void checkAge(Pessoa p){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT months_between(TRUNC(sysdate),to_date(?,'DD/MM/YYYY'))/12 "
                                      + "AS age "
                                      + "FROM dual");
            stmt.setString(1,p.getData_nasc());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                p.setIdade(rs.getInt("Age"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
        
    }
    
    //Pagar Mensalidade
    public void buttonPago(Pessoa p, Mensalidade m){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        NumberFormat df = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        String data_venc_atual = "";
        String data_venc_prox = "";
        String status_prox = "";
        String descricao_prox = "";
        Double valor_atual = 0.0;
        Double valor_final = 0.0;
        int dia_venc_atual = 0;
        int dias_entre = 0;
        
        try {
            //Seleciona data da mensalidade a ser paga
            stmt = con.prepareStatement("SELECT TO_CHAR(data_venc, 'DD/MM/YYYY' ) "
                                      + "AS data_venc, "
                                      + "valor "
                                      + "FROM tb_mensalidade "
                                      + "WHERE cod_pessoa = ? "
                                      + "AND status = 'Em aberto'");
            stmt.setInt(1, p.getCOD_Pessoa());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                data_venc_atual = rs.getString("data_venc");
                valor_atual = rs.getDouble("valor");
            }
            
            //Adiciona 1 mês à data da mensalidade a ser paga
            stmt = con.prepareStatement("SELECT TO_CHAR(ADD_MONTHS(TO_DATE(?, 'DD/MM/YYYY'), 1), 'DD/MM/YYYY') "
                                      + "AS addmes "
                                      + "FROM dual");
            stmt.setString(1, data_venc_atual);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                data_venc_prox = rs.getString("addmes");
            }
            
            data_venc_prox = p.getDia_venc_mens() + data_venc_prox.substring(2);
            
            //Paga a mensalidade em aberto
            stmt = con.prepareStatement("UPDATE tb_mensalidade "
                                      + "SET status = 'Pago' "
                                      + "WHERE cod_pessoa = ? "
                                      + "AND status = 'Em aberto'");
            stmt.setInt(1, p.getCOD_Pessoa());
            
            stmt.executeUpdate();
            
            //Dias entre vencimento da fatura sendo paga e vencimento da próxima fatura
            stmt = con.prepareStatement("SELECT ABS(to_date(?, 'DD/MM/YYYY') - to_date(?, 'DD/MM/YYYY')) "
                                     + "AS diasentre "
                                     + "FROM dual");
            stmt.setString(1, data_venc_atual);
            stmt.setString(2, data_venc_prox);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                dias_entre = rs.getInt("diasentre");
            }
            
            //Calcula valor da próxima mensalidade
            dia_venc_atual = (Integer.parseInt(data_venc_atual.substring(0, 2).replaceAll("[\\D]", "")));
            valor_final = p.getDia_venc_mens() == dia_venc_atual ? p.getValor_mens() : (dias_entre * p.getValor_mens()/30) ;
            
            //Cria nova mensalidade
            status_prox = "Em aberto";
            descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(valor_final);
            
            stmt = con.prepareStatement("INSERT INTO tb_mensalidade(cod_mensalidade, cod_pessoa, data_venc, valor, status, descricao) "
                                      + "VALUES(cod_mensalidade_seq.nextval, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?)");
            stmt.setInt(1, p.getCOD_Pessoa());
            stmt.setString(2, data_venc_prox);
            stmt.setDouble(3, valor_final);
            stmt.setString(4, status_prox);
            stmt.setString(5, descricao_prox);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pagamento da mensalidade " + data_venc_atual + " : " + df.format(valor_atual) + " registrado com sucesso!"
                                              + "\nPróxima mensalidade: " + data_venc_prox + " : " + df.format(valor_final));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pagar mensalidade: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
        
    }
    
    //Alterar Usuário
    public void updateUsuario(Usuario u){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE tb_usuario "
                                      + "SET Tipo_usuario = ?, Status = ? "
                                      + "WHERE COD_Usuario = ?");
            stmt.setString(1,u.getTipo_usuario());
            stmt.setBoolean(2, u.getStatus());
            stmt.setInt(3, u.getCOD_Usuario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Alterar Aluno
    public void updateAluno(Pessoa p, Mensalidade m){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            //Buscar status atual
            boolean status_antigo = false;
            boolean status_final = p.getStatus();
            
            stmt = con.prepareStatement("SELECT status "
                                      + "FROM tb_pessoa "
                                      + "WHERE cod_pessoa = ?");
            stmt.setInt(1, p.getCOD_Pessoa());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                status_antigo = rs.getBoolean("status");
            }
            
            //Se rematriculado(Alterado de "Inativo" para "Ativo"), calcular último dia em que aluno tem direito com este primeiro pagamento(rematrícula) e registrar na variável "lastDay"
            Double Valor = 0.0;
            Double Valor_prox = 0.0;
            String data_venc_prox = "";
            NumberFormat df = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            
            if((status_antigo == false) && (status_final == true)){
                
                String sDate = "";
                int dias_entre = 0;
                
                String lastDay = "";
                String lastDay_prox = "";
                String data_venc = "";
                String status = "";
                String status_prox = "";
                String descricao = "";
                String descricao_prox = "";
                
                stmt = con.prepareStatement("SELECT TO_CHAR(sysdate, 'DD/MM/YYYY') "
                                          + "AS sdate "
                                          + "FROM dual");
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    sDate = rs.getString("sDate");
                }
                
                // lastDay = sysdate + 1 month
                stmt = con.prepareStatement("SELECT TO_CHAR(ADD_MONTHS(sysdate,1), 'DD/MM/YYYY') "
                                          + "AS lday "
                                          + "FROM dual");
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    lastDay_prox = rs.getString("Lday");
                }
                
                //Dias entre hoje e próxima data_venc
                stmt = con.prepareStatement("SELECT ABS(trunc(sysdate) - to_date(?, 'DD/MM/YYYY')) "
                                          + "AS daysb "
                                          + "FROM dual");
                stmt.setString(1, (p.getDia_venc_mens() + lastDay_prox.substring(2)));
                
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    dias_entre = Integer.parseInt(rs.getString("daysb"));
                }
                
                String sDate_day_string = sDate.charAt(0)+""+sDate.charAt(1);
                int sDate_day = Integer.parseInt(sDate_day_string);
                
                if(sDate_day < p.getDia_venc_mens()){
                    //Rematrícula
                    data_venc = sDate;
                    Valor = (p.getDia_venc_mens() - sDate_day) * (p.getValor_mens() / 30);
                    status = "Pago";
                    descricao = "Rematrícula: " + sDate + " : Valor: " + df.format(Valor);
                    
                    //Próxima mensalidade
                    data_venc_prox = p.getDia_venc_mens() + sDate.substring(2);
                    Valor_prox = p.getValor_mens();
                    status_prox = "Em aberto";
                    descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(Valor_prox);
                }else if(sDate_day > p.getDia_venc_mens()){
                    //Rematrícula
                    data_venc = sDate;
                    Valor = (dias_entre) * (p.getValor_mens() / 30);
                    status = "Pago";
                    descricao = "Rematrícula: " + data_venc + " : Valor: " + df.format(Valor);
                    
                    //Próxima mensalidade
                    data_venc_prox = p.getDia_venc_mens() + lastDay_prox.substring(2);
                    Valor_prox = p.getValor_mens();
                    status_prox = "Em aberto";
                    descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(Valor_prox);
                }else if(sDate_day == p.getDia_venc_mens()){
                    //Rematrícula
                    data_venc = sDate;
                    Valor = p.getValor_mens();
                    status = "Pago";
                    descricao = "Rematrícula: " + data_venc + " : Valor: " + df.format(Valor);
                    
                    //Próxima mensalidade
                    data_venc_prox = lastDay_prox;
                    Valor_prox = p.getValor_mens();
                    status_prox = "Em aberto";
                    descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(Valor_prox);
                }
//                INSERT INTO tb_mensalidade(cod_mensalidade, cod_pessoa, data_venc, valor, status, descricao) VALUES(cod_mensalidade_seq.nextval, 234, TO_DATE('01/01/1911', 'DD/MM/YYYY'), 111, 1, 'AEW')
                stmt = con.prepareStatement("INSERT INTO tb_mensalidade(cod_mensalidade, cod_pessoa, data_venc, valor, status, descricao) "
                                          + "VALUES(cod_mensalidade_seq.nextval, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?)");
                stmt.setInt(1, p.getCOD_Pessoa());
                stmt.setString(2,data_venc);
                stmt.setDouble(3,Valor);
                stmt.setString(4,status);
                stmt.setString(5,descricao);
                
                stmt.executeUpdate();
                
                stmt = con.prepareStatement("INSERT INTO tb_mensalidade(cod_mensalidade, cod_pessoa, data_venc, valor, status, descricao) "
                                          + "VALUES(cod_mensalidade_seq.nextval, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?)");
                stmt.setInt(1, p.getCOD_Pessoa());
                stmt.setString(2,data_venc_prox);
                stmt.setDouble(3,Valor_prox);
                stmt.setString(4,status_prox);
                stmt.setString(5,descricao_prox);
                
                stmt.executeUpdate();
                
            }
            //Se Status mudou de Ativo para Inativo, pagar fatura em aberto e inativar aluno
            else if((status_antigo == true) && (status_final == false)){
                
                stmt = con.prepareStatement("UPDATE tb_mensalidade "
                                          + "SET status = 'Pago' "
                                          + "WHERE cod_pessoa = ? "
                                          + "AND status = 'Em aberto'");
                stmt.setInt(1, p.getCOD_Pessoa());
                
                stmt.executeUpdate();
                
            }
            
            //Executar atualização
            stmt = con.prepareStatement("UPDATE tb_pessoa "
                                      + "SET Nome = ?, RG = ?, CPF = ?, Telefone = ?, Status = ?, Endereco = ? "
                                      + "WHERE cod_pessoa = ?");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getRG());
            stmt.setString(3,p.getCPF());
            stmt.setString(4,p.getTelefone());
            stmt.setBoolean(5,p.getStatus());
            stmt.setString(6,p.getEndereco());
            stmt.setInt(7, p.getCOD_Pessoa());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE tb_aluno "
                                      + "SET cidade = ?, data_nasc = to_date(?, 'DD/MM/YYYY'), nome_responsavel = ?, cpf_responsavel = ?, rg_responsavel = ?, endereco_responsavel = ?, tel_responsavel_um = ?, tel_responsavel_dois = ?, observacoes = ?, valor_mens = ?, dia_venc_mens = ? "
                                      + "WHERE cod_pessoa = ?");
            stmt.setString(1, p.getCidade());
            stmt.setString(2, p.getData_nasc());
            stmt.setString(3, p.getNome_responsavel());
            stmt.setString(4, p.getCPF_responsavel());
            stmt.setString(5, p.getRG_responsavel());
            stmt.setString(6, p.getEndereco_responsavel());
            stmt.setString(7, p.getTel_responsavel_um());
            stmt.setString(8, p.getTel_responsavel_dois());
            stmt.setString(9, p.getObservacoes());
            stmt.setDouble(10, p.getValor_mens());
            stmt.setInt(11, p.getDia_venc_mens());
            stmt.setInt(12, p.getCOD_Pessoa());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, ((status_antigo == false) && (status_final == true)) ? "Aluno rematriculado com sucesso!"
                                                                                                     + "\nValor da rematrícula: " + df.format(Valor) 
                                                                                                     + "\nPrimeira mensalidade: Data: " + data_venc_prox + " Valor: " + df.format(Valor_prox) : "Aluno atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
        
    }
    
    //Alterar Produto
    public void updateProduto(Produto p){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tb_produto "
                                      + "SET Nome = ?, Fornecedor = ?, Valor_Compra = ?, Valor_Venda = ?, Status = ?, Descricao = ? "
                                      + "WHERE COD_Produto = ?");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getFornecedor());
            stmt.setDouble(3,p.getValor_Compra());
            stmt.setDouble(4,p.getValor_Venda());
            stmt.setBoolean(5, p.getStatus());
            stmt.setString(6,p.getDescricao());
            stmt.setInt(7, p.getCOD_Produto());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Alterar Professor
    public void updateProfessor(Pessoa p){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tb_pessoa "
                                      + "SET Nome = ?, RG = ?, CPF = ?, Telefone = ?, Status = ?, Endereco = ? "
                                      + "WHERE cod_pessoa = ?");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getRG());
            stmt.setString(3,p.getCPF());
            stmt.setString(4,p.getTelefone());
            stmt.setBoolean(5,p.getStatus());
            stmt.setString(6,p.getEndereco());
            stmt.setInt(7, p.getCOD_Pessoa());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE tb_professor "
                                      + "SET Salario = ?, Faixa = ? "
                                      + "WHERE cod_pessoa = ?");
            stmt.setDouble(1,p.getSalario());
            stmt.setString(2, p.getFaixa());
            stmt.setInt(3, p.getCOD_Pessoa());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar professor: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
    }
    
    //Pesquisar Professor
    public List<Pessoa> searchProfessor(String nome){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT a.*, b.* "
                                      + "FROM tb_pessoa a, tb_professor b "
                                      + "WHERE a.nome "
                                      + "LIKE ? "
                                      + "AND a.COD_PESSOA = b.COD_PESSOA");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Pessoa pessoa = new Pessoa();
                
                //Pessoa
                pessoa.setCOD_Pessoa(rs.getInt("COD_Pessoa"));
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setStatus(rs.getBoolean("Status"));          //Boolean getter
                pessoa.setEndereco(rs.getString("Endereco"));
                
                //Professor
                pessoa.setSalario(rs.getDouble("Salario"));
                pessoa.setFaixa(rs.getString("Faixa"));
                
                pessoas.add(pessoa);                
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return pessoas;
    }
    
    //Incluir Aluno
    public void createAluno(Pessoa p, Mensalidade m){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tb_pessoa(cod_pessoa, Nome, RG, CPF, Telefone, Status, Endereco) "
                                      + "VALUES               (cod_pessoa_seq.nextval,?,?,?,?,?,?)");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getRG());
            stmt.setString(3,p.getCPF());
            stmt.setString(4,p.getTelefone());
            stmt.setBoolean(5,p.getStatus());
            stmt.setString(6, p.getEndereco());
            
            stmt.executeUpdate();
            
            //Corrige erro "Invalid Month"
            stmt = con.prepareStatement("alter session set nls_date_format = 'dd/mm/yyyy'");
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("INSERT INTO tb_aluno(cod_pessoa, Cidade, Data_nasc, Nome_responsavel, CPF_responsavel, RG_responsavel, Endereco_responsavel, Tel_responsavel_um, Tel_responsavel_dois, Observacoes, valor_mens, dia_venc_mens) "
                                      + "VALUES              (cod_pessoa_seq.currval,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,p.getCidade());
            stmt.setString(2,p.getData_nasc());
            stmt.setString(3,p.getNome_responsavel());
            stmt.setString(4,p.getCPF_responsavel());
            stmt.setString(5,p.getRG_responsavel());
            stmt.setString(6,p.getEndereco_responsavel());
            stmt.setString(7,p.getTel_responsavel_um());
            stmt.setString(8,p.getTel_responsavel_dois());
            stmt.setString(9,p.getObservacoes());
            stmt.setDouble(10,p.getValor_mens());
            stmt.setInt(11, p.getDia_venc_mens());
            
            stmt.executeUpdate();
            
            //Mensalidade
            Double Valor = 0.0;
            Double Valor_prox = 0.0;
            String data_venc_prox = "";
            NumberFormat df = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            //Se cadastrado como "Ativo", calcular último dia em que aluno tem direito com este primeiro pagamento(matrícula) e registrar na variável "lastDay"
            if (p.getStatus() == true){
                
                String sDate = "";
                int dias_entre = 0;
                
                String lastDay = "";
                String lastDay_prox = "";
                String data_venc = "";
                String status = "";
                String status_prox = "";
                String descricao = "";
                String descricao_prox = "";
                
                stmt = con.prepareStatement("SELECT TO_CHAR(sysdate, 'DD/MM/YYYY') "
                                          + "AS sdate "
                                          + "FROM dual");
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    sDate = rs.getString("sDate");
                }
                
                // lastDay = sysdate + 1 month
                stmt = con.prepareStatement("SELECT TO_CHAR(ADD_MONTHS(sysdate,1), 'DD/MM/YYYY') "
                                          + "AS lday "
                                          + "FROM dual");
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    lastDay_prox = rs.getString("Lday");
                }
                
                //Dias entre hoje e próxima data_venc
                stmt = con.prepareStatement("SELECT ABS(trunc(sysdate) - to_date(?, 'DD/MM/YYYY')) "
                                          + "AS daysb "
                                          + "FROM dual");
                stmt.setString(1, (p.getDia_venc_mens() + lastDay_prox.substring(2)));
                
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    dias_entre = Integer.parseInt(rs.getString("daysb"));
                }
                
                String sDate_day_string = sDate.charAt(0)+""+sDate.charAt(1);
                int sDate_day = Integer.parseInt(sDate_day_string);
                
                if(sDate_day < p.getDia_venc_mens()){
                    // Matrícula
                    data_venc = sDate;
                    Valor = (p.getDia_venc_mens() - sDate_day) * (p.getValor_mens() / 30);
                    status = "Pago";
                    descricao = "Matrícula: " + sDate + " : Valor: " + df.format(Valor);
                    
                    // Primeira mensalidade
                    data_venc_prox = p.getDia_venc_mens() + sDate.substring(2);
                    Valor_prox = p.getValor_mens();
                    status_prox = "Em aberto";
                    descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(Valor_prox);
                }else if(sDate_day > p.getDia_venc_mens()){
                    // Matrícula
                    data_venc = sDate;
                    Valor = (dias_entre) * (p.getValor_mens() / 30);
                    status = "Pago";
                    descricao = "Matrícula: " + data_venc + " : Valor: " + df.format(Valor);
                    
                    // Primeira mensalidade
                    data_venc_prox = p.getDia_venc_mens() + lastDay_prox.substring(2);
                    Valor_prox = p.getValor_mens();
                    status_prox = "Em aberto";
                    descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(Valor_prox);
                }else if(sDate_day == p.getDia_venc_mens()){
                    // Matrícula
                    data_venc = sDate;
                    Valor = p.getValor_mens();
                    status = "Pago";
                    descricao = "Matrícula: " + data_venc + " : Valor: " + df.format(Valor);
                    
                    // Primeira mensalidade
                    data_venc_prox = lastDay_prox;
                    Valor_prox = p.getValor_mens();
                    status_prox = "Em aberto";
                    descricao_prox = "Mensalidade: " + data_venc_prox + " : Valor: " + df.format(Valor_prox);
                }
                
                stmt = con.prepareStatement("INSERT INTO tb_mensalidade(cod_mensalidade, cod_pessoa, data_venc, valor, status, descricao) "
                                          + "VALUES(cod_mensalidade_seq.nextval, cod_pessoa_seq.currval, ?, ?, ?, ?)");
                
                stmt.setString(1,data_venc);
                stmt.setDouble(2,Valor);
                stmt.setString(3,status);
                stmt.setString(4,descricao);
                
                stmt.executeUpdate();
                
                stmt = con.prepareStatement("INSERT INTO tb_mensalidade(cod_mensalidade, cod_pessoa, data_venc, valor, status, descricao) "
                                          + "VALUES(cod_mensalidade_seq.nextval, cod_pessoa_seq.currval, ?, ?, ?, ?)");
                
                stmt.setString(1,data_venc_prox);
                stmt.setDouble(2,Valor_prox);
                stmt.setString(3,status_prox);
                stmt.setString(4,descricao_prox);
                
                stmt.executeUpdate();
            
            }
            
            JOptionPane.showMessageDialog(null, (p.getStatus() == true) ? "Aluno matriculado com sucesso!"
                                                                      + "\nValor da matrícula: " + df.format(Valor) 
                                                                      + "\nPrimeira mensalidade: Data: " + data_venc_prox + " Valor: " + df.format(Valor_prox) : "Aluno INATIVO matriculado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar aluno: "+ex);
        } finally{
            ConnectionAcademia.closeConnection(con, stmt);
        }
        
    }
    
    //Consultar Evento
    public List<Evento> readEvento(){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Evento> eventos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT cod_evento, nome, descricao, horario, valor, TO_CHAR(data,'DD/MM/YYYY') as Data "
                                      + "FROM tb_evento "
                                      + "WHERE data > sysdate-1");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Evento evento = new Evento();
                
                //tb_evento
                evento.setCOD_Evento(rs.getInt("COD_Evento"));
                evento.setNome(rs.getString("Nome"));
                evento.setDescricao(rs.getString("Descricao"));
                evento.setData(rs.getString("Data"));
                evento.setHorario(rs.getString("Horario"));
                evento.setValor(rs.getDouble("Valor"));
                
                eventos.add(evento);
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return eventos;
    }
    
    //Consultar Aluno
    public List<Pessoa> readAluno(String nome){
        
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT a.*, b.Cidade, TO_CHAR(b.data_nasc,'DD/MM/YYYY') as Data_nasc, b.Cidade, b.Nome_responsavel, b.cpf_responsavel, b.rg_responsavel, b.endereco_responsavel, b.Tel_responsavel_um, b.Tel_responsavel_dois, b.Observacoes "
                                      + "FROM TB_PESSOA a, TB_ALUNO b "
                                      + "WHERE upper(a.nome) "
                                      + "LIKE ? "
                                      + "AND a.COD_PESSOA = b.COD_PESSOA");
            stmt.setString(1, "%"+nome.toUpperCase()+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Pessoa pessoa = new Pessoa();
                
                //tb_pessoa
                pessoa.setCOD_Pessoa(rs.getInt("COD_Pessoa"));
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setStatus(rs.getBoolean("Status"));          //Boolean getter
                
                //tb_aluno
                pessoa.setCidade(rs.getString("Cidade"));
                pessoa.setData_nasc(rs.getString("Data_nasc"));
                pessoa.setNome_responsavel(rs.getString("Nome_responsavel"));
                pessoa.setRG_responsavel(rs.getString("RG_responsavel"));
                pessoa.setCPF_responsavel(rs.getString("CPF_responsavel"));
                pessoa.setEndereco_responsavel(rs.getString("Endereco_responsavel"));
                pessoa.setTel_responsavel_um(rs.getString("Tel_responsavel_um"));
                pessoa.setTel_responsavel_dois(rs.getString("Tel_responsavel_dois"));
                pessoa.setObservacoes(rs.getString("Observacoes"));
                pessoa.setEndereco(rs.getString("Endereco"));
                
                pessoas.add(pessoa);
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return pessoas;
    }
    
}
