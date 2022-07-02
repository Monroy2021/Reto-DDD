package domain.lead.values;

import co.com.sofka.domain.generic.Identity;

public class LeadID extends Identity {
    public LeadID(String uuid) {
        super(uuid);
    }

    public LeadID() {
    }

    public static LeadID of(String value){
        return new LeadID(value);
    }
}
