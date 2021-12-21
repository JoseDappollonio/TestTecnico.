package prueba.Modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_Id")
	long usuario_Id;
	
	@JsonProperty("password")
	@NotNull
	private String password;
	
	
	@JsonProperty("name")
	@NotNull
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "usuario_Id")
	@JsonProperty("phones")
	@NotNull
	private List<Phones> phones;
	
	@JsonProperty("email")
	@NotNull
	private String email;
	
	
	private Date fechaIngreso;
	private Date fechaModificacion;
	private Date ultimaConexion;
	private Boolean isactive;



}