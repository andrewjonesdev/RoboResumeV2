package backEnd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haveYouSeenRoboCup.Work;
import utilityForHire.UtilityDate;

/**
 * Servlet implementation class WorkS
 */
@WebServlet("/Work")
public class WorkS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList <Work> workList = new ArrayList();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkS() {
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
		String addWork = "";
		String errorWork = "";
		String entryWork = "";
		
		try{
			if(!request.getParameter("jobTitle").isEmpty()&&!request.getParameter("employer").isEmpty()&&!request.getParameter("startMonth").isEmpty()&&!request.getParameter("endMonth").isEmpty()&&!request.getParameter("startYear").isEmpty()&&!request.getParameter("endYear").isEmpty()){
				if(Integer.parseInt(request.getParameter("startYear"))>Integer.parseInt(request.getParameter("endYear"))){
					errorWork = "Error:&nbsp;Invalid&nbsp;Work&nbsp;Duration";
					request.setAttribute("errorWork", errorWork);
				}
				else if((Integer.parseInt(request.getParameter("startYear"))==Integer.parseInt(request.getParameter("endYear")))&&(Integer.parseInt(request.getParameter("startMonth"))>Integer.parseInt(request.getParameter("endMonth")))){
					errorWork = "Error:&nbsp;Invalid&nbsp;Work&nbsp;Duration";
					request.setAttribute("errorWork", errorWork);
				}
				else{
					Work work = new Work(request.getParameter("jobTitle"), request.getParameter("employer"), UtilityDate.numToMonth(Integer.parseInt(request.getParameter("startMonth"))), UtilityDate.numToMonth(Integer.parseInt(request.getParameter("endMonth"))), Integer.parseInt(request.getParameter("startYear")), Integer.parseInt(request.getParameter("endYear")), ResumeS.getResume());
					workList.add(work);
					addWork = "Added";
					request.setAttribute("addWork", addWork);
				}
			}
			else{
				errorWork = "Error:&nbsp;Invalid&nbsp;Work";
				request.setAttribute("errorWork", errorWork);
			}
		}
		catch(Exception e){
			errorWork = "Error:&nbsp;Invalid&nbsp;Work";
			request.setAttribute("errorWork", errorWork);
		}
		finally{
			if(workList.size()==1){
				entryWork = workList.size() + "&nbsp;Entry";
			}
			else{
				entryWork = workList.size() + "&nbsp;Entries";
			}
		request.setAttribute("entryWork", entryWork);
		String nextURL = "/ResumeHome.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}
		//doGet(request, response);
	}
	public static ArrayList<Work> getWorkList(){
		return workList;
	}

}
