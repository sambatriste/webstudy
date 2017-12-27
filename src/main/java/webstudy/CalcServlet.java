package webstudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

/**
 * @author Nakayama Yumi
 *
 * 計算を行うサーブレット
 * 足し算が実装されている。
 */
@WebServlet(urlPatterns = "/plus")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String x = req.getParameter("x");
        String y = req.getParameter("y");

        int result = Integer.parseInt(x) + Integer.parseInt(y);

        req.setAttribute("result",result);

        req.getRequestDispatcher("/pages/calc/calc.jsp")
                .forward(req, resp);
    }
}
