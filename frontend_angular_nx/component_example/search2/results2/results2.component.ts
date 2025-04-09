import { Component, ElementRef, Input, Renderer2, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Book } from '@libros-monorepo/classes';
import { TruncatePipe } from '@libros-monorepo/pipes';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'lib-results2',
  standalone: true,
  imports: [CommonModule, TruncatePipe, RouterModule, MatIconModule, MatButtonModule],
  templateUrl: './results2.component.html',
  styleUrl: './results2.component.css',
})
export class Results2Component {

  //la lista de libros creo que se ha pasado del componente padre
  @Input() books_info: Book[]=[];
  maxWords=40;
  truncateWords=true;
  idDescription='';
  descriptionWords=0;

  //We change the values of the book.showFullDescription from true to false and viceversa
  public descriptionLength(book:Book){
    book.showFullDescription=!book.showFullDescription;
  }

  public descriptionWordsNumber(book: Book){
    const words = book.description.split(' ');
    return words.length;
  }
}
