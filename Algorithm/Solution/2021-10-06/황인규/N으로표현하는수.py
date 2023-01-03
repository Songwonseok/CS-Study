def solution(N, number):
    answer = 0
    DP = []
    
    for i in range(1,9):
        numbers = set()
        numbers.add(int(str(N)*i))
        for j in range(0, i-1) : 
            for op1 in DP[j] :
                for op2 in DP[-j-1]:
                    numbers.add(op1+op2)
                    numbers.add(op1-op2)
                    numbers.add(op1*op2)
                    if op2!=0 : 
                        numbers.add(op1//op2)
        if number in numbers :
            answer = i
            break
        DP.append(number)
    return answer