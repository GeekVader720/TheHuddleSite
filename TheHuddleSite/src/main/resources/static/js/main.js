'use strict';


const messageForm = document.querySelector('#messageForm');
const messageInput = document.querySelector('#message');
const messageArea = document.querySelector('#messageArea');
const connectingElement = document.querySelector('.connecting');
const chatBox = $('#chatbox');
let stompClient = null;
let username = null;


const colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect() {
    username = document.querySelector('#username').textContent.trim();

    if (username) {
        //selectPage.classList.add('hidden');
        //chatPage.classList.remove('hidden');

        const socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
}

function onPublicMessage(event) {
    const {sender, content} = JSON.parse(event.body);
    const newMesssage = document.createElement('p');
    newMesssage.textContent = `${sender}: ${content}`;
    chatBox.append(newMesssage);
}

function onConnected() {

    stompClient.subscribe('/topic/public', onPublicMessage);

    // Tell your username to the server
    stompClient.send("/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    // connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    event.preventDefault();

    const messageContent = messageInput.value.trim();
    if (messageContent && stompClient) {
        const chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
}

messageForm.addEventListener('submit', sendMessage, true);