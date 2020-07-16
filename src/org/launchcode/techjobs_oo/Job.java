package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString(){
        String missingValue = "Data not available\n";
        String[] values = {
                this.getName() == null ? "" : this.getName(),
                this.getEmployer() == null || this.getEmployer().getValue() == null ? "" : this.getEmployer().getValue(),
                this.getLocation() == null || this.getLocation().getValue() == null ? "" : this.getLocation().getValue(),
                this.getPositionType() == null || this.getPositionType().getValue() == null ? "" : this.getPositionType().getValue(),
                this.getCoreCompetency() == null || this.getCoreCompetency().getValue() == null ? "" : this.getCoreCompetency().getValue(),
        };
        int miss = 0;
        String[] out = {
                "\n",
                "ID: " + this.getId() + "\n",
                "Name: ",
                "Employer: ",
                "Location: ",
                "Position Type: ",
                "Core Competency: ",
                "\n"
        };

        for(int i = 0; i < values.length; i++){
            if(values[i].equals("")){
                out[i + 2] += missingValue;
                miss++;
            } else {
                out[i + 2] += values[i] + "\n";
            }
        }
        return miss == 5 ?
                "\nOOPS! This job does not seem to exist.\n\n" :
                out[0] + out[1] + out[2] + out[3] + out[4] + out[5] + out[6] + out[7];
    }

    // Custom .equals() and .hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Getters and Setters:

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Employer getEmployer() { return employer; }

    public void setEmployer(Employer employer) { this.employer = employer; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public PositionType getPositionType() { return positionType; }

    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }

    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }
}
