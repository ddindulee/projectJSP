package member;

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

@WebServlet("/members/delete")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deletId = req.getParameter("id");
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std325","oracle21c");
			String sql = "delete from member where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1,Long.parseLong(deletId));
			
			int executeUpdate = statement.executeUpdate();
			if(executeUpdate>0) {
				resp.sendRedirect("/members");
			}else {
//				삭제가 실패했을 경우 현재 보는 뷰 페이지 다시 보여줌
				resp.sendRedirect("/members/view?id="+deletId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
