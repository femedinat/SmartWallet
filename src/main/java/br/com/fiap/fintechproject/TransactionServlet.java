package br.com.fiap.fintechproject;

import br.com.fiap.fintechproject.dao.TransactionDAO;
import br.com.fiap.fintechproject.model.Transaction;
import br.com.fiap.fintechproject.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "transacao", value = "/transacao")
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        User user = (User) session.getAttribute("usuario");

        String tipo = req.getParameter("tipo");
        double valor = Double.parseDouble(req.getParameter("valor"));

        // Aqui vamos delegar a criação da transação ao DAO
        Transaction transacao = new Transaction(0, tipo, valor, user.getCd());

        TransactionDAO dao = new TransactionDAO();
        dao.inserir(transacao);

        resp.sendRedirect("home"); // Volta para a dashboard
    }
}
