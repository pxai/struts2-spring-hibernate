package info.pello.spring.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * DAO for customer entity
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 *
 */
public class CustomerDAO {

	// I use both jdbcTemplate/namedParameterJdbcTemplate depending on needs
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final static String CREATE_SQL = "insert into customer (name,address,email) values(:name,:address,:email)";
	private final static String UPDATE_SQL = "update customer set name=?,address=?,email=? where id=?";
	private final static String DELETE_SQL = "delete from customer where id=?";
	private final static String SELECT_ALL_SQL = "select * from customer order by id";
	private final static String SELECT_BY_ID_SQL = "select * from customer where id=?";
	
	/**
	 * gets Customer data from DataBase
	 * @param customerId
	 * @return
	 */
	public Customer getCustomersById (long customerId) {
		// we need a custom class to map rows with our class.
		// in this case we do everything on the fly: is the second parameter of queryForObject
		return jdbcTemplate.queryForObject(
				SELECT_BY_ID_SQL,
				new ParameterizedRowMapper<Customer>() {
					public Customer mapRow (ResultSet rs, int rowNumber) {
						Customer newCustomer = new Customer();
						try {
							newCustomer.setId(rs.getLong(1));
							newCustomer.setName(rs.getString(2));
							newCustomer.setAddress(rs.getString(3));
							newCustomer.setEmail(rs.getString(4));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return newCustomer;
					}
				},
				customerId
				);
	} 

	/**
	 * gets all Customer data from DataBase
	 * @return list of customers
	 */
	public List<Customer> getCustomers () {
		// Being pro:
		List<Customer> customers = new ArrayList<Customer>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_SQL); 

		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setId((Long)(row.get("id")));
			customer.setName((String)row.get("name"));
			customer.setAddress((String)row.get("address"));
			customer.setEmail((String)row.get("email"));
			customers.add(customer);
		}
		
		// Bajeril Style
		// Living la vida loca, RowMapper is a Raw type but
		// everything may be ok.
		/*List<Customer> customers = jdbcTemplate.query(SELECT_ALL_SQL,
				new BeanPropertyRowMapper(Customer.class));*/
	
		return customers;
	} 
	
	/**
	 * creates new Customer
	 * @param newCustomer
	 * @return
	 */
	public long create (Customer newCustomer) {
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("name", newCustomer.getName());
		namedParameters.addValue("address", newCustomer.getAddress());
		namedParameters.addValue("email", newCustomer.getEmail());
		
		namedParameterJdbcTemplate.update(CREATE_SQL,
							namedParameters,
							generatedKeyHolder);
		
		// Maybe this is not suitable for all
		newCustomer.setId(generatedKeyHolder.getKey().intValue());
		return newCustomer.getId();
	}
	
	/**
	 * updates customer information 
	 * @param customer
	 * @return affected rows
	 */
	public int update (Customer customer) {
		return jdbcTemplate.update(UPDATE_SQL,
							customer.getName(),
							customer.getAddress(),
							customer.getEmail(),
							customer.getId());
	}
	
	/**
	 * delete customer  
	 * @param customerId
	 * @return affected rows
	 */
	public int delete (long customerId) {
		return jdbcTemplate.update(DELETE_SQL,
				customerId);
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @return the namedParameterJdbcTemplate
	 */
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	/**
	 * @param namedParameterJdbcTemplate the namedParameterJdbcTemplate to set
	 */
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


}
