import React from 'react';
import ReactDOM from 'react-dom';
import { Store } from 'fluxx';
import { init } from './actions';
import UserScreen from './UserScreen';

let unregister;
import store from './store';

export default {
  enter() {
    unregister = Store.onChange(store)(() => {
      ReactDOM.render(<UserScreen refUsers={store.refUsers()} />, document.getElementById('viewContainer'));
    });
    init();
  },

  exit() {
    unregister();
  }
};
