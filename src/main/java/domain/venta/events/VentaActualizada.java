package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.Asesor;
import domain.venta.Cliente;

public class VentaActualizada extends DomainEvent {
    private Asesor asesor;
    private Cliente cliente;

    public VentaActualizada(Asesor asesor, Cliente cliente) {
        super("domain.venta.events.VentaActualizada");
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public Asesor Asesor() {
        return asesor;
    }

    public Cliente Cliente() {
        return cliente;
    }
}
