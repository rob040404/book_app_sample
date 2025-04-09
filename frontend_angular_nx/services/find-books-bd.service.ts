import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '@libros-monorepo/classes';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FindBooksBdService {

  private searchURL = "http://localhost:9000/book/search";

  constructor(private http: HttpClient) {
    
  }

 
  public searchBookDB(title?: string, authors?: string) : Observable <Book[]>{


     const bookDTO ={
      title: title,
      authors: authors,
    };

    return this.http.post<Book[]>(this.searchURL, bookDTO).pipe(
      map((data: any[]) =>
        data.map(
          (item) =>
            new Book(
              item.id,
              item.title,
              item.authors,
              item.description,
              item.genders,
              item.lang,
              item.image,
              item.rating,
              item.numVotes
            )
        )
      )
    );
  }

  public findById(id: number) : Observable <Book>{
    
    const bookDTO = {
      id: id
    }

    return this.http.post<Book>(this.searchURL, bookDTO).pipe(
      map((data:any) => new Book(
              data.id,
              data.title,
              data.authors,
              data.description,
              data.genders,
              data.lang,
              data.image,
              data.rating,
              data.numVotes
      )
        
    )
    )
  }
}
