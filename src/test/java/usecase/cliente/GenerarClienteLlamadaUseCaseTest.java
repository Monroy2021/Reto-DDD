package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.command.GenerarClienteLlamada;
import domain.cliente.event.ClienteLlamadaCreado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenerarClienteLlamadaUseCaseTest {
    private GenerarClienteLlamadaUseCase useCase;

    @BeforeEach
    public void config(){
        useCase= new GenerarClienteLlamadaUseCase();
    }
    @Test
    public void crearClienteLlamada(){
        var command = new GenerarClienteLlamada(
                ClienteLlamadaID.of("Cliente01"),
                new Llamada(LlamadaID.of("Llamada01"),
                        new Prospecto(ProspectoID.of("Prospecto01"),
                                new DescripcionProspecto("",""),
                                new Cita(true, "202101", "1600"),
                                new TipoFinaciamiento("Cuenta Abierta"),
                                new Renta(true, 2000.1),
                                new Conyugue(true, "carlos" )),
                        new Asistente(AsistenteID.of("Asistente01"), new Email("mb@gmail.com"), new NombreAsistente("Maria")))
        );
        var response = UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();

        ClienteLlamadaCreado clienteCreado = (ClienteLlamadaCreado) events.get(0);
        Assertions.assertEquals("mb@gmail.com", clienteCreado.Llamada().Asistente().Email().value());
    }
}