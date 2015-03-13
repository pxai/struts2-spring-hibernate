package info.pello.servlets.foro;

import java.util.Date;
import java.sql.Timestamp;

public class Mensaje {
	

	private int id;
	private int idusuario;
	private String autor;
	private int idpadre = 0;
	private String titulo;
	private String texto;
	private String fecha;
	
	
	/**
	 * Mensaje
	 * @param id
	 * @param idpadre
	 * @param idusuario
	 * @param autor
	 * @param titulo
	 * @param texto
	 * @param fecha
	 */
	public Mensaje(int id, int idpadre, int idusuario, String autor,
			String titulo, String texto, String fecha) {
		this.id = id;
		this.idpadre = idpadre;
		this.setIdusuario(idusuario);
		this.autor = autor;
		this.titulo = titulo;
		this.texto = texto;
		this.fecha = fecha;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * @return the idpadre
	 */
	public int getIdpadre() {
		return idpadre;
	}
	/**
	 * @param idpadre the idpadre to set
	 */
	public void setIdpadre(int idpadre) {
		this.idpadre = idpadre;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the idusuario
	 */
	public int getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
}
