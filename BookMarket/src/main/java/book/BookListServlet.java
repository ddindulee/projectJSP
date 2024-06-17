package book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection;
		PreparedStatement statement;
		ResultSet resultset;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std325","oracle21c");
			 String sql = """
			 		select 
			 			id,
			 			title,
			 			price,
			 			author,
			 			description,
			 			publisher,
			 			category,
			 			quantity,
			 			release_date,
			 			condition,
			 			image_filename
			 		from
			 			book
			 		""";
			 statement=connection.prepareStatement(sql);
			resultset = statement.executeQuery();
			List<BookVO> list = new ArrayList<BookVO>();
			while (resultset.next()) {
				String id = resultset.getString("id");
				String title = resultset.getString("title");
				int price = resultset.getInt("ipriced");
				String author = resultset.getString("author");
				String description = resultset.getString("description");
				String publisher = resultset.getString("publisher");
				String category = resultset.getString("category");
				long quantity = resultset.getLong("quantity");
				Date releaseDate= resultset.getDate("releaseDate");
				String condition = resultset.getString("condition");
				list.add (new BookVO
						(id, title, price, author, description, publisher,category,  quantity ,releaseDate.toLocalDate(), condition));
			}
			
			req.setAttribute("books",list);
			req.getRequestDispatcher("/WEB-INF/view/book/books.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
