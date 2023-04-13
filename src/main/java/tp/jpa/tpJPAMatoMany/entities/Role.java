package tp.jpa.tpJPAMatoMany.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String desc;
	@Column(unique = true,length = 20)
	private String roleName;
	@ManyToMany(fetch=FetchType.EAGER)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)																																		
	//-----pour eviter le pointeur null
	private List<User> users=new ArrayList<>();
}
