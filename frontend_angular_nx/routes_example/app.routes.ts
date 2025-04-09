import { Route } from '@angular/router';

//Example of some of the routes

export const appRoutes: Route[] = [
    {
        path: '', 
        redirectTo: '/home', 
        pathMatch: 'full' 
    },
    {
        path: 'home',
        loadComponent: () =>
        import('@libros-monorepo/ui').then((m)=>m.HomeComponent),
    },
    {
        path: 'explore-books',
        loadComponent: () =>
        import('@libros-monorepo/ui').then((m)=>m.Search2Component)
    },
    {
        path: 'explore-books/book-sheet/:id',
        loadComponent: () =>
        import('@libros-monorepo/ui').then((m)=>m.BookSheetComponent)
    }
];
