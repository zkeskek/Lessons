package Stack

import "fmt"

type ArrayStack struct {
	Arr []int
	ArrSize int
	Index int
}

// Constructor initialize
func (arr *ArrayStack) Constructor(){
	arr.ArrSize = 2
	arr.Index = 0
	arr.Arr = []int{0,0}
}

// Push Add to data
func (arr *ArrayStack) Push(data int) {
	if arr.Index >= arr.ArrSize{
		newArr := make([]int, arr.ArrSize * 2)
		for i := 0; i < arr.ArrSize; i++ {
			newArr[i] = arr.Arr[i]
		}
		arr.Arr = newArr
		arr.ArrSize *= 2
	}
	arr.Arr[arr.Index] = data
	arr.Index++
}

// Pop Remove to data
func (arr *ArrayStack) Pop() {
	arr.Index--
	arr.Arr[arr.Index] = 0
	if arr.Index <= arr.ArrSize / 4{
		newArr := make([]int, arr.ArrSize / 2)
		for i := 0; i < arr.ArrSize; i++ {
			if arr.Arr[i] != 0 {
				newArr[i] = arr.Arr[i]
			}
		}
		arr.Arr = newArr
		arr.ArrSize /= 2
	}
}

// Print Yazdır
func (arr *ArrayStack) Print() {
	//fmt.Printf("len=%d cap=%d %v\n", len(arr.Arr), cap(arr.Arr), arr.Arr)
	for i := 0; i < arr.Index; i++ {
		fmt.Printf("%v ", arr.Arr[i])
	}
	fmt.Println()
}