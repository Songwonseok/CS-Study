class Trie():
    def __init__(self):
        self.next = dict()
        self.value = 0
 
def solution(words):
    answer = 0
    tree = Trie()
    for word in words:
        sub = tree
        for idx, val in enumerate(word):
            sub.value += 1
            if val not in sub.next:
                sub.next[val] = Trie()
            sub = sub.next[val]
            if (idx == len(word) - 1):
                sub.value += 1
 
    for word in words:
        sub = tree
        counts = 0
        for idx, val in enumerate(word):
            if (sub.value == 1):
                answer += counts
                break
            elif idx == len(word) - 1:
                answer += counts + 1
                break
            else:
                sub = sub.next[val]
                counts += 1
 
 
    return answer