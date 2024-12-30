import java.util.Scanner;

public class mergesort {
    public static void arrayElements(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of array: ");

        int size = scanner.nextInt();

        int array[] = new int[size];

        if(array.length ==0){
            System.out.println("Array is empty");
            return;
        }
        else{
        System.out.println("Enter " + size + " elements");

        for(int p = 0; p<size;p++){
            System.out.println("Element" + (p+1) + " :"); 
            array[p]=scanner.nextInt();
        } 
    }

       
        System.out.println("The array you have entered is: ");    

        for(int p=0;p<size;p++){
            System.out.println(array[p] +" ");
        }



        divide(array,0,array.length-1);

        System.out.println("Sorted array is: ");

        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+" ");
        }
        System.out.println();
        scanner.close();
    }

    public static void conquer(int[] array,int LHSi,int mid, int RHSi){
        int merged[] =  new int[RHSi-LHSi+1];
        int idx1= LHSi;
        int idx2= mid+1;
        int x=0;

        while(idx1<= mid && idx2<= RHSi){
            if(array[idx1]<=array[idx2]){
                merged[x++]=array[idx1++];
            }else{
                merged[x++]=array[idx2++];
            }
        }

        while(idx1<=mid){
            merged[x++]=array[idx1++];
        }

        while(idx2<=RHSi){
            merged[x++]=array[idx2++];
        }

        for(int i=0,j=LHSi;i<merged.length;i++,j++){
            array[j]=merged[i];
        }

    }

    public static void divide(int[] array, int LHSi , int RHSi){
        
        if(LHSi>=RHSi){
            return;
        }

            int mid = LHSi + (RHSi-LHSi)/2;
            divide(array, LHSi, mid);
            divide(array, mid+1 ,RHSi);
            conquer(array,LHSi,mid,RHSi);
    }

    public static void main(String[] args) {
        arrayElements();
        
    }
}
