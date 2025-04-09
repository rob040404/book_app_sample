import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Book } from '@libros-monorepo/classes';
import { FindBooksBdService} from '@libros-monorepo/services';
//import { ResultsComponent } from './results/results.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Results2Component } from "./results2/results2.component";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'lib-search2',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    Results2Component
],
  templateUrl: './search2.component.html',
  styleUrl: '../common-css-pages/forms.css',
})
export class Search2Component implements OnInit{

  books: Book[]=[];
  titleQuery = '';
  authorsQuery = '';


  titleInput = new FormControl('');  //We initialize its initial value 
  authorInput= new FormControl('');
  
  constructor(private findBooksService: FindBooksBdService, private route: ActivatedRoute){

  }

  ngOnInit(): void {
  this.route.queryParams.subscribe(params => {
    // Comprobar si los parámetros existen y tienen valor
    if (params['title'] && params['authors']) {
      this.titleQuery = params['title'];
      this.authorsQuery = params['authors'];
      this.searchBooks();
    } 
    else if(params['title']) {
      this.titleQuery = params['title'];
      this.searchBooks();
    }
    else if(params['authors']){
      this.authorsQuery =params['authors'];
      this.searchBooks();
    }
  });

  
}

  public onSubmit(){
    this.titleQuery=String(this.titleInput.value);
    this.authorsQuery=String(this.authorInput.value);

    this.searchBooks();
   
  }

  public searchBooks(){

    this.findBooksService.searchBookDB(this.titleQuery, this.authorsQuery).subscribe({
      next: (data) => {
        this.books = data;
        console.log('Books:', this.books);
      },
      error: (err) => {
        console.error('Error:', err);
      }
    }
    );
  }

}
