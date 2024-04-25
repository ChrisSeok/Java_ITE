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
 * Servlet implementation class EditPostServlet
 */
@WebServlet("/editpostservlet")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int post_id = Integer.parseInt(request.getParameter("postid"));
		
		HttpSession session = request.getSession();
	    String session_userid = (String) session.getAttribute("UserID");
	    int s_userid = Integer.parseInt(session_userid);

	    BoardVO postinfo = (BoardVO)session.getAttribute("POSTINFO"); //postinfo가 
	    
		//세션으로 userid 확인 후 본인이작성한 글이면 수정 가능하게.
		//post id를 가지고 post 정보를 vo로 불러온 다음에 
		//가져온 post 정보의 user_id와 세션의 id가 일치하면 jsp로 가고, 아니면 경고창 띄우기
	    
	    //근데...session으로 post info도 그냥 받아서 user id랑 비교 하면 될듯?!
	    
	    
//		BoardService service = new BoardService();
//		BoardVO postinfo_edit = service.ShowPost(post_id);
		
		if (postinfo.getUser_id() == s_userid) {
			// 수정 jsp로 갑시다
		
//			RequestDispatcher dispatcher = request.getRequestDispatcher("board_detail.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect("board_edit.jsp");
			
			
		}
	
		else {
			response.setContentType("text/html;charset=UTF-8");
		    
		    PrintWriter out = response.getWriter();
		    
		    out.println("<html>");
		    out.println("<head><title>Popup Example</title></head>");
		    out.println("<body>");
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert(\"본인이 쓴 글만 수정 가능합니다?!\");"); // 팝업 메시지를 출력하는 JavaScript 코드
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
