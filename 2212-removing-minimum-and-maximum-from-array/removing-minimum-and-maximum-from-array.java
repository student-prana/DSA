class Solution {
    public int minimumDeletions(int[] arr) {
        int n=arr.length;
        int minIndex=0;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
            if(arr[i]<arr[minIndex]){
                minIndex=i;
            }
        }

        if(minIndex>maxIndex){
            int temp=minIndex;
            minIndex=maxIndex;
            maxIndex=temp;
        }
        int deleteFront=maxIndex+1;
        int deleteBack=n-minIndex;
        int deleteBoth=(minIndex+1)+(n-maxIndex);
        

        return Math.min(deleteFront,Math.min(deleteBack,deleteBoth));
    }
}