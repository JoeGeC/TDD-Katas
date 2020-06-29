package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	private ArrayList<Trip> noTrips  = new ArrayList<>();

	List<Trip> getTripsByUser(User otherUser) throws UserNotLoggedInException {
		validateUser(getLoggedUser());

		if (otherUser.isFriendWith(getLoggedUser())) {
            return getTrips(otherUser);
        }
		return noTrips;
    }

	private void validateUser(User loggedUser) {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
	}

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }

	protected List<Trip> getTrips(User user) {
        return TripDAO.findTripsByUser(user);
    }
}
