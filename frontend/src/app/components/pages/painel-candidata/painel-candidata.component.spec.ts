import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelCandidataComponent } from './painel-candidata.component';

describe('PainelCandidataComponent', () => {
  let component: PainelCandidataComponent;
  let fixture: ComponentFixture<PainelCandidataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PainelCandidataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PainelCandidataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
