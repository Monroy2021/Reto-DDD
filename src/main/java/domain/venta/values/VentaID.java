package domain.venta.values;

import co.com.sofka.domain.generic.Identity;

public class VentaID extends Identity {

    public VentaID(String uuid) {
        super(uuid);
    }

    public VentaID(){
    }

    public static VentaID of(String value){
        return new VentaID(value);
    }
}
