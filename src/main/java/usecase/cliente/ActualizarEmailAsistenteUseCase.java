package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarEmailAsistente;

public class ActualizarEmailAsistenteUseCase extends UseCase<RequestCommand<ActualizarEmailAsistente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEmailAsistente> actualizarEmailAsistenteRequestCommand) {
        var command = actualizarEmailAsistenteRequestCommand.getCommand();
        var email = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.AsistenteID().value()));
        email.actualizarEmailAsistente(command.AsistenteID(), command.Email());
        emit().onResponse(new ResponseEvents(email.getUncommittedChanges()));

    }
}
