package cl.alkewallet.controlador;

import cl.alkewallet.modelo.Cuenta;
import cl.alkewallet.modelo.Usuario;
import cl.alkewallet.servicio.CuentaServicio;
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
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private CuentaServicio cuentaServicio;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.registrarUsuario(usuario);
        cuentaServicio.crearCuenta(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String mostrarDashboard(Model model, Principal principal) {
        Usuario usuario = usuarioServicio.encontrarPorEmail(principal.getName()).orElseThrow();
        List<Cuenta> cuentas = cuentaServicio.obtenerCuentasPorUsuarioId(usuario.getId());
        model.addAttribute("usuario", usuario);
        model.addAttribute("cuentas", cuentas);
        return "dashboard";
    }
}

