package usecase.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import domain.venta.Asesor;
import domain.venta.Cliente;
import domain.venta.command.CrearVenta;
import domain.venta.events.VentaCreada;
import domain.venta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class CrearVentaUseCaseTest {

    private CrearVentaUseCase ventaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        ventaUseCase = new CrearVentaUseCase();
        repository = mock(DomainEventRepository.class);
        ventaUseCase.addRepository(repository);
    }

    @Test
    public void generaVenta(){
        AsesorID idAsesor = AsesorID.of("MB");
        Nombre nombre = new Nombre("Maria");

        ClienteID idCliente = ClienteID.of("300123456");
        Identificacion identificacion = new Identificacion("xx", "Cedula");
        Comprobante comprobante = new Comprobante("Recibo luz mes enero", "Recibo luz");
        NumeroContacto contacto = new NumeroContacto("300123456");
        Deposito deposito = new Deposito(1000.0, "cash");


        Asesor asesor = new Asesor(idAsesor, nombre);
        Cliente cliente = new Cliente(idCliente, identificacion,comprobante, contacto, deposito);

        var command = new CrearVenta(VentaID.of("DMLEAD"), asesor, cliente);
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("DMLEAD").syncExecutor(ventaUseCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        VentaCreada ventaCreada = (VentaCreada) events.get(0);


        Assertions.assertEquals("Maria", ventaCreada.Asesor().Nombre().value());

    }

}