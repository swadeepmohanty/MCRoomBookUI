import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/data.service';
import { Room } from 'src/app/model/Room';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {

  rooms: Array<Room>;
  selectedRoom: Room;

  constructor(private dataService: DataService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
     this.dataService.getRooms().subscribe(
       (next) => {
         this.rooms = next;
       }
     );
     this.route.queryParams.subscribe(
       (params) => {
         const id = params.id;
         if (id) {
          this.selectedRoom = this.rooms.find(room => room.id === +id);
         }
       }
     );
  }

  setRoom(id: number ) {
    this.router.navigate(['admin', 'rooms'], {queryParams : {id} });
  }
}
