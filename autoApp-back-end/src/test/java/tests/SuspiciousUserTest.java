package tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.autoAppbackend.model.*;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SuspiciousUserTest {

    protected final String ksessionName = "suspiciousUserSession";

    @Test
    public void TestCancellationLessThanADayAfterReservation(){

        List<VehicleReservation> reservations = createCancellationLessThanADayAfterReservation();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Invalid reason");
        System.out.println("Fired rules: " + firedRules);
        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , res time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " ,res time: " + reservations.get(1).getReservationTime() + ", cancel time: " + reservations.get(1).getCancellationTime() + ", cancel reason length: " + reservations.get(1).getCancellationReason().length());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " ,res time: " + reservations.get(2).getReservationTime() + ", cancel time: " + reservations.get(2).getCancellationTime() + ", cancel reason length: " + reservations.get(2).getCancellationReason().length());
        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + " ,res time: " + reservations.get(3).getReservationTime() + ", cancel time: " + reservations.get(3).getCancellationTime() + ", cancel reason length: " + reservations.get(3).getCancellationReason().length());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + " ,res time: " + reservations.get(4).getReservationTime() + ", cancel time: " + reservations.get(4).getCancellationTime() + ", cancel reason length: " + reservations.get(4).getCancellationReason().length());


        assertThat(reservations.get(0).getUser().isSuspicious(), equalTo(true));

    }

    @Test
    public void TestCancellationLessThanADayAfterReservationButReasonIsValid(){

        List<VehicleReservation> reservations = createCancellationLessThanADayAfterReservation();

        reservations.get(1).setCancellationReason("Ovo je validan razlog otkazivanja");

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Valid reason");
        System.out.println("Fired rules: " + firedRules);
        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , res time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " ,res time: " + reservations.get(1).getReservationTime() + ", cancel time: " + reservations.get(1).getCancellationTime() + ", cancel reason length: " + reservations.get(1).getCancellationReason().length());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " ,res time: " + reservations.get(2).getReservationTime() + ", cancel time: " + reservations.get(2).getCancellationTime() + ", cancel reason length: " + reservations.get(2).getCancellationReason().length());
        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + " ,res time: " + reservations.get(3).getReservationTime() + ", cancel time: " + reservations.get(3).getCancellationTime() + ", cancel reason length: " + reservations.get(3).getCancellationReason().length());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + " ,res time: " + reservations.get(4).getReservationTime() + ", cancel time: " + reservations.get(4).getCancellationTime() + ", cancel reason length: " + reservations.get(4).getCancellationReason().length());


        assertThat(reservations.get(0).getUser().isSuspicious(), equalTo(false));

    }

    @Test
    public void TestCancellationLessThanHourBeforePickup(){

        List<VehicleReservation> reservations = createCancellationLessThanADayAfterReservation();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Invalid reason");
        System.out.println("Fired rules: " + firedRules);
        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " , pickup time: " + reservations.get(1).getScheduledPickupTime() + ", cancel time: " + reservations.get(1).getCancellationTime() + ", cancel reason length: " + reservations.get(1).getCancellationReason().length());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " , pickup time: " + reservations.get(2).getScheduledPickupTime() + ", cancel time: " + reservations.get(2).getCancellationTime() + ", cancel reason length: " + reservations.get(2).getCancellationReason().length());
        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + " , pickup time: " + reservations.get(3).getScheduledPickupTime() + ", cancel time: " + reservations.get(3).getCancellationTime() + ", cancel reason length: " + reservations.get(3).getCancellationReason().length());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + " , pickup time: " + reservations.get(4).getScheduledPickupTime() + ", cancel time: " + reservations.get(4).getCancellationTime() + ", cancel reason length: " + reservations.get(4).getCancellationReason().length());


        assertThat(reservations.get(0).getUser().isSuspicious(), equalTo(true));

    }

    @Test
    public void TestCancellationLessThanHourBeforePickupButReasonIsValid(){

        List<VehicleReservation> reservations = createCancellationLessThanADayAfterReservation();
        reservations.get(1).setCancellationReason("Ovo je validan razlog otkazivanja");

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Valid reason");
        System.out.println("Fired rules: " + firedRules);
        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " , pickup time: " + reservations.get(1).getScheduledPickupTime() + ", cancel time: " + reservations.get(1).getCancellationTime() + ", cancel reason length: " + reservations.get(1).getCancellationReason().length());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " , pickup time: " + reservations.get(2).getScheduledPickupTime() + ", cancel time: " + reservations.get(2).getCancellationTime() + ", cancel reason length: " + reservations.get(2).getCancellationReason().length());
        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + " , pickup time: " + reservations.get(3).getScheduledPickupTime() + ", cancel time: " + reservations.get(3).getCancellationTime() + ", cancel reason length: " + reservations.get(3).getCancellationReason().length());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + " , pickup time: " + reservations.get(4).getScheduledPickupTime() + ", cancel time: " + reservations.get(4).getCancellationTime() + ", cancel reason length: " + reservations.get(4).getCancellationReason().length());


        assertThat(reservations.get(0).getUser().isSuspicious(), equalTo(false));

    }


    @Test
    public void TestDamagedVehicleReturned(){

        List<VehicleReservation> reservations = createDamagerVehicleReturned();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Damaged vehicle");
        System.out.println("Fired rules: " + firedRules);
        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + ", vehicle sstate: " + reservations.get(1).getVehicleState());

        assertThat(reservations.get(0).getUser().isSuspicious(), equalTo(true));
    }

    @Test
    public void TestFullyFunctionalVehicleReturned(){

        List<VehicleReservation> reservations = createDamagerVehicleReturned();

        reservations.get(1).setVehicleState(VehicleType.FULLY_FUNCTIONAL);

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Damaged vehicle");
        System.out.println("Fired rules: " + firedRules);
        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + ", vehicle sstate: " + reservations.get(1).getVehicleState());

        assertThat(reservations.get(0).getUser().isSuspicious(), equalTo(false));
    }

    @Test
    public void TestMoreThanTwoDirtyVehiclesReturned(){

        List<VehicleReservation> reservations = createMoreThanTwoDirtyVehiclesReturned();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("More Than Two TImes Dirty vehicle");
        System.out.println("Fired rules: " + firedRules);

        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " , reservation time: " + reservations.get(1).getReservationTime());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " , reservation time: " + reservations.get(2).getReservationTime());

        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + ", vehicle state: " + reservations.get(3).getVehicleState());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + ", vehicle state: " + reservations.get(4).getVehicleState());
        System.out.println(reservations.get(5).getUser().getId().toString() + " " + reservations.get(5).getStatus() + ", vehicle state: " + reservations.get(5).getVehicleState());


        assertThat(reservations.get(3).getUser().isSuspicious(), equalTo(true));
        assertThat(reservations.get(4).getUser().isSuspicious(), equalTo(true));
        assertThat(reservations.get(5).getUser().isSuspicious(), equalTo(true));
    }


    @Test
    public void TestLessThanTwoDirtyVehiclesReturned(){

        List<VehicleReservation> reservations = createLessThanTwoDirtyVehiclesReturned();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Less Than Two TImes Dirty vehicle");
        System.out.println("Fired rules: " + firedRules);

        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " , reservation time: " + reservations.get(1).getReservationTime());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " , reservation time: " + reservations.get(2).getReservationTime());

        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + ", vehicle state: " + reservations.get(3).getVehicleState());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + ", vehicle state: " + reservations.get(4).getVehicleState());
        System.out.println(reservations.get(5).getUser().getId().toString() + " " + reservations.get(5).getStatus() + ", vehicle state: " + reservations.get(5).getVehicleState());


        assertThat(reservations.get(3).getUser().isSuspicious(), equalTo(false));
        assertThat(reservations.get(4).getUser().isSuspicious(), equalTo(false));
        assertThat(reservations.get(5).getUser().isSuspicious(), equalTo(false));
    }

    @Test
    public void TestMoreThanTwoTimesLateVehiclesReturned(){

        List<VehicleReservation> reservations = createMoreThanTwoTimesLateVehiclesReturned();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("More Than Two Times Late vehicle");
        System.out.println("Fired rules: " + firedRules);

        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " , reservation time: " + reservations.get(1).getReservationTime());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " , reservation time: " + reservations.get(2).getReservationTime());

        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + ", vehicle state: " + reservations.get(3).getVehicleState());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + ", vehicle state: " + reservations.get(4).getVehicleState());
        System.out.println(reservations.get(5).getUser().getId().toString() + " " + reservations.get(5).getStatus() + ", vehicle state: " + reservations.get(5).getVehicleState());


        assertThat(reservations.get(3).getUser().isSuspicious(), equalTo(true));
        assertThat(reservations.get(4).getUser().isSuspicious(), equalTo(true));
        assertThat(reservations.get(5).getUser().isSuspicious(), equalTo(true));
    }

    @Test
    public void TestLessThanTwoTimesLateVehiclesReturned(){

        List<VehicleReservation> reservations = createLessThanTimesLateVehiclesReturned();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kieContainer.newKieSession("suspiciousUserSession");
        kieSession.addEventListener(new DebugAgendaEventListener());


        for (VehicleReservation reservation : reservations) {
            kieSession.insert(reservation);
        }

        int firedRules = kieSession.fireAllRules();

        var a = kieSession.getObjects();
        kieSession.dispose();

        System.out.println("Less Than Two Times Late vehicle");
        System.out.println("Fired rules: " + firedRules);

        System.out.println(reservations.get(0).getUser().getId().toString() + " " + reservations.get(0).getStatus() + " , reservation time: " + reservations.get(0).getReservationTime());
        System.out.println(reservations.get(1).getUser().getId().toString() + " " + reservations.get(1).getStatus() + " , reservation time: " + reservations.get(1).getReservationTime());
        System.out.println(reservations.get(2).getUser().getId().toString() + " " + reservations.get(2).getStatus() + " , reservation time: " + reservations.get(2).getReservationTime());

        System.out.println(reservations.get(3).getUser().getId().toString() + " " + reservations.get(3).getStatus() + ", vehicle state: " + reservations.get(3).getVehicleState());
        System.out.println(reservations.get(4).getUser().getId().toString() + " " + reservations.get(4).getStatus() + ", vehicle state: " + reservations.get(4).getVehicleState());
        System.out.println(reservations.get(5).getUser().getId().toString() + " " + reservations.get(5).getStatus() + ", vehicle state: " + reservations.get(5).getVehicleState());


        assertThat(reservations.get(3).getUser().isSuspicious(), equalTo(false));
        assertThat(reservations.get(4).getUser().isSuspicious(), equalTo(false));
        assertThat(reservations.get(5).getUser().isSuspicious(), equalTo(false));
    }

    //***********************Pomocne funkcije**********************************

    private List<VehicleReservation> createCancellationLessThanADayAfterReservation(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
                );
        scheduledReservation.setId(1);

        VehicleReservation cancelledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                LocalDateTime.of(2024,5,27,1,0,0),
                "aa",
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.CANCELLED
        );

        //Ako pokusam da vratim listu tako sto cu prvo da dodam scheduledReservation, a zatim pet puta cancelledReservation
        //iz nekog razloga Drools to shvati kao da ima samo dve rezervacije, valjda zbog toga sto su sve cannceledReservation iste
        //pa pravilo ne radi kako treba. Zbog toga je potrebno da cenncelationReservations nisu bas potpuno iste, u ovom primeru
        //imace razlicite id-eve

        VehicleReservation cancelledReservation1 = createReservation(2,cancelledReservation);
        VehicleReservation cancelledReservation2 = createReservation(3,cancelledReservation);
        VehicleReservation cancelledReservation3 = createReservation(4,cancelledReservation);
        VehicleReservation cancelledReservation4 = createReservation(5,cancelledReservation);

        reservations.add(scheduledReservation);
        reservations.add(cancelledReservation1);
        reservations.add(cancelledReservation2);
        reservations.add(cancelledReservation3);
        reservations.add(cancelledReservation4);
        return reservations;
    }


    private List<VehicleReservation> createCancellationLessThanAHourBeforePickup(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
        );
        scheduledReservation.setId(1);

        VehicleReservation cancelledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                LocalDateTime.of(2024,6,1,10,30,0),
                "aa",
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.CANCELLED
        );

        //Ako pokusam da vratim listu tako sto cu prvo da dodam scheduledReservation, a zatim pet puta cancelledReservation
        //iz nekog razloga Drools to shvati kao da ima samo dve rezervacije, valjda zbog toga sto su sve cannceledReservation iste
        //pa pravilo ne radi kako treba. Zbog toga je potrebno da cenncelationReservations nisu bas potpuno iste, u ovom primeru
        //imace razlicite id-eve

        VehicleReservation cancelledReservation1 = createReservation(2,cancelledReservation);
        VehicleReservation cancelledReservation2 = createReservation(3,cancelledReservation);
        VehicleReservation cancelledReservation3 = createReservation(4,cancelledReservation);
        VehicleReservation cancelledReservation4 = createReservation(5,cancelledReservation);

        reservations.add(scheduledReservation);
        reservations.add(cancelledReservation1);
        reservations.add(cancelledReservation2);
        reservations.add(cancelledReservation3);
        reservations.add(cancelledReservation4);
        return reservations;
    }

    private List<VehicleReservation> createDamagerVehicleReturned(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
        );
        scheduledReservation.setId(1);

        VehicleReservation returnedReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                LocalDateTime.of(2024,6,3,14,0, 0),
                VehicleType.DAMAGED,
                ReservationStatus.RETURNED
        );

        VehicleReservation returnedReservation1 = createReservation(2,returnedReservation);

        reservations.add(scheduledReservation);
        reservations.add(returnedReservation1);
        return reservations;
    }

    private User createUser(){
        return new User(1L,"user@gmail.com","password123","User","User",false);
    }

    private Vehicle createVehicle(){
        return new Vehicle("Vehicle model", VehicleType.OTHER,2000,"");
    }

    private VehicleReservation createReservation(int id, VehicleReservation reservation){
        VehicleReservation res = new VehicleReservation();
        res.setId(id);
        res.setUser(reservation.getUser());
        res.setVehicle(reservation.getVehicle());
        res.setReservationTime(reservation.getReservationTime());
        res.setCancellationTime(reservation.getCancellationTime());
        res.setCancellationReason(reservation.getCancellationReason());
        res.setScheduledPickupTime(reservation.getScheduledPickupTime());
        res.setScheduledReturnTime(reservation.getScheduledReturnTime());
        res.setActualReturnTime(reservation.getActualReturnTime());
        res.setVehicleState(reservation.getVehicleState());
        res.setStatus(reservation.getStatus());
        return res;
    }

    private List<VehicleReservation> createMoreThanTwoDirtyVehiclesReturned(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
        );

        VehicleReservation scheduledReservation1 = createReservation(1, scheduledReservation);
        VehicleReservation scheduledReservation2 = createReservation(2, scheduledReservation);
        VehicleReservation scheduledReservation3 = createReservation(3, scheduledReservation);

        VehicleReservation returnedReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                LocalDateTime.of(2024,6,3,14,0, 0),
                VehicleType.DIRTY,
                ReservationStatus.RETURNED
        );

        VehicleReservation returnedReservation1 = createReservation(4,returnedReservation);
        VehicleReservation returnedReservation2 = createReservation(5,returnedReservation);
        VehicleReservation returnedReservation3 = createReservation(6,returnedReservation);

        reservations.add(scheduledReservation1);
        reservations.add(scheduledReservation2);
        reservations.add(scheduledReservation3);
        reservations.add(returnedReservation1);
        reservations.add(returnedReservation2);
        reservations.add(returnedReservation3);
        return reservations;
    }


    private List<VehicleReservation> createLessThanTwoDirtyVehiclesReturned(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
        );

        VehicleReservation scheduledReservation1 = createReservation(1, scheduledReservation);
        VehicleReservation scheduledReservation2 = createReservation(2, scheduledReservation);
        VehicleReservation scheduledReservation3 = createReservation(3, scheduledReservation);

        VehicleReservation returnedDirtyReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                LocalDateTime.of(2024,6,3,14,0, 0),
                VehicleType.DIRTY,
                ReservationStatus.RETURNED
        );

        VehicleReservation returnedCleanReservation = new VehicleReservation(
            createVehicle(),
            createUser(),
            LocalDateTime.of(2024,5,27,0,0,0),
            null,
            null,
            LocalDateTime.of(2024,6,1,11,0, 0),
            LocalDateTime.of(2024,6,3,15,0, 0),
            LocalDateTime.of(2024,6,3,14,0, 0),
            VehicleType.FULLY_FUNCTIONAL,
            ReservationStatus.RETURNED
    );

        VehicleReservation returnedReservation1 = createReservation(4,returnedDirtyReservation);
        VehicleReservation returnedReservation2 = createReservation(5,returnedDirtyReservation);
        VehicleReservation returnedReservation3 = createReservation(6,returnedCleanReservation);

        reservations.add(scheduledReservation1);
        reservations.add(scheduledReservation2);
        reservations.add(scheduledReservation3);
        reservations.add(returnedReservation1);
        reservations.add(returnedReservation2);
        reservations.add(returnedReservation3);
        return reservations;
    }

    private List<VehicleReservation> createMoreThanTwoTimesLateVehiclesReturned(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
        );

        VehicleReservation scheduledReservation1 = createReservation(1, scheduledReservation);
        VehicleReservation scheduledReservation2 = createReservation(2, scheduledReservation);
        VehicleReservation scheduledReservation3 = createReservation(3, scheduledReservation);

        VehicleReservation returnedReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                LocalDateTime.of(2024,6,4,14,0, 0),
                VehicleType.FULLY_FUNCTIONAL,
                ReservationStatus.RETURNED
        );

        VehicleReservation returnedReservation1 = createReservation(4,returnedReservation);
        VehicleReservation returnedReservation2 = createReservation(5,returnedReservation);
        VehicleReservation returnedReservation3 = createReservation(6,returnedReservation);

        reservations.add(scheduledReservation1);
        reservations.add(scheduledReservation2);
        reservations.add(scheduledReservation3);
        reservations.add(returnedReservation1);
        reservations.add(returnedReservation2);
        reservations.add(returnedReservation3);
        return reservations;
    }


    private List<VehicleReservation> createLessThanTimesLateVehiclesReturned(){
        List<VehicleReservation> reservations = new ArrayList<>();
        VehicleReservation scheduledReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,10,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                null,
                VehicleType.OTHER,
                ReservationStatus.SCHEDULED
        );

        VehicleReservation scheduledReservation1 = createReservation(1, scheduledReservation);
        VehicleReservation scheduledReservation2 = createReservation(2, scheduledReservation);
        VehicleReservation scheduledReservation3 = createReservation(3, scheduledReservation);

        VehicleReservation returnedDirtyReservation = new VehicleReservation(
                createVehicle(),
                createUser(),
                LocalDateTime.of(2024,5,27,0,0,0),
                null,
                null,
                LocalDateTime.of(2024,6,1,11,0, 0),
                LocalDateTime.of(2024,6,3,15,0, 0),
                LocalDateTime.of(2024,6,4,14,0, 0),
                VehicleType.FULLY_FUNCTIONAL,
                ReservationStatus.RETURNED
        );

        VehicleReservation returnedCleanReservation = new VehicleReservation(
            createVehicle(),
            createUser(),
            LocalDateTime.of(2024,5,27,0,0,0),
            null,
            null,
            LocalDateTime.of(2024,6,1,11,0, 0),
            LocalDateTime.of(2024,6,3,15,0, 0),
            LocalDateTime.of(2024,6,3,14,0, 0),
            VehicleType.FULLY_FUNCTIONAL,
            ReservationStatus.RETURNED
    );

        VehicleReservation returnedReservation1 = createReservation(4,returnedDirtyReservation);
        VehicleReservation returnedReservation2 = createReservation(5,returnedDirtyReservation);
        VehicleReservation returnedReservation3 = createReservation(6,returnedCleanReservation);

        reservations.add(scheduledReservation1);
        reservations.add(scheduledReservation2);
        reservations.add(scheduledReservation3);
        reservations.add(returnedReservation1);
        reservations.add(returnedReservation2);
        reservations.add(returnedReservation3);
        return reservations;
    }
}
