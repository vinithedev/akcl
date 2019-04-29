//tb_pessoa
//tb_professor
//tb_aluno

package model.bean;

public class Pessoa {
    
    //tb_pessoa
    private int COD_Pessoa;
    private String Nome;
    private String RG;
    private String CPF;
    private String Telefone;
    private boolean Status;
    private String Endereco;
    
    //tb_professor
    private double Salario;
    private String Faixa;
    
    //tb_aluno
    private String Endereco_responsavel;
    private int Idade;
    private String Cidade;
    private String Data_nasc;           //Tipo no banco = Date
    private String Nome_responsavel;
    private String CPF_responsavel;
    private String RG_responsavel;
    private String Tel_responsavel_um;
    private String Tel_responsavel_dois;
    private String Observacoes;
    private Double Valor_mens;
    private int Dia_venc_mens;

    public Double getValor_mens() {
        return Valor_mens;
    }

    public void setValor_mens(Double Valor_mens) {
        this.Valor_mens = Valor_mens;
    }

    public int getDia_venc_mens() {
        return Dia_venc_mens;
    }

    public void setDia_venc_mens(int Dia_venc_mens) {
        this.Dia_venc_mens = Dia_venc_mens;
    }
    
    public String getCPF_responsavel() {
        return CPF_responsavel;
    }

    public void setCPF_responsavel(String cpf_responsavel) {
        this.CPF_responsavel = cpf_responsavel;
    }

    public String getRG_responsavel() {
        return RG_responsavel;
    }

    public void setRG_responsavel(String rg_responsavel) {
        this.RG_responsavel = rg_responsavel;
    }

    public String getTel_responsavel_dois() {
        return Tel_responsavel_dois;
    }

    public void setTel_responsavel_dois(String Tel_responsavel_dois) {
        this.Tel_responsavel_dois = Tel_responsavel_dois;
    }

    public String getEndereco_responsavel() {
        return Endereco_responsavel;
    }

    public void setEndereco_responsavel(String endereco_responsavel) {
        this.Endereco_responsavel = endereco_responsavel;
    }
    
    public int getIdade() {
        return Idade;
    }
    
    public void setIdade(int idade) {
        this.Idade = idade;
    }
    
    public int getCOD_Pessoa() {
        return COD_Pessoa;
    }

    public void setCOD_Pessoa(int COD_Pessoa) {
        this.COD_Pessoa = COD_Pessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public String getFaixa() {
        return Faixa;
    }

    public void setFaixa(String Faixa) {
        this.Faixa = Faixa;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getData_nasc() {
        return Data_nasc;
    }

    public void setData_nasc(String Data_nasc) {
        this.Data_nasc = Data_nasc;
    }

    public String getNome_responsavel() {
        return Nome_responsavel;
    }

    public void setNome_responsavel(String Nome_responsavel_um) {
        this.Nome_responsavel = Nome_responsavel_um;
    }

    public String getTel_responsavel_um() {
        return Tel_responsavel_um;
    }

    public void setTel_responsavel_um(String Tel_responsavel_um) {
        this.Tel_responsavel_um = Tel_responsavel_um;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }
    
}
