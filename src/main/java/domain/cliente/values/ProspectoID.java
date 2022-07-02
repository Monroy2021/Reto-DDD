package domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ProspectoID extends Identity {
    public ProspectoID(String uuid) {
        super(uuid);
    }

    public ProspectoID() {
    }

    public static ProspectoID of(String value){
        return new ProspectoID(value);
    }
}
