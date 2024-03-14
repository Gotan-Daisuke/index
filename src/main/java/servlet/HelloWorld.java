package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import dao.Logindao;
import entity.LoginEntity;

/**
 * Servlet implementation class HalloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/helloworld.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 文字コードの指定
	    request.setCharacterEncoding("utf-8");
	    // formから値を取得
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    
	    List<LoginEntity> list = new ArrayList<>();
	    Logindao dao = new Logindao();
	    list = dao.findAll(name,password);
	    if(StringUtils.isBlank(list.get(0).getUsername())) {
	    	
	    	request.setAttribute("result", "ログイン出来ませんでした");
			String view = "/WEB-INF/view/helloworld.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);

	    	
	    }
	    
	    // HTTPセッション生成（取得）
	    HttpSession session = request.getSession(false);
	    
	    // 既にセッションが存在する場合は一度破棄する
	    if (session != null) {
	      log("セッション破棄 セッションID=[" + session.getId() + "]");
	      session.invalidate();
	    }
	    
	    try {
	        // セッションを新規で作成する
	        session = request.getSession(true);
	        
	        // ログイン名をセッションで保持する
	        request.setAttribute("userid", list.get(0).getUserId());
	        request.setAttribute("username", list.get(0).getUsername());
	        
			String view = "/WEB-INF/view/success.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
	    }catch(Exception e){
	        log("セッション作成 失敗");
	        // 例外によりセッションの作成に失敗
	        e.printStackTrace();
	    }

	    


	}

}
