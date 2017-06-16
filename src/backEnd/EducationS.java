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
		String addEducation = "";
		String errorEducation = "";
		String entryEducation = "";
		try{
			if(!request.getParameter("courseOfStudy").isEmpty()&&!request.getParameter("degree").isEmpty()&&!request.getParameter("school").isEmpty()&&!request.getParameter("gradYear").isEmpty()){
				Education education = new Education(request.getParameter("courseOfStudy"), request.getParameter("degree"), request.getParameter("school"), Integer.parseInt(request.getParameter("gradYear")), ResumeS.getResume());
				eduList.add(education);
				addEducation = "Added";
				request.setAttribute("addEducation", addEducation);
			}
			else{
				errorEducation = "Error:&nbsp;Invalid&nbsp;Education";
				request.setAttribute("errorEducation", errorEducation);
			}
		}
		catch(Exception e){
			errorEducation = "Error:&nbsp;Invalid&nbsp;Education";
			request.setAttribute("errorEducation", errorEducation);
		}
		finally{
			if(eduList.size()==1){
				entryEducation = eduList.size() + "&nbsp;Entry";
			}
			else{
				entryEducation = eduList.size() + "&nbsp;Entries";
			}
			request.setAttribute("entryEducation", entryEducation);
		String nextURL = "/ResumeHome.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}
		//doGet(request, response);
	}
	public static ArrayList<Education> getEduList(){
		return eduList;
	}

}
