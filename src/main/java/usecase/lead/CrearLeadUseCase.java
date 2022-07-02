package usecase.lead;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.lead.Lead;
import domain.lead.command.CrearLead;

public class CrearLeadUseCase extends UseCase<RequestCommand<CrearLead>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearLead> crearLeadRequestCommand) {
        var command = crearLeadRequestCommand.getCommand();
        var lead = new Lead(command.LeadID(), command.Campana(), command.Interes(), command.NumeroDeContacto(), command.Ubicacion());
        emit().onResponse(new ResponseEvents(lead.getUncommittedChanges()));
    }
}
