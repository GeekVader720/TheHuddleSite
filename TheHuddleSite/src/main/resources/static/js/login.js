/*var usernameForm = document.querySelector('#usernameForm');
var usernamePage = document.querySelector('#username-page');
var passwordPage = document.querySelector('password-page');
var passwordForm = document.querySelector('passwordForm');

var stompClient = null;
var username = null;
var password = null;

function connect(event) {
    username = document.querySelector('#name').value.trim();
    password = document.querySelector('#authentification').value.trim();

    if (username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )
}*/