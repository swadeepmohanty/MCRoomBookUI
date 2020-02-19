package com.mcrb.MCRoomBooking.util;

import com.mcrb.MCRoomBooking.model.AngularUser;

import java.util.List;

public class AdminOprCheck {

	public static boolean deletePossible(List<AngularUser> angularUsers){

		if(angularUsers.size()>1){
			return true;
		}
		return false;
	}
}
