package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class MyPostServlet
 */
@WebServlet("/mypostservlet")
public class MyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Doget");
		
		
		//세션에서 가져온 user id로 posts 테이블에서 유저가 쓴 글 다 List<VO>로 가져오기.
		HttpSession session = request.getSession(true);
	    String session_userid = (String) session.getAttribute("UserID");
	    int userid = Integer.parseInt(session_userid);
	    
	    BoardService service = new BoardService();
		List<BoardVO> myresultlist = (List<BoardVO>) service.BringMyPost(userid);
		
		
		
		if(myresultlist!=null) {
//			
		    request.setAttribute("MyPostList", myresultlist); 
//		    //가져온 글 List BoardVO를 mypost.jsp로 보냅시다
		    
//		    RequestDispatcher dispatcher = request.getRequestDispatcher("board_list.jsp");
//		    dispatcher.forward(request, response);
		    response.sendRedirect("mypost.jsp");

		    
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
