var app= require('express')();
var http =require('http').Server(app);
var io=require('socket.io')(http);

io.on('connection', function(socket)
{
console.log('usuario connection');
});

http.listen(3000,function()
{
	console.log('listening on http://127.0.0.1:3000');
	});