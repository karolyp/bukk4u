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
  // TODO: api hívás
  categories = ['Sci-fi', 'Szatíra', 'Dráma', 'Akció', 'Kaland', 'Romantikus',
    'Horror', 'Egészség', 'Tudomány', 'Történelem', 'Matematika', 'Költészet',
    'Enciklopédia', 'Művészet', 'Fantasy'];


  constructor() {
    this.value = 0;
    this.maxPrice = 20000;
    this.steps = 100;
    this.categories.sort();

  }

  ngOnInit() {
  }


}
