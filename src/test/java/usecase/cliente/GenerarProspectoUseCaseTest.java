package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.command.GenerarProspecto;
import domain.cliente.event.ClienteLlamadaCreado;
import domain.cliente.event.prospectoGenerado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenerarProspectoUseCaseTest {
    private GenerarProspectoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config() {
        useCase = new GenerarProspectoUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }
        @Test
        public void generarProspecto(){
            var command = new GenerarProspecto(
                    ClienteLlamadaID.of("Cliente01"),
                    LlamadaID.of("Llamada01"),
                    ProspectoID.of("Prospecto01"),
                    new DescripcionProspecto("Construir", "new caney"),
                    new Cita(true, "20211201", "1400"),
                    new TipoFinaciamiento("cuenta abierta"),
                    new Renta(true, 1000.0),
                    new Conyugue(true, "Josefa")
            );
            when(repository.getEventsBy(any())).thenReturn(events());
            var response = UseCaseHandler.getInstance().setIdentifyExecutor("Cliente01").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
            var events = response.getDomainEvents();
            prospectoGenerado prospecto = (prospectoGenerado) events.get(0);
            Assertions.assertEquals("Construir", prospecto.DescripcionProspecto().value().razonDeBusqueda());
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