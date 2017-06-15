package backEnd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haveYouSeenRoboCup.Education;

/**
 * Servlet implementation class EducationS
 */
@WebServlet("/Education")
public class EducationS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static ArrayList <Education> eduList = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationS() {
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
		Education education = new Education(request.getParameter("courseOfStudy"), request.getParameter("degree"), request.getParameter("school"), Integer.parseInt(request.getParameter("gradYear")), ResumeS.getResume());
		eduList.add(education);
		String nextURL = "/ResumeHome.html";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		//doGet(request, response);
	}
	public static ArrayList<Education> getEduList(){
		return eduList;
	}

}
