package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.Tarea;


public interface TareaDAO {

	public void guardarOActualizarTarea(Tarea tarea);
	public List<Tarea> listarTareas();
	public Tarea listarTareaPorId(Long id);
	public void eliminarTarea(Long id);
}
