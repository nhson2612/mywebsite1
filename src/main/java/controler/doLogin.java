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
        System.out.println("do Login");
        DAOCustomer daoCustomer = new DAOCustomer();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("name",username);

        System.out.print(daoCustomer.selectByUser(username));

        if(daoCustomer.selectByUser(username)!=null&&daoCustomer.selectByUser(username).getPassWord().equals(password)){
            System.out.println("trong if");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request,response);
        }
    }
}
