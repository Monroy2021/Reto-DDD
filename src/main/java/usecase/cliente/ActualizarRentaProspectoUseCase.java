package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.ClienteLlamada;
import domain.cliente.command.ActualizarRentaProspecto;

public class ActualizarRentaProspectoUseCase extends UseCase<RequestCommand<ActualizarRentaProspecto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarRentaProspecto> actualizarRentaProspectoRequestCommand) {
        var command = actualizarRentaProspectoRequestCommand.getCommand();
        var renta = ClienteLlamada.from(command.ClienteLlamadaID(), retrieveEvents(command.ProspectoID().value()));
        renta.actualizarRentaProspecto(command.ProspectoID(), command.Renta());
        emit().onResponse(new ResponseEvents(renta.getUncommittedChanges()));
    }
}

