package kr.or.ddit.user.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 사용자 아이디와 비밀번호를 reqeuest객체에서 받아온다.
		// 2. db에서 조회해온 아이디, 비밀번호를 체크한다.
		// 3_1. 일치할경우 main.jsp로 이동
		// 3_2. 불일치할경우 login.jsp로 이동
		
		//1 : input에 있는 name을 괄호에 넣어준다
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		
	
		//2 --> db대신 상수로 대체 --> db로 대체
			// 1.  사용자가 전송한 userId 파라미터로 사용자 정보조회 
			// 2.  db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교 
			// 3.  session에 사용자 정보등록(as-is : 임의의 userVo등록
			//						to-be : db에서 조회한 userVo)
			// pom.xml 에서 oracle dependecy scope삭제
		
		// 서비스 객체 생성 
		UserServiceInf service = new UserService();
		// 1.  사용자가 전송한 userId 파라미터로 사용자 정보조회 
		UserVo user = service.selectUser(userId);

	
		// 2.  db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교 
		//3_1 : main.jsp로 이동
		if(user != null &&  user.getPass().equals(password)){

			// session으로 만들기 
			request.getSession().setAttribute("user", user );
			
			//dispatch : 요청을 한번 보낸것 ( 주소줄에 http://localhost:8081/dditLogin)로 나오게된다
			RequestDispatcher rd =  request.getRequestDispatcher("/main.jsp");
			// HttpServletRequest request, HttpServletResponse resp 변수 입력하기
			rd.forward(request, response);
		}
		
		//3_2 : login.jsp로 이동
		else{
			//login폴더 안에 있기 때문에 폴더명 명시
			response.sendRedirect("/login.jsp");
		}
	}

}
