package main

import (
	linklist "./LinkList"
)

func main() {

	// Linear Linked List, Her node bir sonraki node objesinin referansını tutar.
	linkList()

}

func linkList() {

	// ilk adımlar
	// linklist.Approach()

	// Eleman ekleme ve yazdırma
	// linklist.GenerateElement()

	// Araya eleman ekleme ve harici yazdırma dosyası
	// linklist.AddElementBetween()

	// Sıralı eleman ekleme
	// linklist.AddSequentially()

	// Eleman Silme
	//linklist.DeleteElement()

	// struct objesi üzerinden tüm methodları kullanabiliriz.
	// yukarda yapılan örneklerin hepsi artık struct objemizin birer methodu haline geldi.
	myNode := linklist.Node{X: 23, Next: nil}

	myNode.AddToEnd(21)

	myNode.AddToStart(3)

	myNode.AddToSequentially(5)
	myNode.AddToSequentially(35)
	myNode.AddToSequentially(55)

	myNode.AddToBetween(12, 21)
	myNode.AddToBetween(66, 35)

	myNode.Delete(23)

	myNode.Print()
}
