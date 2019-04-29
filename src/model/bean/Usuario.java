//tb_usuario

package model.bean;

public class Usuario {
    
    private int COD_Usuario;
    private static String Tipo_usuario;        //Admin ou Funcionario //Bug de duplicação!!!
    private String Login;
    private String Senha;
    private boolean Status;
    private String Tusuario;

    public String getTusuario() {
        return Tusuario;
    }

    public void setTusuario(String Tusuario) {
        this.Tusuario = Tusuario;
    }

    public int getCOD_Usuario() {
        return COD_Usuario;
    }

    public void setCOD_Usuario(int COD_Usuario) {
        this.COD_Usuario = COD_Usuario;
    }

    public String getTipo_usuario() {
        return Tipo_usuario;
    }

    public void setTipo_usuario(String Tipo_usuario) {
        this.Tipo_usuario = Tipo_usuario;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
}
