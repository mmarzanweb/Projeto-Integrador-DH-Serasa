import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardEmpresaCarrosselComponent } from './card-empresa-carrossel.component';

describe('CardEmpresaCarrosselComponent', () => {
  let component: CardEmpresaCarrosselComponent;
  let fixture: ComponentFixture<CardEmpresaCarrosselComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardEmpresaCarrosselComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardEmpresaCarrosselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
