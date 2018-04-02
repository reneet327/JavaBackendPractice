package com.example.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProjectServlet")

public class HOServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6632886175268784375L;

	// resource management
	// throws ServletException
	public void init() throws ServletException {
		super.init();
	}

	// resource management
	public void destroy() {
		super.destroy();
	}
	
	// Create
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// retrieve the "Test-Header" value from the HTTP request header
				String testHeaderID = "nothing";
				testHeaderID = request.getHeader("Payload-Data");

				// store the 'responseText' string in the response object (to be sent to the client)
				String responseText = "Data can be created using this method (POST).  " + testHeaderID;
;
				response.getWriter().append(responseText);
				System.out.println("POST was called.");
				// set the status of the response to 200 (OK)
				response.setStatus(HttpServletResponse.SC_OK);

			}

	// Read
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// retrieve the "Test-Header" value from the HTTP request header
				String testHeaderID = "nothing";
				testHeaderID = request.getHeader("Payload-Data");

				// store the 'responseText' string in the response object (to be sent to the client)
				String responseText = "GET is used to read information information.  " + testHeaderID;
;
				response.getWriter().append(responseText);
				System.out.println("GET was called.");
				// set the status of the response to 200 (OK)
				response.setStatus(HttpServletResponse.SC_OK);

			}
	
		
	// Update
			protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// retrieve the "Test-Header" value from the HTTP request header
				String testHeaderID = "nothing";
				testHeaderID = request.getHeader("Payload-Data");

				// store the 'responseText' string in the response object (to be sent to the client)
				String responseText = "Use this (PUT) to update information.  " + testHeaderID;
;
				response.getWriter().append(responseText);
				System.out.println("PUT was called.");
				// set the status of the response to 200 (OK)
				response.setStatus(HttpServletResponse.SC_OK);

			}
			
	// Update
			protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// retrieve the "Test-Header" value from the HTTP request header
				String testHeaderID = "nothing";
				testHeaderID = request.getHeader("Payload-Data");

				// store the 'responseText' string in the response object (to be sent to the client)
				String responseText = "Only use DELETE to remove the specified target.  " + testHeaderID;
;
				response.getWriter().append(responseText);
				System.out.println("DELETE was called.");
				// set the status of the response to 200 (OK)
				response.setStatus(HttpServletResponse.SC_OK);

			}

}
