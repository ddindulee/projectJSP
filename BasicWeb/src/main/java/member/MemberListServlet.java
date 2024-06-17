package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/members")
public class MemberListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std325", "oracle21c");
			String sql = "select id, email, name, register_date from member";

			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
//			Flusx 0~무한대
			List<MemberVO> list = new ArrayList<MemberVO>();
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String email = resultSet.getString("email");
				String name = resultSet.getString("name");
				Date registerDate = resultSet.getDate("register_date");
				// Timestamp timestamp = resultSet.getTimestamp("register_date");
				// timestamp.toLocalDateTime();
				// Data Transfer Object => DTO(VO)
				list.add(new MemberVO(id, email, name, registerDate.toLocalDate()));
			}
			req.setAttribute("members", list);
			req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};
}
