package main

import (
	"fmt"
	"sync"
)

var wg sync.WaitGroup

func hello(c chan string){
	c <- "Hello"
}

func helloWg(){
	fmt.Println("Hello -> wait group")
	wg.Done()
}

func main(){

	wg.Add(1)

	c := make(chan string)

	go hello(c)
	fmt.Println(<-c)

	go helloWg()

	wg.Wait()
}
