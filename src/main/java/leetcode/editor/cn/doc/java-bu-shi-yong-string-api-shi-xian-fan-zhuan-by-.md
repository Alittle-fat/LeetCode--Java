双指针方式 : 寻找中间元素 , 头尾指针两两换位
public void reverseString(char[] s) {
    if(s.length <=1)
        return;
    int center = s.length / 2;  
    for(int i=0,j=s.length-1;i<j-1 ; j--,i++){
        s[i] ^= s[j];
        s[j] ^= s[i];
        s[i] ^= s[j];
    }
}