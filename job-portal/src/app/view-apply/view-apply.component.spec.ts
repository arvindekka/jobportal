import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewApplyComponent } from './view-apply.component';

describe('ViewApplyComponent', () => {
  let component: ViewApplyComponent;
  let fixture: ComponentFixture<ViewApplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewApplyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewApplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
