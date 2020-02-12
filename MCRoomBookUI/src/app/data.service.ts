import { Injectable } from '@angular/core';
import { Room, LayoutCapacity, Layout } from './model/Room';
import { User } from './model/User';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private rooms: Array<Room>;
  private users: Array<User>;

  getRooms(): Observable<Array<Room>> {
    return of(this.rooms);
  }

  getUsers(): Observable<Array<User>> {
    return of(this.users);
  }

  updateUser(user: User): Observable<User> {
    const originalUser = this.users.find(u => u.id === user.id);
    originalUser.name = user.name;
    return of(originalUser);
  }

  addUser(newuser: User, password: string): Observable<User> {
    let id = 0;
    for (const user of this.users) {
      if (user.id > id) {
          id = user.id;
      }
    }
    newuser.id = id + 1;
    this.users.push(newuser);
    return of(newuser);
  }

  constructor() {
    this.rooms = new Array<Room>();
    const room1 = new Room();
    room1.id = 1;
    room1.name = 'First Room';
    room1.location = 'First Floor';

    const capacity1 = new LayoutCapacity();
    capacity1.layout = Layout.THEATER;
    capacity1.capacity = 50;

    const capacity2 = new LayoutCapacity();
    capacity2.layout = Layout.USHAPE;
    capacity2.capacity = 10;

    const capacity3 = new LayoutCapacity();
    capacity3.layout = Layout.BOARD;
    capacity3.capacity = 15;

    room1.capacities.push(capacity1);
    room1.capacities.push(capacity2);
    room1.capacities.push(capacity3);

    const room2 = new Room();
    room2.id = 2;
    room2.name = 'Second Room';
    room2.location = 'Second Floor';

    const capacity4 = new LayoutCapacity();
    capacity4.layout = Layout.THEATER;
    capacity4.capacity = 45;

    const capacity5 = new LayoutCapacity();
    capacity5.layout = Layout.USHAPE;
    capacity5.capacity = 15;

    room2.capacities.push(capacity4);
    room2.capacities.push(capacity5);

    this.rooms.push(room1);
    this.rooms.push(room2);

    this.users = new Array<User>();

    const user1 = new User();
    user1.id = 1;
    user1.name = 'Swadeep';

    const user2 = new User();
    user2.id = 2;
    user2.name = 'John';

    this.users.push(user1);
    this.users.push(user2);
   }
}
