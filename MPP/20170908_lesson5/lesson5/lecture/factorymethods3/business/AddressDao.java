package lesson5.lecture.factorymethods3.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lesson5.lecture.factorymethods3.dataaccess.Dao;
import lesson5.lecture.factorymethods3.dataaccess.DataAccess;
import lesson5.lecture.factorymethods3.dataaccess.DataAccessFactory;

public class AddressDao implements Dao {
	DataAccess da = DataAccessFactory.getDataAccess();
	private List<Address> allAddresses;
	public List<Address> getAllAddresses() {	
		try {
			da.read(this);
			allAddresses = (List<Address>)getResults();
		} catch(SQLException e) {
			//handle
		}
		return allAddresses;
	}
	public AddressDao() {}
	
	@Override
	public String getSql() {
		return "SELECT * from ADDRESS";
	}
	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		allAddresses = new ArrayList<>();
		while(rs.next()) {
			allAddresses.add(new Address(rs.getString("street").trim(), 
					rs.getString("city").trim(),
					rs.getString("state").trim(),
					rs.getString("zip").trim()));
		}		
	}
	@Override
	public List<?> getResults() {
		return allAddresses;
	}
}
