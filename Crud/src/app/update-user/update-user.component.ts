import { Component,OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css'],
})
export class UpdateUserComponent {
  id!: number;
  user: User = new User();

  constructor(
    private service: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.service.getUserById(this.id).subscribe((data) => {
    this.user = data;
    });
  }

  submitData() {
    this.service.updateUser(this.id, this.user).subscribe((data) => {
      this.router.navigate([`/users`]);
    });
  }
}
