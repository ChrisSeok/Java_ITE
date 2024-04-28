<%@ page
	import="java.util.ArrayList, board.vo.BoardVO, board.vo.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 상세보기</title>
<!-- 부트스트랩 CDN 링크 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+z9rU+lcTzoIyFkLegdsiK/KOQ/h02KLb5t9iiC"
	crossorigin="anonymous">
<style>
body {
	padding: 20px;
}

.post-container {
	margin-bottom: 30px;
}

.post-header {
	background-color: #f8f9fa;
	padding: 25px;
	border-bottom: 1px solid #dee2e6;
}

.post-content {
	padding: 20px;
	border: 1px solid #dee2e6;
	border-radius: 5px;
	background-color: #fff;
}

.large-box {
	padding: 20px;
	border: 2px solid #007bff;
	border-radius: 10px;
	background-color: #f0f8ff;
}

.btn-primary {
	background-color: #28a745; /* 초록색 */
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	transition: text-decoration 0.3s;
}

.btn-primary:hover {
	text-decoration: underline;
}

.btn-danger {
	background-color: #dc3545;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	transition: text-decoration 0.3s;
}

.btn-danger:hover {
	text-decoration: underline;
}

.btn-tolist {
	background-color: #5a657d;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	transition: text-decoration 0.3s;
}

.btn-tolist:hover {
	text-decoration: underline;
}

.button-group {
	position: relative;
	margin-top: 20px;
	text-align: right;
}

.button-group .btn {
	margin-right: 10px;
}

.btn-commentwrite{
	width: 100%;
}


.table {
        width: 100%;
    }

</style>



<script>
function a(){

}
</script>



</head>
<body>
	<div class="container">
		<!-- 게시글 -->
		<h1 class="mt-5">게시글 상세보기</h1>
		<div class="post-container">
			<div class="post-header"></div>
			<div class="post-content">
				<%
				BoardVO postinfo = (BoardVO) session.getAttribute("POSTINFO");
				String username = (String) session.getAttribute("USERNAME");
				String useridstring = (String) session.getAttribute("UserID");
				int userid = Integer.parseInt(useridstring);
				//System.out.println("로그인한 유저: "+userid);

				if (postinfo != null) {
				%>
				<p>
				<h2>
					<strong>제목:</strong> &nbsp;<%=postinfo.getTitle()%></h2>
				</p>
				<p>
					<strong>작성자:</strong>
					<%=username%></p>
				<div class="large-box">
					<p>
						<strong>내용:</strong>
					</p>
					<p><%=postinfo.getContent()%></p>
				</div>
				<p>
					<strong>작성시간:</strong>
					<%=postinfo.getCreated_at()%></p>
				<%
				}
				%>
				
				
				
	<!-- 수정, 삭제 버튼 추가 -->
	<%
		// 세션의 user id와 글의 post id 비교하고, 일치할 경우에만 수정,삭제 버튼 보이게 !!!

		if (userid == postinfo.getUser_id()) {
		%>
	<div class="button-group">
	
		<!-- 수정 -->
		<a href="editpostservlet?postid=<%= postinfo.getPost_id() %>"
			class="btn btn-primary">수정</a>
		<!-- 삭제 -->
		<a a href="postdelete?postid=<%= postinfo.getPost_id() %>"
			class="btn btn-danger">삭제</a>
	</div>
	<%} %>
	<div class="button-group">
		<!-- 목록 -->
		<a a href="boardlistservlet" class="btn btn-tolist">글 목록으로</a>
	</div>
	
	</div>

			</div> <!-- 게시글 박스 끝입니당 -->




<!-- 댓글 -->
<!-- <div id="comments-container"></div> -->

<style>
    .horizontal-flex {
        display: flex;
        flex-direction: row;
        align-items: center; /* 요소들을 세로 중앙에 정렬합니다. */
    }
    .comment-details {
        flex-grow: 1; /* 내용이 가능한한 많은 공간을 차지하도록 합니다. */
    }
