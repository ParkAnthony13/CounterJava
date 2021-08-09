package parkanthony;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("count")==null) {
			session.setAttribute("count",0);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 1;
			session.setAttribute("count", currentCount);
		}
		
		if (session.getAttribute("count2")==null) {
			session.setAttribute("count2",0);
		} else {
			Integer currentCount2 = (Integer) session.getAttribute("count2");
			currentCount2 += 2;
			session.setAttribute("count2", currentCount2);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		
		return "counter.jsp";
	}
	@RequestMapping("/counter2")
	public String counter2(HttpSession session, Model model) {

		Integer count2 = (Integer) session.getAttribute("count2");
		model.addAttribute("count2", count2);
		
		return "counter2.jsp";
	}
	@RequestMapping("/remove")
	public String remove(HttpSession session, Model model) {
		if (session != null) {
			session.invalidate();
		}
		return "index.jsp";
	}
}
