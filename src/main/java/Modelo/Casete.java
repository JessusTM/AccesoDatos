package Modelo;

import java.util.Date;

public class Casete {
    // ----- ATRIBUTOS -----
    private Long        idCasete;
    private String      nombre;
    private String      artista;
    private Date        anioPublicacion;
    private Long        minutos;
    private String      material;
    private Long        tamanio;
    private Inventario  inventario;



    // ----- CONSTRUCTORES -----
    public Casete(Long idCasete         , String nombre         , String artista    ,
                  Date anioPublicacion  , Long minutos          , String material   ,
                  Long tamanio          , Inventario inventario ) {
        this.idCasete           = idCasete;
        this.nombre             = nombre;
        this.artista            = artista;
        this.anioPublicacion    = anioPublicacion;
        this.minutos            = minutos;
        this.material           = material;
        this.tamanio            = tamanio;
        this.inventario         = inventario;
    }

    public Casete() {
    }



    // ----- GETTER / SETTER -----
    public Long getIdCasete() {
        return idCasete;
    }

    public void setIdCasete(Long idCasete) {
        this.idCasete = idCasete;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Long getTamanio() {
        return tamanio;
    }

    public void setTamanio(Long tamanio) {
        this.tamanio = tamanio;
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
        return  "\t [" + idCasete       + "]" +
                " | " +  nombre         +
                " | " + artista         +
                " | " + anioPublicacion +
                " | " + minutos         +
                " | " + material        +
                " | " + tamanio;
    }
}
