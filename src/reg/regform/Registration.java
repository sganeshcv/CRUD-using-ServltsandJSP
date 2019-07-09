package reg.regform;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Student;
import com.student.StudentDao;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student Ob1 = new Student();
		Ob1.setName(request.getParameter("name"));
		Ob1.setEmail(request.getParameter("email"));
		Ob1.setDob(request.getParameter("dob"));
		Ob1.setUsername(request.getParameter("username"));
		Ob1.setPassword(request.getParameter("password"));
        if(isNullOrEmpty(Ob1.getName()) || isNullOrEmpty(Ob1.getEmail()) || isNullOrEmpty(Ob1.getDob()) || isNullOrEmpty(Ob1.getUsername()) || isNullOrEmpty(Ob1.getPassword()))
			response.sendRedirect("failed.html");

		boolean rs = StudentDao.reg(Ob1);
		if(!rs)
			response.sendRedirect("success.html");
		else 
			response.sendRedirect("failed.html");
		return;		
	}
	
    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

}
