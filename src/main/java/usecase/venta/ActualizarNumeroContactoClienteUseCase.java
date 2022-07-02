package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.ActualizarNumeroContactoCliente;

public class ActualizarNumeroContactoClienteUseCase extends UseCase<RequestCommand<ActualizarNumeroContactoCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNumeroContactoCliente> actualizarNumeroContactoClienteRequestCommand) {
        var command = actualizarNumeroContactoClienteRequestCommand.getCommand();
        var numeroContacto = Venta.from(command.IdVenta(), retrieveEvents(command.ClienteID().value()));
        numeroContacto.actualizarNumeroContactoCliente(command.ClienteID(), command.Numero());
        emit().onResponse(new ResponseEvents(numeroContacto.getUncommittedChanges()));
    }
}