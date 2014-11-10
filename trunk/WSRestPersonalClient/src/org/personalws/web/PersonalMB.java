package org.personalws.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.personalws.msg.PersonalJSON;


@ManagedBean(name="personalMB")
@RequestScoped
public class PersonalMB implements Serializable{


	private Integer id;
	private String nombre;
	private String apellido;
	private String genero;
	private String fechaNacimiento;
	private String paisDocumento;
	private String tipoDocumento;
	
	
	@PostConstruct
	public void init(){
	
	}

	public String sendAdd(){
		
		try {
		
			ClientRequest request = new ClientRequest("http://localhost:8080/WSRestPersonal/Rest/Personal/");
			request.accept("application/json");
			
			
			String input = "{"
					+ "\"nombre\": \""+ nombre +"\","
					+ "\"apellido\": \""+ apellido +"\","
					+ "\"genero\": \""+ genero +"\","
					+ "\"fechaNacimiento\": \""+ fechaNacimiento +"\","
					+ "\"paisDocumento\": \""+ paisDocumento +"\","
					+ "\"tipoDocumento\": \""+ tipoDocumento +"\"}";
			
			request.body("application/json", input);
			ClientResponse<PersonalJSON> response = request.post(PersonalJSON.class);
	
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
			
 
			PersonalJSON p = response.getEntity();
 			id = p.getId();
 			nombre = p.getNombre();
 			apellido = p.getApellido();
 			fechaNacimiento = p.getFechaNacimiento();
 			genero = p.getGenero();
 			paisDocumento = p.getPaisDocumento();
 			tipoDocumento = p.getTipoDocumento();
			
			System.out.println("PERSONA AGREGADA CON EXITO :" + input);
			agregarMsgInfo("PERSONA AGREGADA CON EXITO");
	 		
		} catch (Exception e) {
			e.printStackTrace();
			agregarMsgError("ERROR");
		}
		return null;
	}
	
	
	
	public String sendEdit(){

		
		try {
			
			ClientRequest request = new ClientRequest("http://localhost:8080/WSRestPersonal/Rest/Personal/"+ id);
			request.accept("application/json");
			
			
			String input = "{"
					+ "\"id\": \""+ id +"\","
					+ "\"nombre\": \""+ nombre +"\","
					+ "\"apellido\": \""+ apellido +"\","
					+ "\"genero\": \""+ genero +"\","
					+ "\"fechaNacimiento\": \""+ fechaNacimiento +"\","
					+ "\"paisDocumento\": \""+ paisDocumento +"\","
					+ "\"tipoDocumento\": \""+ tipoDocumento +"\"}";
			
			request.body("application/json", input);
			ClientResponse<PersonalJSON> response = request.put(PersonalJSON.class);
	
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
			
 
			PersonalJSON p = response.getEntity();
 			id = p.getId();
 			nombre = p.getNombre();
 			apellido = p.getApellido();
 			fechaNacimiento = p.getFechaNacimiento();
 			genero = p.getGenero();
 			paisDocumento = p.getPaisDocumento();
 			tipoDocumento = p.getTipoDocumento();
			
			System.out.println("PERSONA MODIFICADA CON EXITO :" + input);
			agregarMsgInfo("PERSONA MODIFICADA CON EXITO");
 		
		} catch (Exception e) {
			e.printStackTrace();
			agregarMsgError("ERROR");
		}
		return null;
		
	}
	
	
	public String get(){
		

		try {
			
			ClientRequest request = new ClientRequest("http://localhost:8080/WSRestPersonal/Rest/Personal/"+ id);
			request.accept("application/json");
			
			ClientResponse<PersonalJSON> response = request.get(PersonalJSON.class);
	
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
			
 			PersonalJSON p = response.getEntity();
 			id = p.getId();
 			nombre = p.getNombre();
 			apellido = p.getApellido();
 			fechaNacimiento = p.getFechaNacimiento();
 			genero = p.getGenero();
 			paisDocumento = p.getPaisDocumento();
 			tipoDocumento = p.getTipoDocumento();
 			
 			agregarMsgInfo("PERSONA OBTENIDA CON EXITO");
 	 		
		} catch (Exception e) {
			e.printStackTrace();
			agregarMsgError("ERROR");
		}
		
		return null;

		
	}
	
	public String delete(){
		
		try {
			
			ClientRequest request = new ClientRequest("http://localhost:8080/WSRestPersonal/Rest/Personal/"+ id);
			request.accept("application/json");
			
			ClientResponse<?> response = request.delete();
	
			
//			if (response.getStatus() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//					+ response.getStatus());
//			}
			
			id = null;
			nombre = null;
			apellido = null;
			genero = null;
			fechaNacimiento = null;
			paisDocumento = null;
			tipoDocumento = null;
		
			agregarMsgInfo("PERSONA BORRADA CON EXITO");
 		
		} catch (Exception e) {
			e.printStackTrace();
			agregarMsgError("ERROR");
		}
		
		return null;
		
	}
	
	public void agregarMsgInfo(String msg){
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
	}
	
	public void agregarMsgError(String msg ){
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}
	
	
	public String genero(){
		return genero!= null ? genero.equals("1") ? "F" : "M" : null;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPaisDocumento() {
		return paisDocumento;
	}

	public void setPaisDocumento(String paisDocumento) {
		this.paisDocumento = paisDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	
	

}
