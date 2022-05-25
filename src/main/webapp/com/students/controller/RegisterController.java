package com.students.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.repository.StudentRepository;

/**
 * Servlet implementation class StudentController
 */

@SuppressWarnings("serial")
public class RegisterController extends HttpServlet {

	private StudentRepository studentRepository;

	private static String REGISTRATION_SUCCESS = "content/register_success.jsp";
	private static String REGISTRATION_FAILURE = "content/register_failure.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		studentRepository = new StudentRepository();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = REGISTRATION_SUCCESS;

		try {
			studentRepository.register(request.getParameter("username"), request.getParameter("password"),
					request.getParameter("email"));
		} catch (SQLException e) {
			forward = REGISTRATION_FAILURE;
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
