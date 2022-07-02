package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarDescripcionProspecto;

public class ActualizarDescripcionProspectoUseCase extends UseCase<RequestCommand<ActualizarDescripcionProspecto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionProspecto> actualizarDescripcionProspectoRequestCommand) {
        var command = actualizarDescripcionProspectoRequestCommand.getCommand();
        var desc = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.ProspectoID().value()));
        desc.actualizarDescripcionProspecto(command.ProspectoID(), command.DescripcionProspecto());
        emit().onResponse(new ResponseEvents(desc.getUncommittedChanges()));
    }
}
