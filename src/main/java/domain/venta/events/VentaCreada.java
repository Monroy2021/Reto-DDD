package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.Asesor;
import domain.venta.Cliente;

public class VentaCreada extends DomainEvent {
    private final Asesor asesor;
    private final Cliente cliente;

    public VentaCreada(Asesor asesor, Cliente cliente) {
        super("domain.venta.events.VentaCreada");
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
