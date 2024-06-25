package Controlador;

import Modelo.*;
import Repositorio.CaseteRepositorio;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class CaseteControlador {
    private CaseteRepositorio repositorio;
    private final ReentrantLock lock = new ReentrantLock();

    public CaseteControlador() {
        this.repositorio = new CaseteRepositorio();
    }

    public void guardarCasete(Casete casete) {
        lock.lock();
        try {
            repositorio.guardar(casete);
        } finally {
            lock.unlock();
        }
    }

    public List<Casete> listarCasetes() {
        return repositorio.listar();
    }

    public Casete obtenerCasetePorId(Long id) {
        return repositorio.porId(id);
    }

    public void eliminarCasete(Long id) {
        lock.lock();
        try {
            repositorio.eliminar(id);
        } finally {
            lock.unlock();
        }
    }
}
