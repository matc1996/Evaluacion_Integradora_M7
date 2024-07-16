package cl.alkewallet.servicio;

import cl.alkewallet.modelo.Cuenta;
import cl.alkewallet.modelo.Transaccion;
import cl.alkewallet.repositorio.TransaccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransaccionServicio {
    @Autowired
    private TransaccionRepositorio transaccionRepositorio;
    @Autowired
    private CuentaServicio cuentaServicio;

    public Transaccion realizarTransaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino,
                                           BigDecimal monto, String tipo) {
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaOrigen(cuentaOrigen);
        transaccion.setCuentaDestino(cuentaDestino);
        transaccion.setMonto(monto);
        transaccion.setTipo(tipo);
        transaccionRepositorio.save(transaccion);

        cuentaServicio.actualizarSaldo(cuentaOrigen, monto.negate());
        cuentaServicio.actualizarSaldo(cuentaDestino, monto);

        return transaccion;
    }

    public List<Transaccion> obtenerTransaccionesPorCuentaId(Long cuentaId) {
        return transaccionRepositorio.findByCuentaOrigenIdOrCuentaDestinoId(cuentaId, cuentaId);
    }
}
