package usecase.lead;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.lead.Lead;
import domain.lead.command.ActualizarNombreDeCampana;

public class ActualizarNombreDeCampanaUseCase extends UseCase<RequestCommand<ActualizarNombreDeCampana>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeCampana> actualizarNombreDeCampanaRequestCommand) {
        var command = actualizarNombreDeCampanaRequestCommand.getCommand();
        var lead = Lead.from(command.LeadID(), retrieveEvents(command.CampanaID().value()));
        lead.actualizarNombreDeCampana(command.CampanaID(),  command.Nombre());
        emit().onResponse(new ResponseEvents(lead.getUncommittedChanges()));
    }
}
