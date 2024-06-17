package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/members/update")
public class MemberUpdateServlet extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String searchid = request.getParameter("id");
    	Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std325","oracle21c");
			String sql = "select id, email, password, name from member where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, Long.parseLong(searchid));
			
			resultSet = statement.executeQuery();
			MemberVO member =null;
			if(resultSet.next()) {
				long id = resultSet.getLong("id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				member = new MemberVO(id, email, password, name);
			}
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
			
    	} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				connection.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String updateId = request.getParameter("id");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std325","oracle21c");
			String sql = "update member set email =?, password= ?, name=? where id =?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, name);
			statement.setLong(4, Long.parseLong(updateId));
			
			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				response.sendRedirect("/members");
			} else {
				request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		

	}

}













