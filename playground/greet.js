export function greet(name) {
  return `Merhaba, ${name}`;
}

export function shout(name) {
  return `${greet(name).toLocaleUpperCase('tr-TR')}!`;
}

export function farewell(name) {
  return `Bye, ${name}`;
}
