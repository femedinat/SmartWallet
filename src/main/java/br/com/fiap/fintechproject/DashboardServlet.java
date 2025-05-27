package br.com.fiap.fintechproject;

import br.com.fiap.fintechproject.dao.TransactionDAO;
import br.com.fiap.fintechproject.model.Transaction;
import br.com.fiap.fintechproject.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "dashboard", urlPatterns = {"/home"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("index.jsp"); // ou página de login
            return;
        }

        User user = (User) session.getAttribute("usuario");
        int userCd = user.getCd();

        TransactionDAO dao = new TransactionDAO();

        List<Transaction> transacoes = dao.listarPorUsuario(userCd);
        double totalReceitas = dao.calcularTotalPorTipo(userCd, "Receita");
        double totalDespesas = dao.calcularTotalPorTipo(userCd, "Despesa");
        double saldo = totalReceitas - totalDespesas;

        req.setAttribute("transacoes", transacoes);
        req.setAttribute("receitas", totalReceitas);
        req.setAttribute("despesas", totalDespesas);
        req.setAttribute("saldo", saldo);

        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
