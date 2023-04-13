package tp.jpa.tpJPAMatoMany.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.jpa.tpJPAMatoMany.entities.User;
import tp.jpa.tpJPAMatoMany.repositories.UserRepository;

@RestController
public class Tpcontroller {
@Autowired
private UserRepository userRepository;
@GetMapping("/user")
List<User> testmany(){
	return userRepository.findAll();
}

}
