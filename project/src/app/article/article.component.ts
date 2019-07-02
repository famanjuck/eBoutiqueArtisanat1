import { Component, OnInit } from '@angular/core';
import { Article } from '../Models/Article';
import { ArticleService } from '../service/ArticleService';
import { Artisan } from '../Models/Utilisateur';
import { SectionArt } from '../Models/SectionArt';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  ListeArticles: any;
  editer: number=1;
  photo:File;
  article:Article=new Article();
  artisant:Artisan=new Artisan();
  sectionart:SectionArt=new SectionArt();
  idUser:number;
  Idsection:number;
  
  motcle:string="";
/*   page:number=0;
  size:number=4; */
  
  demandeFile: any = File;

  idArticle:number;

  constructor(private articleService:ArticleService, private router:Router, 
    private activeroute:ActivatedRoute) {
      this.idArticle=activeroute.snapshot.params['idArticle'];
      
     }

  ngOnInit() {
  //  this.getArticles();
  this.doSearch();
  }

  OnSaveArticle(){

  }
  onEditArticle(arti:Article){
    
    this.article=arti;
    this.editer=2;
  }

  DeleteArticle(id:number){
    this.articleService.deleteArticles(id)
    .subscribe(data=>{
    console.log(data);
    this.getArticles();
      },
       err=>{
      console.log(err);
      })

    }

   getArticles(){
/*   this.articleService.getListeArticles()
  .subscribe(data=>{
    console.log(data);
    this.ListeArticles=data;
    },
     err=>{
    console.log(err);
    }) */ 
    
  } 


  doSearch(){
    console.log(this.motcle);
    this.articleService.chercherArticles(this.motcle)
    .subscribe(data=>{
      console.log(data);
      this.ListeArticles=data;
      },
       err=>{
      console.log(err);
      })
    }

    



   UpdateArticle(){
    console.log(this.article);
    this.articleService.updateArticles(this.article)
    .subscribe(data=>{
    console.log(data);
    alert("Mise a jour réussi");
    this.router.navigate(['Listearticle'])
    },
    err=>{
    console.log(err);
    alert("problem");
    })
              
    }

    onSelectFile(event) {
      const file = event.target.files[0];
      this.demandeFile = file;
    }
  
}
