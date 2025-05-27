package br.com.fiap.fintechproject;

import br.com.fiap.fintechproject.dao.UserDAO;
import br.com.fiap.fintechproject.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.autenticar(email, senha);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("usuario", user);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("erro", "Email ou senha inválidos.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
