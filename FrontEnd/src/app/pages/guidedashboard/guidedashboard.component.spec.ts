import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuidedashboardComponent } from './guidedashboard.component';

describe('GuidedashboardComponent', () => {
  let component: GuidedashboardComponent;
  let fixture: ComponentFixture<GuidedashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GuidedashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuidedashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
