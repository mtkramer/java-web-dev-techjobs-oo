package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(job1.getId() + 1, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertEquals(job.getName(), "Product tester");
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertTrue(job.getLocation() instanceof Location);
        assertEquals(job.getLocation().getValue(), "Desert");
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        Job job2 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertNotEquals(job1, job2);
    }

    @Test
    public void testNullJobOutput(){
        Job job = new Job();
        assertEquals(job.toString(), "\nOOPS! This job does not seem to exist.\n\n");
    }

    @Test
    public void testAllValuesOutputFormat(){
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertEquals(job.toString(),
                "\n" +
                        "ID: " + job.getId() + "\n" +
                        "Name: " + job.getName() + "\n" +
                        "Employer: " + job.getEmployer().getValue() + "\n" +
                        "Location: " + job.getLocation().getValue() + "\n" +
                        "Position Type: " + job.getPositionType().getValue() + "\n" +
                        "Core Competency: " + job.getCoreCompetency().getValue() + "\n" +
                        "\n"
        );
    }

    @Test
    public void testMissingValueOutput(){
        Job job = new Job(
                "",
                new Employer(""),
                new Location(),
                new PositionType("Quality control"),
                null
        );
        assertEquals(job.toString(),
                "\n" +
                        "ID: " + job.getId() + "\n" +
                        "Name: Data not available\n" +
                        "Employer: Data not available\n" +
                        "Location: Data not available\n" +
                        "Position Type: " + job.getPositionType().getValue() + "\n" +
                        "Core Competency: Data not available\n" +
                        "\n"
        );
    }

}
