package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.GenerarProspecto;

public class GenerarProspectoUseCase extends UseCase<RequestCommand<GenerarProspecto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarProspecto> generarProspectoRequestCommand) {
        var command = generarProspectoRequestCommand.getCommand();
        var clienteLlamada = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.ProspectoID().value()));
        clienteLlamada.generarProspecto(command.ProspectoID(), command.DescripcionProspecto(), command.Cita(), command.TipoFinaciamiento(), command.Renta(), command.Conyugue());
        emit().onResponse(new ResponseEvents(clienteLlamada.getUncommittedChanges()));
    }
}
