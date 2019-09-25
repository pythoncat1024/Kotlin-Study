package org.victor.cat.java.by;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Case {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private String caseName;
    private int caseLevel;


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public int getCaseLevel() {
        return caseLevel;
    }

    public void setCaseLevel(int caseLevel) {
        int oldValue = this.caseLevel;
        this.caseLevel = caseLevel;
        this.pcs.firePropertyChange("caseLevel", oldValue, caseLevel);
        this.caseLevel = caseLevel;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseName='" + caseName + '\'' +
                ", caseLevel=" + caseLevel +
                '}';
    }
}
