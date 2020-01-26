package ro.oradeaecasa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.oradeaecasa.DBHelper.DBHelper;
import ro.oradeaecasa.Pojo.Client;

public class ClientDAO {

	public void createClient(Client c) throws SQLException {
		Connection con = DBHelper.getConnection();
		String insertString = "INSERT INTO client (name,identificationCode,phoneNumber,email) VALUES (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		//stmt.setInt(1, c.getId());
		stmt.setString(1, c.getName());
		stmt.setString(2, c.getIdentificationCode());
		stmt.setString(3, c.getPhoneNumber());
		stmt.setString(4, c.getEmail());
		stmt.executeUpdate();
		// DBHelper.closeConnection(con);
	}

	public ArrayList<Client> getClient() throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from client";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		ArrayList<Client> result = new ArrayList<Client>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode = rs.getString("identificationCode");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			Client c = new Client(id,name, identificationCode, phoneNumber, email);
			result.add(c);
		}
		// DBHelper.closeConnection(con);
		return result;
	}
	
	public Client getClientById(String clientId) throws SQLException {
		Connection con=DBHelper.getConnection();
		String selectString ="select * from client where id=?";
		PreparedStatement stmt=con.prepareStatement(selectString);
		stmt.setString(1,clientId);
		ResultSet rs=stmt.executeQuery();
		Client result=null;
		if (rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String identificationCode=rs.getString("identificationCode");
			String phoneNumber=rs.getString("phoneNumber");
			String email=rs.getString("email");
			result = new Client(id,name,identificationCode,phoneNumber,email);
		}
		//DBHelper.closeConnection(con);
		return result;
	}
	
	public void updateClient(Client c)throws SQLException{
		Connection con=DBHelper.getConnection();
		String updateString="UPDATE client SET name=?,identificationCode=?,phoneNumber=?,email=? WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(updateString);
		stmt.setString(1,c.getName());
		stmt.setString(2,c.getIdentificationCode());
		stmt.setString(3,c.getPhoneNumber());
		stmt.setString(4,c.getEmail());
		stmt.setInt(5,c.getId());
		stmt.executeUpdate();
		//DBHelper.closeConnerction(con);
	}
	
	public void deleteClient(Client c) throws SQLException{
		Connection con=DBHelper.getConnection();
		String deleteString="DELETE FROM client WHERE id=?";
		PreparedStatement stmt =con.prepareStatement(deleteString);
		stmt.setInt(1,c.getId());
		stmt.executeUpdate();
		//DBHelper.closeConnection(con);
	}
	public ArrayList<Client> showClients() throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select name from client";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		ArrayList<Client> result = new ArrayList<Client>();
		while (rs.next()) {
			String name = rs.getString("name");
			Client c = new Client(name);
			result.add(c);
			//System.out.println(name);
		}
		// DBHelper.closeConnection(con);
		return result;
	
	
	}	
	
	public ArrayList<Client> showClientsDropdownList() throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from client";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		ArrayList<Client> result = new ArrayList<Client>();
		while (rs.next()) {
			int id=rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode=rs.getString("identificationCode");
			String phoneNumber=rs.getString("phoneNumber");
			String email=rs.getString("email");
			Client c = new Client(id,name,identificationCode,phoneNumber,email);
			result.add(c);
					
			//System.out.println(name);
		}
		// DBHelper.closeConnection(con);
		return result;
}
	
	
}
