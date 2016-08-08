import qajax from 'qajax';


export function getRefUsers() {
  return qajax.getJSON('/all');
}

export function addUser(user) {
  return qajax({
    method: 'POST',
    url: '/add',
    data: JSON.stringify(user),
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  })
  .then(qajax.filterSuccess)
  .then(qajax.toJSON);
}
