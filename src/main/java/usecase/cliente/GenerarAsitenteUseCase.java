package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.GenerarAsistente;

public class GenerarAsitenteUseCase extends UseCase<RequestCommand<GenerarAsistente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarAsistente> generarAsistenteRequestCommand) {
        var command = generarAsistenteRequestCommand.getCommand();
        var clienteLlamada = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.AsistenteID().value()));
        clienteLlamada.generarAsistente(command.AsistenteID(), command.Email(), command.NombreAsistente());
        emit().onResponse(new ResponseEvents(clienteLlamada.getUncommittedChanges()));
    }
}
