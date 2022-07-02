package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarConyugueProspecto;

public class ActualizarConyugeProspectoUseCase extends UseCase<RequestCommand<ActualizarConyugueProspecto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarConyugueProspecto> actualizarConyugueProspectoRequestCommand) {
        var command = actualizarConyugueProspectoRequestCommand.getCommand();
        var conyuge = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.ProspectoID().value()));
        conyuge.actualizarConyugueProspecto(command.ProspectoID(), command.Conyugue());
        emit().onResponse(new ResponseEvents(conyuge.getUncommittedChanges()));
    }
}
