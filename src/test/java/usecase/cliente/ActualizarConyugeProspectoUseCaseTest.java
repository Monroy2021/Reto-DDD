package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.command.ActualizarConyugueProspecto;
import domain.cliente.event.ClienteLlamadaCreado;
import domain.cliente.event.conyugueProspectoActualizada;
import domain.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarConyugeProspectoUseCaseTest {

    private ActualizarConyugeProspectoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        useCase = new ActualizarConyugeProspectoUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void updateConyuge(){
        var command = new ActualizarConyugueProspecto(
                ClienteLlamadaID.of("Cliente01"),
                LlamadaID.of("Llamada01"),
                ProspectoID.of("Prospecto01"),
                new Conyugue(true, "Josefo")
        );
        when(repository.getEventsBy("Prospecto01")).thenReturn(events());
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("Cliente01").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        conyugueProspectoActualizada conyugue = (conyugueProspectoActualizada) events.get(0);
        Assertions.assertEquals(true, conyugue.Conyugue().value().tieneConyugue());
    }

    private List<DomainEvent> events() {
        return List.of(
                new ClienteLlamadaCreado(ClienteLlamadaID.of("Cliente01"),
                        new Llamada(
                                LlamadaID.of("Llamada01"),
                                new Prospecto(
                                        ProspectoID.of("Prospecto01"),
                                        new DescripcionProspecto("Terreno construir", "al norte "),
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