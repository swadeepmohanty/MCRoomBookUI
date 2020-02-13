import {Layout, Room} from './Room';
import {User} from './User';

export class Booking {
  id: number;
  room: Room;
  user: User;
  layout: Layout;
  title: string;
  date: string;
  startTime: string;
  endTime: string;
  participants: number;

  getDateAsDate() {
    return new Date(this.date);
  }
}
