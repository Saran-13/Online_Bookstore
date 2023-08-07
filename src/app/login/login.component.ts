import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { User } from '../register-user/register-user.component';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  loginError: boolean = false;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private authService: AuthenticationService
  ) {}

  validateForm(): boolean {
    if (this.email.trim() === '' || this.password.trim() === '') {
      this.loginError = true;
      return false;
    }
    return true;
  }

  loginUser() {
    if (!this.validateForm()) {
      return;
    }

    const credentials: User = {
      userId: 0,
      firstName: '',
      lastName: '',
      email: this.email,
      password: this.password,
      mobileNo: '',
      streetName: '',
      city: '',
      state: '',
      postalCode: 0
    };

    this.loginService.loginUser(credentials).subscribe(
      (response: any) => {
        console.log('Login successful:', response);
        if (response) {
          this.authService.login(response);

          if (
            credentials.email === 'saranpalanisamy07@gmail.com' &&
            credentials.password === 'Saran@123'
          ) {
            this.router.navigate(['/addbook']);
          } else {
            this.router.navigate(['/order']);
          }
        } else {
          this.loginError = true;
        }
      },
      (error: any) => {
        console.error('Login failed:', error);
        this.loginError = true;
      }
    );
  }
}
