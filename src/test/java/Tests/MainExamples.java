package Tests;

public class MainExamples {
    public static void main(String[] args){
       int[] nums = {1,3,2,77,4,0,14};
       int temp;
       boolean sorted = false;
       while (!sorted){
           sorted = true;
           for(int i = 0; i < nums.length-1;i++){
               if(nums[i]>nums[i+1]){
                 temp = nums[i];
                 nums[i] = nums[i+1];
                 nums[i+1] = temp;
                 sorted = false;
               }
           }
       }
   for(int i : nums){
       System.out.print(" "+ i);
   }

    }
}
