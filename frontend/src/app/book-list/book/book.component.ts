import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

 @Input() book: {isbn: number, title: string, details: string,
    category: string, author: string, price: number,
    publisher: string, onStock: boolean};

  constructor() { }

  ngOnInit() {
  }

}
