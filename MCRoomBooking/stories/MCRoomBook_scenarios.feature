Feature: MC Room Booking Portal
  As Admin member I can operate admin membership and Room registration

  Scenario: User added as Admin in the portal
	Given Admin browse to http://localhost:4200/admin/users?action=add
	When username is Smith
	When password is test123
	When re confirm password is test123
	Then user added as admin successfully
	
	
  Scenario: Admin can only able to add Meeting rooms
	Given Admin browse to http://localhost:4200/admin/rooms?action=add
	When Name is GreenRoom
	When location is 6th floor
	When Theater size is 40
	When U-Shape size is 20
	When BoardMeeting size is 12
	Then Room added succussfully