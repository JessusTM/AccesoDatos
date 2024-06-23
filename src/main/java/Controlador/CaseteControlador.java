package Controlador;

import Modelo.Casete;
import Repositorio.CaseteRepositorio;

import java.util.List;

public class CaseteControlador {
    private CaseteRepositorio repositorio;

    public CaseteControlador() {
        this.repositorio = new CaseteRepositorio();
    }

    public void guardarCasete(Casete casete) {
        repositorio.guardar(casete);
    }

    public List<Casete> listarCasetes() {
        return repositorio.listar();
    }

    public Casete obtenerCasetePorId(Long id) {
        return repositorio.porId(id);
    }

    public void eliminarCasete(Long id) {
        repositorio.eliminar(id);
    }
}
