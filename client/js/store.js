import { Store } from 'fluxx';

import { types } from './actions';

export default Store(on => {
  let refUsers;

  on(types.INIT, data => {
    refUsers = data;
  });

  on(types.UPDATE_USERS, data => {
    refUsers = data;
  });

  return {
    refUsers: () => refUsers
  };

});
