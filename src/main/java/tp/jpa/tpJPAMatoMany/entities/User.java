package tp.jpa.tpJPAMatoMany.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data 
@NoArgsConstructor @AllArgsConstructor
@Table(name="USERS")
@Entity
public class User implements Serializable{
	@Id
	private String userId;
	//---pour indiquer que la colone doit avoir les valeurs unique et ne doit pas depasser 
	@Column(unique = true,length = 20)
	private String username;
	private String password;
	//@JsonIgnore
	@ManyToMany(mappedBy = "users",fetch=FetchType.EAGER)
	//@ToString.Exclude    //----permet d'exclure cette attribut de la methode toString
	private List<Role> roles=new ArrayList<>();
	
}
