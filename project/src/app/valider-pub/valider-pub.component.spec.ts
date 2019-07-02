import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValiderPubComponent } from './valider-pub.component';

describe('ValiderPubComponent', () => {
  let component: ValiderPubComponent;
  let fixture: ComponentFixture<ValiderPubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValiderPubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValiderPubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