</style>
<!-- 댓글 수정, 삭제 script -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
    	//삭제버튼
        $('.delete-comment').click(function(e) {
            e.preventDefault();
            var CommentId = $(this).data('comment-id');
            var confirmation = confirm("정말로 삭제하시겠습니까?");
            if (confirmation) {
                $.ajax({
                    url: 'commentdeleteservlet',
                    method: 'POST',
                    data: { commentid: CommentId },
                    success: function(response) {
                        // 삭제가 성공하면 (삭제의 경우 수정처럼 데이터를 반환할 필요 없으니) 문자열 리턴해서 성공여부 확인 후 
                        location.reload();// 이렇게 하면 페이지 전체 리로딩된다. 그 부분만 다시 로딩되게 짜야한다.
                        
                        // 페이지 전체가 아닌 html의 특정 부분만 고치는 것을 jQuery를 사용해서 할 수 있다!!
                     },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
            }
        });
    	//수정 버튼
        // 수정 버튼 클릭 시
        $('.edit-comment').click(function(e) {
            e.preventDefault();
            var commentId = $(this).data('comment-id');
            var newText = prompt("댓글을 수정하세요:");
            if (newText !== null) {
                // Ajax를 사용하여 서블릿에 수정 요청을 보냄
                $.ajax({
                    url: 'commenteditservlet',
                    method: 'POST',
                    data: { commentid: commentId, newtext: newText },
                    success: function(response) {
                        // 수정이 성공하면 페이지를 새로고침하여 변경사항을 반영
                        location.reload();
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
            }
        });
    	
    	
    	
    	
    });
</script>






<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped" style="text-align: center; border: none; width:100%;">
                <tbody>
                    <tr>
                        <td align="left" bgcolor="beige" >댓글</td>
                        </div>
                    </tr>
                    <% ArrayList<CommentVO> comments = (ArrayList<CommentVO>) request.getAttribute("commentlist");
                    if (comments != null) {
                    for (CommentVO comm : comments) {  
                    %>
                    <tr>
                        <td>
                            <div class="card mb-3" style="border: 1px solid #dddddd; border-radius: 10px;">
                                <!-- 각각의 댓글영역 내부  -->
                                <div class="card-body horizontal-flex">
                                    <div class="comment-details">
                                        <p class="card-text"><%= comm.getUser_id()%></p>
                                        <p class="card-text"><%= comm.getComment_text() %></p>
                                        <p class="card-text"><%= comm.getCreated_at() %></p>
                                    </div>
                                    <% //본인이 쓴 댓글만 수정 가능하게 합니다
                                    if(comm.getUser_id()==userid){
                                    %>
                                    <div class="button-group">
                                        <!-- 수정 -->
                                        <button class="btn btn-primary btn-sm edit-comment" data-comment-id="<%= comm.getComment_id() %>">수정</button>
                                        <!-- 삭제 -->
                                        <button class="btn btn-danger btn-sm delete-comment" data-comment-id="<%= comm.getComment_id() %>">삭제</button>
                                    </div>
                                    <% } %>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <% } %>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>





<div class="container">
    <!-- 내용 생략 -->
<br>
    <!-- 댓글 작성 영역 -->
    <div class="fixed-bottom p-3" style="background-color: #fff;">
        <textarea class="form-control mb-2 btn-commentwrite" rows="3" placeholder="댓글을 작성하세요..."></textarea>
        <button class="btn btn-primary" style="float: right;" >댓글 작성</button>
        <br><br><br>
    </div>
</div>




	<!-- 부트스트랩 JS 및 기타 스크립트 파일들을 불러오는 CDN 링크 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-bCFkBRo14VX8fZV0U+KKTaqVXdV4aQk8W5gce1xKKl/SbGlB8foFifBpuFyD7I4M"
		crossorigin="anonymous"></script>


	<!-- jQuery CDN 링크 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+z9rU+lcTzoIyFkLegdsiK/KOQ/h02KLb5t9iiC"
		crossorigin="anonymous"></script>

</body>
</html>
