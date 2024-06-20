package memo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos/add")
public class ServletMemoAdd extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/memo/memoAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std325","oracle21c");
			
			String sql = "insert into memo (title, content, writer) values (?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, content);
			statement.setString(3, writer);
			
			int executeUpdate = statement.executeUpdate();
			if(executeUpdate > 0) {
				response.sendRedirect(request.getContextPath()+"/memos");
				
			}else {
				request.getRequestDispatcher("/WEB-INF/view/memo/memoAdd.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
