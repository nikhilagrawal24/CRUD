import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
})
export class AddUserComponent {
  user: User = new User();

  constructor(private service: UserService, private router: Router) {}

  saveUser() {
    this.service.addUser(this.user).subscribe(data => {
      this.router.navigate(['/users']);
    });
  }


  submitData() {
    this.saveUser();
  }
}
