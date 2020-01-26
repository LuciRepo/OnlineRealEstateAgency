package ro.oradeaecasa;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.oradeaecasa.DAO.ClientDAO;
import ro.oradeaecasa.DAO.RealEstateDAO;
import ro.oradeaecasa.Pojo.Client;
import ro.oradeaecasa.Pojo.RealEstate;

@Controller
public class TransactionController {
	@RequestMapping(value="rentRealEstate/{realEstateId}")
	public ModelAndView displayEditForm(@PathVariable String realEstateId,Model model) throws SQLException {
		RealEstateDAO redao=new RealEstateDAO();
		RealEstate re= redao.getRealEstateStatusAndClient(realEstateId);
		
		model.addAttribute("rentEstateForm",re); //realEstateForm e cel din commandName din add.jsp
		
		return new ModelAndView("transaction/rent","model",model);
	}
	
	@ModelAttribute("dropBoxListClients")
	public ArrayList <Client> dropBoxClients() throws SQLException{
	ClientDAO cdao=new ClientDAO();
	
	ArrayList <Client> clientsList=cdao.showClientsDropdownList();
	//System.out.println(clientsList);
	return clientsList;
	
	}
	
	@RequestMapping(value="rentRealEstate.htm", method=RequestMethod.POST)
		public ModelAndView rentRealEstate(@ModelAttribute("rentEstateForm") RealEstate re,ModelMap model,BindingResult result) {
		// re=new RealEstate();
		// System.out.println(re.getId());
		try {
			RealEstateDAO redao=new RealEstateDAO();
			redao.rentRealEstate(re);
			//redao.updateRealEstate(re);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ModelAndView("redirect:/realEstateList.htm");
		}
}
