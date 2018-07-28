import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularPostComponent } from './popular-post.component';

describe('PopularPostComponent', () => {
  let component: PopularPostComponent;
  let fixture: ComponentFixture<PopularPostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularPostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
