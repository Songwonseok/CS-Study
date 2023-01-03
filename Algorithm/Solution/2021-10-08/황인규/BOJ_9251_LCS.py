import sys
sub = sys.readline().strip().upper()
sub2 = sys.readline().strip().upper()

matrix = [ (len(sub2)+1)*[0] for _ in range(len(sub)+1) ]

for i in range(1, len1+1):
    for j in range(1, len2+1):
        if sub[i-1] == sub2[j-1]:
            matrix[i][j] = matrix[i-1][j-1]+1
        else :
            matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1])
print(matrix[-1][-1])