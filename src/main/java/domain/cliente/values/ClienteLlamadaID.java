package domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteLlamadaID extends Identity {
    public ClienteLlamadaID(String uuid) {
        super(uuid);
    }

    public ClienteLlamadaID() {
    }

    public static ClienteLlamadaID of(String value){
        return new ClienteLlamadaID(value);
    }
}
