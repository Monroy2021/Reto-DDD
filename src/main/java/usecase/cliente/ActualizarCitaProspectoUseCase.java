package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarCitaProspecto;

public class ActualizarCitaProspectoUseCase extends UseCase<RequestCommand<ActualizarCitaProspecto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<domain.cliente.command.ActualizarCitaProspecto> actualizarCitaProspectoRequestCommand) {
        var command = actualizarCitaProspectoRequestCommand.getCommand();
        var cita = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.ProspectoID().value()));
        cita.actualizarCitaProspecto(command.ProspectoID(), command.Cita());
        emit().onResponse(new ResponseEvents(cita.getUncommittedChanges()));
    }
}
