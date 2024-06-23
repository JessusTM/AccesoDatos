package Modelo;

import java.util.Date;

public class Cd {
    // ----- ATRIBUTOS -----
    private Long        idCd;
    private String      nombre;
    private String      artista;
    private Date        anioPublicacion;
    private Long        minutos;
    private Inventario  inventario;



    // ----- CONSTRUCTORES -----
    public Cd(Long idCd             , String nombre     , String artista            ,
              Date anioPublicacion  , Long minutos      , Inventario inventario     ) {
        this.idCd               = idCd;
        this.nombre             = nombre;
        this.artista            = artista;
        this.anioPublicacion    = anioPublicacion;
        this.minutos            = minutos;
        this.inventario         = inventario;
    }

    public Cd() {
    }



    // ----- GETTER / SETTER -----
    public Long getIdCd() {
        return idCd;
    }

    public void setIdCd(Long idCd) {
        this.idCd = idCd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Long getMinutos() {
        return minutos;
    }

    public void setMinutos(Long minutos) {
        this.minutos = minutos;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }



    // ----- TO STRING -----
    @Override
    public String toString() {
        return  "\t [" + idCd           + "]" +
                " | " + nombre          +
                " | " + artista         +
                " | " + anioPublicacion +
                " | " + minutos;
    }
}
