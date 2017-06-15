package backEnd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haveYouSeenRoboCup.Resume;

/**
 * Servlet implementation class ResumeS
 */
@WebServlet("/Resume")
public class ResumeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static Resume resume;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resume = new Resume(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"));
		String nextURL = "/ResumeHome.html";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		//doGet(request, response);
	}
	public static Resume getResume(){
		return resume;
	}

}
