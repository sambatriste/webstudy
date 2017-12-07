package webstudy;

/**
 * Created by takatani on 2017/12/07.
 *
 *
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/plus")
public class CalculateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");

        int number_x = Integer.parseInt(x);
        int number_y = Integer.parseInt(y);

        int result = number_x + number_y;

        req.setAttribute("result",result);
        req.getRequestDispatcher("/pages/calculator/plus.jsp").forward(req, resp);
    }
}
