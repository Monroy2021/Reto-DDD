package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.command.ActualizarEmailAsistente;
import domain.cliente.event.ClienteLlamadaCreado;
import domain.cliente.event.EmailAsistenteActualizado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarEmailAsistenteUseCaseTest {
    private ActualizarEmailAsistenteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void conf(){
        useCase = new ActualizarEmailAsistenteUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }
    @Test
    public void updateEmail(){
        var command = new ActualizarEmailAsistente(
                ClienteLlamadaID.of("Cliente01"),
                LlamadaID.of("Llamada01"),
                AsistenteID.of("Asistente01"),
                new Email("r@r.com")
        );

        when(repository.getEventsBy("Asistente01")).thenReturn(events());
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("Cliente01").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        EmailAsistenteActualizado email = (EmailAsistenteActualizado) events.get(0);
        Assertions.assertEquals("r@r.com", email.Email().value());

    }

    private List<DomainEvent> events() {
        return List.of(
                new ClienteLlamadaCreado(ClienteLlamadaID.of("Cliente01"),
                        new Llamada(
                                LlamadaID.of("Llamada01"),
                                new Prospecto(
                                        ProspectoID.of("Prospecto01"),
                                        new DescripcionProspecto("Terreno construir", "al norte"),
                                        new Cita(true, "20211207", "1600"),
                                        new TipoFinaciamiento("Cuenta abierta"),
                                        new Renta(true, 2000.0),
                                        new Conyugue(true, "carlos")
                                ),
                                new Asistente(
                                        AsistenteID.of("Asistente01"),
                                        new Email("r@r.com"),
                                        new NombreAsistente("Maria")
                                )
                        ))
        );
    }
}