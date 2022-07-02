package usecase.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.Asesor;
import domain.venta.Cliente;
import domain.venta.command.CrearAsesor;
import domain.venta.events.AsesorCreado;
import domain.venta.events.VentaActualizada;
import domain.venta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.*;


class CrearAsesorUseCaseTest {

    private CrearAsesorUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        useCase = new CrearAsesorUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void crearAsesor(){
        var command = new CrearAsesor(
                VentaID.of("MB"),
                AsesorID.of("MB3"),
                new Nombre("RS")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("MB")
                .syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        AsesorCreado asesorCreado = (AsesorCreado) events.get(0);
        Assertions.assertEquals("RS", asesorCreado.Nombre().value());

    }

    private List<DomainEvent> events(){
        return List.of(new VentaActualizada(
                new Asesor(AsesorID.of("MB"), new Nombre("Maria")),
                new Cliente(ClienteID.of("RS"),
                        new Identificacion("1111", "CC"),
                        new Comprobante("lUZ", "RECIBO"),
                        new NumeroContacto("300123456"),
                        new Deposito(4000.0, "CASH")
                )));
    }
}