package Modelo;

import java.util.Date;

public class Cd {
    // ----- ATRIBUTOS -----
    private Long        idCd;
    private String      nombre;
    private String      artista;
    private Integer     anioPublicacion;
    private Long        minutos;
    private Long        precio;
    private Integer     stock;
    private Date        fechaRegistro;



    // ----- CONSTRUCTORES -----
    public Cd(  Long idCd               , String nombre             , String artista        ,
                Integer anioPublicacion , Long minutos              , Long precio           ,
                Integer stock           , Date fechaRegistro        ) {
        this.idCd               = idCd;
        this.nombre             = nombre;
        this.artista            = artista;
        this.anioPublicacion    = anioPublicacion;
        this.minutos            = minutos;
        this.precio             = precio;
        this.stock              = stock;
        this.fechaRegistro      = fechaRegistro;
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

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Long getMinutos() {
        return minutos;
    }

    public void setMinutos(Long minutos) {
        this.minutos = minutos;
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
        return String.format("| %-7d | %-30s | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s |",
                idCd, nombre, artista, anioPublicacion, minutos, precio, stock, fechaRegistro);
    }

    // ----- GET HEADER -----
    public static String getHeader() {
        return String.format("| %-7s | %-30s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s |",
                "ID", "Nombre", "Artista", "Año", "Minutos", "Precio", "Stock", "Fecha Registro");
    }
}

