package prueba.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
public class Phones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long phone_Id;

	@JsonProperty("number")
	@NotNull
	private Integer number;

	@JsonProperty("contrycode")
	@NotNull
	private Integer contrycode;

	@JsonProperty("citycode")
	@NotNull
	private Integer citycode;

	
	@NotNull
	@JoinColumn(name = "usuario_id")
	private Long usuario_Id;

}
