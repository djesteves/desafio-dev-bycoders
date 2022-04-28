import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalListaLojaComponent } from './total-lista-loja.component';

describe('TotalListaLojaComponent', () => {
  let component: TotalListaLojaComponent;
  let fixture: ComponentFixture<TotalListaLojaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TotalListaLojaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalListaLojaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
