package org.personalws.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import org.personalws.dao.PersonalDAO;
import org.personalws.model.Personal;
import org.personalws.msg.PersonalJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Stateless
public class PersonalRest implements IPersonalRest{

	
	@EJB
	private PersonalDAO dao;
	
	@Override
	public PersonalJSON getById(Integer id) {
		
		Personal p = dao.getById(id);
		return new PersonalJSON(p);		
	}

//	@Override
//	public PersonalJSON add(String nombre, String apellido, String genero,
//			String fechaNacimiento, String paisDocumento, String tipoDocumento) {
		
//	@Override
	public PersonalJSON add(String content) {
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		PersonalJSON pjson = gson.fromJson(content, PersonalJSON.class);
		Personal p = dao.add(	pjson.getNombre(),
								pjson.getApellido(),
								pjson.getGenero(),
								pjson.getFechaNacimiento(),
								pjson.getPaisDocumento(),
								pjson.getTipoDocumento());
		
		return new PersonalJSON(p);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

//	@Override
	public PersonalJSON edit(Integer id, String content) {
		
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		PersonalJSON pjson = gson.fromJson(content, PersonalJSON.class);
		pjson.setId(id);
		Personal p = dao.edit(
					pjson.getId(),
					pjson.getNombre(),
					pjson.getApellido(),
					pjson.getGenero(),
					pjson.getFechaNacimiento(),
					pjson.getPaisDocumento(),
					pjson.getTipoDocumento());
		return new PersonalJSON(p);
	}

	@Override
	public PersonalJSON add(PersonalJSON p) {
		
		
		
		Personal ps = dao.add(	
				p.getNombre(),
				p.getApellido(),
				p.getGenero(),
				p.getFechaNacimiento(),
				p.getPaisDocumento(),
				p.getTipoDocumento());

		return new PersonalJSON(ps);
	}

	@Override
	public PersonalJSON edit(Integer id, PersonalJSON p) {
		// TODO Auto-generated method stub
		p.setId(id);
		Personal ps = dao.edit(
				p.getId(),
				p.getNombre(),
				p.getApellido(),
				p.getGenero(),
				p.getFechaNacimiento(),
				p.getPaisDocumento(),
				p.getTipoDocumento());
		
		return new PersonalJSON(ps);
	}



	
}
