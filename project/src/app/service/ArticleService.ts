import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Article } from '../Models/Article';
import { Observable } from 'rxjs';

@Injectable()
export class ArticleService{
    host:string = "http://localhost:8080"

    constructor(private http:HttpClient){

    }

    getListeArticles(){
        return this.http.get(this.host+"/Article"); 
   
    }


    getOneArticles(id:number){
        return this.http.get(this.host+"/Article/"+id); 
   
    }

    saveArticles(formData: FormData): Observable<any> {
        return this.http.post(this.host+"/Article",formData);
   }

   deleteArticles(id:number){
    return this.http.delete(this.host+"/Article/"+id)
    }

    updateArticles(article:Article){
        return this.http.put(this.host+"/Article",article);
}
chercherArticles(libellet:string){
    return this.http.get(this.host+"/chercherArticle?mc="+libellet);
}

}