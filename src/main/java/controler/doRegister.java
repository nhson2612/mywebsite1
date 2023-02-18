package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOCustomer;

import java.io.IOException;
import java.io.PrintWriter;

public class doRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String name = request.getParameter("name");
            String numberPhone = request.getParameter("numberPhone");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String passWord = request.getParameter("passWord");
            String confirmPassWord = request.getParameter("confirmPassWord");
            String error = request.getParameter("error");

            System.out.println(name);
            System.out.println(numberPhone);
            System.out.println(dateOfBirth);
            System.out.println(sex);
            System.out.println(address);
            System.out.println(email);
            System.out.println(passWord);
            System.out.println(confirmPassWord);
            System.out.println(error);

            if (!passWord.equals(confirmPassWord)) { // xác nhận mật khẩu không khớp
                request.setAttribute("error", "xác nhận mật khẩu không khớp");
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
                System.out.println("xac nhan mat khau khong khop");
            } else if (DAOCustomer.getInstance().seachUser(name)) { // username đã tồn tại
                request.setAttribute("error", "username đã tồn tại");
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
                System.out.println("user name da ton tai");
            } else if (DAOCustomer.getInstance().searchEmail(email)) { // email đã tồn tại
                request.setAttribute("error", "email đã được đăng kí");
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.forward(request,response);
                System.out.println("Email da duoc dang ki");
            }else {
                RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
                rd.forward(request,response);
                System.out.println("khong van de j");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
