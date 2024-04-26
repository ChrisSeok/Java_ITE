package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.CommentService;
import board.vo.BoardVO;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/commentdeleteservlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//댓글 아이디를 받아서 댓글을 지울게용
//		System.out.println("댓삭서블릿");
		String id = request.getParameter("commentid");
		int commid = Integer.parseInt(id);
		
		CommentService comservice = new CommentService();
		int row = comservice.deleteComment(commid);

		// 클라이언트에게 응답을 전송합니다.
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		if (row==1) {
			out.println("댓글이 성공적으로 삭제되었습니다.");
		} else {
			out.println("댓글 삭제 중 오류가 발생하였습니다.");
		}
		out.close();
	
	
	}

}
