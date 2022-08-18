import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuPainelComponent } from './menu-painel.component';

describe('MenuPainelComponent', () => {
  let component: MenuPainelComponent;
  let fixture: ComponentFixture<MenuPainelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuPainelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenuPainelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
