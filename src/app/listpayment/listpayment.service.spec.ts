import { TestBed } from '@angular/core/testing';

import { ListpaymentService } from './listpayment.service';

describe('ListpaymentService', () => {
  let service: ListpaymentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListpaymentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
