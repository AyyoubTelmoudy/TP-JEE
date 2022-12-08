import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers:any

  constructor(private http:HttpClient) { }

   getOrders(c:any)
  {

  }


  ngOnInit(): void {
    this.http.get("http://localhost:8888/CUSTOMER-SERVICE/customers").subscribe(
      {
        next:(data)=>{
        this.customers=data;
        },
     error:(err) =>{

     },
      }
    )
  }

}
