import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewReimbursementComponentComponent } from './new-reimbursement-component.component';

describe('NewReimbursementComponentComponent', () => {
  let component: NewReimbursementComponentComponent;
  let fixture: ComponentFixture<NewReimbursementComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewReimbursementComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewReimbursementComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
