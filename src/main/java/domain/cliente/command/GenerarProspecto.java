package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.*;

public class GenerarProspecto extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final ProspectoID prospectoID;
    private final DescripcionProspecto descripcionProspecto;
    private final Cita cita;
    private final TipoFinaciamiento tipoFinaciamiento;
    private final Renta renta;
    private final Conyugue conyugue;

    public GenerarProspecto(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, ProspectoID prospectoID, DescripcionProspecto descripcionProspecto, Cita cita, TipoFinaciamiento tipoFinaciamiento, Renta renta, Conyugue conyugue) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.prospectoID = prospectoID;
        this.descripcionProspecto = descripcionProspecto;
        this.cita = cita;
        this.tipoFinaciamiento = tipoFinaciamiento;
        this.renta = renta;
        this.conyugue = conyugue;
    }

    public ClienteLlamadaID ClienteLlamadaID() {
        return clienteLlamadaID;
    }

    public LlamadaID LlamadaID() {
        return llamadaID;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public DescripcionProspecto DescripcionProspecto() {
        return descripcionProspecto;
    }

    public Cita Cita() {
        return cita;
    }

    public TipoFinaciamiento TipoFinaciamiento() {
        return tipoFinaciamiento;
    }

    public Renta Renta() {
        return renta;
    }

    public Conyugue Conyugue() {
        return conyugue;
    }
}
