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

import ro.oradeaecasa.DAO.OwnerDAO;
import ro.oradeaecasa.Pojo.Owner;

@Controller
public class OwnerController {
	@RequestMapping(value = "addOwner.htm")
	public ModelAndView displayAddForm(Model model) {

		Owner o = new Owner();
		model.addAttribute("ownerForm", o); // ownerForm e cel din commandName din add.jsp
		return new ModelAndView("owner/add", "model", model);
	}

	@RequestMapping(value = "addOwner.htm", method = RequestMethod.POST)
	public ModelAndView addOwner(@ModelAttribute("ownerForm") Owner o, ModelMap model, BindingResult result) {
		try {
			OwnerDAO odao = new OwnerDAO();
			odao.createOwner(o);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ModelAndView("redirect:/owners.htm");
	}
	
	@RequestMapping(value = "owners.htm", method = RequestMethod.GET)
	public ModelAndView getOwners() throws SQLException {
		ModelMap model = new ModelMap();
		OwnerDAO odao = new OwnerDAO();
		ArrayList<Owner> owners = odao.getOwner();
		model.put("owners", owners);
		return new ModelAndView("owner/owners", "model", model);// trebuie setat path-ul catre jsp-ul clients
	}
	@RequestMapping(value = "detailsOwner/{ownerId}")
	public ModelAndView getOwnerDetails(@PathVariable String ownerId) throws SQLException {
		// cerem object Client dupa Id din SQL
		OwnerDAO odao = new OwnerDAO();
		Owner owner = odao.getOwnerById(ownerId);
		// punem obj pe Model
		ModelMap model = new ModelMap();
		model.put("owner", owner);
		// trimitem modelul in jsp
		return new ModelAndView("owner/detailsOwner", "model", model);
	}
	
	@RequestMapping(value="editOwner/{ownerId}")
	public ModelAndView displayEditForm(@PathVariable String ownerId,Model model) throws SQLException {
		OwnerDAO odao=new OwnerDAO();
		Owner o= odao.getOwnerById(ownerId);
		//System.out.println(b.getName());
		model.addAttribute("ownerForm",o); //clientForm e cel din commandName din add.jsp
		
		return new ModelAndView("owner/edit","model",model);
	}
	@RequestMapping(value="editOwner.htm", method=RequestMethod.POST)
		public ModelAndView editOwner(@ModelAttribute("ownerForm") Owner owner,ModelMap model,BindingResult result) {
		try {
			OwnerDAO odao=new OwnerDAO();
			odao.updateOwner(owner);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ModelAndView("redirect:/owners.htm");
		}
	@RequestMapping(value="deleteOwner/{ownerId}")
	public ModelAndView displayDeleteForm(@PathVariable String ownerId,Model model) throws SQLException {
		OwnerDAO odao=new OwnerDAO();
		odao.deleteOwner(odao.getOwnerById((ownerId)));
		//System.out.println(b.getName());
				
		return new ModelAndView("redirect:/owners.htm");
	}
	
}
