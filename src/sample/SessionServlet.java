package sample;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String attributeName = req.getParameter("attributeName");
        String attributeValue = req.getParameter("attributeValue");
        req.getSession().setAttribute(attributeName, attributeValue);
        
        //Imprimir datos de la petición
        
        Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println("["+headerName+"]: "+req.getHeader(headerName));
		}
		
		System.out.println("[Protocol]: "+req.getProtocol());
		System.out.println("[URL]: "+req.getRequestURL());
		System.out.println("[URi]: "+req.getRequestURI());
		
	
        resp.sendRedirect(req.getRequestURL().substring(0, req.getRequestURL().lastIndexOf("/")));    
        
    }

    private static final long serialVersionUID = 2878267318695777395L;
}
