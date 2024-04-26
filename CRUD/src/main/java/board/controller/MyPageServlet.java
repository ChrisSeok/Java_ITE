package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/mypageservlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
	    String session_userid = (String) session.getAttribute("UserID");
	    int userid = Integer.parseInt(session_userid);
	    
	    //userid로 userinfo 테이블에서 MemberVO 받아와서 mypage.jsp로 전달. 
	    //username, user_loginid, user_pw
	    MemberService service = new MemberService();
	    MemberVO meminfo = (MemberVO) service.getUserInfo(userid);
	    if (meminfo != null) {
	    	//mypage.jsp로 전달
			session.setAttribute("USERVO", meminfo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("mypage.jsp");
			dispatcher.forward(request, response);
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
