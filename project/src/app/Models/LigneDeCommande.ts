import { Article } from './Article';
import { Commande } from './commande';


export class LigneDeCommande{
    constructor(){}

      idlignedecommande:number;
      datecommander:Date;
      quantitecommander: number=0;

      commande:Commande=new Commande();
      article: Article= new Article();

    

}