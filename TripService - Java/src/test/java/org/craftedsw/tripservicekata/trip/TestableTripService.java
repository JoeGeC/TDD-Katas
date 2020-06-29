package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.ArrayList;
import java.util.List;

public class TestableTripService extends TripService {

    private User user;

    @Override
    protected User getLoggedUser() {
        return user;
    }

    @Override
    protected List<Trip> getTrips(User user) {
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip());
        return trips;
    }

    void setLoggedUser(User user) {
        this.user = user;
    }
}
