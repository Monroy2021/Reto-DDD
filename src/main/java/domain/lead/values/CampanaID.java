package domain.lead.values;

import co.com.sofka.domain.generic.Identity;

public class CampanaID extends Identity {

    public CampanaID(String uuid) {
        super(uuid);
    }

    public CampanaID() {
    }

    public static CampanaID of(String value){
        return new CampanaID(value);
    }
}
