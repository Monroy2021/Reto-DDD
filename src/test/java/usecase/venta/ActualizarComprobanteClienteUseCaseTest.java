package usecase.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.Asesor;
import domain.venta.Cliente;
import domain.venta.command.ActualizarComprobanteCliente;
import domain.venta.events.ComprobanteClienteActualizado;
import domain.venta.events.VentaActualizada;
import domain.venta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarComprobanteClienteUseCaseTest {

    private ActualizarComprobanteClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        useCase = new ActualizarComprobanteClienteUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void actualizarComprobante(){
        var command = new ActualizarComprobanteCliente(
                ClienteID.of("RS"),
                VentaID.of("MB2"),
                new Comprobante("Recibo gas","Recibo")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("RS").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        ComprobanteClienteActualizado comprobanteClienteActualizado = (ComprobanteClienteActualizado) events.get(0);
        Assertions.assertEquals("Recibo gas", comprobanteClienteActualizado.Comprobante().value().descripcion());
    }

    private List<DomainEvent> events(){
        return List.of(new VentaActualizada(
                new Asesor(AsesorID.of("MB"), new Nombre("Maria")),
                new Cliente(ClienteID.of("RS"),
                        new Identificacion("1111", "CC"),
                        new Comprobante("lUZ", "RECIBO"),
                        new NumeroContacto("49493882"),
                        new Deposito(4000.0, "CASH")
                )));
    }
}