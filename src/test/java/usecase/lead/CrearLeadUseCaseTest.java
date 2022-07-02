package usecase.lead;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.lead.Campana;
import domain.lead.command.CrearLead;
import domain.lead.events.LeadCreado;
import domain.lead.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearLeadUseCaseTest {
    private CrearLeadUseCase useCase;

    @BeforeEach
    public void config(){
        useCase = new CrearLeadUseCase();
    }
    @Test
    public void crearLead(){
        var command = new CrearLead(
                LeadID.of("DMLEAD"),
                new Campana(CampanaID.of("BUZON"), new NombreCampana("NoShow"), new FechaDeContacto("202112")),
                new Interes("busca terreno en el norte"),
                new NumeroDeContacto("300123456"),
                new Ubicacion("Nueva"));

        var response = UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();

        LeadCreado leadCreado = (LeadCreado) events.get(0);
        Assertions.assertEquals("Nueva ", leadCreado.Ubicacion().value());
    }



}