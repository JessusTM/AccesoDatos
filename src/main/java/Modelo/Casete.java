package Modelo;

import java.util.Date;

public class Casete {
    // ----- ATRIBUTOS -----
    private Long        idCasete;
    private String      nombre;
    private String      artista;
    private Integer     anioPublicacion;
    private Long        minutos;
    private String      material;
    private Long        tamanio;
    private Long        precio;
    private Integer     stock;
    private Date        fechaRegistro;



    // ----- CONSTRUCTORES -----
    public Casete(  Long idCasete               , String nombre             , String artista        ,
                    Integer anioPublicacion     , Long minutos              , String material       ,
                    Long tamanio                , Long precio               , Integer stock         ,
                    Date fechaRegistro) {
        this.idCasete           = idCasete;
        this.nombre             = nombre;
        this.artista            = artista;
        this.anioPublicacion    = anioPublicacion;
        this.minutos            = minutos;
        this.material           = material;
        this.tamanio            = tamanio;
        this.precio             = precio;
        this.stock              = stock;
        this.fechaRegistro      = fechaRegistro;
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
        return String.format("| %-7d | %-30s | %-20s | %-10d | %-10d | %-15s | %-10d | %-5d | %-15s |",
                idCasete, nombre, artista, anioPublicacion, minutos, material, precio, stock, fechaRegistro);
    }

    // ----- GET HEADER -----
    public static String getHeader() {
        return String.format("| %-7s | %-30s | %-20s | %-10s | %-10s | %-15s | %-10s | %-5s | %-15s |",
                "ID", "Nombre", "Artista", "Año", "Minutos", "Material", "Precio", "Stock", "Fecha Registro");
    }
}
