import { NewPostModule } from './new-post.module';

describe('NewPostModule', () => {
  let newPostModule: NewPostModule;

  beforeEach(() => {
    newPostModule = new NewPostModule();
  });

  it('should create an instance', () => {
    expect(newPostModule).toBeTruthy();
  });
});
