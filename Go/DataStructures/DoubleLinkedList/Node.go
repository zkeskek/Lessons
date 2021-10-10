package DoubleLinkedList

import "fmt"

// İki yönlü link list, her node objesi bir sonraki ve bir önceki node objesinin referansını taşır.
// bu sayede next'in next'i ile tek yöne giderken aynı zamanda previous ile geri gidebileceğiz.

type Node struct {
	X        int
	Next     *Node
	Previous *Node
}

// Başına Ekle Methodu
func (node *Node) AddToStart(data int) {
	temp := *node
	node.X = data
	node.Next = &temp
}

// Sıralı Ekle Methodu
func (node *Node) AddToSequentially(data int) {

	for node.Next != nil && node.Next.X < data {
		node = node.Next
	}

	temp := *node

	node.Next = &Node{X: data, Next: nil}

	node.Next.Next = temp.Next
}

// Araya Ekle Methodu
func (node *Node) AddToBetween(data int, which int) {

	for node.X != which {
		node = node.Next
	}

	temp := *node

	node.Next = &Node{X: data, Next: nil}

	node.Next.Next = temp.Next
}

// Sonuna Ekle Methodu
func (node *Node) AddToEnd(data int) {
	for node.Next == nil {
		node.Next = &Node{X: data, Next: nil}
		break
	}
}

// Eleman Sil Methodu
func (node *Node) Delete(data int) {

	// silmek istenen değer arada veya sonda bir değer ise iter objemizi silinecek node objesinin bir öncekine kadar ilerletiyoruz
	for node.Next != nil && node.Next.X != data {
		node = node.Next
	}

	if node.Next == nil {
		fmt.Println("Silmek istediğiniz değer listede bulunamadı!")
	} else {
		node.Next = node.Next.Next
	}
}

// Yazdır
func (node *Node) Print() {
	iter := node
	for iter != nil {
		fmt.Println(iter.X)
		iter = iter.Next
	}
}
