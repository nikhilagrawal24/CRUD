import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getUsersList(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/users`);
  }

  getUserById(id:number): Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`)
  }

  addUser(user: User): Observable<Object> {
    return this.http.post(`${this.url}/add`, user);
  }

  updateUser(id: number, user: User) {
    return this.http.put(`${this.url}/update/${id}`, user);
  }

  deleteUser(id: number) {
    return this.http.delete(`${this.url}/delete/${id}`);
  }
}
