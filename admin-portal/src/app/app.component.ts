import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'admin-portal';

  messages:string[] = []

  public constructor(private httpClient:HttpClient) {}

  ngOnInit(): void {
    this.httpClient.get('/api/account-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })

    this.httpClient.get('/api/order-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })


    this.httpClient.get('/api/inventory-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })

    this.httpClient.get('/api/cart-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })
  }
}
