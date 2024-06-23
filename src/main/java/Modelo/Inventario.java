package Modelo;

import java.util.Date;

public class Inventario {
    // ----- ATRIBUTOS -----
    private Long    idProducto;
    private Integer stock;
    private Date    fechaRegistro;
    private Long    precio;



    // ----- CONSTRUCTORES -----
    public Inventario(Long idProducto       , Integer stock ,
                      Date fechaRegistro    , Long precio   ) {
        this.idProducto     = idProducto;
        this.stock          = stock;
        this.fechaRegistro  = fechaRegistro;
        this.precio         = precio;
    }

    public Inventario() {
    }



    // ----- GETTER / SETTER -----
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
