package cl.alkewallet.repositorio;

import cl.alkewallet.modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByCuentaOrigenIdOrCuentaDestinoId(Long cuentaOrigenId, Long cuentaDestinoId);
}
