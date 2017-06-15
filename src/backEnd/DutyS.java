package backEnd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haveYouSeenRoboCup.Duty;

/**
 * Servlet implementation class DutyS
 */
@WebServlet("/Duty")
public class DutyS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList <Duty> dutyList = new ArrayList();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DutyS() {
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
		if(!WorkS.getWorkList().isEmpty())
		{
		Duty duty = new Duty(request.getParameter("dutyTitle"), WorkS.getWorkList().get(WorkS.getWorkList().size()-1));
		dutyList.add(duty);
		}
		String nextURL = "/ResumeHome.html";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		//doGet(request, response);
	}
	public static ArrayList <Duty> getDutyList(){
		return dutyList;
	}
}
