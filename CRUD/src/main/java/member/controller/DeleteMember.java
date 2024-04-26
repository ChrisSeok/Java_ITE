package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class DeleteMember
 */


@WebServlet("/deletemember")

public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//세션에 있는 MemberVO 를 활용해서 멤버 삭제, 세션에 있는 정보 모두 삭제하기, 로그인 화면으로 돌려보내.
		HttpSession session = request.getSession(true);
		MemberVO uservo = (MemberVO) session.getAttribute("USERVO");
		int user_id = Integer.parseInt(uservo.getUser_id());
		
		//user id로 삭제 쿼리로 
		MemberService service = new MemberService();
		int drow= service.DeleteMember(user_id);
		
		if (drow == 1) {
			System.out.println("회원탈퇴 성공!");
			
			//팝업 띄우기
			
			//세션 삭제하고 로그인 페이지 (index.jsp) 으로 갑시다
			session.invalidate();
			String popupScript = "<script>alert('회원탈퇴 성공!'); window.location.href='index.jsp';</script>";
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			response.sendRedirect("index.jsp");
			response.getWriter().println(popupScript);
//			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
