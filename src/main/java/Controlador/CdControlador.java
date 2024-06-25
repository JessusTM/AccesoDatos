package Controlador;

import Modelo.Cd;
import Repositorio.CdRepositorio;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class CdControlador {
    private CdRepositorio repositorio;
    private final ReentrantLock lock = new ReentrantLock();

    public CdControlador() {
        this.repositorio = new CdRepositorio();
    }

    public void guardarCd(Cd cd) {
        lock.lock();
        try {
            repositorio.guardar(cd);
        } finally {
            lock.unlock();
        }
    }

    public List<Cd> listarCds() {
        return repositorio.listar();
    }

    public Cd obtenerCdPorId(Long id) {
        return repositorio.porId(id);
    }

    public void eliminarCd(Long id) {
        lock.lock();
        try {
            repositorio.eliminar(id);
        } finally {
            lock.unlock();
        }
    }
}
