package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOCustomer;

import java.io.IOException;

public class doLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("name",username);

        if(DAOCustomer.getInstance().selectByUser(username)!=null){
            if(DAOCustomer.getInstance().selectByUser(username).getName() == username){
                if(DAOCustomer.getInstance().selectByUser(username).getPassWord() == password){
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request,response);
                }
            }
        }
    }
}
