package Modelo;

import java.util.Date;

public class Venta {
    // ----- ATRIBUTOS -----
    private Long    idVenta;
    private Long    idProducto;
    private String  tipoProducto;
    private Integer cantidad;
    private Date    fechaVenta;



    // ----- CONSTRUCTOR -----
    public Venta(Long idVenta       , Long idProducto       , String tipoProducto,
                 Integer cantidad   , Date fechaVenta       ) {
        this.idVenta        = idVenta;
        this.idProducto     = idProducto;
        this.tipoProducto   = tipoProducto;
        this.cantidad       = cantidad;
        this.fechaVenta     = fechaVenta;
    }

    public Venta() {
    }



    // ----- GETTER / SETTER -----
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }



    // ----- TO STRING -----
    @Override
    public String toString() {
        return "\t ["   + idVenta       +
                "] "    + idProducto    +
                " | "   + tipoProducto  +
                " | "   + cantidad      +
                " | "   + fechaVenta;
    }
}
