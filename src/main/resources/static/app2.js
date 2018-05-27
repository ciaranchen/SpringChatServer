var stomp;

function init() {
  output = document.getElementById("output");
}

function send_echo() {
  let wsUri = "ws://localhost:8080/ws";
  writeToScreen("Connecting to " + wsUri);
  stomp = Stomp.client(wsUri);
  stomp.connect({username: 'ciaran'}, "qweasd", function (frame) {
    console.log('Connected: ' + frame);
    stomp.subscribe('/topic/ciaran', function (g) {
        writeToScreen('recv: ');
    });
    stomp.send("/send", {}, JSON.stringify({'from': 1, 'to': 2, 'content': "qwertasdfg"}));
  });
}

function doSend(message) {
  echo_websocket.send(message);
  writeToScreen("Sent message: " + message);
}

function writeToScreen(message) {
  var pre = document.createElement("p");
  pre.style.wordWrap = "break-word";
  pre.innerHTML = message;
  output.appendChild(pre);
}
window.addEventListener("load", init, false);