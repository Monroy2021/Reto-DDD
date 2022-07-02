package usecase.lead;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.lead.Lead;
import domain.lead.command.ActualizarFechaDeContactoCampana;

public class ActualizarFechaDeContactoCampanaUseCase extends UseCase<RequestCommand<ActualizarFechaDeContactoCampana>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarFechaDeContactoCampana> actualizarFechaDeContactoCampanaRequestCommand) {
        var command = actualizarFechaDeContactoCampanaRequestCommand.getCommand();
        var lead = Lead.from(command.LeadID(), retrieveEvents(command.CampanaID().value()));
        lead.actualizarFechaDeContacto(command.CampanaID(), command.FechaDeContacto());
        emit().onResponse(new ResponseEvents(lead.getUncommittedChanges()));
    }

}
