import sys
import math
input = sys.stdin.readline

N,L = map(int, input().split())
pool = []
for i in range(N) :
    pool.append(list(map(int, input().split())))
pool.sort(key=lambda x:x[0])
print(pool)

maxl = 0
cnt = 0
answer = 0
for s,e in pool :
    #print(type(s))

    if s <= maxl :
        s = maxl + 1

    cnt = math.ceil((e-s)/L)
    answer += cnt
    maxl = max(maxl, s+cnt*L-1)
    #확 생각나진 않네, 이게 판떼지가 늘어선거라곤

print(answer)