package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Supermarche;

public class SupermarcheDaoImpl implements ISupermarcheDao {

	@Override
	public Supermarche save(Supermarche s) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO supermarche(NOM_Supermarche,TYPE,Localisation_Supermarche,Date_de_creation) VALUES(?,?,?,?)");
			ps.setString(1, s.getNomSupermarche());
			ps.setString(2, s.getType());
			ps.setString(3, s.getLoc());
			ps.setDate(4, s.getDateSup());
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_Supermarche ) as MAX_ID FROM supermarche");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				s.setIdSupermarche(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Supermarche> supermarcheParMC(String mc) {
		List<Supermarche> supers = new ArrayList<Supermarche>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from supermarche where NOM_Supermarche LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supermarche s = new Supermarche();
				s.setIdSupermarche(rs.getLong("ID_Supermarche"));
				s.setNomSupermarche(rs.getString("NOM_Supermarche"));
				s.setType(rs.getString("TYPE"));
				s.setLoc(rs.getString("Localisation_Supermarche"));
				s.setDateSup(rs.getDate("Date_de_creation"));
				supers.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supers;
	}

	@Override
	public Supermarche getSupermarche(Long id) {
		Connection conn = SingletonConnection.getConnection();
		Supermarche s = new Supermarche();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from supermarche where ID_Supermarche = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setIdSupermarche(rs.getLong("ID_Supermarche"));
				s.setNomSupermarche(rs.getString("NOM_Supermarche"));
				s.setType(rs.getString("TYPE"));
				s.setLoc(rs.getString("Localisation_Supermarche"));
				s.setDateSup(rs.getDate("Date_de_creation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Supermarche  updateSupermarche(Supermarche s) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE supermarche SET NOM_Supermarche=?,TYPE=?,Localisation_Supermarche=? WHERE ID_Supermarche=?");
			ps.setString(1, s.getNomSupermarche());
			ps.setString(2, s.getType());
			ps.setString(3, s.getLoc());
			ps.setLong(4, s.getIdSupermarche());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void deleteSupermarche(Long id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM supermarche WHERE ID_Supermarche = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
