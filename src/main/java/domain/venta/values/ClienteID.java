package domain.venta.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteID extends Identity {
    public ClienteID(String uuid) {
        super(uuid);
    }

    public ClienteID() {
    }

    public static ClienteID of(String value){return new ClienteID(value); }
}
