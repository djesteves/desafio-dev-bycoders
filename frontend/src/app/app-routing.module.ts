import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UploadComponent } from './upload/upload.component';
import { ListaLojaComponent } from './lista-loja/lista-loja.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from 'helpers/auth.guard';
import { TotalListaLojaComponent } from './total-lista-loja/total-lista-loja.component';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'upload', component: UploadComponent },
  { path: 'lista-loja', component: ListaLojaComponent },
  { path: 'total-lista-loja', component: TotalListaLojaComponent },


  { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
