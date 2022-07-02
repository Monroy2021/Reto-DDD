package usecase.lead;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.Campana;
import domain.lead.command.ActualizarFechaDeContactoCampana;
import domain.lead.events.FechaDeContactoCampanaActualizada;
import domain.lead.events.LeadCreado;
import domain.lead.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
class ActualizarFechaDeContactoCampanaUseCaseTest {
    private ActualizarFechaDeContactoCampanaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        useCase = new ActualizarFechaDeContactoCampanaUseCase();
        repository= mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void UpdateFecha(){
        var command = new ActualizarFechaDeContactoCampana(
                LeadID.of("DMLEAD"), CampanaID.of("BUZON"), new FechaDeContacto("20211212")
        );
        when(repository.getEventsBy("BUZON")).thenReturn(events());
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("DMLEAD").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        FechaDeContactoCampanaActualizada fechaDeContactoCampanaActualizada = (FechaDeContactoCampanaActualizada) events.get(0);
        Assertions.assertEquals("20211212", fechaDeContactoCampanaActualizada.FechaDeContacto().value());
    }

    private List<DomainEvent> events() {
        return List.of( new LeadCreado(
                new Campana(CampanaID.of("DMLEAD"), new NombreCampana("Buzon"), new FechaDeContacto("202112")),
                new Interes("Casa finca "),
                new NumeroDeContacto("300123456"),
                new Ubicacion("New caney")
        ));
    }
}