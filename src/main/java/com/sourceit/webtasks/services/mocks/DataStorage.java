package com.sourceit.webtasks.services.mocks;

import com.sourceit.webtasks.WebtasksConstants;
import com.sourceit.webtasks.model.Account;
import com.sourceit.webtasks.model.Role;

import java.util.Arrays;
import java.util.List;

class DataStorage implements WebtasksConstants {
	static final Role ADMIN_ROLE 			= new Role(ROLE_ADMIN, "Admin");
	static final Role TUTOR_ROLE 			= new Role(ROLE_TUTOR, "Tutor");
	static final Role STUDENT_ROLE 			= new Role(ROLE_STUDENT, "Student");
	static final List<Role> ALL_ROLES 		= Arrays.asList(
			new Role[]{
			DataStorage.ADMIN_ROLE,
			DataStorage.TUTOR_ROLE,
			DataStorage.STUDENT_ROLE,
	});
	
	static final Account ADMIN 				= new Account("admin", "password", ALL_ROLES);
	static final Account TUTOR 				= new Account("tutor", "password", Arrays.asList(new Role[]{
			TUTOR_ROLE, STUDENT_ROLE
	})); 
	static final Account STUDENT 			= new Account("student", "password", Arrays.asList(new Role[]{
			STUDENT_ROLE
	})); 
	
	static final List<Account> ALL_ACCOUNTS = Arrays.asList(new Account[]{
			DataStorage.ADMIN,
			DataStorage.TUTOR,
			DataStorage.STUDENT,
	});
}
