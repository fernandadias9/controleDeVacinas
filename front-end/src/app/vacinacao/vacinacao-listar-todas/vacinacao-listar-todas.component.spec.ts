import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VacinacaoListarTodasComponent } from './vacinacao-listar-todas.component';

describe('VacinacaoListarTodasComponent', () => {
  let component: VacinacaoListarTodasComponent;
  let fixture: ComponentFixture<VacinacaoListarTodasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VacinacaoListarTodasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VacinacaoListarTodasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
