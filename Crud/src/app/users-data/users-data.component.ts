import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-users-data',
  templateUrl: './users-data.component.html',
  styleUrls: ['./users-data.component.css']
})
export class UsersDataComponent {

  users: User[] = [];

  constructor(private service:UserService, private router:Router){ }

  ngOnInit(): void{
    this.getUsers();
  }

  getUsers(){
    this.service.getUsersList().subscribe(data =>{
      this.users = data;
    })
  }

  updateUser(id:number){
    this.router.navigate(['update',id]);
  }
  deleteUser(id:number){
    this.service.deleteUser(id).subscribe(data =>{
      this.getUsers();
    })
  }



}
