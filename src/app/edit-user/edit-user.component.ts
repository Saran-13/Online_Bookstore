import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../register-user/register-user.component';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit, OnDestroy {
  editUserForm: FormGroup;
  userId!: number;
  private unsubscribe$ = new Subject<void>();

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.editUserForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      mobileNo: ['', Validators.required],
      streetName: ['', Validators.required],
      state:['',Validators.required],
      city: ['', Validators.required], 
      postalCode: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.params.pipe(takeUntil(this.unsubscribe$)).subscribe((params) => {
      this.userId = +params['id'];
      if (this.userId) {
        
        this.getUserById(this.userId);
        console.log(this.userId);
      }
    });
  }

  ngOnDestroy(): void {
    
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  getUserById(userId: number) {
    this.userService
      .getUserById(userId)
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe(
        (user) => {
          this.editUserForm.patchValue(user);
        },
        (error: any) => {
          console.error('Failed to get user by ID:', error);
        }
      );
  }

  onSubmit() {
    if (this.editUserForm.valid) {
      const editedUser: User = this.editUserForm.value;
      console.log(this.userId);
      console.log(editedUser);
      this.userService
        .updateUser(this.userId, editedUser)
        .pipe(takeUntil(this.unsubscribe$))
        .subscribe(
          () => {
            console.log('User updated successfully.');
            this.router.navigate(['/user']);
          },
          (error: any) => {
            console.error('Failed to update user:', error);
          }
        );
    }
  }
}
