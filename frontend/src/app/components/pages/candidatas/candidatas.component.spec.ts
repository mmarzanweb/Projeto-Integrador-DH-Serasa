import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CandidatasComponent } from './candidatas.component';

describe('CandidatasComponent', () => {
  let component: CandidatasComponent;
  let fixture: ComponentFixture<CandidatasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidatasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
