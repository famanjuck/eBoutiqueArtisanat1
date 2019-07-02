import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RouterModule, Routes} from '@angular/router';
import { CategoriesComponent } from './categories/categories.component';
import { HommeComponent } from './homme/homme.component';
import { FemmeComponent } from './femme/femme.component';
import { HttpClientModule } from '@angular/common/http';
import { CommandeServices } from './service/CommandeService';
import { ArticleService } from './service/ArticleService';
import { UtilisateurServiices } from './service/UtilisateurService';
import { NewArticleComponent } from './new-article/new-article.component';
import { ArticleComponent } from './article/article.component';
import { SectionArtService } from './service/SectionArtService';
import { SectionArtComponent } from './section-art/section-art.component';
import { ArtisantService } from './service/ArtisanService';
import { CommandeComponent } from './commande/commande.component';
import { DetailleComponent } from './detaille/detaille.component';
import { LigneDeCommandeComponent } from './ligne-de-commande/ligne-de-commande.component';
import { ValiderPubComponent } from './valider-pub/valider-pub.component';


const appRoutes: Routes = [
  { path:'categories', component:CategoriesComponent},
  { path:'article', component:FemmeComponent},
  { path:'article1', component:HommeComponent},
  { path:'article2', component:CategoriesComponent},
  {path:'ajouter',component:NewArticleComponent},
  {path:'ajout',component:NewArticleComponent},
  {path:'Listearticle',component:ArticleComponent},
  {path:'Listecommande',component:CommandeComponent},
  {path:'commande',component:CommandeComponent},
  {path:'detailleArticle/:id',component:DetailleComponent},
  {path:'',redirectTo: '/categories',pathMatch: 'full' }
  ];
  


@NgModule({
  declarations: [
    AppComponent,
    HommeComponent,
    FemmeComponent,
    CategoriesComponent,
    NewArticleComponent,
    ArticleComponent,
    SectionArtComponent,
    CommandeComponent,
    DetailleComponent,
    LigneDeCommandeComponent,
    ValiderPubComponent
   
    
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule
    
  ],
  providers: [
    CommandeServices,
    ArticleService,
    UtilisateurServiices,
    SectionArtService,
    ArtisantService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
