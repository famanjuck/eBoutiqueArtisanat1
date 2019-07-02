import { Component, OnInit } from '@angular/core';
import { Article } from '../Models/Article';
import { ArticleService } from '../service/ArticleService';
import { Artisan } from '../Models/Utilisateur';
import { SectionArtService } from '../service/SectionArtService';
import { ArtisantService } from '../service/ArtisanService';

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.css']
})
export class NewArticleComponent implements OnInit {

  //nouveau: any;
  artisant:Artisan=new Artisan();
  article:Article=new Article();
  section:number=0 ;
  Listesections:any;
  ListeArtisan:any;
  artisan:number;

  demandeFile: any = File;

  constructor(private articleService:ArticleService,
    private sectionArt:SectionArtService, private artisans:ArtisantService
     )
   { }

  ngOnInit() {
this.getAllSectionArt();
this.getAllArtisan();
   
  }

  saveArticle(){
    //console.log(this.section);
    //console.log(this.artisan);
    this.article.sectionart.idsection=this.section;
    //console.log(this.article.section.idSection);
   // this.article.artisan.user.idUtilisateur=this.artisan;
    this.article.artisan.idUtilisateur=this.artisan;
    //console.log(this.article);
    console.log(this.demandeFile);
    const formData = new FormData();
      formData.append('article', JSON.stringify(this.article));
      formData.append('file1', this.demandeFile);

    this.articleService.saveArticles(formData)
    .subscribe(data=>{
     // this.nouveau=data ;
    console.log(data);
      },
       err=>{
      console.log(err);
      })

    }
  
  getAllArtisan(){
    this.artisans.getListeArtisan()
    .subscribe(data=>{
      this.ListeArtisan=data;

      console.log(this.ListeArtisan);
      },
       err=>{
      console.log(err);
      })
    

  }

  getAllSectionArt(){
    this.sectionArt.getListeSection()
    .subscribe(data=>{
      this.Listesections=data;
      console.log( this.Listesections);
      },
       err=>{
      console.log(err);
      })


    }

    onSelectFile(event) {
      const file = event.target.files[0];
      this.demandeFile = file;
    }

    }
  



  


