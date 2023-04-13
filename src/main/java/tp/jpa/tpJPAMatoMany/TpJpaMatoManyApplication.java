package tp.jpa.tpJPAMatoMany;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tp.jpa.tpJPAMatoMany.entities.Role;
import tp.jpa.tpJPAMatoMany.entities.User;
import tp.jpa.tpJPAMatoMany.service.UserService;

@SpringBootApplication
public class TpJpaMatoManyApplication {
	@Autowired
    private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaMatoManyApplication.class, args);
	}

	
	@Bean
	CommandLineRunner start(UserService userService) {
		return args->{
			User u=new User();
			u.setUsername("user1");
			u.setPassword("123456");
			userService.addNewUser(u);
			
			User u2=new User();
			u2.setUsername("admin");
			u2.setPassword("123456");
			userService.addNewUser(u2);
			
			Stream.of("STUDENT","USER","ADMIN").forEach(r->{
				Role role1=new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);
			});
			userService.addRoleToUser("user1", "STUDENT");
			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("admin", "USER");
			userService.addRoleToUser("admin", "ADMIN");
		
		};
	};


}
