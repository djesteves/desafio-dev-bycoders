import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'environments/environment';
import { User } from './interfaces/user.interface';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  private url = '/oauth/token';
  sidenav_opened = true;

  constructor(
    private authService: AuthService, 
    private router: Router, 
    private formBuilder: FormBuilder,
    private http: HttpClient
  ) { }

  authForm: FormGroup;
  isSubmitted = false;

  ngOnInit(): void {
    this.authForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  signIn() {
    this.isSubmitted = true;
    if(this.authForm.invalid){
      return;
    }

    this.http.post(environment.apiURL + this.url, body)
      .subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('/upload');
      })
}
