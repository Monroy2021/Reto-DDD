package domain.venta.values;

import co.com.sofka.domain.generic.Identity;

public class AsesorID extends Identity {
    public AsesorID(String uuid) {
        super(uuid);
    }

    public AsesorID() {
    }

    public static AsesorID of(String value){
        return new AsesorID(value);
    }
}
