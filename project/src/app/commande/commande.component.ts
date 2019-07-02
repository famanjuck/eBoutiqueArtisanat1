import { Component, OnInit } from '@angular/core';

import { CommandeServices } from '../service/CommandeService';
import { Commande } from '../Models/commande';


@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {
  ListeCommandes:any;
  commande:Commande=new Commande();

  constructor(private commadeServices:CommandeServices) { }

  ngOnInit() {
    this.getCommande();
  }

  OnSaveCommande(){
    
  }

  getCommande(){
    this.commadeServices.getListeCommandes()
    .subscribe(data=>{
      console.log(data);
      this.ListeCommandes=data;
      },
       err=>{
      console.log(err);
      })
    }

}
