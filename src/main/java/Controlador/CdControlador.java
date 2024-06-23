package Controlador;

import Modelo.Cd;
import Repositorio.CdRepositorio;

import java.util.List;

public class CdControlador {
    private CdRepositorio repositorio;

    public CdControlador() {
        this.repositorio = new CdRepositorio();
    }

    public void guardarCd(Cd cd) {
        repositorio.guardar(cd);
    }

    public List<Cd> listarCds() {
        return repositorio.listar();
    }

    public Cd obtenerCdPorId(Long id) {
        return repositorio.porId(id);
    }

    public void eliminarCd(Long id) {
        repositorio.eliminar(id);
    }
}
