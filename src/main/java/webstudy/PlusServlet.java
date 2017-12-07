package webstudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 *
 */
@WebServlet(urlPatterns = "/plus")
public class PlusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String x = req.getParameter("x");
        String y = req.getParameter("y");
        int sum = Integer.parseInt(x) + Integer.parseInt(y);
        req.setAttribute("sum", sum);
        req.getRequestDispatcher("/pages/homework/plus.jsp")
                .forward(req, resp);
    }
}