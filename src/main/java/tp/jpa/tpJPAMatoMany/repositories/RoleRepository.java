package tp.jpa.tpJPAMatoMany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.jpa.tpJPAMatoMany.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
Role findByRoleName(String roleName);
}
