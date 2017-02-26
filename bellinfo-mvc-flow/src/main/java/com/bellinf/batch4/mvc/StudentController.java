package com.bellinf.batch4.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bellinf.batch4.mvc.model.DatabaseConnection;
import com.bellinf.batch4.mvc.model.Student;


@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getStudent(Model model){
		Student student1 = new Student();
		model.addAttribute("student", student1);
		return "student-login";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String studentDetails(@Valid @ModelAttribute Student student, BindingResult result, HttpServletRequest model){
		
		 ArrayList<Student> userInfoIterator = new ArrayList<>();
	        
	        String Name = model.getParameter("Name");
	        String Course = model.getParameter("Course");
	        int Fee = Integer.parseInt(model.getParameter("Fee"));
	        int Year = Integer.parseInt(model.getParameter("Year"));
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        System.out.println("Name \t"+ Name+"\t Course \t"+ Course+"\t Fee \t"+Fee+"\t Year \t"+Year);
	        Date date = new Date();
	        String curDate = (String)dateFormat.format(date);
	        student.setName(Name);
	        student.setCourse(Course);
	        student.setFee(Fee);
	        student.setYear(Year);
	        student.setCurDate(curDate);
	        userInfoIterator.add(student);
	        DatabaseConnection dbc = new DatabaseConnection();
	        dbc.getConnection();
	        dbc.createTable();
	        
	        dbc.InsertUserInfoValues(userInfoIterator);
	        
	        String NameRet="",CourseRet="",CurDateRet="";
	        int FreRet=0,YearRet=0;
	        
	         String Name1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getName();
	         String Course1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getCourse();
	         int fee1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getFee();
	         int year1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getYear();
	         String curDate1 = dbc.RetrieveUserInformationValues().get(dbc.UserRetrevialInfo.size()-1).getCurDate();
	        model.setAttribute("NameRet", Name1);
	        model.setAttribute("CourseRet", Course1);
	        model.setAttribute("FreRet", fee1);
	        model.setAttribute("YearRet", year1);
	        model.setAttribute("CurDateRet", curDate1);
		
		
		
		if(result.hasErrors()){
			return "student-login";
		}
		
		return "success";
	}
	
}
