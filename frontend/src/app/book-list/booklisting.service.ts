import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Book} from "../_model/book";
import {AppConstants} from "../app.constants";


@Injectable()
export class BooklistingService {
  constructor(private http: Http){}


  getBooks(){
    this.http.get(AppConstants.API + '/getbooksbygenre')
      .subscribe(
        (response: Response) => {
          const books: Book[] = response.json();
          console.log(books);
        }
      );


  }

}
