import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterguideComponent } from './registerguide.component';

describe('RegisterguideComponent', () => {
  let component: RegisterguideComponent;
  let fixture: ComponentFixture<RegisterguideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterguideComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterguideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
