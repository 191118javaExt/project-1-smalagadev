import { ErsPage } from './app.po';

describe('ers App', function() {
  let page: ErsPage;

  beforeEach(() => {
    page = new ErsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
