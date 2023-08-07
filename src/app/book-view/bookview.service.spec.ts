import { TestBed } from '@angular/core/testing';

import { BookviewService } from './bookview.service';

describe('BookviewService', () => {
  let service: BookviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
