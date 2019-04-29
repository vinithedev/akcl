//tb_produto

package model.bean;

public class Produto {
    
    private int COD_Produto;
    private String Nome;
    private String Fornecedor;
    private Double Valor_Compra;
    private Double Valor_Venda;
    private String Descricao;
    private boolean Status;
    private int Quantidade;

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public Double getValor_Compra() {
        return Valor_Compra;
    }

    public void setValor_Compra(Double Valor_Compra) {
        this.Valor_Compra = Valor_Compra;
    }

    public Double getValor_Venda() {
        return Valor_Venda;
    }

    public void setValor_Venda(Double Valor_Venda) {
        this.Valor_Venda = Valor_Venda;
    }
    
    public int getCOD_Produto() {
        return COD_Produto;
    }

    public void setCOD_Produto(int COD_Produto) {
        this.COD_Produto = COD_Produto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

}