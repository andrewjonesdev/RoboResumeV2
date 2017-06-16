package backEnd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haveYouSeenRoboCup.Duty;
import haveYouSeenRoboCup.Education;
import haveYouSeenRoboCup.MakeResume;
import haveYouSeenRoboCup.Resume;
import haveYouSeenRoboCup.Skill;
import haveYouSeenRoboCup.Work;

/**
 * Servlet implementation class ResumeS
 */
@WebServlet("/Resume")
public class ResumeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static Resume resume = new Resume();
       private static ArrayList<Resume> hiddenResumeList = new ArrayList();
       private static ArrayList<Education> hiddenEduList = new ArrayList();
       private static ArrayList<Work> hiddenWorkList = new ArrayList();
       private static ArrayList<Duty> hiddenDutyList = new ArrayList();
       private static ArrayList<Skill> hiddenSkillList = new ArrayList();
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
		// TODO Auto-generated method stub;
		String updateResume = "";
		String errorResume = "";
		if(!request.getParameter("firstName").isEmpty()&&!request.getParameter("lastName").isEmpty()&&!request.getParameter("email").isEmpty()){
			if (!request.getParameter("email").isEmpty()&&request.getParameter("email").length()>=7&&(request.getParameter("email").contains("@")&&(request.getParameter("email").contains(".com")||request.getParameter("email").contains(".gov")||request.getParameter("email").contains(".org")||request.getParameter("email").contains(".net")))){
				updateResume = "Updated";
				request.setAttribute("updateResume", updateResume);
				resume.setFirstName(request.getParameter("firstName"));
				resume.setLastName(request.getParameter("lastName"));
				resume.setEmail(request.getParameter("email"));
			}
			else{
				errorResume = "Error:&nbsp;Invalid&nbsp;Email";
				request.setAttribute("errorResume", errorResume);
			}
		}
		else{
			errorResume = "Error:&nbsp;Invalid&nbsp;Basic&nbsp;Info";
			request.setAttribute("errorResume", errorResume);
		}
		String nextURL = "/ResumeHome.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		//doGet(request, response);
	}
	public static Resume getResume(){
		return resume;
	}
	public static void newResume(){
		hiddenResumeList.add(resume);
		for (int add = 0; add < EducationS.getEduList().size();add++){
			hiddenEduList.add(EducationS.getEduList().get(add));
		}
		WorkS.getWorkList().clear();
		for (int add = 0; add < WorkS.getWorkList().size();add++){
			hiddenWorkList.add(WorkS.getWorkList().get(add));
		}
		DutyS.getDutyList().clear();
		for (int add = 0; add < DutyS.getDutyList().size();add++){
			hiddenDutyList.add(DutyS.getDutyList().get(add));
		}
		SkillS.getSkillList().clear();
		for (int add = 0; add < SkillS.getSkillList().size();add++){
			hiddenSkillList.add(SkillS.getSkillList().get(add));
		}
		SkillS.getSkillList().clear();
		resume = new Resume();
	}
	private static String generateAllResume(){
		String output = "";
		for (int print = 0; print < hiddenResumeList.size(); print++){
			output += MakeResume.generateResumeHTML(hiddenResumeList.get(print), hiddenEduList, hiddenWorkList, hiddenDutyList, hiddenSkillList);
		}
		return output;
	}
	

}
