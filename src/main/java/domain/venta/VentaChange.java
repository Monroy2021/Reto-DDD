package domain.venta;

import co.com.sofka.domain.generic.EventChange;
import domain.venta.events.*;

public class VentaChange extends EventChange {

    public VentaChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.asesor= event.Asesor();
            venta.cliente= event.Cliente();
        });


        apply((ClienteCreado event)->{
            venta.cliente = new Cliente(event.Id(), event.Identificacion(), event.Comprobante(), event.Numero(), event.Downpayment());
        });

        apply((AsesorCreado event)->{
            venta.asesor = new Asesor(event.Id(), event.Nombre());
        });

        apply((NumeroContactoClienteActualizado event)->{
            venta.cliente.actualizarNumeroContacto(event.Numero());
        });

        apply((NombreAsesorActualizado event)->{
            venta.asesor.actualizarNombre(event.Nombre());
        });

        apply((ComprobanteClienteActualizado event)->{
            venta.actualizarComprobanteCliente(event.ClienteID(), event.Comprobante());
        });
    }

}
