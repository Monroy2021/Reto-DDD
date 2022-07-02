package usecase.lead;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.Campana;
import domain.lead.command.CrearCampana;
import domain.lead.events.CampanaCreada;
import domain.lead.events.LeadCreado;
import domain.lead.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CrearCampanaUseCaseTest {
    private CrearCampanaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        useCase = new CrearCampanaUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void CreateCampana(){
        var command = new CrearCampana(LeadID.of("DMLEAD"), CampanaID.of("BUZON"), new NombreCampana("Buzon"), new FechaDeContacto("202112"));
        when(repository.getEventsBy(any())).thenReturn(events());
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("DMLEAD").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        CampanaCreada campanaCreada = (CampanaCreada) events.get(0);
        Assertions.assertEquals("Buzon", campanaCreada.NombreCampana().value());

    }

    private List<DomainEvent> events() {
        return List.of(
                new LeadCreado(
                        new Campana(CampanaID.of("DMLEAD"), new NombreCampana("Buzon"), new FechaDeContacto("202112")),
                        new Interes("Casa finca "),
                        new NumeroDeContacto("300123456"),
                        new Ubicacion("Nuevo")
                )
        );
    }
}