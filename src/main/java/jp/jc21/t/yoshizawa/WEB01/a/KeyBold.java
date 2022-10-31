package jp.jc21.t.yoshizawa.WEB01.a;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KeyBold
 */
@WebServlet("/Bold")
public class KeyBold extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyBold() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = "アクアパッツァとマスクメロンはおいしい";
		try {
			Language0 result = KeyPhrasesAPI.getLanguage(string);
			String[] message = result.documents[0].keyPhrases; 
			request.setAttribute("aa", message);
			request
				.getRequestDispatcher("/WEB-INF/jsp/BoldKey.jsp")
				.forward(request, response);
		}catch(IOException e) {	
		}catch(URISyntaxException e) {	
		}catch(InterruptedException e) {
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message = request.getParameter("aa");
		
		try {
			Language0 result = null;
			result = KeyPhrasesAPI.getLanguage(message);
			String[] message1 = result.documents[0].keyPhrases; 
			request.setAttribute("aa", message);
			request.setAttribute("bb", message1);

			request
				.getRequestDispatcher("/WEB-INF/jsp/KeyBold.jsp")
				.forward(request, response);
		} catch (IOException e) {
		} catch (URISyntaxException e) {
		} catch (InterruptedException e) {	
		}
	}
}

