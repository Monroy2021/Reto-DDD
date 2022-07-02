package domain.cliente;

import co.com.sofka.domain.generic.EventChange;
import domain.cliente.event.*;

public class ClienteLlamadaChange extends EventChange {
    public ClienteLlamadaChange(ClienteLlamada cliente) {
        apply((ClienteLlamadaCreado event)->{
            cliente.llamada=event.Llamada();
        });

        apply((llamadaGenerada event)->{
            cliente.llamada= new Llamada(event.Llamadaid(), event.Prospecto(), event.Asistente());
        });

        apply((prospectoGenerado event)->{
            cliente.llamada.generarProspecto(event.Prospectoid(), event.DescripcionProspecto(), event.Cita(), event.TipoFinaciamiento(), event.Renta(), event.Conyugue());
        });

        apply((asistenteGenerado event)->{
            cliente.llamada.generarAsistente(event.AsistenteID(), event.Email(), event.NombreAsistente());
        });

        apply((NombreAsistenteActualizado event)->{
            cliente.llamada.actualizarnombreAsistente(event.getNombreAsistente());
        });

        apply((EmailAsistenteActualizado event)->{
            cliente.llamada.actualizarEmailAsistente(event.Email());
        });

        apply((DescripcionProspectoActualizado event)->{
            cliente.llamada.actualizarDescripcionProspecto(event.DescripcionProspecto());
        });

        apply((CitaProspectoActualizada event)->{
            cliente.llamada.actualizarCitaProspecto(event.Cita());
        });

        apply((TipoFinanciamientoProspectoActualizado event)->{
            cliente.llamada.actualizarTipoFinanciamientoProspecto(event.TipoFinaciamiento());
        });

        apply((RentaProspectoActualizada event)->{
            cliente.llamada.actualizarRentaProspecto(event.Renta());
        });

        apply((conyugueProspectoActualizada event)->{
            cliente.llamada.actualizarConyugue(event.Conyugue());
        });


    }
}
