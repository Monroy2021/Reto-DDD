package usecase.lead;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.lead.Lead;
import domain.lead.command.CrearCampana;

public class CrearCampanaUseCase extends UseCase<RequestCommand<CrearCampana>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCampana> crearCampanaRequestCommand) {
        var command = crearCampanaRequestCommand.getCommand();
        var lead = Lead.from(command.LeadID(), retrieveEvents(command.CampanaID().value()));
        lead.generarCampana(command.CampanaID(), command.NombreCampana(), command.FechaDeContacto());
        emit().onResponse(new ResponseEvents(lead.getUncommittedChanges()));
    }
}
