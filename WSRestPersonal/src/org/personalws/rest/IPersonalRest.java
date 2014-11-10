package org.personalws.rest;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.personalws.msg.PersonalJSON;

@Local
@Stateless
@Path("/Personal")
public interface IPersonalRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public PersonalJSON add(
//			@FormParam("nombre") String nombre,
//			@FormParam("apellido") String apellido,
//			@FormParam("genero") String genero,
//			@FormParam("fechaNacimiento") String fechaNacimiento,
//			@FormParam("paisDocumento") String paisDocumento,
//			@FormParam("tipoDocumento") String tipoDocumento
//			String content
			PersonalJSON p
			);
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public PersonalJSON edit(
			@PathParam("id") Integer id,
//			String content
			PersonalJSON p
			);
	
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public PersonalJSON getById(@PathParam("id") Integer id );
	

	@DELETE
	@Path("{id}")
	public void deleteById(@PathParam("id") Integer id );

		

}