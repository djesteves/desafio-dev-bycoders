import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UploadComponent } from './upload/upload.component';
import { ListaLojaComponent } from './lista-loja/lista-loja.component';

const routes: Routes = [
  { path: 'upload', component: UploadComponent },
  { path: 'lista-loja', component: ListaLojaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
