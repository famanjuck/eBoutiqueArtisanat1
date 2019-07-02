import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ArtisantService{
        host:string = "http://localhost:8080"
    
        constructor(private http:HttpClient){
    
        }
    
        getListeArtisan(){
            return this.http.get(this.host+"/Artisan"); 
       
        }
}