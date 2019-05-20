package webstudy.member.servlet;

import webstudy.entity.Member;
import webstudy.member.serivce.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/** 一覧 */
public class MemberList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MemberService service = new MemberService();
        List<Member> allMembers = service.getAllMembers();
        req.setAttribute("memberList", allMembers);
        req.getRequestDispatcher("/pages/member/memberList.jsp")
           .forward(req, resp);
    }
}
