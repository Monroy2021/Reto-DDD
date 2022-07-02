package usecase.lead;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.lead.Lead;
import domain.lead.command.ActualizarNumeroDeContacto;

public class ActualizarNumeroDeContactoUseCase extends UseCase<RequestCommand<ActualizarNumeroDeContacto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNumeroDeContacto> actualizarNumeroDeContactoRequestCommand) {
        var command = actualizarNumeroDeContactoRequestCommand.getCommand();
        var lead = Lead.from(command.LeadID(), retrieveEvents(command.LeadID().value()));
        lead.actualizarNumeroContacto(command.LeadID(), command.NumeroDeContacto());
        emit().onResponse(new ResponseEvents(lead.getUncommittedChanges()));
    }

}
