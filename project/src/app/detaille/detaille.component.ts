import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../service/ArticleService';
import { Article } from '../Models/Article';
import { ActivatedRoute, Router } from '@angular/router';
import { CommandeServices } from '../service/CommandeService';
import { Commande } from '../Models/commande';
import { Client, Utilisateur } from '../Models/Utilisateur';

@Component({
  selector: 'app-detaille',
  templateUrl: './detaille.component.html',
  styleUrls: ['./detaille.component.css']
})
export class DetailleComponent implements OnInit {
  art:any
  id:number;
  commande:Commande=new Commande;

  constructor(private articleService: ArticleService , private activeRout: ActivatedRoute, 
               private commandeService: CommandeServices,private route:Router) { }

  ngOnInit() {
    this.getArticle() ;
  }
getArticle(){
  this.id=this.activeRout.snapshot.params['id']
  console.log(this.id);
  
  this.articleService.getOneArticles(this.id)
  .subscribe(data=>{
    console.log(data);
  this.art = data ;
      },
       err=>{
      console.log(err);
      })
}

saveCommande(){
 const utilisateur=new Utilisateur();
 utilisateur.idUtilisateur=4;
  this.commande.numcommande = 1 ;
  this.commande.livraison.idLivraison = 1;
  const  clent =new Client();
  clent.utilisateur=utilisateur;
  this.commande.client=clent;
this.commandeService.saveCommandes(this.art.idArticle,this.commande)
.subscribe(data=>{
  console.log(data);
 // alert("Commande réussir");
this.art = data ;
    },
     err=>{
    console.log(err);
   // alert("problem");
    })
}
 onsave(){
  console.log("dfdfdf");
  this.route.navigate(['detailleArticle']) ;
} 

}
