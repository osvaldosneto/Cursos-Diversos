import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ProdutoDTO } from '../../models/produto.dto';
import { ProdutoService } from '../../services/domain/produto.service';
import { API_CONFIG } from '../../config/api.config';

@IonicPage()
@Component({
  selector: 'page-produtos',
  templateUrl: 'produtos.html',
})
export class ProdutosPage {

  itens : ProdutoDTO[]

  constructor(public navCtrl: NavController, 
    public navParams: NavParams,
    public produtoService: ProdutoService) {
  }

  ionViewDidLoad() {
    //pegando objeto enviado de cagegorias
    let categoria_id = this.navParams.get('cat')

    //tratando itens paginados
    this.produtoService.findByCategoria(categoria_id)
      .subscribe(response =>{
        this.itens = response['content'] //recebendo itens paginados
        this.loadImageUrls();
      },
      error => {

      });
  }

  loadImageUrls() {
    for (var i=0; i<this.itens.length; i++) {
      let item = this.itens[i];
      this.produtoService.getSmallImageFromBucket(item.id)
        .subscribe(response => {
          item.imageUrl = `${API_CONFIG.bucketBaseUrl}/prod${item.id}-small.jpg`;
        },
        error => {});
    }
  }

  showDetail(produto_id : string){
    this.navCtrl.push("ProdutoDetailPage", {produto_id: produto_id})
  }

}
