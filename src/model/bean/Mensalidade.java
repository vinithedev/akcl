//tb_mensalidade

package model.bean;

public class Mensalidade {
    
    private int COD_Mensalidade;
    private String Data_venc;
    private Double Valor;
    private String Descricao;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String getData_venc() {
        return Data_venc;
    }

    public void setData_venc(String Data_venc) {
        this.Data_venc = Data_venc;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    public int getCOD_Mensalidade() {
        return COD_Mensalidade;
    }

    public void setCOD_Mensalidade(int COD_Mensalidade) {
        this.COD_Mensalidade = COD_Mensalidade;
    }
    
}