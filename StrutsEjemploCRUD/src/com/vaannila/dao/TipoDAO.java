package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.Tipo;

public interface TipoDAO {

	public void guardarOActualizarTipo(Tipo tipo);
	public List<Tipo> listarTipo();
	public Tipo listarTipoPorId(Long id);
	public void eliminarTipo(Long id);
}
