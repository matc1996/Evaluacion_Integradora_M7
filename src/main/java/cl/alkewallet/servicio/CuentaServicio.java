package cl.alkewallet.servicio;

import cl.alkewallet.modelo.Cuenta;
import cl.alkewallet.modelo.Usuario;
import cl.alkewallet.repositorio.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServicio {
    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    public Cuenta crearCuenta(Usuario usuario) {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario);
        cuenta.setSaldo(BigDecimal.ZERO);
        return cuentaRepositorio.save(cuenta);
    }

    public List<Cuenta> obtenerCuentasPorUsuarioId(Long usuarioId) {
        return cuentaRepositorio.findByUsuarioId(usuarioId);
    }

    public Optional<Cuenta> obtenerCuentaPorId(Long cuentaId) {
        return cuentaRepositorio.findById(cuentaId);
    }

    public Cuenta actualizarSaldo(Cuenta cuenta, BigDecimal monto) {
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        return cuentaRepositorio.save(cuenta);
    }
}

