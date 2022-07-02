package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarTipoFinanciamientoProspecto;

public class ActualizarTipoFinanciamientoProspectoUseCase extends UseCase<RequestCommand<ActualizarTipoFinanciamientoProspecto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoFinanciamientoProspecto> actualizarTipoFinanciamientoProspectoRequestCommand) {
        var command = actualizarTipoFinanciamientoProspectoRequestCommand.getCommand();
        var fin = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.ProspectoID().value()));
        fin.actualizarTipoFinanciamientoProspecto(command.ProspectoID(), command.TipoFinaciamiento());
        emit().onResponse(new ResponseEvents(fin.getUncommittedChanges()));
    }
}
