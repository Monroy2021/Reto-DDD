package domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class AsistenteID extends Identity {
    public AsistenteID(String uuid) {
        super(uuid);
    }

    public AsistenteID() {
    }

    public static AsistenteID of(String value){
        return new AsistenteID(value);
    }
}
