import { State } from 'abyssa';
import { babelpolyfill } from 'babel-polyfill';
import router from './router';
import fiche from './fiche';


router
  .addState('fiche', State('fiche', fiche))
  .init('fiche');
