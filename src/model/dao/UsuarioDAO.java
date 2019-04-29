package model.dao;

import connection.ConnectionAcademia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Usuario;

public class UsuarioDAO {
    
        public boolean checkLogin(String usuario, String senha){
        
        Usuario u = new Usuario();
        Connection con = ConnectionAcademia.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_usuario WHERE login = ? AND senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                u.setTipo_usuario(rs.getString("Tipo_usuario"));
                
                check = true;
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionAcademia.closeConnection(con, stmt, rs);
        }
        return check;
        }
}
