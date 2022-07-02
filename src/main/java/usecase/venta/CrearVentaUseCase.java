package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.CrearVenta;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVenta> crearVentaRequestCommand) {
        var command = crearVentaRequestCommand.getCommand();
        var venta = new Venta(command.VentaID(),command.Asesor(), command.Cliente());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
