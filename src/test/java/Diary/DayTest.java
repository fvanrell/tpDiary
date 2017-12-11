/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.Diary;

import Diary.Appointment;
import Diary.Day;
import Diary.Week;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rzgheib
 */
public class DayTest {
    Week semaine;
    Day jourT1;
    Appointment rdvT1;
    Appointment rdvT2;
    
    public DayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        semaine = new Week(1);
        jourT1 = new Day(1);
        rdvT1 = new Appointment("RDV 3h", 3);
        rdvT2 = new Appointment("RDV 2h", 2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAppointment() {
        assertEquals(3, rdvT1.getDuration());
        assertEquals("RDV 2h", rdvT2.getDescription());
    }
    
    @Test
    public void testDay() {
        assertEquals(1, jourT1.getDayNumber());
    }
    
    @Test
    public void testWeek() {
        assertEquals(1,semaine.getWeekNumber());
        assertEquals(null, semaine.getDay(7));
    }
    
    @Test
    public void testFindSpace() {
        assertEquals(9,jourT1.findSpace(rdvT1));
    }
    
    @Test
    public void testMakeAppointment() {
        assertFalse(jourT1.makeAppointment(8,rdvT2));
        assertTrue(jourT1.makeAppointment(10,rdvT1));
        assertFalse(jourT1.makeAppointment(11, rdvT2));
        assertFalse(jourT1.makeAppointment(17,rdvT1));
    }
    
    @Test
    public void testGetAppointment() {
        jourT1.makeAppointment(10,rdvT1);
        assertEquals(rdvT1, jourT1.getAppointment(10));
        assertEquals(null, jourT1.getAppointment(18));
    }
 
    @Test
    public void testFailFindSpace() {
        jourT1.makeAppointment(11,rdvT1);
        jourT1.makeAppointment(16, rdvT2);
        assertEquals(-1, jourT1.findSpace(rdvT1));
    }
    
    @Test
    public void testShowAppointments() {
        semaine.getDay(1).makeAppointment(10,rdvT1);
        semaine.getDay(1).makeAppointment(15,rdvT2);
        semaine.getDay(2).makeAppointment(11,rdvT1);
        semaine.getDay(3).makeAppointment(14,rdvT1);
        semaine.getDay(5).makeAppointment(9,rdvT2);
        semaine.showAppointments();
    }
    
    @Test
    public void testMakeAppointmentViaWeek() {
        assertTrue(semaine.getDay(1).makeAppointment(10,rdvT1));
        assertFalse(semaine.getDay(1).makeAppointment(11, rdvT2));
    }
}
