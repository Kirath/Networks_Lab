#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>

#define MAX_MSG 100
#define SERVER_ADDR "127.0.0.1"
#define CLIENT_ADDR "127.0.0.1"
#define SERVER_PORT 1500
#define CLIENT_PORT 2500

int main() 
{
	int sd, rc, i;
	struct sockaddr_in clientAddr, servAddr;
	char line[MAX_MSG];
	
	// build server address structure
	bzero((char *)&servAddr, sizeof(servAddr));
	servAddr.sin_family=AF_INET;
	servAddr.sin_addr.s_addr=inet_addr(SERVER_ADDR);
	servAddr.sin_port=htons(SERVER_PORT);
	
	
	bzero((char*)&clientAddr, sizeof(clientAddr));
	clientAddr.sin_family = AF_INET;
	clientAddr.sin_addr.s_addr = INADDR_ANY;
	clientAddr.sin_port = htons(0);
	
    //create stream socket
	sd = socket(AF_INET, SOCK_STREAM, 0);
	printf("Successfully created stream socket \n");
	
	// bind local port number
	bind(sd, (struct sockaddr *) &clientAddr, sizeof(clientAddr));
	printf("Bound local port successfully\n");
	
	connect(sd, (struct sockaddr *) &servAddr, sizeof(servAddr));
	printf("Connected to server successfully \n");
	
	do 
	{
		printf("Enter string to send to server : ");
		scanf("%s", line);
		
		send(sd, line, strlen(line) + 1, 0);
		printf("Data sent (%s)\n", line);
	} while(strcmp(line, "quit"));
	
	printf("CLosing connection with the server\n");
	close(sd);	
	
	return 0;
}
