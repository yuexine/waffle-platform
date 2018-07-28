import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Recommend2Component } from './recommend2.component';

describe('Recommend2Component', () => {
  let component: Recommend2Component;
  let fixture: ComponentFixture<Recommend2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Recommend2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Recommend2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
