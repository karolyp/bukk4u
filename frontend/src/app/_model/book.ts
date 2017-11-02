export class Book{
  public isbn: number;
  public title: string;
  public details: string;
  public category: string;
  public author: string;
  public price: number;
  public publisher: string;
  public onStock: boolean;


  constructor(isbn: number, title: string, details: string,
              category: string, author: string, price: number,
              publisher: string, onStock: boolean) {
    this.isbn = isbn;
    this.title = title;
    this.details = details;
    this.category = category;
    this.author = author;
    this.price = price;
    this.publisher = publisher;
    this.onStock = onStock;
  }
}


