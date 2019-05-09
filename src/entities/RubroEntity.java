package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rubros")
public class RubroEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identificador")
	private int codigo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="habilitado")
	private String habilitado;
	
	public RubroEntity() { }
	
	public RubroEntity(int codigo, String descripcion, boolean habilitado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		if(habilitado)
			this.habilitado = "Si";
		else
			this.habilitado = "No";
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isHabilitado() {
		return habilitado.equals("Si");
	}
}
