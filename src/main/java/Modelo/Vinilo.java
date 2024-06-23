package Modelo;

import java.util.Date;

public class Vinilo {
    // ----- ATRIBUTOS -----
    private Long    idVinilo;
    private String  nombre;
    private String  artista;
    private Long    peso;
    private Long    tamanio;
    private String  descripcion;
    private String  color;
    private Long    precio;
    private Integer stock;
    private Date    fechaRegistro;



    // ----- CONSTRUCTORES -----
    public Vinilo(  Long idVinilo       , String nombre         , String artista        ,
                    Long peso           , Long tamanio          , String descripcion    ,
                    String color        , Long precio           , Integer stock         ,
                    Date fechaRegistro  ) {
        this.idVinilo       = idVinilo;
        this.nombre         = nombre;
        this.artista        = artista;
        this.peso           = peso;
        this.tamanio        = tamanio;
        this.descripcion    = descripcion;
        this.color          = color;
        this.precio         = precio;
        this.stock          = stock;
        this.fechaRegistro  = fechaRegistro;
    }

    public Vinilo() {
    }



    // ----- GETTER / SETTER -----
    public Long getIdVinilo() {
        return idVinilo;
    }

    public void setIdVinilo(Long idVinilo) {
        this.idVinilo = idVinilo;
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

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public Long getTamanio() {
        return tamanio;
    }

    public void setTamanio(Long tamanio) {
        this.tamanio = tamanio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    // ----- TO STRING -----
    @Override
    public String toString() {
        return  "\t ["  + idVinilo        +
                "] "    + nombre          +
                " | "   + artista         +
                " | "   + peso            +
                " | "   + tamanio         +
                " | "   + descripcion     +
                " | "   + color           +
                " | "   + precio          +
                " | "   + stock           +
                " | "   + fechaRegistro;
    }
}
