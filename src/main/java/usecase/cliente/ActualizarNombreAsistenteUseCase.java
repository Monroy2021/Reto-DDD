package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarNombreAsistente;

public class ActualizarNombreAsistenteUseCase extends UseCase<RequestCommand<ActualizarNombreAsistente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreAsistente> actualizarNombreAsistenteRequestCommand) {
        var command = actualizarNombreAsistenteRequestCommand.getCommand();
        var asistente = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.AsistenteID().value()));
        asistente.actualizarNombreAsistente(command.AsistenteID(), command.NombreAsistente());
        emit().onResponse(new ResponseEvents(asistente.getUncommittedChanges()));
    }
}
