package domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class LlamadaID extends Identity {
    public LlamadaID(String uuid) {
        super(uuid);
    }

    public LlamadaID() {
    }

    public static LlamadaID of(String value){
        return new LlamadaID(value);
    }
}
