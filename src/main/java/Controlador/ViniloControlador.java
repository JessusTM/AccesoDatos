package Controlador;

import Modelo.Vinilo;
import Repositorio.ViniloRepositorio;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ViniloControlador {
    private ViniloRepositorio repositorio;
    private final ReentrantLock lock = new ReentrantLock();

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
        lock.lock();
        try {
            repositorio.guardar(vinilo);
        } finally {
            lock.unlock();
        }
    }

    public void eliminarVinilo(Long idVinilo) {
        lock.lock();
        try {
            repositorio.eliminar(idVinilo);
        } finally {
            lock.unlock();
        }
    }
}
