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
import ro.oradeaecasa.DAO.OwnerDAO;
import ro.oradeaecasa.DAO.RealEstateDAO;
import ro.oradeaecasa.Pojo.Client;
import ro.oradeaecasa.Pojo.Owner;
import ro.oradeaecasa.Pojo.RealEstate;

@Controller
public class RealEstateController {
	@RequestMapping(value = "addRealEstate.htm")
	public ModelAndView displayAddForm(Model model) throws SQLException {
		
		RealEstate re = new RealEstate();
		model.addAttribute("realEstateForm", re); // realEstateForm e cel din commandName din add.jsp
		
		return new ModelAndView("realEstate/add", "model", model);
	}
	
	
	@ModelAttribute("dropBoxListOwners")
	public ArrayList <Owner> dropBoxOwners() throws SQLException{
	OwnerDAO odao=new OwnerDAO();
	ArrayList <Owner> ownersList=odao.showOwnersDropdownList();
	//System.out.println(ownersList);
	return ownersList;
	
	}
		
	@ModelAttribute("dropBoxListClients")
	public ArrayList <Client> dropBoxClients() throws SQLException{
	ClientDAO cdao=new ClientDAO();
	
	ArrayList <Client> clientsList=cdao.showClientsDropdownList();
	//System.out.println(clientsList);
	return clientsList;
	
	}
	
	@RequestMapping(value = "addRealEstate.htm", method = RequestMethod.POST)
	public ModelAndView addRealEstate(@ModelAttribute("realEstateForm") RealEstate re, ModelMap model,
			BindingResult result) {
		try {
			RealEstateDAO redao = new RealEstateDAO();
			redao.createRealEstate(re);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ModelAndView("redirect:/realEstateList.htm");
	}
	@RequestMapping(value = "realEstateList.htm", method = RequestMethod.GET)
	public ModelAndView getRealEstate() throws SQLException {
		ModelMap model = new ModelMap();
		RealEstateDAO redao = new RealEstateDAO();
		ArrayList<RealEstate> realEstates = redao.getRealEstate();
		model.put("realEstateList", realEstates);
		return new ModelAndView("realEstate/realEstateList", "model", model);// trebuie setat path-ul catre jsp-ul clients
	}
	
	@RequestMapping(value="editRealEstate/{realEstateId}")
	public ModelAndView displayEditForm(@PathVariable String realEstateId,Model model) throws SQLException {
		RealEstateDAO redao=new RealEstateDAO();
		RealEstate re= redao.getRealEstateById(realEstateId);
		
		model.addAttribute("realEstateForm",re); //realEstateForm e cel din commandName din add.jsp
		
		return new ModelAndView("realEstate/edit","model",model);
	}
	@RequestMapping(value="editRealEstate.htm", method=RequestMethod.POST)
		public ModelAndView editRealEstate(@ModelAttribute("realEstateForm") RealEstate re,ModelMap model,BindingResult result) {
		try {
			RealEstateDAO redao=new RealEstateDAO();
			redao.updateRealEstate(re);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ModelAndView("redirect:/realEstateList.htm");
		}
	
	@RequestMapping(value="deleteRealEstate/{realEstateId}")
	public ModelAndView displayDeleteForm(@PathVariable String realEstateId,Model model) throws SQLException {
		RealEstateDAO redao=new RealEstateDAO();
		redao.deleteRealEstate(redao.getRealEstateById((realEstateId)));
		
		return new ModelAndView("redirect:/realEstateList.htm");
	}
}
