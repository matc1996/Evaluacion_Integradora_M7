package cl.alkewallet.controlador;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagosControlador {

    @PostMapping("/realizarPago")
    public String realizarPago(@RequestBody PagoRequest request) {
        // Aquí implementarías la lógica para procesar el pago
        // Puedes acceder a los datos del pago desde request
        // y devolver la respuesta apropiada, por ejemplo:
        return "Pago realizado exitosamente";
    }

    @GetMapping("/estadoPago/{id}")
    public String estadoPago(@PathVariable Long id) {
        // Aquí implementarías la lógica para consultar el estado de un pago
        // Utilizando el ID proporcionado en la URL
        // y devolver la respuesta apropiada, por ejemplo:
        return "Estado del pago con ID " + id + ": Aprobado";
    }
}

