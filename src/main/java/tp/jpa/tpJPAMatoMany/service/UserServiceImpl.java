package tp.jpa.tpJPAMatoMany.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.jpa.tpJPAMatoMany.entities.Role;
import tp.jpa.tpJPAMatoMany.entities.User;
import tp.jpa.tpJPAMatoMany.repositories.RoleRepository;
import tp.jpa.tpJPAMatoMany.repositories.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	 
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

 
	public Role addNewRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

 
	public User findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	 
	public Role findRoleByRoleName(String rolename) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(rolename);
	}

	 
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		User user=findUserByUserName(username);
		Role role=findRoleByRoleName(roleName);
		user.getRoles().add(role);
		role.getUsers().add(user);
		
	}


	@Override
	public User authenticate(String username, String password) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username);
		if(user.getPassword().equals(password)) return user;
		throw new RuntimeException("bad credentials");
	}

}
