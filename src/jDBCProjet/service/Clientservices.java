package jDBCProjet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jDBCProjet.Dao.IDAO;
import jDBCProjet.beans.Client;
import jDBCProjet.connexion.Connexion;

public class Clientservices implements IDAO<Client> {

	@Override
	public boolean create(Client o) {

		PreparedStatement stmt;
		try {
			stmt = Connexion.getConn().prepareStatement("INSERT into Client (prenom,nom) VALUES (?,?)");
			stmt.setString(1, o.getNom());
			stmt.setString(2, o.getPrenom());
			int count = stmt.executeUpdate();

			if (count > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Client> findAll() {

		String query = "SELECT * FROM Client ";
		List<Client> l = new ArrayList<>();
		try {
			Statement stmt = Connexion.getConn().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Client c = new Client(rs.getInt(1), rs.getString(2), rs.getString(3));
				l.add(c);

			}

			return l;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Client findById(int id) {

		String query = "SELECT * From Client where id = ?";
		try {
			PreparedStatement ps = Connexion.getConn().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Client c = new Client(rs.getInt(1), rs.getString(2), rs.getString(3));
				return c;
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("nnnn");
			return null;
		}
	}

	@Override
	public boolean delete(Client o) {
		String query = "DELETE From Client where id = ?";
		try {
		    PreparedStatement ps = Connexion.getConn().prepareStatement(query);
		    ps.setInt(1, o.getId());
		    int count = ps.executeUpdate(); 
		    return count > 0;
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("nnnn");
		    return false;
		}

		
	}

	@Override
	public boolean update(Client o) {
	    String query = "UPDATE Client SET prenom = ?, nom = ? WHERE id = ?";
	    try {
	        PreparedStatement ps = Connexion.getConn().prepareStatement(query);
	        ps.setString(1, "update");
	        ps.setString(2, "query");
	        ps.setInt(3, o.getId());
	        int count = ps.executeUpdate();
	        return count > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


}
