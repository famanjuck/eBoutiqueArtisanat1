export class Utilisateur {
    constructor(){}

    idUtilisateur:number;
    nom:string="";
    prenom:string="";
    cni:string="";
    adress:string="";
    numtel:number;
    profile:string="";
    login:string="";
    password:string="";


}

export class Artisan{
    constructor(){}
    //artisan:string="";
    idUtilisateur:number;
    utilisateur:Utilisateur= new Utilisateur();
    
    
}


export class Superviseur{
    constructor(){}
    superviseur:string="";
    user:Utilisateur= new Utilisateur();
    
}


export class Client{
    constructor(){}
    Client:string="";
    utilisateur:Utilisateur= new Utilisateur();
}

export class Administrateur{
    constructor(){}
        Administrateur:string="";
        user:Utilisateur= new Utilisateur();  
    
}
