
package sn.ismonline.ism_examen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Elector {
    private final StringProperty name;
    private final StringProperty district;

    public Elector(String name, String district) {
        this.name = new SimpleStringProperty(name);
        this.district = new SimpleStringProperty(district);
    }

    public String getName() {
        return (String)this.name.get();
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    public String getDistrict() {
        return (String)this.district.get();
    }

    public StringProperty districtProperty() {
        return this.district;
    }
}
