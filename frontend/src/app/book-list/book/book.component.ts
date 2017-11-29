import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

 @Input() book: {isbn: number, title: string, description: string,
    category: string, authors: string[], price: number,
    publisher: string, inStock: number, thumbnail: string, releaseDate: string};

  constructor() { }

  ngOnInit() {
  }

}
