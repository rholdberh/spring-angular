import { TestBed } from '@angular/core/testing';

import { ConfiguraionService } from './configuraion.service';

describe('ConfiguraionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ConfiguraionService = TestBed.get(ConfiguraionService);
    expect(service).toBeTruthy();
  });
});
