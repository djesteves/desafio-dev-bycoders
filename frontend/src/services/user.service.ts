import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { User } from 'models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(environment.apiURL);
  }

  register(user: User) {
    return this.http.post(environment.apiURL, user);
  }

  delete(id: number) {
    return this.http.delete(environment.apiURL);
  }
}
