package webstudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String sayHelloTo = req.getParameter("to");
        if (sayHelloTo == null) {
            sayHelloTo = "World";
        }

        resp.setContentType("text/html");
        PrintWriter w = resp.getWriter();
        w.println("<!DOCTYPE html>");
        w.println("<html lang='ja'>");
        w.println("<h1>Welcome</h1>");
        w.println("Hello " + sayHelloTo + "!</h1>");
        w.println("</html>");
    }
}
