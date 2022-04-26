import { Component, OnInit } from '@angular/core';
import { Cnab } from 'models/cnab.model';
import { CnabService } from 'services/cnab.service';

@Component({
  selector: 'app-lista-loja',
  templateUrl: './lista-loja.component.html',
  styleUrls: ['./lista-loja.component.css']
})
export class ListaLojaComponent implements OnInit {

  displayedColumns: string[] = ['id', 'tipo', 'data', 'valor', 'cpf', 'cartao', 'hora', 'donoLoja', 'nomeLoja'];
  public stores: Cnab[] = [];

  constructor(
    private cnabService: CnabService
  ) { }

  ngOnInit(): void {
    this.findAllStore();
  }

  private findAllStore(): void {
    this.cnabService.findAllStore().subscribe(
      stores => {
        this.stores = stores
      }
    )
  }

}
