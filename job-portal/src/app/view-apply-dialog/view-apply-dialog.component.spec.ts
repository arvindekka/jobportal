import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewApplyDialogComponent } from './view-apply-dialog.component';

describe('ViewApplyDialogComponent', () => {
  let component: ViewApplyDialogComponent;
  let fixture: ComponentFixture<ViewApplyDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewApplyDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewApplyDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
