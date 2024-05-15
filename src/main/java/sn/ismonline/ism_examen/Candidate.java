package sn.ismonline.ism_examen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidate {
    private final StringProperty name;
    private final StringProperty party;

    public Candidate(String name, String party) {
        this.name = new SimpleStringProperty(name);
        this.party = new SimpleStringProperty(party);
    }

    public String getName() {
        return (String)this.name.get();
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    public String getParty() {
        return (String)this.party.get();
    }

    public StringProperty partyProperty() {
        return this.party;
    }
}

