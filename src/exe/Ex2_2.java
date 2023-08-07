// 207404997
package exe;

public class Ex2_2 {
    public static void main(String[] args) {
        // test case of values
        int[] data = {45, -2, -45, 78, 30, -42, 10, 19, 73, 93};
        mergeSort3(data);
        System.out.println("After 3 way merge sort: ");
        for (int d : data) System.out.print(d + " ");
    }

    /**
     * split and sort recursively:
     * an array of length 1 or 0 is sorted.
     * split into 3 sub-arrays until get to length 1 or 0,
     * then merge the arrays in order.
     * complexity O(n log_3 n).
     * the merge algorithm in this class merges all 3 arrays simultaneously.
     * alternatively, we can use a regular 2-array merge:
     * merge arrays 1 and 2, and then merge 1+2 and 3.
     * @param arr array to sort
     */
    public static void mergeSort3(int[] arr){
        if(arr==null || arr.length<2) return;
        int length = arr.length;
        // set lengths and create the 3 sub-arrays:
        int third = length/3;
        int second = (length-third)/2;
        int first = length-third-second;
        int[] right = new int[third];
        int[] middle = new int[second];
        int[] left = new int[first];
        int a=0, b=0, c=0;
        // fill the sub-arrays:
        for(int i=0; i<length; i++){
            if(i<first) left[a++] = arr[i];
            else if(i<first+second) middle[b++] = arr[i];
            else right[c++] = arr[i];
        }
        // recursive call: sort each sub-array:
        mergeSort3(left);
        mergeSort3(middle);
        mergeSort3(right);
        // merge the sorted sub-arrays:
        int[] ans = merge3(left,middle,right);
        System.arraycopy(ans, 0, arr, 0, length);
    }

    /**
     * merge 3 arrays: use 3 counters.
     * check the first index from each array and take the minimum. increment that counter by one.
     * continue until one array is done. then merge the other 2 arrays in the same way.
     * when two arrays are done, add the rest from the last array.
     * @param a first array
     * @param b second array
     * @param c third array
     * @return a merged array of the 3 arrays.
     */
    public static int[] merge3(int[] a, int[] b, int[] c){
        int aLen=0, bLen=0, cLen=0;
        if(a!=null) aLen = a.length;
        if(b!=null) bLen = b.length;
        if(c!=null) cLen = c.length;
        int l = aLen+bLen+cLen;
        int[] ans = new int[l];
        int i=0, j=0, k=0, p=0;
        while (p<l){
            if(i<aLen && j<bLen && k<cLen){
                if(a[i]<=b[j]){
                    if(a[i]<=c[k]){
                        ans[p++] = a[i++];
                    }
                    else{
                        ans[p++] = c[k++];
                    }
                }
                else{
                    if(b[j]<=c[k]){
                        ans[p++] = b[j++];
                    }
                    else{
                        ans[p++] = c[k++];
                    }
                }
            }
            else if(i<aLen && j<bLen){
                if(a[i]<=b[j]){
                    ans[p++] = a[i++];
                }
                else{
                    ans[p++] = b[j++];
                }
            }
            else if(i<aLen && k<cLen){
                if(a[i]<=c[k]){
                    ans[p++] = a[i++];
                }
                else{
                    ans[p++] = c[k++];
                }
            }
            else if(j<bLen && k<cLen){
                if(b[j]<=b[j]){
                    ans[p++] = b[j++];
                }
                else{
                    ans[p++] = c[k++];
                }
            }
            else if(i<aLen){
                ans[p++] = a[i++];
            }
            else if(j<bLen){
                ans[p++] = b[j++];
            }
            else if(k<cLen){
                ans[p++] = c[k++];
            }
        }
        return ans;
    }
}
