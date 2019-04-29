//tb_venda

package model.bean;

public class Venda {
    
    private int COD_Venda;
    private String Descricao;
    private double Valor;

    public int getCOD_Venda() {
        return COD_Venda;
    }

    public void setCOD_Venda(int COD_Venda) {
        this.COD_Venda = COD_Venda;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

}