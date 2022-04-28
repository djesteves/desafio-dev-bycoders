import { Component, OnInit } from '@angular/core';
import { CnabResponse } from 'models/cnabResponse.model';
import { CnabService } from 'services/cnab.service';

@Component({
  selector: 'app-total-lista-loja',
  templateUrl: './total-lista-loja.component.html',
  styleUrls: ['./total-lista-loja.component.css']
})
export class TotalListaLojaComponent implements OnInit {

  displayedColumns: string[] = [ 'cpf', 'dono_Loja', 'nome_Loja', 'valor'];
  public stores: CnabResponse[] = [];

  constructor(
    private cnabService: CnabService
  ) { }

  ngOnInit(): void {
    this.findTotalStore();
  }

  private findTotalStore(): void {
    this.cnabService.totalStore().subscribe(
      stores => {
        this.stores = stores
      }
    )
  }

}
