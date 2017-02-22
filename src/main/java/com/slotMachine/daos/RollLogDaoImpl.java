package com.slotMachine.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slotMachine.models.Spin;
import com.slotMachine.models.UserPlay;
import com.slotMachine.models.UserRequest;

@Transactional
@Repository
public class RollLogDaoImpl implements RollLogDao {

	@Autowired
	private JdbcTemplate h2JdbcTemplate;

	@Override
	public List<UserPlay> GetSpinsForUser(String username) {
		username = username.toLowerCase();
		String statement = String.format("SELECT * FROM SPINS WHERE SPIN_USERNAME = '%s'", username);
		List<UserPlay> users = h2JdbcTemplate.query(statement, new RowMapper<UserPlay>() {
			public UserPlay mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserPlay userPlay = new UserPlay(new Spin(rs.getString("SPIN_ROLLERS"), rs.getString("SPIN_WINSTATUS")),
						new UserRequest(rs.getString("SPIN_USERNAME"), rs.getString("SPIN_USERTOKEN")));
				return userPlay;
			}
		});
		if (users.isEmpty()) {
			users.add(new UserPlay());
		}
		return users;
	}

	@Override
	public UserPlay GetLastSpinForUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddSpin(UserPlay newSpin) {
		String statement = String.format(
				"INSERT INTO SPINS(SPIN_USERNAME, SPIN_ROLLERS, SPIN_BET, SPIN_USERTOKEN, SPIN_WINSTATUS) VALUES"
						+ " ('%s', '%s', '%d, '%s', '%s')",
				newSpin.getUserRequest().getUsername().toLowerCase(), newSpin.getUserSpin().stringifyRollers(),
				newSpin.getUserRequest().getUserBet(), newSpin.getUserRequest().getUserToken(),
				newSpin.getUserSpin().getWinStatus().name());
		h2JdbcTemplate.update(statement);
	}

	@Override
	public List<UserPlay> GetWinningSpins() {
		// TODO Auto-generated method stub
		return null;
	}

}
