package main

import (
	"context"
	"fmt"
	"grpc-demo/proto"
	"net"

	"google.golang.org/grpc"
)

func main(){

	listen, err := net.Listen("tcp", "localhost:9090")
	if err != nil {
		panic(err)
	}

	server := grpc.NewServer()
	proto.RegisterHelloServiceServer(server, &helloController{})

	fmt.Println("Running Server : 9090")

	panic(server.Serve(listen))

}

type helloController struct{
	proto.UnimplementedHelloServiceServer
}

func (h *helloController) SayHello(ctx context.Context, req *proto.HelloRequest) (*proto.HelloResponse, error) {
	return &proto.HelloResponse{Message: req.Name}, nil
}