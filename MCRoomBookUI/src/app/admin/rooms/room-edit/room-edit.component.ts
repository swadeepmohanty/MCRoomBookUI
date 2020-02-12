import { Component, OnInit, Input } from '@angular/core';
import { Room } from 'src/app/model/Room';

@Component({
  selector: 'app-room-edit',
  templateUrl: './room-edit.component.html',
  styleUrls: ['./room-edit.component.css']
})
export class RoomEditComponent implements OnInit {

  @Input()
  room: Room;

  constructor() { }

  ngOnInit() {
  }

}
