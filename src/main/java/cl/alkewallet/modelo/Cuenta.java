package cl.alkewallet.modelo;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private BigDecimal saldo;

    public Cuenta() {
    }

    public Cuenta(BigDecimal saldo, Usuario usuario, Long id) {
        this.saldo = saldo;
        this.usuario = usuario;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
