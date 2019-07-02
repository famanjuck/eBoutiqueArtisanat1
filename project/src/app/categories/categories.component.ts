import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../service/ArticleService';
import { Article } from '../Models/Article';
import { Router } from '@angular/router';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  ListeArticles: any;

  
  constructor(private articleService:ArticleService, private route:Router) { }

  
  ngOnInit() {
    this.getArticles();
  }

  getArticles(){
    this.articleService.getListeArticles()
    .subscribe(data=>{
      console.log(data);
      this.ListeArticles=data;
      },
       err=>{
      console.log(err);
      })
    }
    
   OndetailleArticle(idArticle:number){
    console.log("dfdfdf");
    
    this.route.navigate(['detailleArticle',idArticle]) ;
  }
 

}
