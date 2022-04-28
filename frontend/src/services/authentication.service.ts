import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from 'models/user.model';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url = '/oauth/token';
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  private headers = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('Authorization', 'Basic Y2xpZW50OnNlY3JldA==');

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(username, password) {
    let userRequest = {
      "grant_type": "password",
      "username": username,
      "password": password
    }
    let body = `grant_type=${userRequest.grant_type}&username=${userRequest.username}&password=${userRequest.password}`;
    return this.http.post<any>(environment.apiURL + this.url, body, { headers: this.headers })
      .pipe(map(obj => {
        let user = new User;
        user.username = userRequest.username;
        user.password = userRequest.password;
        user.token = obj.access_token;
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        return user;
      }));
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
