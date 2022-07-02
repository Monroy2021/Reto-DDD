package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand) {
        var command = crearClienteRequestCommand.getCommand();
        var cliente = Venta.from(command.IdVenta(), retrieveEvents(command.Id().value()));
        cliente.generarCliente(command.Id(), command.Identificacion(), command.Comprobante(), command.Numero(), command.Downpayment());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
