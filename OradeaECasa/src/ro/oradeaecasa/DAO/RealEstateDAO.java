package ro.oradeaecasa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.oradeaecasa.DBHelper.DBHelper;
import ro.oradeaecasa.Pojo.Client;
import ro.oradeaecasa.Pojo.Owner;
import ro.oradeaecasa.Pojo.RealEstate;

public class RealEstateDAO {

	public void createRealEstate(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String insertString = "INSERT INTO real_estate(id,address,statusOfTransaction,areaSqm,description,salePrice,rentPrice,owner_id,client_id) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, re.getId());
		stmt.setString(2, re.getAddress());
		stmt.setString(3, re.getStatusOfTransaction());
		stmt.setDouble(4, re.getAreaSqm());
		stmt.setString(5, re.getDescription());
		stmt.setDouble(6, re.getSalePrice());
		stmt.setDouble(7, re.getRentPrice());
		stmt.setString(8, re.getOwner().getName());
		stmt.setString(9, re.getClient().getName());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys(); // aflarea id-ului generat automata pentru realEstate-ul creat in DB
		rs.next();
		re.setId(rs.getInt(1));
		String insertRealEstateOwnerClient = "INSERT INTO real_estate_owner_client(real_estate_id,owner_id,client_id) VALUES (?,?,?)";
		PreparedStatement stmt2 = con.prepareStatement(insertRealEstateOwnerClient);
		stmt2.setInt(1, re.getId());
		stmt2.setInt(2, re.getOwner().getId());
		stmt2.setInt(3, re.getClient().getId());
		stmt2.executeUpdate();
		// DBHelper.closeConnection(con);

	}

	public ArrayList<RealEstate> getRealEstate() throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "SELECT * from real_estate";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		ArrayList<RealEstate> result = new ArrayList<RealEstate>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String address = rs.getString("address");
			String statusOfTransaction = rs.getString("statusOfTransaction");
			double areaSqm = rs.getDouble("areaSqm");
			String description = rs.getString("description");
			double salePrice = rs.getDouble("salePrice");
			double rentPrice = rs.getDouble("rentPrice");
			String ownerId = rs.getString("owner_id");
			String clientId = rs.getString("client_id");
			OwnerDAO odao = new OwnerDAO();
			Owner owner = odao.getOwnerById(ownerId);
			ClientDAO cdao = new ClientDAO();
			Client client = cdao.getClientById(clientId);
			RealEstate re = new RealEstate(id, address, statusOfTransaction, areaSqm, description, salePrice, rentPrice,
					owner, client);
			result.add(re);
		}
		// DBHelper.closeConnection(con);
		return result;
	}

	public RealEstate getRealEstateById(String realEstateId) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from real_estate where id=?";
		PreparedStatement stmt = con.prepareStatement(selectString);
		stmt.setString(1, realEstateId);
		ResultSet rs = stmt.executeQuery();
		RealEstate result = null;
		if (rs.next()) {
			int id = rs.getInt("id");
			String address = rs.getString("address");
			String statusOfTransaction = rs.getString("statusOfTransaction");
			double areaSqm = rs.getDouble("areaSqm");
			String description = rs.getString("description");
			double salePrice = rs.getDouble("salePrice");
			double rentPrice = rs.getDouble("rentPrice");
			String ownerId = rs.getString("owner_id");
			String clientId = rs.getString("client_id");
			OwnerDAO odao = new OwnerDAO();
			Owner owner = odao.getOwnerById(ownerId);
			ClientDAO cdao = new ClientDAO();
			Client client = cdao.getClientById(clientId);
			result = new RealEstate(id, address, statusOfTransaction, areaSqm, description, salePrice, rentPrice, owner,
					client);
			
		}
		// DBHelper.closeConnection(con);
		return result;
	}

	public RealEstate getRealEstateStatusAndClient(String realEstateId) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectString = "select * from real_estate where id=?";
		PreparedStatement stmt = con.prepareStatement(selectString);
		stmt.setString(1, realEstateId);
		ResultSet rs = stmt.executeQuery();
		RealEstate result = null;
		if (rs.next()) {
			int id = rs.getInt("id");
			String statusOfTransaction = rs.getString("statusOfTransaction");
			String clientId = rs.getString("client_id");
			ClientDAO cdao = new ClientDAO();
			Client client = cdao.getClientById(clientId);
			result = new RealEstate(id,statusOfTransaction, client);
			
		}
		// DBHelper.closeConnection(con);
		return result;
	}
	
	
	public void updateRealEstate(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String updateString = "UPDATE real_estate SET address=?,statusOfTransaction=?,areaSqm=?,description=?,salePrice=?,rentPrice=?,owner_id=?,client_id=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, re.getAddress());
		stmt.setString(2, re.getStatusOfTransaction());
		stmt.setDouble(3, re.getAreaSqm());
		stmt.setString(4, re.getDescription());
		stmt.setDouble(5, re.getSalePrice());
		stmt.setDouble(6, re.getRentPrice());
		stmt.setString(7, re.getOwner().getName());
		stmt.setString(8, re.getClient().getName());
		stmt.setInt(9, re.getId());
		stmt.executeUpdate();

		// DBHelper.closeConnection(con);
	}
	
	public void updateRealEstateOwnerId(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String updateString = "UPDATE real_estate SET owner_id=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setInt(1, re.getOwner().getId());
		stmt.setInt(2, re.getId());
		stmt.executeUpdate();

		// DBHelper.closeConnection(con);
	}

	public void deleteRealEstate(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteString = "DELETE FROM real_estate WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, re.getId());
		stmt.executeUpdate();
		String deleteStr="DELETE FROM real_estate_owner_client WHERE real_estate_id=?";
		PreparedStatement prestmt=con.prepareStatement(deleteStr);
		prestmt.setInt(1,re.getId());
		prestmt.executeUpdate();
		// DBHelper.closeConnection(con);
	}

	public void showOwnerOfRealEstate(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectWithJoin = "SELECT owner.nume,owner.phoneNumber,owner.email,real_estate.statusOfTransaction,real_estate.description, FROM owner INNER JOIN real_estate ON owner.id=real_estate.owner_id";
		PreparedStatement stmt = con.prepareStatement(selectWithJoin);
		 //stmt.executeUpdate();
		//System.out.println(re.getOwner().getName() + " " + re.getOwner().getPhoneNumber() + " "
		//		+ re.getOwner().getEmail() + " " + re.getStatusOfTransaction() + " " + re.getDescription());

		// DBHelper.closeConnection(con);
	}

	public void showClientOfRealEstate(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String selectWithJoin = "SELECT client.nume,client.phoneNumber,client.email,real_estate.statusOfTransaction,real_estate.description, FROM client INNER JOIN real_estate ON client.id=real_estate.client_id";
		PreparedStatement stmt = con.prepareStatement(selectWithJoin);
		 //stmt.executeUpdate();
		System.out.println(re.getClient().getName() + " " + re.getClient().getPhoneNumber() + " "
				+ re.getClient().getEmail() + " " + re.getStatusOfTransaction() + " " + re.getDescription());

		// DBHelper.closeConnection(con);
	}

	public void rentRealEstate(RealEstate re) throws SQLException {
		Connection con = DBHelper.getConnection();
		String updateString = "UPDATE real_estate SET statusOfTransaction=?,client_id=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, re.getStatusOfTransaction());
		stmt.setString(2, re.getClient().getName());
		stmt.setInt(3, re.getId());
		stmt.executeUpdate();

		// DBHelper.closeConnection(con);
	}
}
