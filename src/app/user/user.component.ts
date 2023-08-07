import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../register-user/register-user.component';
import { UserService } from './user.service';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
    users: User[] = [];
  constructor(private  service : UserService){}
  ngOnInit(): void {
    this.getAllUsers()
    
  }  
  getAllUsers() {
    this.service.getAllUser().subscribe(
      (response: User[]) => { 
        this.users = response;
      }
    );
}


deleteUser(userId: number) {
  this.service.deleteUser(userId).subscribe(
    () => {
      console.log(`User with ID ${userId} deleted successfully.`);
    },
    (error: any) => {
      console.error('Failed to delete user:', error);
    }
  );
}

}


