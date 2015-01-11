package com.sourceit.webtasks.services;

import com.sourceit.webtasks.exceptions.InvalidDataException;
import com.sourceit.webtasks.exceptions.WebtasksDataException;
import com.sourceit.webtasks.model.Account;
import com.sourceit.webtasks.model.Role;

import java.util.List;


public interface DataService extends IClosable {
	
	Account login(String username, String password, Integer role) throws InvalidDataException;
	List<Role> listRoles() throws WebtasksDataException;
}
