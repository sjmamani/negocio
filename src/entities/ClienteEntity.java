package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero")
	private int numero;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cuit")
	private String cuit;
	@Column(name="estado")
	private String activo;
	
	public ClienteEntity(){ }

	
	public ClienteEntity(int numero, String nombre, String cuit, boolean activo) {
		this.numero = numero;
		this.nombre = nombre;
		this.cuit = cuit;
		if(activo)
			this.activo = "true";
		else
			this.activo = "false";
	}


	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public String getActivo() {
		return activo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
}
