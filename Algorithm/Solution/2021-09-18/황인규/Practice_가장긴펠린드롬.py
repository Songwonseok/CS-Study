def expand(s, left, right) : 
    temp = s[left:right+1]
    while left>=0 and right<len(s) and temp == temp[::-1] :
        left-=1
        right+=1
        temp = s[left:right+1]
    
    return s[left+1:right]
    
def solution(s):
    answer = 0

    if len(s)<2 or s == s[::-1]:
        return len(s)
    
    result = ''
    for i in range(0, len(s)) : 
        result = max(expand(s, i, i+1), expand(s, i,i+2), result, key=len)
    
    return len(result)