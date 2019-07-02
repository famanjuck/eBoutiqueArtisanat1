import { VillageArtisanal } from './VillageArtisanal';
import { Superviseur } from './Utilisateur';

export class ChambreMetier{

    constructor(){}
    idChambremetier:number;
    nomChambremetier: string="";
    commune:string="";


    villageartisanal:VillageArtisanal= new VillageArtisanal();
    superviseur:Superviseur=new Superviseur();

}