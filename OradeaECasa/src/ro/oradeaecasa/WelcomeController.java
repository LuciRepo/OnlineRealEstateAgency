package ro.oradeaecasa;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping(value="about.htm", method=RequestMethod.GET)
	public ModelAndView getAbout(){
		ModelMap map = new ModelMap();
		
		return new ModelAndView("about","model",map);
		
}
	@RequestMapping(value="home.htm", method=RequestMethod.GET)
	public ModelAndView getHome(){
		ModelMap map = new ModelMap();
		
		return new ModelAndView("home","model",map);
		
}
}