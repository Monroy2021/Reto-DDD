package usecase.lead;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.lead.Lead;
import domain.lead.command.ActualizarInteres;

public class ActualizarInteresUseCase extends UseCase<RequestCommand<ActualizarInteres>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarInteres> actualizarInteresRequestCommand) {
        var command = actualizarInteresRequestCommand.getCommand();
        var lead = Lead.from(command.LeadID(), retrieveEvents(command.LeadID().value()));
        lead.actualizarInteres(command.LeadID(), command.Interes());
        emit().onResponse(new ResponseEvents(lead.getUncommittedChanges()));
    }
}
