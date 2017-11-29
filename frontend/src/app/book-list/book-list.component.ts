import { Component, OnInit } from '@angular/core';
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Book} from "../_model/book";
import {AppConstants} from "../app.constants";

@Component({
  selector: 'book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  books: Book[] = [
    new Book(9781543138849,
      'Introduction to 64 Bit Windows Assembly Language Programming: Fourth Edition',
      'This book introduces programmers to 64 bit Intel assembly language using the Microsoft Windows operating system. The book also discusses how to use the free integrated development environment, ebe, designed by the author specifically to meet the needs of assembly language programmers. Ebe is a C++ program which uses the Qt library to implement a GUI environment consisting of a source window, a data window, a register window, a floating point register window, a backtrace window, a console window, a terminal window, a project window and a pair of teaching tools called the "Toy Box" and the "Bit Bucket".',
      'Education',
      'Ray Seyfarth',
      6402,
      'CreateSpace Independent Publishing Platform',
      true),
    new Book(9781543138849,
      'Introduction to 64 Bit Windows Assembly Language Programming: Fourth Edition',
      'This book introduces programmers to 64 bit Intel assembly language using the Microsoft Windows operating system. The book also discusses how to use the free integrated development environment, ebe, designed by the author specifically to meet the needs of assembly language programmers. Ebe is a C++ program which uses the Qt library to implement a GUI environment consisting of a source window, a data window, a register window, a floating point register window, a backtrace window, a console window, a terminal window, a project window and a pair of teaching tools called the "Toy Box" and the "Bit Bucket".',
      'Education',
      'Ray Seyfarth',
      6402,
      'CreateSpace Independent Publishing Platform',
      true),
    new Book(9781543138849,
      'Introduction to 64 Bit Windows Assembly Language Programming: Fourth Edition',
      'This book introduces programmers to 64 bit Intel assembly language using the Microsoft Windows operating system. The book also discusses how to use the free integrated development environment, ebe, designed by the author specifically to meet the needs of assembly language programmers. Ebe is a C++ program which uses the Qt library to implement a GUI environment consisting of a source window, a data window, a register window, a floating point register window, a backtrace window, a console window, a terminal window, a project window and a pair of teaching tools called the "Toy Box" and the "Bit Bucket".',
      'Education',
      'Ray Seyfarth',
      6402,
      'CreateSpace Independent Publishing Platform',
      true)

  ];


  constructor(private http: Http){}

  getBooks(){
    this.http.get(AppConstants.API + '/getbooksbygenre?genre=KALAND&maxprice=50000')
      .subscribe(
        (response: Response) => {
          const books: Book[] = response.json();
          console.log(books);
        }
      );

  }

  ngOnInit() {
  }

}
