package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identificador")
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="password")
	private String password;
	@Column(name="habilitado")
	private String habilitado;
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	@Column(name="fecha_ultimo_cambio")
	private Date ultimaFechaCambio;
	@Column(name="passwords_anteriores")
	private String[] passwordsAnteriores;
	@Column(name="cantidad_passwords")
	private int cantidad;
	
	public UsuarioEntity(){
		this.passwordsAnteriores = new String[10];
		this.cantidad = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUltimaFechaCambio() {
		return ultimaFechaCambio;
	}

	public void setUltimaFechaCambio(Date ultimaFechaCambio) {
		this.ultimaFechaCambio = ultimaFechaCambio;
	}

	public String[] getPasswordsAnteriores() {
		return this.passwordsAnteriores;
	}

	public void addOldPassword(String password) {
		passwordsAnteriores[cantidad] = password;
		cantidad++;
	}

	public int getCantidad(){
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public void setPasswordsAnteriores(String[] passwordsAnteriores) {
		this.passwordsAnteriores = passwordsAnteriores;
	}
	
}
