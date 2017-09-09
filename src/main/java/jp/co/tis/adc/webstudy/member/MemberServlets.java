package jp.co.tis.adc.webstudy.member;


import jp.co.tis.adc.webstudy.util.SimpleBeanUtil;
import jp.co.tis.adc.webstudy.validation.ValidationExecutor;
import jp.co.tis.adc.webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberServlets {

    @WebServlet(name = "memberList", urlPatterns = "/member/list")
    public static class MemberList extends HttpServlet {
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

    @WebServlet(urlPatterns = "/member/inputForRegister")
    public static class MemberInputForRegister extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            req.getRequestDispatcher("/pages/member/memberInput.jsp")
               .forward(req, resp);
        }
    }

    @WebServlet(urlPatterns = "/member/register")
    public static class MemberRegister extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Member member = SimpleBeanUtil.create(req.getParameterMap(), Member.class);
            ValidationResult<Member> result = ValidationExecutor.validate(member);
            if (!result.isValid()) {
                req.setAttribute("member", member);
                result.forward("/pages/member/memberInput.jsp");
            }

            MemberService service = new MemberService();
            service.register(member);
            resp.sendRedirect("list");
        }

    }


    @WebServlet(urlPatterns = "/member/search")
    public static class MemberSearch extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Member member  = findMember(req);
            if (member == null) {
                resp.sendError(400);
                return;
            }
            req.setAttribute("member", member);

            req.getRequestDispatcher("/pages/member/memberSearch.jsp")
               .forward(req, resp);
        }
    }

    @WebServlet(urlPatterns = "/member/inputForUpdate")
    public static class MemberInputForUpdate extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Member member = findMember(req);
            if (member == null) {
                resp.sendError(400);
                return;
            }
            req.setAttribute("member", member);
            req.getRequestDispatcher("/pages/member/memberUpdate.jsp")
               .forward(req, resp);
        }
    }


    @WebServlet(urlPatterns = "/member/update")
    public static class MemberUpdate extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Member member = SimpleBeanUtil.create(req.getParameterMap(), Member.class);
            ValidationResult<Member> result = ValidationExecutor.validate(member);
            if (!result.isValid()) {
                req.setAttribute("member", member);
                result.forward("/pages/member/memberUpdate.jsp");
            }

            new MemberService().update(member);
            resp.sendRedirect("list");
        }
    }

    private static Member findMember(HttpServletRequest req) throws IOException {
        MemberFindForm form = SimpleBeanUtil.create(req.getParameterMap(), MemberFindForm.class);
        ValidationExecutor.validate(form)
                          .sendErrorIfInvalid();
        return new MemberService().findById(form.getParsedId());
    }

}