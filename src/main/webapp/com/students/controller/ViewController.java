package com.students.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.model.Student;
import com.students.repository.StudentRepository;

/**
 * Servlet implementation class StudentController
 */

@SuppressWarnings("serial")
public class ViewController extends HttpServlet {
	private StudentRepository studentRepository;

	private static String VIEW_RECORDS = "content/view_records.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewController() {
		super();
		studentRepository = new StudentRepository();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> records = studentRepository.getRecords();
		request.setAttribute("records", records);
		
		RequestDispatcher view = request.getRequestDispatcher(VIEW_RECORDS);
		view.forward(request, response);
	}
}
