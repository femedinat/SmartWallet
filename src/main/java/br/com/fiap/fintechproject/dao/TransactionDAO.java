package br.com.fiap.fintechproject.dao;

import br.com.fiap.fintechproject.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public List<Transaction> listarPorUsuario(int userId) {
        List<Transaction> lista = new ArrayList<>();

        String sql = "SELECT * FROM TB_TRANSACTIONS WHERE CD_USER = ?";

        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("CD_TRANSACTIONS"),
                        rs.getString("TYPE"),
                        rs.getDouble("VALOR"),
                        rs.getInt("CD_USER")
                );

                lista.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public double calcularTotalPorTipo(int userId, String tipo) {
        double total = 0.0;

        String sql = "SELECT SUM(VALOR) FROM TB_TRANSACTIONS WHERE CD_USER = ? AND TYPE = ?";

        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, tipo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public void inserir(Transaction transacao) {
        String sql = "INSERT INTO TB_TRANSACTIONS (CD_TRANSACTIONS, TYPE, VALOR, CD_USER) VALUES (SQ_TRANSACTIONS.NEXTVAL, ?, ?, ?)";

        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, transacao.getType());
            stmt.setDouble(2, transacao.getValue());
            stmt.setInt(3, transacao.getCdUser());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
