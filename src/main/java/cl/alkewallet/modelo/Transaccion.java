package cl.alkewallet.modelo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;

@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id")
    private Cuenta cuentaOrigen;
    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    private Cuenta cuentaDestino;
    private BigDecimal monto;
    private Timestamp fechaTransaccion;
    private String tipo;

    public Transaccion() {
    }

    public Transaccion(Long id, Timestamp fechaTransaccion, String tipo, BigDecimal monto,
                       Cuenta cuentaDestino, Cuenta cuentaOrigen) {
        this.id = id;
        this.fechaTransaccion = fechaTransaccion;
        this.tipo = tipo;
        this.monto = monto;
        this.cuentaDestino = cuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Timestamp fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}
