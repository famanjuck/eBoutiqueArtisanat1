import { Artisan } from './Utilisateur';
import { SectionArt } from './SectionArt';

export class Article {
    constructor(){ }

    idArticle:number;
    designation:string="";
    libellet:string="";
    prix:number;
    photo:string="";
    quantite:number=0;
    datepulication:Date;
    
    artisan:Artisan= new Artisan();
    sectionart:SectionArt=new SectionArt();
}