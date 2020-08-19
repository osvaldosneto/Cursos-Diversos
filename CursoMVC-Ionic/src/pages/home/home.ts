import { Component } from '@angular/core';
import { NavController, IonicPage, MenuController } from 'ionic-angular';
import { CredenciaisDTO } from '../../models/Credenciais.dto';
import { AuthService } from '../../services/auth.service';

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  creds : CredenciaisDTO = {
    email : "",
    senha : ""
  };

  constructor(
    public navCtrl: NavController,
    public menu : MenuController,
    public auth : AuthService) {
  }

  //criando método login
  login(){
    this.auth.authenticate(this.creds)
      .subscribe(response => {
        this.auth.successfulLogin(response.headers.get('Authorization'))
        this.navCtrl.setRoot('CategoriasPage')
      },
      error => {});
  }

  ionViewDidEnter(){
    this.auth.refreshToken()
      .subscribe(response => {
        this.auth.successfulLogin(response.headers.get('Authorization'))
        this.navCtrl.setRoot('CategoriasPage')
      },
      error => {});
  }

  signup(){
    this.navCtrl.push('SignupPage')
  }

}
