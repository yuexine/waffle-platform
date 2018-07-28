import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestPostComponent } from './latest-post.component';

describe('LatestPostComponent', () => {
  let component: LatestPostComponent;
  let fixture: ComponentFixture<LatestPostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LatestPostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LatestPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
