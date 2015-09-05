
<html>
<head>
	<title>Realtime Guestbook</title>
</head>
<body>
<div>
	<p>Write a message:</p>
	<textarea id="message"></textarea>
	<button type="button" id="send">Send</button>
</div>
<div>
	<h3>Messages:</h3>
	<ol id="messages"></ol>
</div>


<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        var messageList = $("#messages");
        var getMessageString = function(message) {
            var date = new Date(message.date);
            return "<li><p>Received: " + date + "</p><div>" + message.content + "</li>";
        };



        var socket = new SockJS('/guestbook');
        var stompClient = Stomp.over(socket);


        stompClient.connect({ }, function(frame) {
            // subscribe to the /topic/entries endpoint which feeds newly added messages
            stompClient.subscribe('/topic/entries', function(data) {// 서버로부터 json값 호출
                // when a message is received add it to the end of the list

                var body = data.body;
//                var command = data.command;
                var message = JSON.parse(body);
                console.log('test')
                messageList.append(getMessageString(message));
            });

        });

        $("#send").on("click", function() { // 여기서 자바로 이동
            // send the message
//            stompClient.send("/app/guestbook", {}, JSON.stringify({
//                'message': $("#message").val(),
//                'id': $("#message").val()
//            }));
            stompClient.send("/app/guestbook", {}, $("#message").val());
            $("#message").val("");
        });


    });
</script>
