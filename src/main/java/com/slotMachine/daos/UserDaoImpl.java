package com.slotMachine.daos;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slotMachine.models.UserDetails;
import com.slotMachine.services.ValidationServiceImpl;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate h2JdbcTemplate;
	@Autowired
	private ValidationServiceImpl validationServiceImpl;

	/**
	 * Everytime you pass a username it get converted to lowercase.
	 */
	public UserDetails getUserForUsername(String username) {
		username = username.toLowerCase();
		String statement = String.format("SELECT * FROM USERS WHERE USER_USERNAME = '%s'", username);
		List<UserDetails> users = h2JdbcTemplate.query(statement, new RowMapper<UserDetails>() {
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDetails user = new UserDetails();
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setActive(rs.getInt("USER_ACTIVE"));
				user.setWinnings(rs.getInt("USER_WINNINGS"));
				return user;
			}
		});
		UserDetails emptyUser = new UserDetails();
		if (users.isEmpty()){
			return emptyUser;
		}
		return users.get(0);
	}
	
	public void addUser(UserDetails user) {
		if (getUserForUsername(user.getUsername()).getUsername().equals("")){
		try {
			String statement = String.format("INSERT INTO USERS VALUES ('%s', '%s', '%s', %d)",
					user.getUsername().toLowerCase(),
					user.getEmail(), 
					validationServiceImpl.phraseHasher(user.getPassword()), 
					user.getActive(), 
					user.getWinnings());
			h2JdbcTemplate.update(statement);
		} catch (NoSuchAlgorithmException e) {
			//throw it down here so we can see it
//			(USER_USERNAME VARCHAR(25) NOT NULL,
//					USER_EMAIL VARCHAR(50) NOT NULL,
//					USER_PASSWORD VARCHAR(50) NOT NULL,
//					USER_ACTIVE INT NOT NULL,
//					USER_WINNINGS INT NOT NULL,		
			e.printStackTrace();	
		}
		}
	}
	//update email
	//update active
	//update winnings

}
