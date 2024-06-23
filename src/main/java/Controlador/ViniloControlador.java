package Controlador;

import Modelo.Vinilo;
import Repositorio.ViniloRepositorio;

import java.util.List;

public class ViniloControlador {
    private ViniloRepositorio repositorio;

    public ViniloControlador() {
        this.repositorio = new ViniloRepositorio();
    }

    public List<Vinilo> listarVinilos() {
        return repositorio.listar();
    }

    public Vinilo obtenerViniloPorId(Long idVinilo) {
        return repositorio.porId(idVinilo);
    }

    public void guardarVinilo(Vinilo vinilo) {
        repositorio.guardar(vinilo);
    }

    public void eliminarVinilo(Long idVinilo) {
        repositorio.eliminar(idVinilo);
    }
}
