package mylogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("txtUn"); // get the name entered by user's input
        String password = request.getParameter("txtPw"); //get the password entered by user's input

        if(Validate.validateLog(username, password)){ // check with the validateLog method of Validate class
            response.sendRedirect("success.html");// redirect to success.html page
        }     else {
            response.sendRedirect("error.html");//redirect to error.html page
        }
        out.close();
    }

}
