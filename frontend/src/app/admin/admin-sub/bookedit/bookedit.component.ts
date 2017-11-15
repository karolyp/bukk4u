import { Component, OnInit } from '@angular/core';
import { Book } from "../../../_model/book";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bookedit',
  templateUrl: './bookedit.component.html',
  styleUrls: ['./bookedit.component.css']
})
export class BookeditComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  isbn: any;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.isbn = params['isbn']; // --> Name must match wanted parameter
    });
  }

}
