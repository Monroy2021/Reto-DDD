package domain.lead;

import co.com.sofka.domain.generic.EventChange;
import domain.lead.events.*;

public class LeadChange extends EventChange {

    public LeadChange(Lead lead) {
        apply((LeadCreado event)->{
            lead.numeroDeContacto = event.NumeroDeContacto();
            lead.campana = event.Campana();
            lead.interes= event.Interes();
            lead.ubicacion=event.Ubicacion();
        });

        apply((CampanaCreada event)->{
            lead.campana = new Campana(event.CampanaID(), event.NombreCampana(), event.FechaDeContacto());
        });

        apply((FechaDeContactoCampanaActualizada event)->{
            lead.campana.actualizarFechaDeContacto(event.FechaDeContacto());
        });

        apply((NombreDeCampanaActualizado event)->{
            lead.campana.actualizarNombre(event.Nombre());
        });

        apply((NumeroDeContactoActualizado event)->{
            lead.numeroDeContacto = event.NumeroDeContacto();
        });

        apply((InteresActualizado event)->{
            lead.interes = event.Interes();
        });


    }

}
