package com.lti.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.bean.Account;
import com.lti.service.AccountServiceImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String acc=request.getParameter("AccountNo");
		int myacc=Integer.parseInt(acc);
		
		AccountServiceImpl service=new AccountServiceImpl();
		Account ob=service.getMyAccount(myacc);
		
		/*request.setAttribute("myacc", ob);
		RequestDispatcher red=request.getRequestDispatcher("Success.jsp");
		red.forward(request, response);*/
		Document document=new Document();
		
		try 
		{
			response.setContentType("application/pdf");
			PdfWriter writer=PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Account Number: "+ob.getAid()));
			document.add(new Paragraph("Name: "+ob.getAname()));
			document.add(new Paragraph("Date of Birth: "+ob.getDob()));
			document.add(new Paragraph("Balance: "+ob.getBalance()));
			document.close();
			writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
