package co.com.parking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_valor")
public class TipoValorEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_valor", unique = true)
	private int idTipoValor;

	@Column(name = "valor")
	private Double valor;

	public int getIdTipoValor() {
		return idTipoValor;
	}

	public void setIdTipoValor(int idTipoValor) {
		this.idTipoValor = idTipoValor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
