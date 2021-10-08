package main

import "fmt"

// Linear Sequential
// Tek Yönlü Linklist

func main() {
	// ilk node objemizi oluşturuyoruz ve bu root yani ilk objemizdir.
	root := node{x: 12, next: nil}

	// ilk oluşturulan node objemizin içersinde yer alan next isimli pointer için yeni bir node objesi oluşturuyoruz.
	// burda dikkate ederseniz yeni node objesini oluştururken aynı zamanda root'un next'ine referansını (&) veriyoruz.
	root.next = &node{x: 5, next: nil}

	// ikinci oluşturulan node objemizin içersinde yer alan next isimli pointer için yeni bir node objesi daha oluşturuyoruz.
	root.next.next = &node{x: 6, next: nil}

	// böylece 3 adet node objesini birbiri ardına eklemiş olduk.

	// oluşturduğumuz node objesini gezebilmek (iterable) için root olan objemizin referansı ile iter oluşruyoruz.
	iter := &root

	// iter objesinin refransını değiştirmeden yazdırmak istersek eğer
	fmt.Println("root objesi üzerinden iterable")
	fmt.Printf("root node x : %v\nsecond node x : %v\nthirty node x : %v\n\n", iter.x, iter.next.x, iter.next.next.x)

	// ilk önce manuel olarak root objesinden başlayarak her bir node objesinin next'ine gidiyoruz.
	// root objesinin x değerini yaz
	fmt.Println("iter referansını manuel değiştirerek iterable")
	fmt.Printf("root node x : %v\n", iter.x)
	// iter'in sahip olduğu referansı root'un next'i olarak değiştir.
	iter = iter.next
	// iter artık root'un next'ini gösterdiği için bir sonraki node objesinin x değerini yazdır.
	fmt.Printf("second node x : %v\n", iter.x)
	// aynı işlem tekrar
	iter = iter.next
	fmt.Printf("thirty node x : %v\n", iter.x)
	fmt.Println()

	// iter objesi üzerinden tüm node objelerinin next değeri nil olana kadar döngü ile yazdırabiliriz.
	fmt.Println("root objesi üzerinden döngü ile iterable")
	iter = &root
	for iter != nil {
		fmt.Println(iter.x)
		iter = iter.next
	}

}

// struct tipinde bir node oluşturduk bu herhangi bir entitiy veya obje olabilir.
// önemli olan nokta bir pointer niteliği olmasıdır.
// bu pointer ile art arda node tipinde objeler üretebileceğiz.
type node struct {
	x    int
	next *node
}
