import java.util.Arrays;  
class TargetSum{
	public static void main(String[] args){
		int[] arr = { 1, 5, 4, 10};
		System.out.println(Arrays.toString(targetSum(arr,6)));
		System.out.println(Arrays.toString(targetSum(arr,12)));
	}
	public static int[] targetSum(int[] arr,int target){
		int n = arr.length;
		int[] ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
		for(int i = 0; i<n-1; i++){
			for(int j = i+1; j<n; j++){
				int tempSum = arr[i]+arr[j];
				if(tempSum == target){
					ret[0] = i;
					ret[1] = j;
					return ret;
				}
			}
		}
		return ret;
	}
}
