/*
let obj = {
    name: 'John',
    age: 30,
    city: 'New York',
    hobbies: ['reading', 'travelling', 'coding'],
    greet: function() {
        console.log('Hello, I am ' + this.name);
    }

}

console.log(obj.name);
obj.greet();
*/

function add(a,b) {
    return a + b;

}

let i = 0

function addElement(evt) {
    let newElement = document.createElement('p');
    // set new element id
    newElement.id = 'p1';
    newElement.innerHTML = 'This is a new paragraph';
    let body = document.querySelector('body');
    body.appendChild(newElement);
}

window.addEventListener('click', addElement)