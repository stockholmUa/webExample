package com.sourceit.webtasks.services.mocks;

import java.util.List;


import com.sourceit.webtasks.exceptions.InvalidDataException;
import com.sourceit.webtasks.exceptions.WebtasksDataException;
import com.sourceit.webtasks.model.Account;
import com.sourceit.webtasks.model.Role;
import com.sourceit.webtasks.services.DataService;
import org.apache.commons.lang.StringUtils;


public class DataServiceImpl implements DataService {

	@Override
	public Account login(String username, String password, Integer role) throws InvalidDataException {
		for(Account a : DataStorage.ALL_ACCOUNTS) {
			if(StringUtils.equals(username, a.getUsername())) {
				if(StringUtils.equals(password, a.getPassword())) {
					for(Role r : a.getRoles()) {
						if(r.getId().equals(role)) {
							return a;
						}
					}
					throw new InvalidDataException("Invalid role");
				}
				else{
					throw new InvalidDataException("Invalid password");
				}
			}
		}
		throw new InvalidDataException("Account not found");
	}
	
	@Override
	public List<Role> listRoles() throws WebtasksDataException {
		return DataStorage.ALL_ROLES;
	}
	
	@Override
	public void close() {
		
	}
}
