import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionArtComponent } from './section-art.component';

describe('SectionArtComponent', () => {
  let component: SectionArtComponent;
  let fixture: ComponentFixture<SectionArtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SectionArtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SectionArtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
