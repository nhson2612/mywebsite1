package controler;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.DAOCustomer;

import java.io.IOException;
import java.io.PrintWriter;

public class doLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do Login");
        DAOCustomer daoCustomer = new DAOCustomer();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        System.out.println(remember);
        String errorMessage = " ";

        HttpSession session = request.getSession();
        session.setAttribute("name",username);

        System.out.print(daoCustomer.selectByUser(username));

        if(daoCustomer.selectByUser(username)!=null&&daoCustomer.selectByUser(username).getPassWord().equals(password)){
            if(remember!=null){
                session.setAttribute("pass",password);
            }
            int id = daoCustomer.selectByUser(username).getId();
            long numberPhone = daoCustomer.selectByUser(username).getNumberPhone();
            String email = daoCustomer.selectByUser(username).getEmail();
            session.setAttribute("numberPhone",numberPhone);
            session.setAttribute("email",email);
            session.setAttribute("id",id);
            session.setAttribute("error",errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request,response);
        } else if (daoCustomer.selectByUser(username)==null||!daoCustomer.selectByUser(username).getPassWord().equals(password)) {
            errorMessage = "Tên đăng nhập hoặc mật khẩu không chính xác , Vui lòng nhập lại chính xác !";
            session.setAttribute("error",errorMessage);
            RequestDispatcher rd  = request.getRequestDispatcher("/login.jsp");
            rd.forward(request,response);
        }

    }
}
