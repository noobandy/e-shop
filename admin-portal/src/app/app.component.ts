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
    this.httpClient.get('/account-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })

    this.httpClient.get('/order-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })


    this.httpClient.get('/inventory-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })

    this.httpClient.get('/cart-api/', {responseType: "text"}).subscribe(data => {
      this.messages.push(`Success: ${data}`)
    }, err => {
      console.log(err)
      this.messages.push(`Error: ${err}`)
    })
  }
}
