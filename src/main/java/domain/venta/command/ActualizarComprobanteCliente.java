package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.ClienteID;
import domain.venta.values.Comprobante;
import domain.venta.values.VentaID;

public class ActualizarComprobanteCliente extends Command {
    private final ClienteID clienteID;
    private final VentaID idVenta;
    private final Comprobante comprobante;

    public ActualizarComprobanteCliente(ClienteID clienteID, VentaID idVenta, Comprobante comprobante) {
        this.clienteID = clienteID;
        this.idVenta = idVenta;
        this.comprobante = comprobante;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public VentaID getIdVenta() {
        return idVenta;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }
}
