
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SectionArtService{
    host:string = "http://localhost:8080"

    constructor(private http:HttpClient){

    }

    getListeSection(){
        return this.http.get(this.host+"/Sectionart"); 
   
    }

}


