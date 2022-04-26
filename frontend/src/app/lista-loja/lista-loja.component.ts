import { Component, OnInit } from '@angular/core';
import { Cnab } from 'app/models/cnab.model';
import { CnabService } from 'app/services/cnab.service';

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
    console.log('TESTES: ', this.stores);
  }

  private findAllStore(): void {
    this.cnabService.findAllStore().subscribe(
      stores => {
        this.stores = stores
      }
    )
  }

}
