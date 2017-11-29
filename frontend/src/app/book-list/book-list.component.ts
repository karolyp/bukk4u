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


  constructor(private http: Http){}

  getBooks(ctg: String){
    this.http.get(AppConstants.API + '/getbooksbygenre?genre=' + ctg + '&maxprice=50000')
      .subscribe(
        (response: Response) => {
          this.dbBooks = response.json();
          console.log(this.dbBooks);
        }
      );
  }

  // getBooks(){
  //   this.http.get(AppConstants.API + '/getbooksbygenre?genre=KALAND&maxprice=50000')
  //     .subscribe(
  //       (response: Response) => {
  //         this.dbBooks = response.json();
  //         console.log(this.dbBooks);
  //       }
  //     );
  // }


  ngOnInit() {
  }

}
