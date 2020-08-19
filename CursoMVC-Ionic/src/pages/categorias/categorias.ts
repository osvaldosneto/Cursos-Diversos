import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { CategoriaService } from '../../services/domain/categoria.service';
import { CategoriaDTO } from '../../models/categoria.dto';
import { API_CONFIG } from '../../config/api.config';

@IonicPage()
@Component({
  selector: 'page-categorias',
  templateUrl: 'categorias.html',
})
export class CategoriasPage {

  bucketUrl: string = API_CONFIG.bucketBaseUrl;
  itens: CategoriaDTO[];

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public CategoriaService: CategoriaService){
  }

  ionViewDidLoad() {
    this.CategoriaService.findAll()
      .subscribe(response =>{
        this.itens = response;
      },
      error => {
        console.log(error)
      });
  }

  showProdutos(categoria_id : string){
    //passando parâmetros para outra pagina
    this.navCtrl.push('ProdutosPage', {cat : categoria_id})
  }

}
