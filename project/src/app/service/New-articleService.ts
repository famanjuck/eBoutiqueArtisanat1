/* import { Article } from '../Models/Article';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class NewArticleService{
    host:string = "http://localhost:8080"

    constructor(private http:HttpClient){

    }

    
    saveArticles(article:Article){
        return this.http.post("this.host+",article);
   
    }

} */