import { Router } from 'abyssa';

export default Router().configure({
  enableLogs: false,
  notFound: 'fiche',
  urlSync: 'hash'
});
