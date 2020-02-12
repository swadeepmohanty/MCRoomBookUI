import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/model/User';
import { DataService } from 'src/app/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  @Input()
  user: User;

  constructor(private dataService: DataService,
              private router: Router) { }

  ngOnInit() {
  }

  editUser() {
    this.router.navigate(['admin', 'users'], {queryParams: {action: 'edit', id: this.user.id}});
  }
}
