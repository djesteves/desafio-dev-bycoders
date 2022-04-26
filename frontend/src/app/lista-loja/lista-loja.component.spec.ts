import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaLojaComponent } from './lista-loja.component';

describe('ListaLojaComponent', () => {
  let component: ListaLojaComponent;
  let fixture: ComponentFixture<ListaLojaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaLojaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaLojaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
