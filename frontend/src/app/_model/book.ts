export class Book{
  public isbn: number;
  public title: string;
  public description: string;
  public category: string;
  public authors: string[];
  public price: number;
  public publisher: string;
  public inStock: number;
  public thumbnail: string;
  public releaseDate: string;

  //
  // @Input() book: {isbn: string, title: string, description: string,
  //   category: string, authors: string[], price: number,
  //   publisher: string, inStock: number, thumbnail: string};


  constructor(isbn: number, title: string, description: string,
              category: string, author: string[], price: number,
              publisher: string, inStock: number, thumbnail: string,
              releaseDate: string) {
    this.isbn = isbn;
    this.title = title;
    this.description = description;
    this.category = category;
    this.authors = author;
    this.price = price;
    this.publisher = publisher;
    this.inStock = inStock;
    this.thumbnail = thumbnail;
    this.releaseDate = releaseDate;
  }
}


