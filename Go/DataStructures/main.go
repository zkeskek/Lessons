package main

/*
	Bu içerik Şadi Evren ŞEKER'in Youtube platformunda yer alan BilgisayarKavramlari kanalında yayınladığı veri yapıları eğitim serisinden ilham alınarak hazırlanmıştır. Eğitim serisinde c ile veri yapıları işlenmektedir. Bu içerik bir nevi Go versiyonu sayılabilir.
	link : https://www.youtube.com/watch?v=r3uOBb3BM-0&list=PLh9ECzBB8tJN9bckI6FbWB03HkmogKrFT
*/

import (
	circularLinkedList "./CircularLinkedList"
	linearLinkedList "./LinearLinkedList"
)

func main() {

	// Linear Linked List, Her node bir sonraki node objesinin referansını tutar.
	// LinearLinkedList()

	// Circular Linked List, Son node'un next'i root node'unu gösterir.
	CircularLinkedList()

	// Double Linked List, Her node bir sonraki ve bir önceki node objesinin referansını tutar. Çift yönlü linkleme sağlanır.
	// DoubleLinkedList()

}

// Double Linked List
func DoubleLinkedList() {

}

// Circular Linked List
func CircularLinkedList() {
	myCircularLinkedList := circularLinkedList.Node{X: 12, Next: nil}
	myCircularLinkedList.Next = &myCircularLinkedList

	myCircularLinkedList.AddToEnd(33)

	myCircularLinkedList.AddToSequentially(11)
	myCircularLinkedList.AddToSequentially(22)

	myCircularLinkedList.AddToStart(55)

	myCircularLinkedList.AddToBetween(66, 11)

	myCircularLinkedList.Delete(11)
	myCircularLinkedList.Delete(55)

	myCircularLinkedList.Print()
}

// Linear Linked List
func LinearLinkedList() {

	// ilk adımlar
	// linearLinkedList.Approach()

	// Eleman ekleme ve yazdırma
	// linearLinkedList.GenerateElement()

	// Araya eleman ekleme ve harici yazdırma dosyası
	// linearLinkedList.AddElementBetween()

	// Sıralı eleman ekleme
	// linearLinkedList.AddSequentially()

	// Eleman Silme
	// linearLinkedList.DeleteElement()

	// struct objesi üzerinden tüm methodları kullanabiliriz.
	// yukarda yapılan örneklerin hepsi artık struct objemizin birer methodu haline geldi.
	myLinearLinkedList := linearLinkedList.Node{X: 23, Next: nil}

	myLinearLinkedList.AddToEnd(21)

	myLinearLinkedList.AddToStart(3)

	myLinearLinkedList.AddToSequentially(5)
	myLinearLinkedList.AddToSequentially(35)
	myLinearLinkedList.AddToSequentially(55)

	myLinearLinkedList.AddToBetween(12, 21)
	myLinearLinkedList.AddToBetween(66, 35)

	myLinearLinkedList.Delete(23)

	myLinearLinkedList.Print()
}
