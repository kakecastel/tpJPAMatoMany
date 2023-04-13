package tp.jpa.tpJPAMatoMany.service;

import tp.jpa.tpJPAMatoMany.entities.Role;
import tp.jpa.tpJPAMatoMany.entities.User;

public interface UserService {
	User addNewUser(User user);
	Role addNewRole(Role role);
	User findUserByUserName(String username);
	Role findRoleByRoleName(String rolename);
	void addRoleToUser(String username,String roleName);
    User authenticate(String username,String password);
}
