package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripServiceShould {

    private User JOE;
    private TestableTripService tripService;

    @BeforeEach
    void setUp() {
        JOE = new User();
        tripService = new TestableTripService();
    }

    @Test
    void throwUserNotLoggedInException_GivenUserIsNotLoggedIn() {
        assertThrows(UserNotLoggedInException.class, () -> {
            tripService.getTripsByUser(JOE);
        });
    }

    @Test
    void returnAnEmptyListOfTrips_IfNoUsers() {
        tripService.setLoggedUser(JOE);
        assertTrue(tripService.getTripsByUser(JOE).isEmpty());
    }

    @Test
    void returnListOfTrips_IfHasFriends() {
        User KHOOVI = new User();
        JOE.addFriend(KHOOVI);
        tripService.setLoggedUser(KHOOVI);
        assertFalse(tripService.getTripsByUser(JOE).isEmpty());
    }

    @Test
    void returnEmptyListOfTrips_IfNoFriends() {
        User LEE = new User();
        JOE.addFriend(LEE);
        tripService.setLoggedUser(JOE);
        assertTrue(tripService.getTripsByUser(JOE).isEmpty());
    }
}
