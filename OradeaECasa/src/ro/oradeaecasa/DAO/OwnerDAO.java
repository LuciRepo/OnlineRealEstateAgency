package ro.oradeaecasa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.oradeaecasa.DBHelper.DBHelper;
import ro.oradeaecasa.Pojo.Owner;

public class OwnerDAO {

	public void createOwner(Owner o) throws SQLException {
		Connection con = DBHelper.getConnection();
		String insertString = "INSERT INTO owner (id,name,identificationCode,phoneNumber,email) VALUES (?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setInt(1, o.getId());
		stmt.setString(2, o.getName());
		stmt.setString(3, o.getIdentificationCode());
		stmt.setString(4, o.getPhoneNumber());
		stmt.setString(5, o.getEmail());
		stmt.executeUpdate();
		// DBHelper.closeConnection(con);
	}

	
	
	public ArrayList<Owner> getOwner() throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from owner";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		ArrayList<Owner> result = new ArrayList<Owner>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode = rs.getString("identificationCode");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			Owner o = new Owner(id,name, identificationCode, phoneNumber, email);
			result.add(o);
		}
		// DBHelper.closeConnection(con);
		return result;
	}

	public Owner getOwnerById(String ownerId) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from owner where id=?";
		PreparedStatement stmt = con.prepareStatement(selectString);
		stmt.setString(1, ownerId);
		ResultSet rs = stmt.executeQuery();
		Owner result = null;
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode = rs.getString("identificationCode");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			result = new Owner(id,name, identificationCode, phoneNumber, email);
		}
		// DBHelper.closeConnection(con);
		return result;
	}
	public Owner getOwnerByName(String ownerName) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from owner where name=?";
		PreparedStatement stmt = con.prepareStatement(selectString);
		stmt.setString(1, ownerName);
		ResultSet rs = stmt.executeQuery();
		Owner result = null;
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode = rs.getString("identificationCode");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			result = new Owner(id,name, identificationCode, phoneNumber, email);
		}
		// DBHelper.closeConnection(con);
		return result;
		}
	
	public int getOwnerIdByName(String ownerName) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from owner where name=?";
		PreparedStatement stmt = con.prepareStatement(selectString);
		stmt.setString(1, ownerName);
		ResultSet rs = stmt.executeQuery();
		Owner result = null;
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode = rs.getString("identificationCode");
			String phoneNumber = rs.getString("phoneNumber");
			String email = rs.getString("email");
			result = new Owner(id,name, identificationCode, phoneNumber, email);
			
		}
		// DBHelper.closeConnection(con);
		return result.getId();
	}
	public void updateOwner(Owner o) throws SQLException {
		Connection con = DBHelper.getConnection();
		String updateString = "UPDATE owner SET name=?, identificationCode=?, phoneNumber=?, email=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, o.getName());
		stmt.setString(2, o.getIdentificationCode());
		stmt.setString(3, o.getPhoneNumber());
		stmt.setString(4, o.getEmail());
		stmt.setInt(5, o.getId());
		stmt.executeUpdate();
		// DBHelper.closeConnection(con);
	}

	public void deleteOwner(Owner o) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteString = "DELETE FROM owner WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, o.getId());
		stmt.executeUpdate();
		// DBHelper.closeConnection(con);
	}
	public ArrayList<Owner> showOwnersDropdownList() throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from owner";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		ArrayList<Owner> result = new ArrayList<Owner>();
		while (rs.next()) {
			int id=rs.getInt("id");
			String name = rs.getString("name");
			String identificationCode=rs.getString("identificationCode");
			String phoneNumber=rs.getString("phoneNumber");
			String email=rs.getString("email");
			Owner o = new Owner(id,name,identificationCode,phoneNumber,email);
			result.add(o);
					
			//System.out.println(name);
		}
		// DBHelper.closeConnection(con);
		return result;
}
}