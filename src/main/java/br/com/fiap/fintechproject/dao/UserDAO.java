package br.com.fiap.fintechproject.dao;

import br.com.fiap.fintechproject.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User autenticar(String email, String senha) {
        User usuario = null;

        String sql = "SELECT * FROM tb_users WHERE email_user = ? AND pwd_user = ?";

        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, email.trim());
            stmt.setString(2, senha.trim());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new User(
                        rs.getString("NM_USER"),
                        rs.getString("CPF_USER"),
                        rs.getString("PWD_USER"),
                        rs.getString("EMAIL_USER"),
                        rs.getInt("CD_USER")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
