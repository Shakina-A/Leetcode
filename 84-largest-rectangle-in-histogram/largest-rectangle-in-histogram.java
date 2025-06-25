class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(st.size()>0)
            {
                if(heights[st.peek()]<heights[i])
                {
                    left[i]=st.peek();
                    break;
                }
                else
                {
                    st.pop();
                }
            }
            if(st.size()==0)
            {
                left[i]=-1;
            }
            st.push(i);
        }
        int[] right=new int[n];
        st= new Stack();
        for(int i=n-1;i>=0;i--)
        {
            while(st.size()>0)
            {
                if(heights[st.peek()]<heights[i])
                {
                    right[i]=st.peek();
                    break;
                }
                else
                {
                    st.pop();
                }
            }
            if(st.size()==0)
            {
                right[i]=n;
            }
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
}