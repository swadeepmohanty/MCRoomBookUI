import { Injectable } from '@angular/core';
import { Room, LayoutCapacity, Layout } from './model/Room';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  rooms: Array<Room>;

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
    capacity1.layout = Layout.THEATER;
    capacity1.capacity = 45;

    const capacity5 = new LayoutCapacity();
    capacity2.layout = Layout.USHAPE;
    capacity2.capacity = 15;

    room2.capacities.push(capacity4);
    room2.capacities.push(capacity5);

    this.rooms.push(room1);
    this.rooms.push(room2);
   }
}
