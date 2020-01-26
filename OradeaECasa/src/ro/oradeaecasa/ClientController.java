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
import ro.oradeaecasa.Pojo.Client;

@Controller
public class ClientController {

	@RequestMapping(value = "addClient.htm")
	public ModelAndView displayAddForm(Model model) {

		Client c = new Client();
		model.addAttribute("clientForm", c); // bankForm e cel din commandName din add.jsp
		return new ModelAndView("client/add", "model", model);
	}

	@RequestMapping(value = "addClient.htm", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("clientForm") Client c, ModelMap model, BindingResult result) {
		try {
			ClientDAO cdao = new ClientDAO();
			cdao.createClient(c);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ModelAndView("redirect:/clients.htm");
	}

	@RequestMapping(value = "clients.htm", method = RequestMethod.GET)
	public ModelAndView getClients() throws SQLException {
		ModelMap model = new ModelMap();
		ClientDAO cdao = new ClientDAO();
		ArrayList<Client> clients = cdao.getClient();
		model.put("clients", clients);
		return new ModelAndView("client/clients", "model", model);// trebuie setat path-ul catre jsp-ul clients
	}

	@RequestMapping(value = "details/{clientId}")
	public ModelAndView geClientDetails(@PathVariable String clientId) throws SQLException {
		// cerem object Client dupa Id din SQL
		ClientDAO cdao = new ClientDAO();
		Client client = cdao.getClientById(clientId);
		// punem obj pe Model
		ModelMap model = new ModelMap();
		model.put("client", client);
		// trimitem modelul in jsp
		return new ModelAndView("client/details", "model", model);
	}
	
	@RequestMapping(value="editClient/{clientId}")
	public ModelAndView displayEditForm(@PathVariable String clientId,Model model) throws SQLException {
		ClientDAO cdao=new ClientDAO();
		Client c= cdao.getClientById(clientId);
		//System.out.println(b.getName());
		model.addAttribute("clientForm",c); //clientForm e cel din commandName din add.jsp
		
		return new ModelAndView("client/edit","model",model);
	}
	@RequestMapping(value="editClient.htm", method=RequestMethod.POST)
		public ModelAndView editClient(@ModelAttribute("clientForm") Client client,ModelMap model,BindingResult result) {
		try {
			ClientDAO cdao=new ClientDAO();
			cdao.updateClient(client);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ModelAndView("redirect:/clients.htm");
		}
	@RequestMapping(value="deleteClient/{clientId}")
	public ModelAndView displayDeleteForm(@PathVariable String clientId,Model model) throws SQLException {
		ClientDAO cdao=new ClientDAO();
		cdao.deleteClient(cdao.getClientById((clientId)));
		//System.out.println(b.getName());
				
		//return new ModelAndView("bank","model",model);
		return new ModelAndView("redirect:/clients.htm");
	}
}