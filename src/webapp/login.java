package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import appLayer.User;
@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));

        User userobject = new User();

        if (userobject.isValidCredentials(request.getParameter("loginname"), request.getParameter("password"))) {
            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
        }else {
            request.setAttribute("errorMessage", "Invalid Login and/or password. Please try it again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.print("Login-name: "+ request.getParameter("loginname")+ "  Password: "+request.getParameter("password"));
    }
}
