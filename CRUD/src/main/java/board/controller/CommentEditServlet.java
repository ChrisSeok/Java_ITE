package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.CommentService;
import board.vo.CommentVO;

/**
 * Servlet implementation class CommentEditServlet
 */
@WebServlet("/commenteditservlet")
public class CommentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("댓 수정 서블릿");
		String id = request.getParameter("commentid");
		String text = request.getParameter("newtext");
//		System.out.println("수정할 댓글내용:"+text);
		int commid = Integer.parseInt(id);
		
		CommentVO vo = new CommentVO();
		vo.setComment_id(commid);
		vo.setComment_text(text);
		
		CommentService comservice = new CommentService();
		int row = comservice.updateComment(vo);

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
