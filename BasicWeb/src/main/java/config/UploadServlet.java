package config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part; 

@MultipartConfig(location = "c:\\uploads")
@WebServlet("/fileupload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Collection<Part> parts = request.getParts();
		
	
		response.setContentType("text/html; charset=utf-8");//한글깨지는 문제해결
		
		PrintWriter out = response.getWriter();
		for(Part part : parts){
			out.println("<br> name=" +part.getName());
			out.println("<br> content-type=" +part.getContentType());
			if(part.getHeader("Content-Disposition").contains("filename=")){
				out.println("<br> filesize=" +part.getSize());
				out.println("<br> filename=" +part.getSubmittedFileName());
				part.write("C:\\uploads\\"+part.getSubmittedFileName());
			}else{
				out.println("<br> value: "+ request.getParameter(part.getName()));
			}
		}
	}

}
