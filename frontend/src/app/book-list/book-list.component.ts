import { Component, OnInit } from '@angular/core';
import { Book } from "../_model/book";

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
      true)
  ];
  constructor() { }

  ngOnInit() {
  }

}