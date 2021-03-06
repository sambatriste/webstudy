package webstudy.member.servlet;

import webstudy.entity.Member;
import webstudy.member.form.MemberFindForm;
import webstudy.member.serivce.MemberService;
import webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 検索 */
public class MemberSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MemberFindForm form = new MemberFindForm(req.getParameterMap());
        ValidationResult result = form.validate();
        if (result.isError()) {
            resp.sendError(400);  // リクエスト改ざん以外発生しない.
            return;
        }
        MemberService memberService = new MemberService();
        Member member = memberService.findById(form.getMemberId());
        if (member == null) {
            resp.sendError(404);
            return;
        }
        req.setAttribute("member", member);
        req.getRequestDispatcher("/pages/member/memberSearch.jsp")
           .forward(req, resp);
    }
}
