package week1;

import java.util.Arrays;

public class RadixSortStrings {

    public static void main(String[] args) {
        // -97
        //System.out.println((int)'a'-96);
        String[] w = {"the", "tell", "be", "be", "be", "", "not", "or", "to", "toes", "to", "aqua", "car", "digging"};
        //week1.CountingSort(w, 0);
        String[] a = {"to","be","or","not","to","be","that","is","a","question"};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void radixSort(String[] arr){
        if(arr!=null && arr.length>1){
            int max = 0;
            // find longest word:
            for(String s : arr){
                if(s!=null){
                    max = Math.max(max, s.length());
                }
            }
            // use counting sort, each time on a different letter:
            for(int i=max-1; i>=0; i--){
                CountingSort(arr, i);
            }
        }
    }

    public static void CountingSort(String[] arr, int key){
        // null is zero, rest of letters are 1-27
        int[] indexArr = new int[27];
        int length = arr.length;
        String[] temp = new String[length];
        // fill indexArr: add one for each letter at the key place.
        for(String s : arr){
            int i=0;
            if(s!=null && s.length()>key){
                i = (int)s.charAt(key)-96;
            }
            indexArr[i]++;
        }
        //System.out.println(Arrays.toString(indexArr));
        // make into addition series:
        for(int i=1; i<27; i++){
            indexArr[i] += indexArr[i-1];
        }
        // go from end of array:
        for(int i=length-1; i>=0; i--){
            //System.out.println(Arrays.toString(indexArr));
            int index = 0;
            String s = arr[i];
            //System.out.println(s);
            // get the number of the char at 'key':
            if(s!=null && s.length()>key){
                index = (int)s.charAt(key)-96;
            }
            //System.out.println("index: " + index);
            // the position the word should go to in the temp array - is the number at the 'index' index in indexArr
            int position = indexArr[index]-1;
            //System.out.println("position: "+position);
            indexArr[index]--;
            temp[position] = s;
            //System.out.println(Arrays.toString(temp));
        }
        // copy temp to arr:
        for(int i=0; i<length; i++){
            arr[i] = temp[i];
        }
    }
}
