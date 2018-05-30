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
    stomp.subscribe('/double/recv/6', function (g) {
        writeToScreen("double recv: " + g.body);
    });
    stomp.subscribe('/room/recv/6', function(g) {
        writeToScreen("room recv: " + g.body);
    });
    stomp.send("/double/send", {}, JSON.stringify({'channel': 3, 'sender': 1, 'to': 6, 'msg': "qwertasdfg"}));
    stomp.send("/room/send", {}, JSON.stringify({'room': 1, 'user': 1, msg: 'something in the room'}));
  });
}

function writeToScreen(message) {
  var pre = document.createElement("p");
  pre.style.wordWrap = "break-word";
  pre.innerHTML = message;
  output.appendChild(pre);
}
window.addEventListener("load", init, false);