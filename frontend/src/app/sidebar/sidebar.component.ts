import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  maxPrice: number;
  value: number;
  steps: number;
  categories = ["Science fiction", "Satire", "Drama", "Action", "Adventure", "Romance",
    "Horror", "Health", "Science", "History", "Math", "Poetry", "Encyclopedias", "Art", "Fantasy"];


  constructor() {
    this.value = 0;
    this.maxPrice = 20000;
    this.steps = 100;
  }

  ngOnInit() {
  }


}
