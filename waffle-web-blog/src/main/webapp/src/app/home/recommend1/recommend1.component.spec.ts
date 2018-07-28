import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Recommend1Component } from './recommend1.component';

describe('Recommend1Component', () => {
  let component: Recommend1Component;
  let fixture: ComponentFixture<Recommend1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Recommend1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Recommend1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
