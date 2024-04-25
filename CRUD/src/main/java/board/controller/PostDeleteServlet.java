package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class PostDeleteServlet
 */

@WebServlet("/postdelete")

public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int post_id = Integer.parseInt(request.getParameter("postid"));

		//본인이 쓴 글만 삭제 가능하도록 세션 정보를 확인한다
		HttpSession session = request.getSession();
	    String session_userid = (String) session.getAttribute("UserID");
	    int s_userid = Integer.parseInt(session_userid);

	    BoardVO postinfo = (BoardVO)session.getAttribute("POSTINFO");
	    
	    if (postinfo.getUser_id() == s_userid) {
			//post id를 가지고 post를 삭제합시다
			//삭제 후 boardListServlet으로 갑쉬다
			BoardService service = new BoardService();
			int deleterow = service.deletePost(post_id);
			
			if (deleterow==1) {
				// 서블릿에서 다른 서블릿으로 이동하는 코드
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/boardlistservlet");
				dispatcher.forward(request, response);
	
			}
			else {
				System.out.println("글 삭제 실패했는데요?");
			}
	    }
	    else {
	    	response.setContentType("text/html;charset=UTF-8");
		    
		    PrintWriter out = response.getWriter();
		    
		    out.println("<html>");
		    out.println("<head><title>Popup Example</title></head>");
		    out.println("<body>");
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert(\"본인이 쓴 글만 삭제 가능합니다?!\");"); // 팝업 메시지를 출력하는 JavaScript 코드
		    out.println("window.location.href = 'board_detail.jsp';");  //세션 정보를 가지고 있어서 이전 글의 detail 페이지로 가는건가?
		    out.println("</script>");
		    out.println("</body>");
		    out.println("</html>");
		  
		    out.close();
	    }


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
