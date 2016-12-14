package Test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("请输入整数：");
		int n = input.nextInt();
		input.close();
		int arr[] = initArr(n);
		int temp = 2;
		while(true){
			arr = getArr(arr, temp);
			if(arr.length == 1){
				System.out.println("最后剩下的人是：" + arr[0]);
				break;
			}
			temp ++;
		}
		
	}
	
	//初始化数组
	public static int[] initArr(int n){
		
		int arr[]  = new int[n];
		for(int i = 0;i < n;i ++){
			arr[i] = i + 1;
		}
		return arr;
		
	}
	
	public static int getNumber(int[] arr,int count){

		while(true){
			//对喊道该数字的人赋值为0
			if(count%arr.length == 0){
				arr[arr.length - 1] = 0;
			}else{
				arr[count%arr.length - 1] = 0;
			}
			//temp数组
			int temp[] = new int[arr.length - 1]; 
			int index = 0;
			for(int i = 0;i < arr.length;i ++){
				
				//除去为0的数字
				if(arr[i] == 0){
					continue;
				}else{
					temp[index] = arr[i];
				}
				index ++;
				
			}
			arr = temp;
			count ++;
			if(arr.length == 1){
				break;
			}
		}
		return arr[0];
		
	}
	
	public static int[] getArr(int[] arr,int count){
		
		int temp = 0;
		int arrLength = arr.length - arr.length/count;
		System.out.println("第" + (count - 1) + "轮：");
		System.out.println("数组长度为：" + arrLength);
		int tempArr[] = new int[arrLength];
		//数组长度小于报数的时候，则执行该方法
		if(arr.length < count){
			int value = getNumber(arr, count);
			tempArr = new int[1];
			tempArr[0] = value;
			return tempArr;
		}
		for(int i = 0;i < arr.length;i ++){
			if((i+1)%count != 0){
				//把没有喊道数字的人存起来
				tempArr[temp] = arr[i];
				temp ++;
			}
		}
		return tempArr;
		
	}
	
}
