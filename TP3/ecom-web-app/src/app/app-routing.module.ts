import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers/customers.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  {path:"products",component:ProductComponent},
  {path:"customers",component:CustomersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
