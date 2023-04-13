package tp.jpa.tpJPAMatoMany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.jpa.tpJPAMatoMany.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
	User  findByUsername(String username);
}
