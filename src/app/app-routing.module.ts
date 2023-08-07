import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book/book.component';
import { LoginComponent } from './login/login.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { HomeComponent } from './home/home.component';
import { BookViewComponent } from './book-view/book-view.component';
import { editBookComponent } from './edit-book/edit-book.component';
import { UserComponent } from './user/user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { OrderComponent } from './order/order.component';
import { ViewOrderComponent } from './view-order/view-order.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { ListpaymentComponent } from './listpayment/listpayment.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentdetailsComponent } from './paymentdetails/paymentdetails.component';



const routes :Routes =[
  {path :'',component:HomeComponent},
  {path :'login',component:LoginComponent},
  {path : 'addbook',component:BookComponent},
  {path : 'home',component:HomeComponent},
  {path : 'logout',component:HomeComponent},
  {path : 'signup',component:RegisterUserComponent},
  {path :`viewBook`,component: BookViewComponent},
  {path : `edit-book`,component:editBookComponent},
  { path: 'edit-book/:id', component: editBookComponent },
  {path : `user`,component:UserComponent},
  { path: 'edit-user/:id', component: EditUserComponent },
  {path : 'order',component:OrderComponent},
  {path : 'vieworder',component:ViewOrderComponent},
  {path : 'edit-order',component:EditOrderComponent},
  { path: 'editorder/:id', component: EditOrderComponent },
  { path: 'listpayment', component: ListpaymentComponent },
  { path: 'payment/:orderId', component: PaymentComponent } ,
  {path : 'paymentdetails',component:PaymentdetailsComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
