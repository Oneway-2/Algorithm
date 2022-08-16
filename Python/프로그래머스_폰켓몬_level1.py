def solution(nums):
    c = len(nums) // 2
    nod = set()
    for i in nums:
        nod.add(i)
    answer = min(len(nod), c)
    return answer
