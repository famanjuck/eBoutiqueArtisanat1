import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Commande } from '../Models/commande';

@Injectable()
export class CommandeServices{
    host:string = "http://localhost:8080"

    constructor(private http:HttpClient){}

    getListeCommandes(){
        return this.http.get(this.host+"/Commande");    
    }

    saveCommandes(idArticle:number,commande:Commande) {
        return this.http.post(this.host+"/Commande/"+idArticle,commande);
   } 
}