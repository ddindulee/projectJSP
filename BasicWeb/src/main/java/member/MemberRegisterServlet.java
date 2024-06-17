package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OracleDriver;

@WebServlet("/members/new")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/newMember.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼에서 전송한 데이터를 받아준다
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String password= request.getParameter("password");;
		String name = request.getParameter("name");
		
		//받은 데이터를 DB에 저장하기(JDBC를 이용)
		//0. 드라이버로딩
		//0-1.리플렉션 방법: Class.forName()
		new OracleDriver();
		
		
		PreparedStatement statement=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//0-2.DriverManger를 통한 방법
//			DriverManager.registerDriver(new OracleDriver());
			
//			1.DB접속
			Connection connection;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std325","oracle21c");
			
//			2.쿼리 작성	...생성
			
//			2-2. PreaparedStatement: insert, update와 같은 데이터가 필요한 쿼리
			String sql ="insert into member(email,password,name) values (?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, name);
			
			//3. 쿼리 실행
			int executeUpdate = statement.executeUpdate();
			if(executeUpdate>0) {
				//그냥 화면만 보여줄떄
				//redirect: DB에 있는 무언가를 조회해야할 떄, 등록이나 수정이 끝났을 때
				response.sendRedirect("/members");
			}else {
				request.getRequestDispatcher("/WEB-INF/views/member/newMember.jsp").forward(request, response);				 
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			//4. 자원 반납			
			}finally {				
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}











