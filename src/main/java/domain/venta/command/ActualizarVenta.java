package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.Asesor;
import domain.venta.Cliente;
import domain.venta.values.VentaID;

public class ActualizarVenta extends Command {
    private final VentaID ventaID;
    private final Asesor asesor;
    private final Cliente cliente;

    public ActualizarVenta(VentaID ventaID, Asesor asesor, Cliente cliente) {
        this.ventaID=ventaID;
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public Asesor Asesor() {
        return asesor;
    }

    public Cliente Cliente() {
        return cliente;
    }

    public VentaID VentaID() {
        return ventaID;
    }
}
