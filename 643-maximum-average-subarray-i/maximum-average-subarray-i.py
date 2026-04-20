class Solution(object):
    def findMaxAverage(self, nums, k):

        curr=0
        n=len(nums)
        for i in range(k):
            curr+=nums[i]
        maxx=curr
        for i in range (1,n-k+1):
            curr=curr-nums[i-1]+nums[i+k-1]
            if(curr>maxx):
                maxx=curr
        return maxx/float(k)
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        