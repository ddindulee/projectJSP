package book;

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

@WebServlet("/books/insert")
public class BookInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/book/addBook.jsp").forward(req, resp);
		
		req.setCharacterEncoding("utf-8");

		String id = req.getParameter("id");
		String title = req.getParameter("title");
		int price = req.getParameter("price").isEmpty() ? 0 : Integer.parseInt(req.getParameter("price"));
		String author = req.getParameter("author");
		String description = req.getParameter("description");
		String publisher = req.getParameter("publisher");
		String category = req.getParameter("category");
		long quantity = req.getParameter("quantity").isEmpty() ? 0 : Integer.parseInt(req.getParameter("quantity"));
		String releaseDate = req.getParameter("releaseDate");
		String condition = req.getParameter("condition");
		
		
		Connection connection;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std325","oracle21c");
			 StringBuilder builder = new StringBuilder();
			 builder.append("insert into book ");
			 builder.append("(id, title, price, author, description, publisher, category, release_date, condition) ");
			 builder.append("values ");
			 builder.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			 String sql = builder.toString();
			 PreparedStatement statement = connection.prepareStatement(sql);
			 statement.setString(1, id);
			 statement.setString(2, title);
			 statement.setInt(3, price);
			 statement.setString(4, author);
			 statement.setString(5, description);
			 statement.setString(6, publisher);
			 statement.setString(7, category);
			 statement.setLong(8, quantity);
			 statement.setDate(9, Date.valueOf(releaseDate));
			 statement.setString(10, condition);
			 
			int executeUpdate= statement.executeUpdate();
			if( executeUpdate> 0) {
				resp.sendRedirect("/books");
			}else {
				req.getRequestDispatcher("/WEB-INF/view/book/books.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
