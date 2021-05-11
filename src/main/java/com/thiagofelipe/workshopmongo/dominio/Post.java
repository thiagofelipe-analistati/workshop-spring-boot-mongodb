package com.thiagofelipe.workshopmongo.dominio;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.thiagofelipe.workshopmongo.dto.AutorDTO;


@Document
public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date data;
	private String titulo;
	private String texto;
	
	
	private AutorDTO autorDTO; 
	
	public Post() {
		
	}
	public Post(String id, Date data, String titulo, String texto, AutorDTO autorDTO) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.texto = texto;
		this.autorDTO = autorDTO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	public AutorDTO getAtorDTO() {
		return autorDTO;
	}
	public void setAtorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", data=" + data + ", titulo=" + titulo + ", texto=" + texto + "]";
	}

	
	
	
}
