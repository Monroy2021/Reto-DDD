package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.GenerarClienteLlamada;

public class GenerarClienteLlamadaUseCase extends UseCase<RequestCommand<GenerarClienteLlamada>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarClienteLlamada> generarClienteLlamadaRequestCommand) {
        var command = generarClienteLlamadaRequestCommand.getCommand();
        var cliente_llamada = new ClienteLlamada(command.ClienteLlamadaID(), command.Llamada());
        emit().onResponse(new ResponseEvents(cliente_llamada.getUncommittedChanges()));
    }
}
