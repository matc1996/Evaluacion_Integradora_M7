package cl.alkewallet.controlador;

import cl.alkewallet.modelo.Cuenta;
import cl.alkewallet.modelo.Transaccion;
import cl.alkewallet.modelo.Usuario;
import cl.alkewallet.servicio.CuentaServicio;
import cl.alkewallet.servicio.TransaccionServicio;
import cl.alkewallet.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TansaccionControlador {
    @Autowired
    private CuentaServicio cuentaServicio;
    @Autowired
    private TransaccionServicio transaccionServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/transacciones")
    public String mostrarFormularioTransacciones(Model model, Principal principal) {
        Usuario usuario = usuarioServicio.encontrarPorEmail(principal.getName()).orElseThrow();
        List<Cuenta> cuentas = cuentaServicio.obtenerCuentasPorUsuarioId(usuario.getId());
        model.addAttribute("cuentas", cuentas);
        model.addAttribute("transaccion", new Transaccion());
        return "transacciones";
    }

    @PostMapping("/transacciones")
    public String realizarTransaccion(@ModelAttribute Transaccion transaccion, HttpExchange.Principal principal) {
        Cuenta cuentaOrigen = cuentaServicio.obtenerCuentaPorId(transaccion.getCuentaOrigen().getId()).orElseThrow();
        Cuenta cuentaDestino = cuentaServicio.obtenerCuentaPorId(transaccion.getCuentaDestino().getId()).orElseThrow();
        transaccionServicio.realizarTransaccion(cuentaOrigen, cuentaDestino, transaccion.getMonto(), transaccion.getTipo());
        return "redirect:/dashboard";
    }
}

