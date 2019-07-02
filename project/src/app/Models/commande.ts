import { Client } from './Utilisateur';



export class Commande{
    constructor(){}
    
    numcommande:number;
    livraison: Livraison=new Livraison;
    client:Client=new Client;
    facture:Facture= new Facture();
  
    
}

export class Livraison{
    idLivraison:number;
    dateLivraison:Date;
    constructor(){}
}

export class Facture{
    constructor(){}
}

