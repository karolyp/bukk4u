import { Component, OnInit } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Book} from "../_model/book";
import {AppConstants} from "../app.constants";

@Component({
  selector: 'book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  dbBooks: Book[];
  maxPrice: number;
  value: number;
  steps: number;

  constructor(private http: Http){
    this.value = 0;
    this.maxPrice = 30000;
    this.steps = 100;
  }

  getBooks(ctg: String){
    this.http.get(AppConstants.API + '/getbooksbygenre?genre=' + ctg + '&maxprice=50000')
      .subscribe(
        (response: Response) => {
          this.dbBooks = response.json();
          console.log(this.dbBooks);
        }
      );
  }

  getBooks2(ctg: String, pric: number){
    this.http.get(AppConstants.API + '/getbooksbygenre?genre=' + ctg + '&maxprice=' + pric)
      .subscribe(
        (response: Response) => {
          this.dbBooks = response.json();
          console.log(this.dbBooks);
        }
      );
  }

  ngOnInit() {
    this.getBooks2('SCIFI', 5000);
  }

}
