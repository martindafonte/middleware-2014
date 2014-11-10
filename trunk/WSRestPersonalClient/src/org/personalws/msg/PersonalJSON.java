package org.personalws.msg;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonAutoDetect
@JsonSerialize
@XmlRootElement
public class PersonalJSON implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@JsonProperty
	@XmlElement(name="id")
	private Integer id;
	@JsonProperty
	@XmlElement(name="nombre")
	private String nombre;
	@JsonProperty
	@XmlElement(name="apellido")
	private String apellido;
	@JsonProperty
	@XmlElement(name="genero")
	private String genero;
	@JsonProperty
	@XmlElement(name="fecha_nacimiento")
	private String fechaNacimiento;
	@JsonProperty
	@XmlElement(name="pais_documento")
	private String paisDocumento;
	@JsonProperty
	@XmlElement(name="tipo_documento")
	private String tipoDocumento;

	public PersonalJSON(){}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaisDocumento() {
		return this.paisDocumento;
	}

	public void setPaisDocumento(String paisDocumento) {
		this.paisDocumento = paisDocumento;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


}
