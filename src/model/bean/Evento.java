//tb_evento

package model.bean;

public class Evento {
    
    private int COD_Evento;
    private String Nome;
    private String Descricao;
    private String Data;            //Tipo no banco = Date
    private String Horario;
    private double Valor;
    private boolean Status;

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getCOD_Evento() {
        return COD_Evento;
    }

    public void setCOD_Evento(int COD_Evento) {
        this.COD_Evento = COD_Evento;
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

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
}