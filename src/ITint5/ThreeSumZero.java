package ITint5;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

 class ABC {
	  public int a, b, c;
	  public ABC(int a, int b, int c) {
	    this.a=a;this.b=b;this.c=c;
	  }
	}
public class ThreeSumZero {
	public List<ABC> threeSumZero(int[] arr) {
        int n = arr.length;
        List<ABC> res = new LinkedList<ABC>();
        if (n <= 2)
            return res;
        Arrays.sort(arr);
        int i = 0;
        while(i < n-2){
        int j = i + 1;
        
            int k = n - 1;
            int target = (-1) * arr[i];
            while (j < k){
                if (arr[j] + arr[k] == target){
                    res.add(new ABC(arr[i], arr[j], arr[k]));
                    j++; 
                    while(j < k && arr[j] == arr[j-1])
                    	j++;
                    k--;
                    while(k > j && arr[k] == arr[k+1])
                    	k--;
                } else if (arr[j] +arr[k] > target)
                    k--;
                  else 
                    j++;
                
            }
            i++;
            while (i < n && arr[i] == arr[i-1])
                i++;
            
        }
        return res;
    }
	public static void main(String[] args){
		int[] arr = {1,-1,0,1,-1,0};
		ThreeSumZero o = new ThreeSumZero();
		System.out.println(o.threeSumZero(arr));
	}
}
