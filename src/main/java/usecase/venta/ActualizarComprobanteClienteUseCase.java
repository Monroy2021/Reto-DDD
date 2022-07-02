package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.ActualizarComprobanteCliente;

public class ActualizarComprobanteClienteUseCase extends UseCase<RequestCommand<ActualizarComprobanteCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarComprobanteCliente> actualizarComprobanteClienteRequestCommand) {
        var command = actualizarComprobanteClienteRequestCommand.getCommand();
        var comprobantecliente = Venta.from(command.getIdVenta(), retrieveEvents(command.getClienteID().value()));
        comprobantecliente.actualizarComprobanteCliente(command.getClienteID(), command.getComprobante());
        emit().onResponse(new ResponseEvents(comprobantecliente.getUncommittedChanges()));

    }
}
