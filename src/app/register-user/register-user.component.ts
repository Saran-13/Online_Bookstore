import { Component, OnInit } from '@angular/core';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit{
  newUser: User = {
    userId: 0,
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    mobileNo: '',
    streetName: '',
    city: '',
    state: '',
    postalCode: 0,
  };
  constructor(private registerService: RegisterService,private router:Router) {} 
  ngOnInit(): void {
    this.registerUser
  }

registerUser() {
  this.registerService.registerUser(this.newUser).subscribe(
    (response) => {
      console.log('User registration successful:', response);
      alert("User is registered");
      this.router.navigate([`/order`]);
    }
  )
}
}

export interface User {
  userId: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  mobileNo: string;
  streetName: string;
  city: string;
  state: string;
  postalCode: number;
}

function displaySuccessAlert() {
  throw new Error('Function not implemented.');
}
