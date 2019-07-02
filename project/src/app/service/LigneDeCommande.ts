import { HttpClient } from '@angular/common/http';

export class LigneDeCommande{
    host:string = "http://localhost:8080"

    constructor(private http:HttpClient){

    }
}