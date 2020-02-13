import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../../model/User';
import {DataService} from '../../../data.service';
import {Router} from '@angular/router';

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
    this.router.navigate(['admin','users'], {queryParams: {action: 'edit', id : this.user.id}});
  }

  deleteUser() {
    this.dataService.deleteUser(this.user.id).subscribe(
      next => {
        this.router.navigate(['admin','users']);
      }
    );
  }

  resetPassword() {
    this.dataService.resetUserPassword(this.user.id).subscribe();
  }

}
