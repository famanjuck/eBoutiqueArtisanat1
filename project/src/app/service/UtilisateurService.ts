import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UtilisateurServiices{
    host:string = "http://localhost:8080"

    constructor(private http:HttpClient){}

    getListeArticles(){
        return this.http.get(this.host+"/Utilisateur");    
    }
}