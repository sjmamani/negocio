package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subrubros")
public class SubRubroEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identificador")	
	private int codigo;
	@Column(name="descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="identificadorRubro")
	private RubroEntity rubro;
	
	public SubRubroEntity(int codigo, String descripcion, RubroEntity rubro) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.rubro = rubro;
	}
	
	public SubRubroEntity(){ }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RubroEntity getRubro() {
		return rubro;
	}

	public void setRubro(RubroEntity rubro) {
		this.rubro = rubro;
	}
}
