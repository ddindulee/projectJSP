package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.membership.StaticMembershipServiceMBean;

@WebServlet("/members/view")
public class MemberViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchId = req.getParameter("id");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std325",
					"oracle21c");
			String sql = "select id, email, name, register_date from member where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, Long.parseLong(searchId));

			ResultSet resultSet = statement.executeQuery();
			// Mono: 0 또는 1
			MemberVO member = null;
			if (resultSet.next()) {
				long id = resultSet.getLong("id");
				String email = resultSet.getString("email");
				String name = resultSet.getString("name");
				Date registerDate = resultSet.getDate("register_date");
				member = new MemberVO(id, email, name, registerDate.toLocalDate());
			}
			req.setAttribute("member", member);
			req.getRequestDispatcher("/WEB-INF/views/member/view.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}
}
