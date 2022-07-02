package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.ClienteID;
import domain.venta.values.NumeroContacto;
import domain.venta.values.VentaID;

public class ActualizarNumeroContactoCliente extends Command {
    private final ClienteID clienteID;
    private final VentaID idVenta;
    private final NumeroContacto numero;

    public ActualizarNumeroContactoCliente(ClienteID clienteID, VentaID idVenta, NumeroContacto numero) {
        this.clienteID = clienteID;
        this.idVenta = idVenta;
        this.numero = numero;
    }

    public ClienteID ClienteID() {
        return clienteID;
    }

    public VentaID IdVenta() {
        return idVenta;
    }

    public NumeroContacto Numero() {
        return numero;
    }
}
