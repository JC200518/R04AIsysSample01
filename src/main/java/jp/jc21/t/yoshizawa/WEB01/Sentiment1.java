package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sentiment1
 */
@WebServlet("/Sen1")
public class Sentiment1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sentiment1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = "アクアパッツァとマスクメロンはおいしい";
		try {
			Sentiments result = Sentiment.getSentiments(string);
			ConfidenceScore result2 = result.documents[0].confidenceScores; 
			request.setAttribute("a", result);
			request.setAttribute("b", result2);
			request
				.getRequestDispatcher("/WEB-INF/jsp/sentimentQ.jsp")
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
		String message = request.getParameter("string");
		
		try {
			Sentiments result = null;
			result = Sentiment.getSentiments(message);
			ConfidenceScore message1 = result.documents[0].confidenceScores; 
			request.setAttribute("aa", message);
			request.setAttribute("bb", message1);

			request
				.getRequestDispatcher("/WEB-INF/jsp/sentimentA.jsp")
				.forward(request, response);
		} catch (IOException e) {
		} catch (URISyntaxException e) {
		} catch (InterruptedException e) {	
		}
	}
}
