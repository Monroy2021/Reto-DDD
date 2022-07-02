package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;
import domain.venta.values.VentaID;

public class ActualizarNombreAsesor extends Command {
    private final AsesorID asesorID;
    private final VentaID ventaID;
    private final Nombre nombre;

    public ActualizarNombreAsesor(AsesorID asesorID, VentaID ventaID, Nombre nombre) {
        this.asesorID = asesorID;
        this.ventaID = ventaID;
        this.nombre = nombre;
    }

    public AsesorID getAsesorID() {
        return asesorID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
