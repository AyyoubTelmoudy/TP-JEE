import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders:any
  customerId!:number
  constructor(private http:HttpClient,private router:Router, private route:ActivatedRoute) {
    this.customerId=this.route.snapshot.params.customerId
  }

  getDetails(o:any){
      this.router.navigateByUrl("order-details/"+o.id)
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/BILLING-SERVICE/fullBill/search/"+this.customerId).subscribe(
      {
        next:(data)=>{
          console.log(data)
        this.orders=data;
        },
     error:(err) =>{

     },
      }
    )
  }

}
