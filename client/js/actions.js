import { Action } from 'fluxx';

import {getRefUsers, addUser} from './api';

export var types = Action.create(
  'INIT',
  'UPDATE_USERS'
);

export function init() {
  return getRefUsers().then(usrs => types.INIT(usrs));
}

export function add(user) {
  return addUser(user).then(() => getRefUsers().then(usrs => types.UPDATE_USERS(usrs)))
}
