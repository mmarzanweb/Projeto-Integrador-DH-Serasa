import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpresaCarrosselComponent } from './empresa-carrossel.component';

describe('EmpresaCarrosselComponent', () => {
  let component: EmpresaCarrosselComponent;
  let fixture: ComponentFixture<EmpresaCarrosselComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpresaCarrosselComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpresaCarrosselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
