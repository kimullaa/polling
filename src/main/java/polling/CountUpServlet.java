package polling;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CountUpServlet", urlPatterns = { "/countUp" })
public class CountUpServlet extends HttpServlet {
	// countUpされる値
	int count;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.getWriter().write("{\"count\":\"" + count + "\"}");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}

	@Override
	public void init() throws ServletException {
		super.init();

		// 1sごとにcountをインクリメントする
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				count++;
			}
		};
		timer.schedule(task, 1000, 1000);
	}

}
