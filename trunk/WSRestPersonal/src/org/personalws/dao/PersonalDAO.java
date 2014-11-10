package org.personalws.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personalws.model.Personal;


@Stateless
public class PersonalDAO {
	
	@PersistenceContext(unitName="WSRestPersonal")
	private EntityManager em;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Personal getById(Integer id) {
		
		try{
			
			Personal p = em.find(Personal.class, id);
			return p;
			
		}catch(Exception ex){
			return null;
		}
		
		
		
	}

	public Personal add(String nombre, String apellido, String genero,
			String fechaNacimiento, String paisDocumento, String tipoDocumento) {

		
		try {
			
			Personal p = new Personal();
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setFechaNacimiento(sdf.parse(fechaNacimiento));
			p.setGenero(genero);
			p.setPaisDocumento(paisDocumento);
			p.setTipoDocumento(tipoDocumento);
			em.persist(p);
			return p;
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Personal edit(Integer id, String nombre, String apellido, String genero,
			String fechaNacimiento, String paisDocumento, String tipoDocumento) {

		
		try {
			
			Personal p = this.getById(id);
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setFechaNacimiento(sdf.parse(fechaNacimiento));
			p.setGenero(genero);
			p.setPaisDocumento(paisDocumento);
			p.setTipoDocumento(tipoDocumento);
			return p;
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void deleteById(Integer id) {
		
		Personal p = this.getById(id);
		em.remove(p);
	}
	
	

}
